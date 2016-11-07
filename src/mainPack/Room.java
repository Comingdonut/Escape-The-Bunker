package mainPack;

import java.util.HashMap;
import java.util.List;

public class Room {

	private HashMap<Action, List<Item>> itemsPerAction;
	private List<Item> hidden;
	private List<Item> relative;
	private List<Item> available;
	private List<Item> back;

	public HashMap<Action, List<Item>> getItemsPerAction() {
		return itemsPerAction;
	}

	public List<Item> getHidden() {
		return hidden;
	}

	public List<Item> getRelative() {
		return relative;
	}

	public List<Item> getAvailable() {
		return available;
	}

	public List<Item> getBack() {
		return back;
	}

	public List<Item> getMid() {
		return mid;
	}

	public List<Item> getFront() {
		return front;
	}

	public void hiddenToAvailable(Item move) throws Exception{
		if(hidden.contains(move)){
			hidden.remove(move);
			available.add(move);
		}else{
			throw new Exception(move.toString() + " was never contained in hidden!");
		}
	}
	public void moveToSection(Item move) throws Exception{
		relative = back.contains(move) ? back : mid.contains(move) ? mid : front;
	}

	private List<Item> mid;
	private List<Item> front;

	public Room(HashMap<Action, List<Item>> itemsPerAction, List<Item> hidden, List<Item> relative, List<Item> available, List<Item> back, List<Item> mid, List<Item> front){
		this.itemsPerAction = itemsPerAction;
		this.hidden = hidden;
		this.relative = relative;
		this.available = available;
		this.back = back;
		this.mid = mid;
		this.front = front;
	}
}
