package mainPack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

	private Item getItem(String input){
		Item item = null;
		//TODO: Make Item list
//		for(Item i : Item){
//			if(input.contains(i.toString){
//				item = i;
//			}
//		}
		return item;
	}

	public Command getCommand(/*Section Lists, Action/Item hashmap*/){
		command = null;
		Action action = null;
		Item item = null;
		do{
			String input = getInput();
			action = getAction(input);
			item = getItem(input);
			if(validation(action, item)){
				command = new Command(action, item);
			}
		}while(command == null);

		return command;
	}

	private boolean validation(Action action, Item item){
		//Add the actionable item hashmap
		//add in section item list
		return checkIfExists(action, item) && checkIfValidCombo(action, item) && checkIfInSection(action, item);
	}
	private boolean checkIfExists(Action action, Item item){
		boolean valid = true;
		if(action == null || item == null){
			IO.printUnknownCommandError();
			valid = false;
		}
		return valid;
	}
	private boolean checkIfValidCombo(Action action, Item item /* Actionable/Item Hashmap */){
		return false;
	}
	private boolean checkIfInSection(Action action, Item item /* Section lists */){
		return false;
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
