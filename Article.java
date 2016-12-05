package project1;

import java.util.ArrayList;
import java.util.List;

public class Article {
	int number;
	List<String>lines;
	
	public Article (int number, String title){
		this.number=number;
		this.lines= new ArrayList<>();	
	}
 public void add_line( String line){
	 lines.add(line);
 }

	 
}
