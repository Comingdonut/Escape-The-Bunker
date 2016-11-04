package mainPack;

public class Command {

	private Action action;
	private Item item;
	
	public Command(Action action, Item item){
		this.action = action;
		this.item = item;
	}

	public Action getAction() {
		return action;
	}

	public Item getItem() {
		return item;
	}
	
	
	
}
