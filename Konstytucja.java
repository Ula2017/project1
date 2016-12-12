package project1;

import java.io.FileNotFoundException;
import java.io.IOException;
//"D:/konstytucja.txt"

public class Konstytucja {
	public static void main(String[] args) {
		try {
			ConstitutionParser parser = new ConstitutionParser();
			Constitution constitution = parser.ConstitutionParse(args[0]);
			int num;
			

			if (args.length != 3)
				throw new IllegalArgumentException("Wprowadzono niepoprawn� ilo�� argument�w.");
			switch (args[1]) {

			case "r":
				num = Integer.valueOf(args[2]);
				System.out.print(constitution.findChapter(num));

				break;
			case "a":
				num = Integer.valueOf(args[2]);
				System.out.print(constitution.findArticle(num));
				break;
			case "A":
				num = Integer.valueOf(args[2]);
				System.out.print(constitution.findArticle(num));
				break;
			case "R":
				num = Integer.valueOf(args[2]);
				System.out.print(constitution.findChapter(num));
				break;
			case "P":
				System.out.print(constitution.findDivArticle(args[2]));
				break;
			case "p":
				System.out.print(constitution.findDivArticle(args[2]));
				break;
			default:
				throw new IllegalArgumentException("U�ytkownik poda� warto�� nieprawdziw�:" + args[1]
						+ " .\nWprowadz A lub a je�li chcesz wy�wietli� pewnien artyku�. \n"
						+ "Wprowa� R lub r jesli chcesz wy�wietli� pewnien rozdzia�. \n"
						+ "Wprowadz P lub p je�li chcesz wy�wietli� przedzia� argument�w.");
			}
		} catch (FileNotFoundException e) {
			System.out.println("Plik o takiej nazwie nie istnieje.");
		} catch (NumberFormatException e) {
			System.out.println(args[2] + " nie jest liczba. \nWprowadz poprawna wartosc.");
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
