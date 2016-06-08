package klaue.mcschematictool.blocktypes;

import java.awt.image.BufferedImage;
import java.util.HashMap;

import klaue.mcschematictool.ImageProvider;


/**
 * A sapling block that can be in different states of growth
 * @author klaue
 *
 */
public class Sapling extends Block {
	private static HashMap<TreeType, BufferedImage> saplingImageCache = new HashMap<TreeType, BufferedImage>();
	private static double saplingZoomCache = -1;
	
	private TreeType treeType = TreeType.OAK;
	private byte growth;
	
	/**
	 * initializes the sapling block
	 * @param data the growth and type value of the sapling.
	 */
	public Sapling(byte data) {
		super((short)6, data);
		this.type = Type.SAPLING;
		setData(data);
	}
	
	/**
	 * Initializes the sapling block
	 * @param type The Tree Type to use
	 * @param growth the current growth (0-3)
	 */
	public Sapling(TreeType type, byte growth) {
		super((short)6);
		this.type = Type.SAPLING;
		setTreeType(type);
		setGrowth(growth);
	}
	
	/**
	 * Get the growth value of the sapling. Growth 0 is a newly planted one, growth 15 (0xF) is one that will convert to a tree
	 * @return the growth
	 */
	public byte getGrowth() {
		return this.growth;
	}

	/**
	 * Set the growth value of the sapling. Strength 0 is a newly planted one, strength 3 is one that will convert to a tree
	 * @param growth the strength to set
	 */
	public void setGrowth(byte growth) {
		if (growth < 0 || growth > 3) {
			throw new IllegalArgumentException("growth " + growth + "outside boundaries"); 
		}
		this.growth = growth;
		this.data = (byte) ((this.data & 3) + (growth << 2));
	}

	/**
	 * Set the tree type
	 * @param type
	 */
	public void setTreeType(TreeType type) {
		byte typedata = 0;
		switch (type) {
			case OAK:		typedata = 0; break;
			case SPRUCE:	typedata = 1; break;
			case BIRCH:		typedata = 2; break;
			case JUNGLE:	typedata = 3; break;
		}
		this.treeType = type;
		this.data = (byte) ((this.data & 12) + typedata);
	}

	/**
	 * Get the tree type
	 * @return the type of tree
	 */
	public TreeType getTreeType() {
		return this.treeType;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", growth: " + this.growth;
	}
	
	@Override
	public void setData(byte data) {
		byte typedata = (byte) (data & 3);
		this.growth = (byte) (data & 12);
		switch (typedata) {
			case 0: this.treeType = TreeType.OAK;	break;
			case 1: this.treeType = TreeType.SPRUCE;	break;
			case 2: this.treeType = TreeType.BIRCH;		break;
			case 3:
			default: this.treeType = TreeType.JUNGLE;		break; // 4+ Same as 3, but never dropped
		}
		this.data = data;
	}
	
	@Override
	public synchronized BufferedImage getImage(double zoom) {
		if (!ImageProvider.isActivated()) return null;
		if (zoom <= 0) return null;
		
		BufferedImage img = null;
		
		if (saplingZoomCache != zoom) {
			// reset cache
			saplingImageCache.clear();
			saplingZoomCache = zoom;
		} else {
			img = saplingImageCache.get(this.treeType);
			if (img != null) {
				return img;
			}
		}
		
		// image not in cache, make new
		// get image from imageprovider
		img = ImageProvider.getImageByBlockOrItemID(this.id, this.data);
		
		if (img == null) return null;
		
		// zoom
		if (zoom != 1) {
			img = ImageProvider.zoom(zoom, img);
		}

		// save image to cache
		saplingImageCache.put(this.treeType, img);
		
		return img;
	}
}
