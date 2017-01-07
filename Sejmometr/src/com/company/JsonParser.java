package com.company;


import java.util.ArrayList;
import java.util.List;

public class JsonParser {
    public List<Deputy> parser (String url) throws Exception {

            String json = URLReader.read(url);

        boolean pierwsza = false;
        boolean druga = false;
        boolean trzecia = false;
        char one;
        String id=" ";
        List<Deputy> deputies=new ArrayList<>();
        for(int i=0;i<json.length();i++)
        {


            if(json.charAt(i)=='{' && pierwsza && druga)
            {
                Deputy deputy = new Deputy();
                deputy.addID(id);

                while(json.charAt(i)!=':' && i<json.length()) i++;
                i++;
                while(json.charAt(i)!=':' && i<json.length()) i++;
                i+=2; //omitting "
                StringBuilder tmp = new StringBuilder();
                while(json.charAt(i)!='"' && i< json.length())
                {
                    boolean unicodeSign = false;
                    char c='r';
                    if(json.charAt(i)==92)
                    {
                        c=unicodeSign(json, i);
                        unicodeSign = true;
                        i+=5;
                    }

                    if(!unicodeSign) one=json.charAt(i);
                    else one=c;
                    tmp.append(one);
                    i++;
                }
                String nazwa = String.valueOf(tmp);
                deputy.addName(nazwa);
                deputies.add(deputy);

                druga = false;
            }
            if(json.charAt(i)=='{' && pierwsza && !druga ){
                druga = true;
                while(json.charAt(i)!=':' && i<json.length())
                    i++;
                i+=2; //omijam cudzysłów
                StringBuilder result =new StringBuilder();

                while(json.charAt(i)!='"' && i<json.length())
                {

                    one= json.charAt(i);
                    result.append(one);
                    i++;

                }
                id = String.valueOf(result);
            }
            if(json.charAt(i)=='{' && !pierwsza && !druga) pierwsza=true;
        }

        return deputies;
        }

        public char unicodeSign(String json, int i){
            char c = 'r';
            i++;
            StringBuilder temp = new StringBuilder();
            temp.append("\\");
            for(int j=0;j<5;j++,i++)
            {
                temp.append((char)json.charAt(i));
            }


            c = (char) Integer.parseInt( temp.substring(2), 16 );
            return c;

        }

}
