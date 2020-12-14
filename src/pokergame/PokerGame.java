package pokergame;

import java.util.ArrayList;
import java.util.Collections;

public class PokerGame {
    public static void main(String[] args) {
        ArrayList<String> pokerbox = new ArrayList<>();
        ArrayList<String> colors = new ArrayList<>();
        ArrayList<String> numbers = new ArrayList<>();

        colors.add("♥");
        colors.add("♦");
        colors.add("♠");
        colors.add("♣");

        for (int i = 2; i <=10; i++) {
            numbers.add(i+"");
        }
        numbers.add("J");
        numbers.add("Q");
        numbers.add("K");
        numbers.add("A");

        for (String color : colors) {
            for (String number : numbers) {
                pokerbox.add(color+number);
            }
        }
        pokerbox.add("小☺");
        pokerbox.add("大☠");

        Collections.shuffle(pokerbox);

        ArrayList<String> p1 = new ArrayList<>();
        ArrayList<String> p2 = new ArrayList<>();
        ArrayList<String> p3= new ArrayList<>();
        ArrayList<String> bottom= new ArrayList<>();

        for (int i = 0; i < pokerbox.size(); i++) {
            String card=pokerbox.get(i);
            if (i>=51){
                bottom.add(card);
            }else{
                if (i%3==0){
                    p1.add(card);
                }else if (i%3==1){
                    p2.add(card);
                }else if (i%3==2){
                    p3.add(card);
                }
            }
        }

        System.out.println("p1: "+p1);
        System.out.println("p2: "+p2);
        System.out.println("p3: "+p3);
        System.out.println("bottom: "+bottom);
    }
}
