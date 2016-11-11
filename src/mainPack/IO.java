package mainPack;

public class IO {
	
	public static void printUnknownCommandError(){
		System.err.println("I don't know how to do that.");
	}
	
	public static void printCommandError(Action a, Item b){
		System.err.print("You can't [" + a.toString() + "] [" + b.getName1() + "] ");
		if(b.getNeeded() != null){
			System.err.print("yet.");
		}
	}
	
	public static void printError(String error){
		System.err.println(error);
	}
	
	public static void print(String message){
		System.out.println(message);
	}
}