package project1;

import java.util.ArrayList;
import java.util.List;

public class Subtitle {
	String title;
	List<Article> articles;

	public Subtitle(String t) {
		this.title = t;
		this.articles = new ArrayList<>();
	}

	public void add_article(Article a) {
		articles.add(a);
	}

	public Article getArticle(int number) {
		for (int i = 0; i < articles.size(); i++) {
			if (articles.get(i).number == number)
				return articles.get(i);
		}
		return null;
	}

	public String toString() {
		String wynik = title + "\n";
		for (int i = 0; i < articles.size(); i++) {
			wynik += articles.get(i);
		}
		return wynik;
	}
}
