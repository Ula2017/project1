package project1;

import java.util.ArrayList;
import java.util.List;

public class Chapter {
	int number;
	List<Subtitle> subtitles;

	public Chapter(int number) {
		this.number = number;
		this.subtitles = new ArrayList<>();
	}

	public void add_subtitle(Subtitle a) {
		subtitles.add(a);
	}

	public Article getArticleNumber(int number) {
		for (int i = 0; i < subtitles.size(); i++) {
			if (subtitles.get(i).getArticle(number) != null)
				return subtitles.get(i).getArticle(number);
		}
		return null;
	}

	public String toString() {
		String wynik = "Rozdzia³ " + number + "\n";
		for (int i = 0; i < subtitles.size(); i++) {
			wynik += subtitles.get(i);
		}
		return wynik;

	}

}
