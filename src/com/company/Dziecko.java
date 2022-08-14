package com.company;

import java.util.List;


public class Dziecko {
    String imie;

    List<Slodycz> slodyczeDzicko;

    public Dziecko(String imie, List<Slodycz> slodyczeDzicko) {
        this.imie = imie;
        this.slodyczeDzicko = slodyczeDzicko;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public List<Slodycz> getSlodyczeDzicko() {
        return slodyczeDzicko;
    }

    public void setSlodyczeDzicko(List<Slodycz> slodyczeDzicko) {
        this.slodyczeDzicko = slodyczeDzicko;
    }
}
