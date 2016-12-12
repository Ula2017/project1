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
		throw new IllegalArgumentException("Artyku³ o numerze: " + numArt + " nie istnieje.");
	}

	Chapter findChapter(int numChapt) throws IllegalArgumentException {
		for (int i = 0; i < chapters.size(); i++) {
			if (chapters.get(i).number == numChapt)
				return chapters.get(i);
		}
		throw new IllegalArgumentException("Rozdzia³ o numerze: " + numChapt + " nie istnieje.");
	}

	String findDivArticle(String arg) throws IllegalArgumentException {
		String wynik[] = new String[2];
		String text = arg;
		Boolean test = false;
		String wyn = "";
		if (text.endsWith("-"))
			throw new IllegalArgumentException("Nie poda³eœ koñca przedzia³u. Popraw dane.");
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) == '-')
				test = true;
		}
		if (test == false)
			throw new IllegalArgumentException(
					"Nie poda³eœ drugiego argumentu. Podaj przedzia³ lub wybierz opcjê wypisywania drugiego arguemntu");
		wynik = text.split("-");
		int first = Integer.valueOf(wynik[0]);
		int last = Integer.valueOf(wynik[1]);
		if (first > last)
			throw new IllegalArgumentException(
					"Podany przedzia³ jest z³y.\n" + "Pocz¹tek przedzia³u jest wiêkszy ni¿ koniec");
		if (last > 234)
			throw new IllegalArgumentException("Podany przedzia³ jest zbyt du¿y. ");

		for (int i = first; i <= last; i++) {
			wyn+=findArticle(i);

		}
		return wyn;

	}

}
