package mainPack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Game {

	private Room createBunker(){
		Room bunker = null;
		HashMap<Action, ArrayList<Item>> actionables = new HashMap<Action, ArrayList<Item>>();
		Item brick = new Item("Brick", "brick", 1);
		Item distKey = new Item("Distorted Key", "Warped Key", 4);
		Item pin = new Item("Bobby Pin", "Pin", 2);
		Item driver = new Item("Screwdriver", "Screw Driver", 3);
		Item storKey = new Item("Storage Key", "StorageKey", 5);
		Item classKey = new Item("Classroom Key", "ClassroomKey", 6);
		Item lswitch = new Item("Light", "Switch", 7);
		Item arcade = new Item("Arcade", "Machine", 8);
		Item couch = new Item("Couch", "couch", 9);
		Item bigTable =new Item("Big Table", "bTable", 10);
		Item table = new Item("Table", "table", 11);
		Item longTable = new Item("Long Table", "LongTable", 12);
		Item bunkerDoor = new Item("Bunker Door", "BunkerDoor", 13);
		Item storDoor = new Item("Closet Door", "Closet", 14);
		Item classDoor = new Item("Class Door", "ClassDoor", 15);
		Item window = new Item("Window", "window", 16);
		Item lDrawer =new Item("Left Drawer", "LeftDrawer", 17);
		Item rDrawer = new Item("Right Drawer", "RightDrawer", 18);
		Item bDrawer = new Item("Back Drawer", "BackDrawer", 19);
		Item counter = new Item("Counter", "Counter Top", 20);
		Item box = new Item("Box", "box", 21);
		Item tv = new Item("TV", "Television", 22);

		ArrayList<Item> use = new ArrayList<>(Arrays.asList(distKey, storKey, classKey, lswitch, arcade));
		ArrayList<Item> take = new ArrayList<>(Arrays.asList(pin, driver, brick));
		ArrayList<Item> look = new ArrayList<>(Arrays.asList(arcade, couch, bigTable, table, longTable, counter, tv, lswitch));
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

		DialogueParser.readDialogue("./OverallDialogue-Bunker");

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

		DialogueParser.readDialogue("../../OverallDialogue-Classroom.txt");

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

		DialogueParser.readDialogue("../../OverallDialogue-Commons.txt");

		return commons;	
	}

	public void run(){
		welcome();
		gameManager();
	}
	Validation validate = new Validation();
	private ArrayList<Command> commandHistory = new ArrayList<Command>();
	private void gameManager() {
		Room currentRoom = createBunker();
		tutorialPhase(currentRoom);
		story(currentRoom);
	}
	private void story(Room currentRoom) {
		boolean bunkerDone = false;
		boolean classRoomDone = false;
		boolean commonsDone = false;
		while(!bunkerDone){
			
			Command com = validate.getCommand(currentRoom, commandHistory);
			addToHistory(com);	

		}
		if(!classRoomDone){
			currentRoom = createClassRoom();
		}
		while(!classRoomDone){

		}
		currentRoom = createCommons();
		while(!commonsDone){

		}
	}

	private void tutorialPhase(Room room) {
		System.out.println("Tutorial: Type in the keywords below" +
				"\nWords in curly braces are commands, words in brackets are valid items.");
		promptTutCommand(Action.LOOKAT, room, "\n{Lookat [light][switch]");
		promptTutCommand(Action.USE, room, "\n{Use} [light][switch]");
		System.out.println("End tutorial: Confused or Lost? Enter [help] for commands and key items.");
	}

	public void promptTutCommand(Action action, Room room, String message){
		boolean valid = false;
		while(!valid){
			System.out.println(message);
			Command com = validate.getCommand(room, commandHistory);
			if(com.getAction() != action | (!com.getItem().getName1().equalsIgnoreCase("light") || !com.getItem().getName2().equalsIgnoreCase("switch"))){
				System.out.println("We're trying to help you get used to the system! Please try again...");
			}else{
				valid = true;
				addToHistory(com);
				DialogueParser.ReadSpecificLine("./BunkerActionDialogue.txt", com.getAction().getValue() + com.getItem().getValue());
			}
		}
	}

	private void addToHistory(Command com) {
		if(!commandHistory.contains(com)){
			commandHistory.add(com);
		}
		
	}
	private void welcome() {
		System.out.println("Welcome to Escape the Bunker, a modernized approach to the classic text-based adventure games!");
		System.out.println("You'll be starting out in the bunker, and attempt to get out from there.\nLet's get started!");		
	}

}

