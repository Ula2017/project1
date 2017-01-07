package com.company;

import java.util.List;

public class ArgumentsParser
{
    private String[] args;
    private int number;


    public ArgumentsParser(String[] args){
    this.args= args;
    }
    public void argumentParse(String[] args) throws Exception {

        if(this.args.length==0) throw new IllegalArgumentException("Brak argumentów");
        if (this.args.length <2)
            throw new IllegalArgumentException("Wprowadzono niepoprawną ilość argumentów.");
        switch (this.args[0]) {
            case "8":
                number=8;
                break;
            case "7":
                number=7;
                break;
            default:
                throw new IllegalArgumentException("Nieprawidlowy argument pierwszy");
        }
        OfficeTerm cadence=new OfficeTerm();
        cadence.deputyListCreate(number);
       List<Deputy> dep =cadence.getDeputiesList();
        for(int j=0; j<500; j++){
            System.out.println(dep.get(j).getNames());
            System.out.println("Ula");
            System.out.println(dep.get(j).getID());
        }

        switch(this.args[1]){
            case "p":
                System.out.print("Mama");
                break;
            case "s":
                break;
            case "a":
                break;
            case "t":
                break;
            case "l":
                break;
            case "e":
                break;
            case "i":
                break;
            default:
                throw new IllegalArgumentException("Nie ma takiej informacji");
        }
    }
}
