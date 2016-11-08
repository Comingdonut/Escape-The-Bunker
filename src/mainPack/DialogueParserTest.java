package mainPack;

import org.junit.Test;

public class DialogueParserTest {

	@Test
	public void test() {
		DialogueParser parse = new DialogueParser();
		parse.readDialogue("C:\\TestFile.txt");
	}

}
