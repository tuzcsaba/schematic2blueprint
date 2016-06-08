package klaue.mcschematictool;


/**
 * This helper class returns the name of the given blocks
 * @author klaue
 *
 */
public class NameProvider {
	/**
	 * This method provides the name of the given block/item id and data
	 * It only provides the name of the block itself, so giving the data value for, for example, rails makes no sense as the rails data
	 * contains directional information - if you need this too, get an instance per Block.getInstance() and read that instances toString()
	 * @param id the id of the block
	 * @param data the data of the block or -1 if it doesn't matter for the block name (or the default value like white wool for wool)
	 * @return the name of the block
	 */
	public static String getNameOfBlockOrItem(short id, byte data) {
		
		switch(id) {
			case 0:		return "Air";
			case 1:		return "Stone";
			case 2:		return "Grass";
			case 3:		return "Dirt";
			case 4:		return "Cobblestone";
			case 5:	// Wooden Plank
				switch(data) {
					case 1:	return "Wooden Plank (spruce)";		// Pine
					case 2:	return "Wooden Plank (birch)";		// Birch
					case 3:	return "Wooden Plank (jungle)";		// Jungle
					case 0:
					default:	return "Wooden Plank (oak)";	// Normal (oak)
				}
			case 6:
				byte typedata = (byte) (data & 3);
				switch (typedata) {
					case 1: return "Spruce Sapling";
					case 2: return "Birch Sapling";
					case 3: return "Jungle Sapling";
					case 0:
					default: return "Oak Sapling";
				}
			case 7:		return "Bedrock";
			case 8:
			case 9:		return "Water"; // water and still water
			case 10:
			case 11:	return "Lava"; // lava and still lava
			case 12:	return "Sand";
			case 13:	return "Gravel";
			case 14:	return "Gold Ore";
			case 15:	return "Iron Ore";
			case 16:	return "Coal Ore";
			case 17:
				typedata = (byte)(data & 0x3);
				switch (typedata) {
					case 1: return "Spruce Log";
					case 2: return "Birch Log";
					case 3: return "Jungle Log";
					case 0:
					default: return "Oak Wood";
				}
			case 18:
				byte typeData = (byte)(data&3);
				switch (typeData) {
					case 1: return "Spruce Leaves";
					case 2: return "Birch Leaves";
					case 3: return "Jungle Leaves";
					case 0:
					default: return "Oak Leaves";
				}
			case 19:	return "Sponge";
			case 20:	return "Glass";
			case 21:	return "Lapis Lazuli Ore";
			case 22:	return "Lapis Lazuli Block";
			case 23:	return "Dispenser";
			case 24:
				switch(data) {
					case 1:	return "Chiseled Sandstone";
					case 2:	return "Smooth Sandstone";
					case 0:
					default:	return "Sandstone";
				}
			case 25:	return "Note";
			case 26:
				if ((data & 8) == 0) {
					return "Bed (foot)";
				}
				return "Bed (head)";
			case 27:	return "Powered Rail";
			case 28:	return "Detector Rail";
			case 29:	return "Sticky Piston";
			case 30:	return "Web";
			case 31:
				switch (data) {
					case 0: return "Dead bush (grass)";
					case 2: return "Fern (grass)";
					case 1: 
					default: return "Tall grass";
				}
			case 32:	return "Dead bush";
			case 33:	return "Piston";
			case 34:
				if ((data & 8) != 0) {
					return "Sticky Piston Extension";
				}
				return "Piston Extension";
			case 35:
				switch (data) {
					case 1:		return "Orange wool";
					case 2:		return "Magenta wool";
					case 3:		return "Light blue wool";
					case 4:		return "Yellow wool";
					case 5:		return "Light green wool";
					case 6:		return "Pink wool";
					case 7:		return "Gray wool";
					case 8:		return "Light gray wool";
					case 9:		return "Cyan wool";
					case 10:	return "Purple wool";
					case 11:	return "Blue wool";
					case 12:	return "Brown wool";
					case 13:	return "Dark green wool";
					case 14:	return "Red wool";
					case 15:	return "Black wool";
					case 0:
					default:	return "White wool";
				}
			case 37:	return "Dandelion";
			case 38:	return "Rose";
			case 39:	return "Brown Mushroom";
			case 40:	return "Red Mushroom";
			case 41:	return "Gold Block";
			case 42:	return "Iron Block";
			case 43:
				// special types 8,9 and 15 have no "upper half" bit
				typedata = (byte)(data & 0x7);
				switch (typedata) {
					case 1:
						if (data == 9) return "Smooth Sandstone Doubleslab";
						return "Sandstone Doubleslab";
					case 2: return "Wood Stone Doubleslab";
					case 3: return "Cobblestone Doubleslab";
					case 4: return "Brick Doubleslab";
					case 5: return "Stone Brick Doubleslab";
					case 6: return "Nether Brick Doubleslab";
					case 7:
						if (data == 15) return "Tile Quartz Doubleslab";
						return "Quartz Doubleslab";
					case 0:
						if (data == 8) return "Smooth Stone Doubleslab";
						return "Stone Doubleslab";
					default: return "Stone Doubleslab";
				}
			case 44:
				String upper = (data & 0x8) > 0 ? "Upside-down " : "";
				typedata = (byte)(data & 0x7);
				switch (typedata) {
					case 1: return upper + "Sandstone Slab";
					case 2: return upper + "Wood Stone Slab";
					case 3: return upper + "Cobblestone Slab";
					case 4: return upper + "Brick Slab";
					case 5: return upper + "Stone Brick Slab";
					case 6: return upper + "Nether Brick Slab";
					case 7: return upper + "Quartz Slab";
					case 0:
					default: return upper + "Stone Slab";
				}
			case 45:	return "Brick Block";
			case 46:	return "TNT";
			case 47:	return "Bookshelf";
			case 48:	return "Moss Stone";
			case 49:	return "Obsidian";
			case 50:	return "Torch";
			case 51:	return "Fire";
			case 52:	return "Monster Spawner";
			case 53:	return "Oak Wood stairs";
			case 54:	return "Chest";
			case 55:	return "Redstone wire";
			case 56:	return "Diamond Ore";
			case 57:	return "Diamond Block";
			case 58:	return "Crafting Table";
			case 59:	return "Wheat";
			case 60:	return "Farmland";
			case 61:
			case 62:	return "Furnace"; // ids differ for on or off, but we don't care here
			case 63:
			case 68:	return "Sign";
			case 64:
				if ((data & 8) == 0) {
					return "Wooden door (bottom half)";
				}
				return "Wooden door (top half)";
			case 65:	return "Ladder";
			case 66:	return "Rail";
			case 67:	return "Cobblestone stairs";
			// 68: sign, see 63
			case 69:	return "Lever";
			case 70:	return "Stone pressure plate";
			case 71:
				if ((data & 8) == 0) {
					return "Iron door (bottom half)";
				}
				return "Iron door (top half)";
			case 72:	return "Wooden pressure plate";
			case 73:	return "Redstone Ore";
			case 74:	return "Glowing Redstone Ore";
			case 75:
			case 76:	return "Redstone torch";
			case 77:	return "Stone Button";
			case 78:	return "Snow cover";
			case 79:	return "Ice";
			case 80:	return "Snow Block";
			case 81:	return "Cactus";
			case 82:	return "Clay Block";
			case 83:	return "Sugar Cane";
			case 84:	return "Jukebox";
			case 85:	return "Fence";
			case 86:	return "Pumpkin";
			case 87:	return "Netherrack";
			case 88:	return "Soul Sand";
			case 89:	return "Glowstone Block";
			case 90:	return "Portal";
			case 91:	return "Jack'o'Lantern";
			case 92:	return "Cake";
			case 93:
			case 94:	return "Redstone repeater";
			case 95:	return "Locked chest";
			case 96:	return "Trap door";
			case 98:
				switch (data) {
					case 1: return "Mossy Stone Brick";
					case 2: return "Cracked Stone Brick";
					case 3: return "Chiseled Stone Brick";
					case 0:
					default: return "Stone Brick";
				}
			case 99:	return "Huge brown mushroom";
			case 100:	return "Huge red mushroom";
			case 101:	return "Iron Bars";
			case 102:	return "Glass Pane";
			case 103:	return "Melon";
			case 104:	return "Pumpkin Stem";
			case 105:	return "Melon Stem";
			case 106:	return "Vines";
			case 107:	return "Fence Gate";
			case 108:	return "Brick Stairs";
			case 109:	return "Stone Brick Stairs";
			case 110:	return "Mycelium";
			case 111:	return "Lily Pad";
			case 112:	return "Nether Brick";
			case 113:	return "Nether Brick Fence";
			case 114:	return "Nether Brick Stair";
			case 372:
			case 115:	return "Nether Wart";
			case 116:	return "Enchantment Table";
			case 379:
			case 117:	return "Brewing Stand";
			case 380:
			case 118:	return "Cauldron";
			case 119:	return "End Portal";
			case 120:
				if ((data&4) != 0) return "End Portal Frame (fixed)";
				return "End Portal Frame";
			case 121:	return "End Stone";
			case 122:	return "Dragon Egg";
			case 123:	return "Redstone lamp (off)";
			case 124:	return "Redstone lamp (on)";
			case 125:
				typedata = (byte)(data & 0x7);
				switch (typedata) {
					case 1: return "Spruce-Wood Doubleslab";
					case 2: return "Birch-Wood Doubleslab";
					case 3: return "Jungle-Wood Doubleslab";
					case 4: return "Acacia-Wood Doubleslab";
					case 5: return "Dark Oak-Wood Doubleslab";
					case 0:
					default: return "Oak-Wood Doubleslab";
				}
			case 126:
				upper = (data & 0x8) > 0 ? "Upside-down " : "";
				typedata = (byte)(data & 0x7);
				switch (typedata) {
					case 1: return upper + "Spruce-Wood Slab";
					case 2: return upper + "Birch-Wood Slab";
					case 3: return upper + "Jungle-Wood Slab";
					case 4: return "Acacia-Wood Slab";
					case 5: return "Dark Oak-Wood Slab";
					case 0:
					default: return upper + "Oak-Wood Slab";
				}
			case 127:
				switch(data >> 2) {
					case 1:		return "Medium Cocoa Pod";	// medium
					case 2:		return "Large Cocoa Pod";	// large
					case 0:
					default:	return "Small Cocoa Pod";	// small
				}
			case 128:	return "Sandstone Stairs";
			case 129:	return "Emerald Ore";
			case 130:	return "Ender Chest";
			case 131:	return "Tripwire Hook";
			case 132:	return "Tripwire";
			case 133:	return "Emerald Block";
			case 134:	return "Spruce Wood Stairs";
			case 135:	return "Birch Wood Stairs";
			case 136:	return "Jungle Wood Stairs";
			case 137:	return "Command Block";
			case 138:	return "Beacon";
			case 139:
				if (data == 1) return "Mossy Cobblestone Wall";
				return "Cobblestone Wall";
			case 140:	return "Flower Pot";
			case 141:	return "Carrots";
			case 142:	return "Potatoes";
			case 143:	return "Wood Button";
			case 144:	return "Human head"; // other heads determined trough tile entity
			case 145:	return "Anvil";
			case 146:	return "Trapped chest";
			case 147:	return "Light weighted pressure plate";
			case 148:	return "Heavy weighted pressure plate";
			case 149:	return "Redstone Comparator (off)";
			case 150:	return "Redstone Comparator (on)";
			case 151:	return "Daylight Sensor";
			case 152:	return "Block of Redstone";
			case 153:	return "Nether Quartz Ore";
			case 154:	return "Hopper";
			case 155:
				switch (data) {
					case 1: return "Chiseled Quartz Block";
					case 2: return "Pillar Quartz Block (vertical)";
					case 3: return "Pillar Quartz Block (north-south)";
					case 4: return "Pillar Quartz Block (east-west)";
					case 0:
					default: return "Block of Quartz";
				}
			case 156:	return "Quartz stairs";
			case 157:	return "Activator Rail";
			case 158:	return "Dropper";
			case 163:   return "Acacia Wood Stairs";
			case 164:   return "Dark Oak Wood Stairs";
			case 171:
				switch (data) {
				case 1:		return "Orange wool carpet";
				case 2:		return "Magenta wool carpet";
				case 3:		return "Light blue wool carpet";
				case 4:		return "Yellow woo carpetl";
				case 5:		return "Light green wool carpet";
				case 6:		return "Pink wool carpet";
				case 7:		return "Gray wool carpet";
				case 8:		return "Light gray wool carpet";
				case 9:		return "Cyan wool carpet";
				case 10:	return "Purple wool carpet";
				case 11:	return "Blue wool carpet";
				case 12:	return "Brown wool carpet";
				case 13:	return "Dark green wool carpet";
				case 14:	return "Red wool carpet";
				case 15:	return "Black wool carpet";
				case 0:
				default:	return "White wool carpet";
			}
			case 175:
			{
				switch(data)
				{
				case 0:	return "Sunflower bottom";
				case 1: return "Lilac bottom";
				case 2: return "Tall grass bottom";
				case 3: return "Large fern bottom";
				case 4: return "Rose bush bottom";
				case 5: return "Peony bottom";
				case 8:	return "Sunflower top";
				case 9: return "Lilac top";
				case 10: return "Tall grass top";
				case 11: return "Large fern top";
				case 12: return "Rose bush top";
				case 13: return "Peony top";
				}
			}
			case 256:	return "Iron shovel";
			case 257:	return "Iron pickaxe";
			case 258:	return "Iron axe";
			case 259:	return "Flint and Steel";
			case 260:	return "Apple";
			case 261:	return "Bow";
			case 262:	return "Arrow";
			case 263:	return "Coal/Charocal";
			case 264:	return "Diamond";
			case 265:	return "Iron ingot";
			case 266:	return "gold ingot";
			case 267:	return "Iron sword";
			case 268:	return "Wooden sword";
			case 269:	return "Wooden shovel";
			case 270:	return "Wooden pickaxe";
			case 271:	return "Wooden axe";
			case 272:	return "Stone sword";
			case 273:	return "Stone shovel";
			case 274:	return "Stone pickaxe";
			case 275:	return "Stone axe";
			case 276:	return "Diamond sword";
			case 277:	return "Diamond shovel";
			case 278:	return "Diamond pickaxe";
			case 279:	return "Diamond axe";
			case 280:	return "Stick";
			case 281:	return "Bowl";
			case 282:	return "Mushroom soup";
			case 283:	return "Gold sword";
			case 284:	return "Gold shovel";
			case 285:	return "Gold pickaxe";
			case 286:	return "Gold axe";
			case 287:	return "String";
			case 288:	return "Feather";
			case 289:	return "Gunpowder";
			case 290:	return "Wooden hoe";
			case 291:	return "Stone hoe";
			case 292:	return "Iron hoe";
			case 293:	return "Diamond hoe";
			case 294:	return "Gold hoe";
			case 295:	return "Seeds";
			case 296:	return "Wheat";
			case 297:	return "Bread";
			case 298:	return "Leather helmet";
			case 299:	return "Leather chestplate";
			case 300:	return "Leather leggings";
			case 301:	return "Leather boots";
			case 302:	return "Chainmail helmet";
			case 303:	return "Chainmail chestplate"; 
			case 304:	return "Chainmail leggings";
			case 305:	return "Chainmail boots";
			case 306:	return "Iron helmet";
			case 307:	return "Iron chestplate";
			case 308:	return "Iron leggings";
			case 309:	return "Iron boots";
			case 310:	return "Diamond helmet";
			case 311:	return "Diamond chestplate";
			case 312:	return "Diamond leggings";
			case 313:	return "Diamond boots";
			case 314:	return "Gold helmet";
			case 315:	return "Gold chestplate";
			case 316:	return "Gold leggings";
			case 317:	return "Gold boots";
			case 318:	return "Flint";
			case 319:	return "Raw Porkchop";
			case 320:	return "Cooked Porkchop";
			case 321:	return "Paintings";
			case 322:	return "Golden apple";
			case 323:	return "Sign";
			case 324:	return "Wooden door";
			case 325:	return "Bucket";
			case 326:	return "Water bucket";
			case 327:	return "Lava bucket";
			case 328:	return "Minecart";
			case 329:	return "Saddle";
			case 330:	return "Iron door";
			case 331:	return "Redstone";
			case 332:	return "Snowball";
			case 333:	return "Boat";
			case 334:	return "Leather";
			case 335:	return "Milk";
			case 336:	return "Clay brick";
			case 337:	return "Clay balls";
			case 338:	return "Sugar cane";
			case 339:	return "Paper";
			case 340:	return "Book";
			case 341:	return "Slimeball";
			case 342:	return "Storage Minecart";
			case 343:	return "Powered Minecart";
			case 344:	return "Egg";
			case 345:	return "Compass";
			case 346:	return "Fishing rod";
			case 347:	return "Clock";
			case 348:	return "Glowstone dust";
			case 349:	return "Raw fish";
			case 350:	return "Cooked fish";
			case 351:
				switch (data) {
					case 1:		return "Rose Red";
					case 2:		return "Cactus Green";
					case 3:		return "Cocoa Beans";
					case 4:		return "Lapis Lazuli";
					case 5:		return "Purple Dye";
					case 6:		return "Cyan Dye";
					case 7:		return "Light Gray Dye";
					case 8:		return "Gray Dye";
					case 9:		return "Pink Dye";
					case 10:	return "Lime Dye";
					case 11:	return "Dandelion Yellow";
					case 12:	return "Light Blue Dye";
					case 13:	return "Magenta Dye";
					case 14:	return "Orange Dye";
					case 15:	return "Bone Meal";
					case 0:
					default:	return "Ink Sac";
				}
			case 352:	return "Bone";
			case 353:	return "Sugar";
			case 354:	return "Cake";
			case 355:	return "Bed";
			case 356:	return "Redstone repeater";
			case 357:	return "Cookie";
			case 358:	return "Map";
			case 359:	return "Shears";
			case 360:	return "Melon Slice";
			case 361:	return "Pumpkin Seeds";
			case 362:	return "Melon Seeds";
			case 363:	return "Raw Beef";
			case 364:	return "Steak";
			case 365:	return "Raw Chicken";
			case 366:	return "Cooked Chicken";
			case 367:	return "Rotten Flesh";
			case 370:	return "Ghast Tear";
			case 373:	return "Potion";
			case 368:	return "Ender Pearl";
			case 369:	return "Blaze Rod";
			case 371:	return "Gold Nugget";
			case 374:	return "Glass Bottle";
			case 375:	return "Spider Eye";
			case 376:	return "Fermented Spider Eye";
			case 377:	return "Blaze Powder";
			case 378:	return "Magma Cream";
			case 381:	return "Eye of Ender";
			case 382:	return "Glistening Melon";
			case 383:	return "Spawn Egg";
			case 384:	return "Bottle o' Enchanting";
			case 385:	return "Fire Charge";
			case 386:	return "Book and Quill";
			case 387:	return "Written Book";
			case 388:	return "Emerald";
			case 389:	return "Item Frame";
			case 390:	return "Flower Pot";
			case 391:	return "Carrot";
			case 392:	return "Potato";
			case 393:	return "Baked potato";
			case 394:	return "Poisoned potato";
			case 395:	return "Empty map";
			case 396:	return "Golden Carrot";
			case 397: // heads
				switch (data) {
					case 0:		return "Skeleton skull";
					case 1:		return "Wither skeleton skull";
					case 2:		return "Zombie head";
					case 4:		return "Creeper head";
					case 3:
					default:	return "Human head";
				}
			case 398:	return "Carrot on a stick";
			case 399:	return "Nether Star";
			case 400:	return "Pumpkin Pie";
			case 401:	return "Firework Rocket";
			case 402:	return "Firework Star";
			case 403:	return "Enchanted book";
			case 404:	return "Redstone comparator";
			case 405:	return "Nether brick";
			case 406:	return "Nether Quartz";
			case 407:	return "Minecart with TNT";
			case 408:	return "Minecart with Hopper";
			case 2256:	return "Record \"13\"";
			case 2257:	return "Record \"cat\"";
			case 2258:	return "Record \"blocks\"";
			case 2259:	return "Record \"chirp\"";
			case 2260:	return "Record \"far\"";
			case 2261:	return "Record \"mall\"";
			case 2262:	return "Record \"mellohi\"";
			case 2263:	return "Record \"stal\"";
			case 2264:	return "Record \"strad\"";
			case 2265:	return "Record \"ward\"";
			case 2266:	return "Record \"11\"";
			case 2267:	return "Record \"wait\"";
			default:	return "Unknown with id = " + id;
		}
	}
	
	/**
	 * This method provides the name of the given block id. same as getNameOfBlock(<id>, -1)
	 * @param id the id of the block
	 * @return the name of the block
	 */
	public static String getNameOfBlockOrItem(short id) {
		return getNameOfBlockOrItem(id, (byte)-1);
	}
}
