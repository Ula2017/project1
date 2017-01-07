package com.company;

import java.util.ArrayList;
import java.util.List;


public class OfficeTerm {

    private List<Deputy> deputies=new ArrayList<>();


    public void deputyListCreate( int number) throws Exception {
        String cadencesURL="https://api-v3.mojepanstwo.pl/dane/poslowie.json?conditions[poslowie.kadencja]=";
        int tmp = 11;
        if(number==8) tmp--;
        for(int i=1; i<=tmp; i++) {
           cadencesURL = cadencesURL + number +"&_type=objects&page=" +i;
            addToList(new JsonParser().parser(cadencesURL));
        }

    }

    public void addToList(List<Deputy> tmpList) {

        deputies.addAll(tmpList);
    }

    public List<Deputy> getDeputiesList()
    {
        return deputies;
    }


}
