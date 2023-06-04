package com.player.item;

	//Enum representing different types of items
	public enum Item {
		
	 SWORD1("Starter Sword", 3, 0, ItemType.WEAPON),     // Item: Sword, Power: 3, Crit % chance: 2, Type: Weapon
	 SWORD2("Training Sword", 7, 5, ItemType.WEAPON),    // Item: Sword, Power: 7, Crit % chance: 5, Type: Weapon
	 SWORD3("Knights Sword", 10, 10, ItemType.WEAPON),     // Item: Sword, Power: 10, Crit % chance: 10, Type: Weapon
	 
	 SHIELD("Shield", 5, 0, ItemType.DEFENSE),    // Item: Shield, Power: 5, Crit % chance: 0, Type: Defense
	 POTION("Potion", 0, 0, ItemType.HEALING);    // Item: Potion, Power: 0, Crit % chance: 0, Type: Healing
	
	 private String name;        // Name of the item
	 private int power;          // Power of the item
	 private int critMultiplier; // Critical hit multiplier
	 private ItemType type;     // Type of the item
		
	 Item(String name, int power, int critMultiplier, ItemType type) {
	     this.name = name;
	     this.power = power;
	     this.critMultiplier = critMultiplier;
	     this.type = type;
	 }
	
	 public String getName() {
	     return name;
	 }
	
	 public int getPower() {
	     return power;
	 }
	 
	 public int getcritMultiplier() {
	     return critMultiplier;
	 }
	
	 public ItemType getType() {
	     return type;
	 }
	 
	}