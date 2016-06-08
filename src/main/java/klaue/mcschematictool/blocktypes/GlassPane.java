package klaue.mcschematictool.blocktypes;

import java.awt.image.BufferedImage;
import java.util.HashMap;

import klaue.mcschematictool.ImageProvider;


/**
 * A wool block that can be in different states of growth
 * @author klaue
 *
 */
public class GlassPane extends Block {
	/**
	 * The Color a wool block can have
	 * @author klaue
	 */
	public enum GlassColor {
		/** White */ WHITE, /** Orange */ ORANGE, /** Magenta */ MAGENTA, /** Light blue */ LIGHTBLUE, /** Yellow */ YELLOW,
		/** Light green */ LIGHTGREEN, /** Pink */ PINK, /** Gray */ GRAY, /** Light gray */ LIGHTGRAY, /** Cyan */ CYAN,
		/** Purple */ PURPLE, /** Blue */ BLUE, /** Brown */ BROWN, /** Dark green */ DARKGREEN, /** Red */ RED, /** Black */ BLACK
	};
	
	private static HashMap<GlassColor, BufferedImage> glassImageCache = new HashMap<GlassColor, BufferedImage>();
	private static double glassZoomCache = -1;
	
	private GlassColor color = GlassColor.WHITE;
	
	/**
	 * initializes the wool block
	 * @param data the minecraft data value (representing color)
	 */
	public GlassPane(byte data) {
		super((short)160, data);
		this.type = Type.GLASS_PANE;
		setData(data);
	}
	
	/**
	 * initializes a white wool block
	 */
	public GlassPane() {
		this(GlassColor.WHITE);
	}
	
	/**
	 * initializes a colored wool block
	 * @param color the color this wool should be dyed in
	 */
	public GlassPane(GlassColor color) {
		super((short)160);
		this.type = Type.GLASS_PANE;
		setColor(color);
	}
	
	/**
	 * Get the color of the wool.
	 * @return the color
	 */
	public GlassColor getColor() {
		return this.color;
	}

	/**
	 * Set the color of the wool.
	 * @param color the color to set
	 */
	public void setColor(GlassColor color) {
		this.color = color;
		switch(color) {
			case WHITE:			this.data = 0;  break;
			case ORANGE:		this.data = 1;  break;
			case MAGENTA:		this.data = 2;  break;
			case LIGHTBLUE:		this.data = 3;  break;
			case YELLOW:		this.data = 4;  break;
			case LIGHTGREEN:	this.data = 5;  break;
			case PINK:			this.data = 6;  break;
			case GRAY:			this.data = 7;  break;
			case LIGHTGRAY:		this.data = 8;  break;
			case CYAN:			this.data = 9;  break;
			case PURPLE:		this.data = 10; break;
			case BLUE:			this.data = 11; break;
			case BROWN:			this.data = 12; break;
			case DARKGREEN:		this.data = 13; break;
			case RED:			this.data = 14; break;
			case BLACK:			this.data = 15; break;
		}
	}
	
//	@Override
//	public String toString() {
//		return "Wool, color: " + this.color;
//	}
	
	@Override
	public void setData(byte data) {
		switch(data) {
			case 0:  this.color = GlassColor.WHITE;			break;
			case 1:  this.color = GlassColor.ORANGE;		break;
			case 2:  this.color = GlassColor.MAGENTA;		break;
			case 3:  this.color = GlassColor.LIGHTBLUE;		break;
			case 4:  this.color = GlassColor.YELLOW;		break;
			case 5:  this.color = GlassColor.LIGHTGREEN;	break;
			case 6:  this.color = GlassColor.PINK;			break;
			case 7:  this.color = GlassColor.GRAY;			break;
			case 8:  this.color = GlassColor.LIGHTGRAY;		break;
			case 9:  this.color = GlassColor.CYAN;			break;
			case 10: this.color = GlassColor.PURPLE;		break;
			case 11: this.color = GlassColor.BLUE;			break;
			case 12: this.color = GlassColor.BROWN;			break;
			case 13: this.color = GlassColor.DARKGREEN;		break;
			case 14: this.color = GlassColor.RED;			break;
			case 15: this.color = GlassColor.BLACK;			break;
			default: throw new IllegalArgumentException("illegal color value: " + this.data);
		}
		this.data = data;
	}
	
	@Override
	public synchronized BufferedImage getImage(double zoom) {
		if (!ImageProvider.isActivated()) return null;
		if (zoom <= 0) return null;
		
		BufferedImage img = null;
		
		if (glassZoomCache != zoom) {
			// reset cache
			glassImageCache.clear();
			glassZoomCache = zoom;
		} else {
			img = glassImageCache.get(this.color);
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
		glassImageCache.put(this.color, img);
		
		return img;
	}
}
