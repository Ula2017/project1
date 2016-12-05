package project1;

import java.util.ArrayList;
import java.util.List;

public class Constitution {
	List<Chapter> chapters;

	public Constitution() {
		chapters = new ArrayList<>();
	}

	Article findArticle(int numArt) {
		for (int i = 0; i < chapters.size(); i++) {
			if (chapters.get(i).getArticleNamber(numArt) != null)
				return chapters.get(i).getArticleNamber(numArt);
		}
		return null;
	}

	Chapter findChapter(int numChapt) {
		for(int i=0; i<chapters.size(); i++){
			if(chapters.get(i).number == numChapt) return chapters.get(i);
		}
		return null;
	}
	
	//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1
	Article fromToArticle(String[] args){
		int from;
		int to;
		return null;
	}
}
