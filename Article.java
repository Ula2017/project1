package project1;

import java.util.ArrayList;
import java.util.List;

public class Article {
	int number;
	List<String> lines;

	public Article(int number) {
		this.number = number;
		this.lines = new ArrayList<>();
	}

	public void add_line(String line) {
		lines.add(line);
	}

	public String toString() {
		String wynik = "Art. " + number + "\n";
		for (int i = 0; i < lines.size(); i++) {
			wynik += lines.get(i) + "\n";
		}
		return wynik;
	}

}
