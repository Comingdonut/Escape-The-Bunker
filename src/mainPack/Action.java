package mainPack;

public enum Action {
	
	USE (100),
	GOTO (200),
	PICKUP (300),
	TAKE (300),
	LOOKAT (400),
	INSPECT (400),
	SCAN (500),
	BREAK (600),
	OPEN (700),
	EXIT (800),
	ESCAPE (900),
	PICKLOCK(1000),
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
