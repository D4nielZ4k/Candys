package com.company;

import java.util.*;

import java.util.stream.Collectors;

public class Dane {
    Slodycz s1 = new Slodycz("guma");
    Slodycz s2 = new Slodycz("lizak");
    Slodycz s3 = new Slodycz("czekolada");
    Slodycz s4 = new Slodycz("jagodzianka");
    Slodycz s5 = new Slodycz("ciasto");


    List<Slodycz> d1S = new ArrayList<>();

    {

        d1S.add(s1);
        d1S.add(s1);
        d1S.add(s2);
        d1S.add(s3);
        d1S.add(s4);
        d1S.add(s4);
        d1S.add(s4);
    }

    List<Slodycz> d2S = new ArrayList<>();

    {

        d2S.add(s1);
        d2S.add(s1);
        d2S.add(s1);
        d2S.add(s1);
        d2S.add(s3);
        d2S.add(s4);
        d2S.add(s5);
    }

    Dziecko d1 = new Dziecko("d1", d1S);
    Dziecko d2 = new Dziecko("d2", d2S);

    // zwroc lista wszystkich slodyczy ktore kupily dzieci
    public List<String> wszystkieSlodycze() {
        List<String> all = new ArrayList<>();

        all.addAll(d1S.stream().map(Slodycz::getNazwa).toList());
        all.addAll(d2S.stream().map(Slodycz::getNazwa).toList());

        return all;
    }
    // zwroc liste unikalnych nazw wszystkich slodyczy ktore kupily dzieci
    public List<String> wszystkieSlodycze2() {
        List<String> all = new ArrayList<>();

        all.addAll(d1S.stream().map(Slodycz::getNazwa).toList());
        all.addAll(d2S.stream().map(Slodycz::getNazwa).toList());
        all = all.stream().distinct().collect(Collectors.toList());

        return all;
    }
// ile słodyczy podanego typu kupily dzieci

    public int danegoTypu(final String nazwaSlodycza) {
        List<String> all = new ArrayList<>();
        all.addAll(d1S.stream().map(Slodycz::getNazwa).toList());
        all.addAll(d2S.stream().map(Slodycz::getNazwa).toList());

        return all.stream().filter(c -> c.equals(nazwaSlodycza)).toList().size();
    }
// znajdz pierwsze dziecko które ma przynajmniej 2 slodycze

    public String pierwsze() {
        List<Dziecko> dzieci = new ArrayList<>();
        dzieci.add(d1);
        dzieci.add(d2);

        dzieci = dzieci.stream().filter(dziecko1 -> dziecko1.getSlodyczeDzicko().size() > 2).findFirst().stream().toList();

        return dzieci.get(0).getImie();
    }

    // sprawdz czy ktorekolwiek dziecko ma gume
    public String sprawdzGume(final String nazwaSlodycza) {
        List<Dziecko> dzieci = new ArrayList<>();
        dzieci.add(d1);
        dzieci.add(d2);
        
        String s = null;
        for (int i = 0; i < dzieci.size(); i++) {
            Integer ile = dzieci.get(i).getSlodyczeDzicko().stream().filter(slodycz -> slodycz.getNazwa().equals(nazwaSlodycza)).toList().size();
            if (ile > 0) {
                return "Ma dziecko gume";
            } else {
                return "nie ma dziecko gumy";
            }
        }
return s;
    }


    public static <T> T mostCommon(List<T> list) {
        Map<T, Integer> map = new HashMap<>();

        for (T t : list) {
            Integer val = map.get(t);
            map.put(t, val == null ? 1 : val + 1);
        }

        Map.Entry<T, Integer> max = null;

        for (Map.Entry<T, Integer> e : map.entrySet()) {
            if (max == null || e.getValue() > max.getValue())
                max = e;
        }

        return max.getKey();
    }


    // chcemy zwrócic dziecko które ma najwiecej slodyczy podanego typu
// czyli np d1 ma s1,s1,s2,s3,s4,s4,s4
// d2 ma s1,s1,s1,s1,s3,s4,s5
// to metoda dla parametru s1 powinna dac d2, dla parametru s4 powinna dac d1
    public void dzieckoNajWS(final String nazwaSlodycza) {
        List<Dziecko> dzieci = new ArrayList<>();
        dzieci.add(d1);
        dzieci.add(d2);
        HashMap<String, Integer> sort = new HashMap<String, Integer>();

        for(int i=0; i<dzieci.size(); i++){
           Integer ile =  dzieci.get(i).getSlodyczeDzicko().stream().filter(slodycz -> slodycz.getNazwa().equals(nazwaSlodycza)).toList().size();
           sort.put(dzieci.get(i).getImie(),ile);
        }
        int maxValueInMap = (Collections.max(sort.values()));

        for (Map.Entry<String, Integer> entry :
                sort.entrySet()) {

            if (entry.getValue() == maxValueInMap) {

                // Print the key with max value
                System.out.println(entry.getKey());
            }}
    }



// zwroc wszystkie nazwy slodyczy, bezpowtórzen, scalone w jednego stringa z
// malych liter

    public String nazwySlodyczy() {
        List<String> all = new ArrayList<>();

        all.addAll(d1S.stream().map(Slodycz::getNazwa).toList());
        all.addAll(d2S.stream().map(Slodycz::getNazwa).toList());
        all = all.stream().distinct().collect(Collectors.toList());

        StringBuilder st = new StringBuilder();

        int i = 0;
        while (i < all.size() - 1) {
            st.append(all.get(i));
            i++;
        }
        st.append(all.get(i));
        String res = st.toString();

        return res;
    }

}
