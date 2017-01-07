package com.company;

public class Main {

    public static void main(String[] args) {
        try {

            ArgumentsParser parser = new ArgumentsParser(args);
            parser.argumentParse(args);

            } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Blad podczas parsowania");
        }

    }
}
