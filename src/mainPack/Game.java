package mainPack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Game {

	private Room createBunker(){
		Room bunker = null;
		HashMap<Action, ArrayList<Item>> actionables;
		return null;	
	}
	private Room createClassRoom(){
		Room classRoom = null;
		HashMap<Action, ArrayList<Item>> actionables = new HashMap<Action, ArrayList<Item>>();
		Item clock = new Item("Clock", "", 1);
		Item desk = new Item("Desk", "", 2);
		Item table =new Item("Tables", "Table", 3);
		Item locker = new Item("Locker", "Cabinet", 4);
		Item bunkDoor = new Item("Bunker Door", "Bunker", 5);
		Item classDoor = new Item("Classroom Door", "Classroom", 6);
		Item cloth = new Item("Cloth", "Towel", 7);
		ArrayList<Item> goTo = new ArrayList<Item>(){{
			add(clock);
			add(desk);
			add(table);
			add(locker);
			add(bunkDoor);
			add(classDoor);
			add(cloth);				
		}};
		ArrayList<Item> pickUp = new ArrayList<Item>(){{
			add(cloth);			
		}};
		ArrayList<Item> lookAt = new ArrayList<Item>(){{
			add(locker);			
		}};
		actionables.put(Action.GOTO, goTo);
		actionables.put(Action.PICKUP, pickUp);
		actionables.put(Action.TAKE, pickUp);
		actionables.put(Action.INSPECT, lookAt);
		actionables.put(Action.LOOKAT, lookAt);
		
		return null;	
	}
	private Room createCommons(){
		Room commons = null;
		HashMap<Action, ArrayList<Item>> actionables;
		return null;	
	}
}
