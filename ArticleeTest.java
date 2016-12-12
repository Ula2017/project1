package project1;

import static org.junit.Assert.*;


import org.junit.Test;

public class ArticleeTest {

	@Test
	public void test() {
		 Article art1 = new Article(1);
		  art1.lines.add("Mama");
			Article art2=new Article(2);
			art2.add_line("Mama");
		assertEquals(art1.lines.get(0), "Mama" );
		assertEquals(art1.lines.get(0),art2.lines.get(0));
	
	}

}
