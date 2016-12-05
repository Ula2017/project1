package project1;


import java.io.IOException;

//("D:/konstytucja.txt"

public class Konstytucja {
	public static void main(String[] args){
		ConstitutionParser parse = new ConstitutionParser();
		try {
			parse.ConstitutionParse(args[0]);
		} catch (IOException e) {
			System.out.println(e);
		}
		
		//w zaleznosci od arguemtu podanego jako drugi bedziemy wypisywaæ albo artyku³
		//albo rozdzial
/*		switch (args[1]){
		case "r":
			break;
		case "a":
			break;
		case "A":
			break;
		case "R":
			break;
			default:
				System.out.println("Nieprawidlowa wartosc ");
		} */
	
	}
}

