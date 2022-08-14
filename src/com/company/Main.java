package com.company;


public class Main {

    public static void main(String[] args) {
        Dane dane = new Dane();

        System.out.println(dane.wszystkieSlodycze());
        System.out.println(dane.wszystkieSlodycze2());
        System.out.println(dane.danegoTypu("guma"));
        System.out.println(dane.pierwsze());
        System.out.println(dane.sprawdzGume("guma"));
        System.out.println(dane.nazwySlodyczy());
        dane.dzieckoNajWS("jagodzianka");
        dane.dzieckoNajWS("guma");
    }


}
