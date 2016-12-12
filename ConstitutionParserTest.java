package project1;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConstitutionParserTest {

	@Test
	public void test() {
	   ConstitutionParser parse = new ConstitutionParser();
	   assertTrue(parse.isUpperCase("MAMA"));
	   assertFalse(parse.isUpperCase("duzy"));
	   
	}

}
