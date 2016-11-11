package mainPack;

public enum Action {
	
	USE (100),
	GO_TO (200),
	PICK_UP (300),
	TAKE (300),
	LOOK_AT (400),
	INSPECT (400),
	SCAN (500),
	BREAK (600),
	OPEN (700),
	EXIT (800),
	ESCAPE (900),
	PICK(1000),
	CLEAN(1100),
	READ(400);
	
	private int value;
	
	private Action(int value){
		this.value = value;
	}
	
	public int getValue(){
		return value;
	}
}
