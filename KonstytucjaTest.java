package project1;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class KonstytucjaTest {

	@Test
	public void test() {
		
		 
		 try {
			 ConstitutionParser parse = new ConstitutionParser();
			Constitution constitution= parse.ConstitutionParse("D:/konstytucja.txt");
			assertFalse(constitution.chapters.isEmpty());
			assertEquals(constitution.chapters.get(0), 1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}

}
