package pokergame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

public class PokerGame2 {
    public static void main(String[] args) {
        HashMap<Integer, String> pokerbox = new HashMap<>();
        ArrayList<String> colors = new ArrayList<>();
        ArrayList<String> numbers = new ArrayList<>();

        Collections.addAll(colors, "♦", "♣", "♥", "♠");
        Collections.addAll(numbers, "2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3");

        int count=0;
        pokerbox.put(count++,"大王");
        pokerbox.put(count++,"小王");

        for (String number : numbers) {
            for (String color : colors) {
                pokerbox.put(count++,color+number);
            }
        }

        Set<Integer> integers = pokerbox.keySet();
        ArrayList<Integer> numlist = new ArrayList<>();
        numlist.addAll(integers);
        Collections.shuffle(numlist);

        ArrayList<Integer> p1 = new ArrayList<>();
        ArrayList<Integer> p2 = new ArrayList<>();
        ArrayList<Integer> p3 = new ArrayList<>();
        ArrayList<Integer> bottom = new ArrayList<>();

        for (int i = 0; i < numlist.size(); i++) {
            Integer integer = numlist.get(i);
            if (integer>=51){
                bottom.add(i);
            }else {
                if (integer%3==0){
                    p1.add(i);
                }else if (integer%3==1){
                    p2.add(i);
                }else if (integer%3==2){
                    p3.add(i);
                }
            }
        }

        Collections.sort(p1);
        Collections.sort(p2);
        Collections.sort(p3);
        Collections.sort(bottom);

        ArrayList<String> player1 = new ArrayList<>();
        ArrayList<String> player2 = new ArrayList<>();
        ArrayList<String> player3 = new ArrayList<>();
        ArrayList<String> bottomcard = new ArrayList<>();

        for (Integer integer : p1) {
            player1.add(pokerbox.get(integer));
        }
        for (Integer integer : p2) {
            player2.add(pokerbox.get(integer));
        }
        for (Integer integer : p3) {
            player3.add(pokerbox.get(integer));
        }
        for (Integer integer : bottom) {
            bottomcard.add(pokerbox.get(integer));
        }

        System.out.println(player1);
        System.out.println(player2);
        System.out.println(player3);
        System.out.println(bottomcard);
    }
}
