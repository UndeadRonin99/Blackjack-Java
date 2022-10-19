/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import javax.swing.JOptionPane;

/**
 *
 * @author Mike
 */
public class Blackjack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] cards = new String[52];
        int score = 0;
        boolean cont = true;
        cards = populate(cards);
        int i;
        int card;
        int cardValue;
        boolean bust = false;
        String conti;
        for (i = 0; i < 2; i++) {
            card = pickCard();
            cardValue = calculateValue(cards[card]);
            score = score + cardValue;
            System.out.println("Card " + (i + 1) + " is: " + cards[card]);
            System.out.println("Your score is now: " + score);
        }
        System.out.println("Your starting score is: " + score);
        if (score > 21) {
            bust = true;
        }

        if (score == 21) {
            System.out.println("Blackjack \nWell done!!");

        } else {
            while (cont && bust == false) {
                conti = JOptionPane.showInputDialog("Would you like another card. Please enter Draw for yes or Knock for no");
                if (conti.equalsIgnoreCase("Draw")) {
                    card = pickCard();
                    cardValue = calculateValue(cards[card]);
                    score = score + cardValue;
                    System.out.println("Card " + (i + 1) + " is: " + cards[card]);
                    i++;
                    System.out.println("Your score is now: " + score);
                    if (score > 21) {
                        bust = true;
                    }
                    if (score == 21) {
                        cont = false;
                        System.out.println("Blackjack \nWell done!!");

                    }
                } else {
                    System.out.println("Your final score is: " + score);
                    cont = false;
                }
            }
        }
        if (bust) {
            System.out.println("You are bust");
        }
        int dealerScore = dealer(cards);
        if(score > dealerScore && bust == false || dealerScore > 21){
            System.out.println("You won, well done!!!!!");
        } else {
            System.out.println("The dealer won, try again");
        }
    }

    public static int dealer(String[] cards) {
        int i;
        int card;
        int cardValue;
        boolean bust = false;
        int score = 0;
        boolean cont = true;
        for (i = 0; i < 2; i++) {
            card = pickCard();
            cardValue = calculateValueDealer(cards[card], score);
            score = score + cardValue;
            System.out.println("Card " + (i + 1) + " is: " + cards[card]);
            System.out.println("The dealer's score is now: " + score);
        }
        System.out.println("The dealer's starting score is: " + score);
        if (score > 21) {
            bust = true;
        }

        if (score == 21) {
            System.out.println("The dealer got a Blackjack");

        } else {
            while (cont && bust == false) {
                if (score <= 15) {
                    card = pickCard();
                    cardValue = calculateValueDealer(cards[card], score);
                    score = score + cardValue;
                    System.out.println("Card " + (i + 1) + " is: " + cards[card]);
                    i++;
                    System.out.println("The dealers score is now: " + score);
                    if (score > 21) {
                        bust = true;
                    }
                    if (score == 21) {
                        cont = false;
                        System.out.println("The dealer got a Blackjack");

                    }
                } else {
                    System.out.println("The dealer's final score is: " + score);
                    cont = false;
                }
            }
        }
        return score;
    }

    public static int pickCard() {
        int cardNum = -1;
        int max = 51;
        int min = 0;
        cardNum = (int) Math.floor(Math.random() * (max - min + 1) + min);;
        return cardNum;
    }

    public static String[] populate(String[] cards) {
        for (int i = 0; i < 52; i++) {
            if (i <= 13) {
                if (i == 0) {
                    cards[i] = "aH";
                }
                if (i > 0 && i < 10) {
                    cards[i] = (i + 1) + "H";
                }
                if (i == 10) {
                    cards[i] = "jH";
                }
                if (i == 11) {
                    cards[i] = "qH";
                }
                if (i == 12) {
                    cards[i] = "kH";
                }
            }
            if (i > 12 && i <= 25) {
                if (i == 13) {
                    cards[i] = "aC";
                }
                if (i > 13 && i < 23) {
                    cards[i] = (i - 12) + "C";
                }
                if (i == 23) {
                    cards[i] = "jC";
                }
                if (i == 24) {
                    cards[i] = "qC";
                }
                if (i == 25) {
                    cards[i] = "kC";
                }
            }
            if (i > 25 && i <= 38) {
                if (i == 26) {
                    cards[i] = "aS";
                }
                if (i > 26 && i < 36) {
                    cards[i] = (i - 25) + "S";
                }
                if (i == 36) {
                    cards[i] = "jS";
                }
                if (i == 37) {
                    cards[i] = "qS";
                }
                if (i == 38) {
                    cards[i] = "kS";
                }
            }
            if (i > 38 && i <= 51) {
                if (i == 39) {
                    cards[i] = "aD";
                }
                if (i > 39 && i < 49) {
                    cards[i] = (i - 38) + "D";
                }
                if (i == 49) {
                    cards[i] = "jD";
                }
                if (i == 50) {
                    cards[i] = "qD";
                }
                if (i == 51) {
                    cards[i] = "kD";
                }
            }
        }

        return cards;
    }

    public static int calculateValue(String card) {
        int cardValue = 0;
        char number = card.charAt(0);
        if (number == 'a') {
            String choice = JOptionPane.showInputDialog("Do you want 1 or 11");
            if (choice.equals("1")) {
                cardValue = 1;
            }
            if (choice.equals("11")) {
                cardValue = 11;
            }
        }
        if (number == 'j') {
            cardValue = 10;
        }
        if (number == 'q') {
            cardValue = 10;
        }
        if (number == 'k') {
            cardValue = 10;
        }
        switch (number) {
            case '2' ->
                cardValue = 2;
            case '3' ->
                cardValue = 3;
            case '4' ->
                cardValue = 4;
            case '5' ->
                cardValue = 5;
            case '6' ->
                cardValue = 6;
            case '7' ->
                cardValue = 7;
            case '8' ->
                cardValue = 8;
            case '9' ->
                cardValue = 9;
            case '1' ->
                cardValue = 10;
        }
        return cardValue;
    }
    
    public static int calculateValueDealer(String card, int score) {
        int cardValue = 0;
        char number = card.charAt(0);
        if (number == 'a') {
            if(score < 10){
                cardValue = 11;
            } else {
                cardValue = 1;
            }
        }
        if (number == 'j') {
            cardValue = 10;
        }
        if (number == 'q') {
            cardValue = 10;
        }
        if (number == 'k') {
            cardValue = 10;
        }
        switch (number) {
            case '2' ->
                cardValue = 2;
            case '3' ->
                cardValue = 3;
            case '4' ->
                cardValue = 4;
            case '5' ->
                cardValue = 5;
            case '6' ->
                cardValue = 6;
            case '7' ->
                cardValue = 7;
            case '8' ->
                cardValue = 8;
            case '9' ->
                cardValue = 9;
            case '1' ->
                cardValue = 10;
        }
        return cardValue;
    }
}
