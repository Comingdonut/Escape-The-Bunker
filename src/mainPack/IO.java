package mainPack;

public class IO {
	
	public void printUnknownCommandError(){
		System.err.println("I don't know how to do that.");
	}
	
	public void printCommandError(Action a, Item b){
		System.err.println("The command [" + a.toString() + "] is not compatible with [" + b.toString() + "].");
	}
	
	public void printError(String error){
		System.err.println(error);
	}
	
	public void print(String message){
		System.out.println(message);
	}
}