package mainPack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Validation {

	private static BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
	private Command command;

	private Action getAction(String input){
		Action action = null;
		for(Action a : Action.values()){
			if(input.toLowerCase().contains(a.toString().toLowerCase())){
				action = a;
			}
		}
		return action;
	}

	private Item getItem(String input, ArrayList<Item> items){
		Item item = null;
		for(Item i : items){
			if(input.toLowerCase().contains(i.getName1().toLowerCase()) || input.toLowerCase().contains(i.getName2().toLowerCase())){
				item = i;
			}
		}
		return item;
	}

	public Command getCommand(Room room, ArrayList<Command> commands){
		command = null;
		Action action = null;
		Item item = null;
		do{
			String input = getInput();
			if(input.contains("help")){
				helper(commands);
			}
			else if(input.contains("look around")){
				System.out.println(room.getDescription());
			}
			else{
				action = getAction(input);
				item = getItem(input, room.getAvailable());
				if(validation(action, item, room)){
					command = new Command(action, item);
				}
			}
		}while(command == null);

		return command;
	}

	private void helper(ArrayList<Command> commands) {
		System.out.println("Command List:");
		for(Command c : commands){
			System.out.println(c.getAction().toString());
		}

	}

	private boolean validation(Action action, Item item, Room room){
		return checkIfExists(action, item) && checkIfValidCombo(action, item, room) /*&& checkIfInSection(item, room)*/;
	}
	private boolean checkIfExists(Action action, Item item){
		boolean valid = true;
		if(action == null || item == null){
			IO.printUnknownCommandError();
			valid = false;
		}
		return valid;
	}
	private boolean checkIfValidCombo(Action action, Item item, Room room){
		boolean valid = false;
		if(room.getItemsPerAction().keySet().contains(action)){
			if(room.getItemsPerAction().get(action).contains(item)){
				valid = true;
			}else{
				IO.printCommandError(action, item);
			}
		}
		else{
			IO.printCommandError(action, item);
		}
		return valid;
	}
	//	private boolean checkIfInSection(Item item, Room room){
	//		boolean valid = false;
	//		if(room.getRelative().contains(item)){
	//			valid = true;
	//		}else{
	//			IO.printError("Your arms are not long enough.");
	//		}
	//		return valid;
	//	}
	public static String getInput(){
		String input = "";
		System.out.print("\n> ");
		try{
			input = read.readLine();
		}
		catch(IOException er){
		}
		return input;
	}
}
