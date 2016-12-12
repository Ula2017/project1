package project1;

import java.util.ArrayList;
import java.util.List;

public class Constitution {
	List<Chapter> chapters;
	List<String> introduction;

	public Constitution() {
		chapters = new ArrayList<>();
		introduction = new ArrayList<>();
	}

	Article findArticle(int numArt) throws IllegalArgumentException {
		for (int i = 0; i < chapters.size(); i++) {
			if (chapters.get(i).getArticleNumber(numArt) != null)
				return chapters.get(i).getArticleNumber(numArt);
		}
		throw new IllegalArgumentException("Artyku� o numerze: " + numArt + " nie istnieje.");
	}

	Chapter findChapter(int numChapt) throws IllegalArgumentException {
		for (int i = 0; i < chapters.size(); i++) {
			if (chapters.get(i).number == numChapt)
				return chapters.get(i);
		}
		throw new IllegalArgumentException("Rozdzia� o numerze: " + numChapt + " nie istnieje.");
	}

	String findDivArticle(String arg) throws IllegalArgumentException {
		String wynik[] = new String[2];
		String text = arg;
		Boolean test = false;
		String wyn = "";
		if (text.endsWith("-"))
			throw new IllegalArgumentException("Nie poda�e� ko�ca przedzia�u. Popraw dane.");
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) == '-')
				test = true;
		}
		if (test == false)
			throw new IllegalArgumentException(
					"Nie poda�e� drugiego argumentu. Podaj przedzia� lub wybierz opcj� wypisywania drugiego arguemntu");
		wynik = text.split("-");
		int first = Integer.valueOf(wynik[0]);
		int last = Integer.valueOf(wynik[1]);
		if (first > last)
			throw new IllegalArgumentException(
					"Podany przedzia� jest z�y.\n" + "Pocz�tek przedzia�u jest wi�kszy ni� koniec");
		if (last > 234)
			throw new IllegalArgumentException("Podany przedzia� jest zbyt du�y. ");

		for (int i = first; i <= last; i++) {
			wyn+=findArticle(i);

		}
		return wyn;

	}

}
