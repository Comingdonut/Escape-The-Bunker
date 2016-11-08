package mainPack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Game {

	private Room createBunker(){
		Room bunker = null;
		HashMap<Action, ArrayList<Item>> actionables = new HashMap<Action, ArrayList<Item>>();
		Item brick = new Item("Brick", "", 1);
		Item distKey = new Item("Distorted Key", "Warped Key", 4);
		Item pin = new Item("Bobby Pin", "Pin", 2);
		Item driver = new Item("Screwdriver", "Screw Driver", 3);
		Item storKey = new Item("Storage Key", "StorageKey", 5);
		Item classKey = new Item("Classroom Key", "ClassroomKey", 6);
		Item lswitch = new Item("Light", "Switch", 7);
		Item arcade = new Item("Arcade", "Machine", 8);
		Item couch = new Item("Couch", "", 9);
		Item bigTable =new Item("Big Table", "", 10);
		Item table = new Item("Table", "", 11);
		Item longTable = new Item("Long Table", "LongTable", 12);
		Item bunkerDoor = new Item("Bunker Door", "BunkerDoor", 13);
		Item storDoor = new Item("Closet Door", "Closet", 14);
		Item classDoor = new Item("Class Door", "ClassDoor", 15);
		Item window = new Item("Window", "", 16);
		Item lDrawer =new Item("Left Drawer", "LeftDrawer", 17);
		Item rDrawer = new Item("Right Drawer", "RightDrawer", 18);
		Item bDrawer = new Item("Back Drawer", "BackDrawer", 19);
		Item counter = new Item("Counter", "Counter Top", 20);
		Item box = new Item("Box", "", 21);
		Item tv = new Item("TV", "Television", 22);
		
		ArrayList<Item> use = new ArrayList<>(Arrays.asList(distKey, storKey, classKey, lswitch, arcade));
		ArrayList<Item> take = new ArrayList<>(Arrays.asList(pin, driver, brick));
		ArrayList<Item> look = new ArrayList<>(Arrays.asList(arcade, couch, bigTable, table, longTable, counter, tv));
		ArrayList<Item> open = new ArrayList<>(Arrays.asList(bunkerDoor, storDoor, classDoor, lDrawer, rDrawer, bDrawer));
		ArrayList<Item> breakA = new ArrayList<>(Arrays.asList(window));
		ArrayList<Item> pickLock = new ArrayList<>(Arrays.asList(pin, driver));
		
		ArrayList<Item> hidden = new ArrayList<>(Arrays.asList(brick, distKey, pin, driver, storKey, classKey, box));
		ArrayList<Item> available = new ArrayList<>(Arrays.asList(lswitch, arcade, couch, bigTable, table, longTable, bunkerDoor, classDoor, window, lDrawer, rDrawer, bDrawer, counter, tv));
		
		actionables.put(Action.TAKE, take);
		actionables.put(Action.PICKUP, take);
		actionables.put(Action.USE, use);
		actionables.put(Action.LOOKAT, look);
		actionables.put(Action.INSPECT, look);
		actionables.put(Action.OPEN, open);
		actionables.put(Action.BREAK, breakA);
		actionables.put(Action.PICKUP, take);
		actionables.put(Action.PICKLOCK, pickLock);	
		
		bunker = new Room(actionables, hidden, available);
		
		return bunker;	
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
		Item classKey = new Item("ClassKey", "Class Key", 8);
		
		ArrayList<Item> pickUp = new ArrayList<>(Arrays.asList(cloth));
		ArrayList<Item> lookAt = new ArrayList<>(Arrays.asList(locker, clock, desk));
		ArrayList<Item> use = new ArrayList<>(Arrays.asList(cloth));
		ArrayList<Item> open = new ArrayList<>(Arrays.asList(locker));

		ArrayList<Item> hidden = new ArrayList<>(Arrays.asList(cloth, classKey));
		ArrayList<Item> available = new ArrayList<>(Arrays.asList(clock, desk, table, locker, bunkDoor, classDoor));
		
		actionables.put(Action.PICKUP, pickUp);
		actionables.put(Action.TAKE, pickUp);
		actionables.put(Action.INSPECT, lookAt);
		actionables.put(Action.LOOKAT, lookAt);
		actionables.put(Action.OPEN, open);
		actionables.put(Action.USE, use);
		
		classRoom = new Room(actionables, hidden, available);
		
		return classRoom;	
	}
	private Room createCommons(){
		
		Room commons = null;
		
		HashMap<Action, ArrayList<Item>> actionables = new HashMap<Action, ArrayList<Item>>();
		
		Item marketKey = new Item("MarketKey", "Market Key", 1);
		Item desk = new Item("Front Desk", "Desk", 4);
		Item noodles = new Item("Ramen", "Noodles", 2);
		Item spareKey = new Item("Spare Key", "SpareKey", 3);
		Item stickyNote = new Item("Sticky Note", "Sticky", 5);
		Item market = new Item("Market", "Shop", 6);
		Item price = new Item("Price", "Amount", 7);
		Item lock = new Item("Lock", "", 8);
		Item gate = new Item("Gate", "", 9);
		Item clothes =new Item("Clothes", "", 10);
		Item note = new Item("Note", "Memo", 11);
		Item drawer = new Item("Drawer", "", 12);
		Item frontDoor = new Item("Front Door", "FrontDoor", 13);
		Item sideDoor = new Item("Side Door", "SideDoor", 14);
		Item backDoor = new Item("Back Door", "BackDoor", 15);
		
		ArrayList<Item> pickUp = new ArrayList<>(Arrays.asList(marketKey, noodles, spareKey));
		ArrayList<Item> lookAt = new ArrayList<>(Arrays.asList(note, stickyNote, desk, market, clothes, price));
		ArrayList<Item> use = new ArrayList<>(Arrays.asList(frontDoor, backDoor, sideDoor, marketKey));
		ArrayList<Item> open = new ArrayList<>(Arrays.asList(drawer, gate, lock));
		ArrayList<Item> scan = new ArrayList<>(Arrays.asList(noodles));
		
		ArrayList<Item> hidden = new ArrayList<>(Arrays.asList(marketKey, noodles, spareKey, stickyNote, price, lock, note));
		ArrayList<Item> available = new ArrayList<>(Arrays.asList(backDoor, sideDoor, frontDoor, desk, market, gate, drawer));
		
		actionables.put(Action.OPEN, open);
		actionables.put(Action.INSPECT, lookAt);
		actionables.put(Action.LOOKAT, lookAt);
		actionables.put(Action.USE, use);
		actionables.put(Action.SCAN, scan);
		actionables.put(Action.PICKUP, pickUp);
		actionables.put(Action.TAKE, pickUp);
		actionables.put(Action.READ, lookAt);
		
		commons = new Room(actionables, hidden, available);
		
		return commons;	
	}
	
	
	public void run(){
		//SHTUFF
		
	}
	
}

