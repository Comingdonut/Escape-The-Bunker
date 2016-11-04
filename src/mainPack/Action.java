package mainPack;

public enum Action {
	
	USE (100),
	GOTO (200),
	PICKUP (300),
	TAKE (400),
	LOOKAT (500),
	INSPECT (600),
	SCAN (700),
	BREAK (800),
	OPEN (900),
	EXIT (1000),
	ESCAPE (1100);
	
	private int value;
	
	private Action(int value){
		this.value = value;
	}
	
	public int getValue(){
		return value;
	}
}
