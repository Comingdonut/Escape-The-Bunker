package mainPack;

import java.util.ArrayList;
import java.util.HashMap;

public class Room {

	private HashMap<Action, ArrayList<Item>> itemsPerAction = new HashMap<Action, ArrayList<Item>>();
	private ArrayList<Item> hidden;
//	private ArrayList<Item> relative;
	private ArrayList<Item> available;
//	private ArrayList<Item> back;	
//	private ArrayList<Item> mid;
//	private ArrayList<Item> front;

	public Room(HashMap<Action, ArrayList<Item>> itemsPerAction, ArrayList<Item> hidden, /*ArrayList<Item> relative,*/ ArrayList<Item> available/*, ArrayList<Item> back, ArrayList<Item> mid, ArrayList<Item> front*/){
		this.itemsPerAction = itemsPerAction;
		this.hidden = hidden;
		//this.relative = relative;
		this.available = available;
		//this.back = back;
		//this.mid = mid;
		//this.front = front;
	}
	
	public HashMap<Action, ArrayList<Item>> getItemsPerAction() {
		return itemsPerAction;
	}

	public ArrayList<Item> getHidden() {
		return hidden;
	}

//	public ArrayList<Item> getRelative() {
//		return relative;
//	}

	public ArrayList<Item> getAvailable() {
		return available;
	}
	
	public void takeItem(ArrayList<Item> items, int value){
		for(Item i : items){
			if(i.getValue() == value){
				available.add(i);
				hidden.remove(i);
			}
		}
	}

//	public ArrayList<Item> getBack() {
//		return back;
//	}
//
//	public ArrayList<Item> getMid() {
//		return mid;
//	}
//
//	public ArrayList<Item> getFront() {
//		return front;
//	}

	public void hiddenToAvailable(Item move) throws Exception{
		if(hidden.contains(move)){
			hidden.remove(move);
			available.add(move);
		}else{
			throw new Exception(move.toString() + " was never contained in hidden!");
		}
	}
//	public void moveToSection(Item move) throws Exception{
//		relative = back.contains(move) ? back : mid.contains(move) ? mid : front;
//	}

}
