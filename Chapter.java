package project1;

import java.util.ArrayList;
import java.util.List;

//pierwszy podzial w konstytucji
public class Chapter {
 int number;
 List<Subtitle> subtitles; 
 
  public Chapter(int number){
	  this.number=number;
	  this.subtitles= new ArrayList<>();
  }
  public void add_subtitle(Subtitle a){
	  subtitles.add(a);
  }
  
  public Article getArticleNamber(int number){
	  for(int i=0; i<subtitles.size(); i++){
		  if(subtitles.get(i).getArticle(number)!=null)
			  return subtitles.get(i).getArticle(number);
	  }
	  return null;
  }
 
}
