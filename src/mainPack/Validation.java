package mainPack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Validation {

	private BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
	private Command command;

	private Action getAction(String input){
		Action action = null;
		for(Action a : Action.values()){
			if(input.contains(a.toString())){
				action = a;
			}
		}
		return action;
	}

	private Item getItem(String input, List<Item> items){
		Item item = null;
		for(Item i : items){
			if(input.toLowerCase().contains(i.getName1()) || input.toLowerCase().contains(i.getName2())){
				item = i;
			}
		}
		return item;
	}

	public Command getCommand(Room room){
		command = null;
		Action action = null;
		Item item = null;
		do{
			String input = getInput();
			action = getAction(input);
			item = getItem(input, room.getAvailable());
			if(validation(action, item, room)){
				command = new Command(action, item);
			}
		}while(command == null);

		return command;
	}

	private boolean validation(Action action, Item item, Room room){
		return checkIfExists(action, item) && checkIfValidCombo(action, item, room) && checkIfInSection(item, room);
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
		if(room.getItemsPerAction().get(action).contains(item)){
			valid = true;
		}else{
			IO.printCommandError(action, item);
		}
		return valid;
	}
	private boolean checkIfInSection(Item item, Room room){
		boolean valid = false;
		if(room.getRelative().contains(item)){
			valid = true;
		}else{
			IO.printError("Your arms are not long enough.");
		}
		return valid;
	}
	private String getInput(){
		String input = "";
		System.out.print("> ");
		try{
			input = read.readLine();
		}
		catch(IOException er){
		}
		return input;
	}
}
