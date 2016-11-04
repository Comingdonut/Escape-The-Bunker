package mainPack;

public class Item {

	private ItemType type;
	private String name1;
	private String name2;
	private int value;
	
	public Item(String name1, String name2, ItemType type, int value){
		this.name1 = name1;
		this.name2 = name2;
		this.type = type;
		this.value = value;
	}

	public ItemType getType() {
		return type;
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
	
	
}
