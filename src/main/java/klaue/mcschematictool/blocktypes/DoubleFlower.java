package klaue.mcschematictool.blocktypes;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.HashMap;

import klaue.mcschematictool.ImageProvider;


/**
 * A flower pot contains various flowers
 * @author klaue
 *
 */
public class DoubleFlower extends Block {
	/**
	 * The type of plant for the flowerpot
	 * @author klaue
	 */
	public enum DoublePlantType {
		SUNFLOWER, LILAC, DOUBLE_TALLGRASS, LARGE_FERN, ROSE_BUSH, PEONY;
		
		private String name = null;
		DoublePlantType(){}
		DoublePlantType(String name) { this.name = name; }
		@Override
		public String toString() { return (this.name == null) ? super.toString().toLowerCase() : this.name; }
	};
	
	public enum DoublePlantLevel {
		TOP, BOTTOM
	}
	
	private static HashMap<DoublePlantType, BufferedImage> flowerPotImageCache = new HashMap<DoublePlantType, BufferedImage>();
	private static double flowerPotZoomCache = -1;
	
	private DoublePlantType doublePlant = DoublePlantType.SUNFLOWER;
	private DoublePlantLevel level = DoublePlantLevel.BOTTOM;
	
	/**
	 * initializes the flower pot
	 * @param data the minecraft data value (representing color)
	 */
	public DoubleFlower(byte data) {
		super((short)175, data);
		this.type = Type.DOUBLEPLANT;
		setData(data);
	}
	
	/**
	 * initializes a flower pot without plant
	 */
	public DoubleFlower() {
		this(DoublePlantType.SUNFLOWER, DoublePlantLevel.BOTTOM);
	}
	
	/**
	 * initializes the flower pot
	 * @param pottedPlant the plant potted in this pot
	 */
	public DoubleFlower(DoublePlantType doublePlant, DoublePlantLevel level) {
		super((short)175);
		this.type = Type.FLOWERPOT;
		setDoublePlant(doublePlant, level);
	}
	
	/**
	 * Get the plant potted in this pot
	 * @return the plant
	 */
	public DoublePlantType getDoublePlant() {
		return this.doublePlant;
	}

	/**
	 * Set the plant potted in the pot
	 * @param pottedPlant the plant to pot
	 */
	public void setDoublePlant(DoublePlantType doublePlant, DoublePlantLevel level) {
		this.doublePlant =doublePlant;
		switch(doublePlant) {
			case SUNFLOWER:			this.data = 0;	break;
			case LILAC:				this.data = 1;	break;
			case DOUBLE_TALLGRASS:	this.data = 2;	break;
			case LARGE_FERN:		this.data = 3;	break;
			case ROSE_BUSH:			this.data = 4;	break;
			case PEONY:				this.data = 5;	break;
		}
		
		if (level == DoublePlantLevel.TOP)
		{
			this.data += 8;
		}
	}
	
	@Override
	public String toString() {
		if (this.doublePlant == DoublePlantType.SUNFLOWER) {
			return super.toString();
		}
		return super.toString() + " with " + this.doublePlant;
	}
	
	@Override
	public void setData(byte data) {
		switch(data) {
			case 0: case 8: this.doublePlant = DoublePlantType.SUNFLOWER;			break;
			case 1: case 9: this.doublePlant = DoublePlantType.LILAC;				break;
			case 2: case 10: this.doublePlant = DoublePlantType.DOUBLE_TALLGRASS;	break;
			case 3: case 11: this.doublePlant = DoublePlantType.LARGE_FERN;			break;
			case 4: case 12: this.doublePlant = DoublePlantType.ROSE_BUSH;			break;
			case 5: case 13: this.doublePlant = DoublePlantType.PEONY;				break;
		}
		if (data < 8)
		{
			this.level = DoublePlantLevel.BOTTOM;
		}
		else
		{
			this.level = DoublePlantLevel.TOP;
		}
		this.data = data;
	}
	
	@Override
	public synchronized BufferedImage getImage(double zoom) {
		if (!ImageProvider.isActivated()) return null;
		if (zoom <= 0) return null;
		
		BufferedImage img = null;
		
		if (flowerPotZoomCache != zoom) {
			// reset cache
			flowerPotImageCache.clear();
			flowerPotZoomCache = zoom;
		} else {
			img = flowerPotImageCache.get(this.doublePlant);
			if (img != null) {
				return img;
			}
		}
		
		// image not in cache, make new
		// get image from imageprovider
			// get plant image, then copy to new image with pot "border"
			BufferedImage plantImg = null;
			String suffix = this.level == DoublePlantLevel.TOP ? "_top" : "_bottom"; 
			switch(this.doublePlant) {
				case SUNFLOWER:  
					if (this.level == DoublePlantLevel.TOP)
					{
						suffix = "_combined_full";
					}
					plantImg = ImageProvider.getImage("double_plant_sunflower" + suffix);  
					break;
				case LILAC:				plantImg = ImageProvider.getImage("double_plant_syringa" + suffix);				break;
				case DOUBLE_TALLGRASS:			plantImg = ImageProvider.getImage("double_plant_grass" + suffix);			break;
				case LARGE_FERN:  plantImg = ImageProvider.getImage("double_plant_fern" + suffix); break;
				case ROSE_BUSH: plantImg = ImageProvider.getImage("double_plant_rose" + suffix); break;
				case PEONY: plantImg = ImageProvider.getImage("double_plant_paeonia" + suffix); break;
			}
			
			//BufferedImage potImg = ImageProvider.getAdditionalImage("flower_pot");
			
			img = new BufferedImage(plantImg.getWidth(), plantImg.getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
			Graphics2D g = img.createGraphics();
			g.drawRenderedImage(plantImg, null);
			//g.drawRenderedImage(potImg, null);
		
		if (img == null) return null;
		
		// zoom
		if (zoom != 1) {
			img = ImageProvider.zoom(zoom, img);
		}

		// save image to cache
		flowerPotImageCache.put(this.doublePlant, img);
		
		return img;
	}
}
