package mainPack;

public class IO {
	
	public void printCommandError(Action a, Item b){
		System.out.println("The command [" + a.toString() + "] is not capatible with [" + b.toString() + "].");
	}
	
	public void printError(String error){
		System.err.println(error);
	}
	
	public void print(String message){
		System.out.println(message);
	}
}
