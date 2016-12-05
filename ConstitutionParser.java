package project1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
//D:/konstytucja.txt lub D:\\konstytucja.txt
public class ConstitutionParser {
	
	public void ConstitutionParse (String arg) throws IOException{


		
		
	try{
		int numberOfChapter=0;
		Constitution constitution= new Constitution();
		File file = new File(arg);
		File file2= new File("D:/wynik.txt");

		BufferedWriter out = new BufferedWriter( new OutputStreamWriter( new FileOutputStream(file2), "UTF8"));

		BufferedReader in = new BufferedReader( new InputStreamReader( new FileInputStream(file), "UTF8"));
 
		
		String line;

		while ((line = in.readLine()) != null) {
			
			if(line.endsWith("Kancelaria Sejmu")){
				line=in.readLine();
			}
			if(line.equals("2009-11-16")){
				line=in.readLine();
			}
			if(line.endsWith("-")){
				//jak polaczyc przod i tyl wyrazu, 
			}
			if(line.startsWith("Rozdzia³")){
				numberOfChapter++;
	constitution.chapters.add(new Chapter(numberOfChapter));
//System. out.println(constitution.chapters.get(1).number);
				
			}

		    out.write(line);
		    System.out.print(line);
		}

                in.close();
                out.close();
	    }
	    catch (FileNotFoundException e)
	    {
			System.out.println("The file doesn't exist.");
	    }
    catch (IOException e)
	    {
			System.out.println(e.getMessage());
	    }

}
}
