package mainPack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Game {

	private Room createBunker(){
		Room bunker = null;
		HashMap<Action, ArrayList<Item>> actionables = new HashMap<Action, ArrayList<Item>>();
		Item brick = new Item("Brick", "brick", 1, null, null);
		Item distKey = new Item("Distorted Key", "Warped Key", 4, null, null);
		Item classKey = new Item("Classroom Key", "ClassroomKey", 6, null, null);
		Item pin = new Item("Bobby Pin", "Pin", 2, null, classKey);
		Item storKey = new Item("Closet Key", "ClosetKey", 5, null, classKey);
		Item lswitch = new Item("Light", "Switch", 7, null, null);
		Item arcade = new Item("Arcade", "Machine", 8, null, brick);
		Item couch = new Item("Couch", "couch", 9, null, null);
		Item bigTable =new Item("Big Table", "bTable", 10, null, null);
		Item table = new Item("Table", "table", 11, null, null);
		Item longTable = new Item("Long Table", "LongTable", 12, null, distKey);
		Item storDoor = new Item("Closet Door", "Closet", 14, pin, classKey);
		Item classDoor = new Item("Class Door", "ClassDoor", 15, classKey, null);
		Item window = new Item("Window", "window", 16, brick, null);
		Item lDrawer =new Item("Left Drawer", "LeftDrawer", 17, null, null);
		Item rDrawer = new Item("Right Drawer", "RightDrawer", 18, distKey, pin);
		Item box = new Item("Box", "box", 21, null, storKey);
		Item counter = new Item("Counter", "Counter Top", 20, null, null);
		Item tv = new Item("TV", "Television", 22, null, box);

		ArrayList<Item> use = new ArrayList<>(Arrays.asList(distKey, storKey, classKey, lswitch, arcade));
		ArrayList<Item> take = new ArrayList<>(Arrays.asList(pin, brick, box, storKey, distKey, classKey));
		ArrayList<Item> look = new ArrayList<>(Arrays.asList(arcade, couch, bigTable, table, longTable, counter, tv, lswitch));
		ArrayList<Item> open = new ArrayList<>(Arrays.asList(storDoor, classDoor, lDrawer, rDrawer));
		ArrayList<Item> breakA = new ArrayList<>(Arrays.asList(window));
		ArrayList<Item> pickLock = new ArrayList<>(Arrays.asList(pin));

		ArrayList<Item> hidden = new ArrayList<>(Arrays.asList(brick, distKey, pin, storKey, classKey, box));
		ArrayList<Item> available = new ArrayList<>(Arrays.asList(lswitch, arcade, couch, bigTable, table, longTable, classDoor, window, rDrawer, lDrawer, counter, tv));

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
		bunker.setDescription("To the left, there is a countertop with a TV and under it are two separate drawers, one on the left, and one on the right.\n" + 
				"Near the entrance is the arcade machine, and a big table.\n" + 
				"In the left side there is a long table and in the right side is a single table.\n" +
				"In the back of the room, there is couch, closet door and a classroom door.\n" +
				"There is a window next to the bunker door.\n");
				DialogueParser.readDialogue("./OverallDialogue-Bunker");

		return bunker;	
	}
	private Room createClassRoom(){

		Room classRoom = null;

		HashMap<Action, ArrayList<Item>> actionables = new HashMap<Action, ArrayList<Item>>();

		Item cloth = new Item("Cloth", "Towel", 7, null, null);
		Item clock = new Item("Clock", "", 1, cloth, null);
		Item desk = new Item("Desk", "", 2, null, cloth);
		Item table = new Item("Tables", "Table", 3, null, null);
		Item classKey = new Item("ClassKey", "Class Key", 8, null, null);
		Item locker = new Item("Locker", "Cabinet", 4, null,classKey);
		Item classDoor = new Item("Classroom Door", "Classroom", 6, classKey, null);



		ArrayList<Item> pickUp = new ArrayList<>(Arrays.asList(cloth));
		ArrayList<Item> lookAt = new ArrayList<>(Arrays.asList(locker, clock, desk));
		ArrayList<Item> use = new ArrayList<>(Arrays.asList(cloth));
		ArrayList<Item> open = new ArrayList<>(Arrays.asList(locker));

		ArrayList<Item> hidden = new ArrayList<>(Arrays.asList(cloth, classKey));
		ArrayList<Item> available = new ArrayList<>(Arrays.asList(clock, desk, table, locker, classDoor));

		actionables.put(Action.PICKUP, pickUp);
		actionables.put(Action.TAKE, pickUp);
		actionables.put(Action.INSPECT, lookAt);
		actionables.put(Action.LOOKAT, lookAt);
		actionables.put(Action.OPEN, open);
		actionables.put(Action.USE, use);

		classRoom = new Room(actionables, hidden, available);
		classRoom.setDescription("");//TODO:***************************************************
		DialogueParser.readDialogue("../../OverallDialogue-Classroom.txt");

		return classRoom;	
	}
	private Room createCommons(){

		Room commons = null;

		HashMap<Action, ArrayList<Item>> actionables = new HashMap<Action, ArrayList<Item>>();

		Item marketKey = new Item("MarketKey", "Market Key", 1, null, null);
		Item desk = new Item("Front Desk", "Desk", 4, null, null);
		Item noodles = new Item("Ramen", "Noodles", 2, null, null);
		Item spareKey = new Item("Spare Key", "SpareKey", 3, null, null);
		Item stickyNote = new Item("Sticky Note", "Sticky", 5, null, marketKey);
		Item market = new Item("Market", "Shop", 6, marketKey, noodles);
		Item price = new Item("Price", "Amount", 7, null, null);
		Item lock = new Item("Lock", "", 8, null, null);
		Item gate = new Item("Gate", "", 9, null, null);
		Item note = new Item("Note", "Memo", 11, null, null);
		Item clothes =new Item("Clothes", "", 10, null, note);
		Item drawer = new Item("Drawer", "", 12, null, spareKey);
		Item frontDoor = new Item("Front Door", "FrontDoor", 13, spareKey, null);
		Item sideDoor = new Item("Side Door", "SideDoor", 14, spareKey, null);
		Item backDoor = new Item("Back Door", "BackDoor", 15, spareKey, null);

		ArrayList<Item> pickUp = new ArrayList<>(Arrays.asList(marketKey, noodles, spareKey));
		ArrayList<Item> lookAt = new ArrayList<>(Arrays.asList(note, stickyNote, desk, market, clothes, price));
		ArrayList<Item> use = new ArrayList<>(Arrays.asList(frontDoor, backDoor, sideDoor, marketKey));
		ArrayList<Item> open = new ArrayList<>(Arrays.asList(drawer, gate, lock));
		ArrayList<Item> scan = new ArrayList<>(Arrays.asList(noodles));

		ArrayList<Item> hidden = new ArrayList<>(Arrays.asList(marketKey, noodles, spareKey,  price, lock, note));
		ArrayList<Item> available = new ArrayList<>(Arrays.asList(backDoor, sideDoor, stickyNote, frontDoor, desk, market, gate, drawer));

		actionables.put(Action.OPEN, open);
		actionables.put(Action.INSPECT, lookAt);
		actionables.put(Action.LOOKAT, lookAt);
		actionables.put(Action.USE, use);
		actionables.put(Action.SCAN, scan);
		actionables.put(Action.PICKUP, pickUp);
		actionables.put(Action.TAKE, pickUp);
		actionables.put(Action.READ, lookAt);

		commons = new Room(actionables, hidden, available);
		commons.setDescription("");//TODO:***************************************************
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
		int[] values = {108, 105, 301, 304, 321, 412, 422, 702, 718};
		while(!bunkerDone){

			Command com = validate.getCommand(currentRoom, commandHistory);
			//
			if(com.getItem().getNeeded() != null){
				//checks if items are contained in the bunker
				if(currentRoom.getAvailable().contains(com.getItem().getNeeded())){
					//reads line from file
					DialogueParser.ReadSpecificLine("./BunkerActionDialogue.txt", com.getAction().getValue() + com.getItem().getValue());
					//Adds to history
					addToHistory(com);
					//if stuff
					if(com.getAction().getValue() + com.getItem().getValue() == 616){
						bunkerDone = true;
						classRoomDone = true;
					}else if(com.getAction().getValue() + com.getItem().getValue() == 106){
						bunkerDone = true;
					}
				}else{
					IO.printCommandError(com.getAction(), com.getItem());
				}
			}else{
				DialogueParser.ReadSpecificLine("./BunkerActionDialogue.txt", com.getAction().getValue() + com.getItem().getValue());
				for(int i : values){
					if(com.getAction().getValue() + com.getItem().getValue() == i){
						currentRoom.takeItem(currentRoom.getHidden(), com.getItem().getContained());
					}
				}
			}
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
		promptTutCommand(Action.LOOKAT, room, "\n{Lookat} [light][switch]");
		promptTutCommand(Action.USE, room, "\n{Use} [light][switch]");
		System.out.println("\nEnd tutorial: Confused or Lost? Enter [help] for commands and key items.");
		System.out.println("Want to take a look around? Enter [look around] for a desciption of the room.");
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
		boolean exists = false;
		for(Command c : commandHistory){
			if(c.getAction() == com.getAction()){
				exists = true;
			}
		}
		if(!exists){
			commandHistory.add(com);
		}

	}

	private void welcome() {
		System.out.println("Welcome to Escape the Bunker, a modernized approach to the classic text-based adventure games!");
		System.out.println("You'll be starting out in the bunker, and attempt to get out from there.\nLet's get started!");		
	}

}

