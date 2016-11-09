package mainPack;

public class Item {
	
	private String name1;
	private String name2;
	private int value;
	private Item needed;
	
	public Item(String name1, String name2, int value, Item needed){
		this.name1 = name1;
		this.name2 = name2;
		this.value = value;
		this.needed = needed;
	}

	public String getName1() {
		return name1;
	}

	public String getName2() {
		return name2;
	}

	public int getValue() {
		return value;
	}
	
	public Item getNeeded() {
		return needed;
	}
	
	
}
