package project1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
//D:/konstytucja.txt lub D:\\konstytucja.txt

public class ConstitutionParser {

	public Constitution ConstitutionParse(String arg) throws IOException {
		int numberOfChapter = 0;
		int numberOfArticle = 0;
		int numberOfSubtitle = 0;
		int index = 0;
		Constitution constitution = new Constitution();
		File file = new File(arg);
		String line;
		String tmp;
		int length;

		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF8"));

		while ((line = in.readLine()) != null) {
			while (line.length() == 1) {
				line = in.readLine();
			}
			if (line.endsWith("Kancelaria Sejmu")) {
				line = in.readLine();
			}
			if (line.equals("2009-11-16")) {
				line = in.readLine();
			}
			while (line.endsWith("-")) {

				length = (line.length() - 1);
				tmp = line.substring(0, length);
				String tmp2 = in.readLine();
				line = tmp + tmp2;
			}

			if (line.startsWith("Rozdzia³")) {
				numberOfSubtitle = 0;
				numberOfChapter++;
				constitution.chapters.add(new Chapter(numberOfChapter));

			} else if (numberOfChapter == 0) {
				constitution.introduction.add(line);
			} else if (isUpperCase(line) && numberOfChapter > 0) {
				constitution.chapters.get(numberOfChapter - 1).subtitles.add(new Subtitle(line));
				numberOfSubtitle++;
				index = 0;
			} else if (line.startsWith("Art.")) {
				numberOfArticle++;
				constitution.chapters.get(numberOfChapter - 1).subtitles.get(numberOfSubtitle - 1)
						.add_article(new Article(numberOfArticle));
				index++;
			}

			else {
				constitution.chapters.get(numberOfChapter - 1).subtitles.get(numberOfSubtitle - 1).articles
						.get(index - 1).add_line(line);

			}
		}

		in.close();

		return constitution;

	}

	public boolean isUpperCase(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (Character.isLowerCase(s.charAt(i))) {
				return false;
			}
		}
		return true;
	}

}
