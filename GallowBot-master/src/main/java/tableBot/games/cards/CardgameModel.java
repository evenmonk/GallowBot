package tableBot.games.cards;

import java.util.ArrayList;

public class CardgameModel
{
    private static Deck deck = new Deck();
    private ArrayList <Card> cards = new ArrayList<Card>(4);


    public boolean getOneMoreCard() {
        cards.add(deck.getCardFromDeck());
        if(getValueOfHand() == 21) {//если мгновенно обнаружился победитель
            System.out.println("The winner is " + this);
            System.out.println(showCards());
            return false;
        } else {
            return true;
        }
    }

    public int getValueOfHand() {
        int value = 0;
        for(Card i : cards) {
            value += i.getValueOfCard();
        }
        return value;
    }
    public String showCards() {
        String result = "";
        int value = 0;
        for(Card i : cards) {
            result += i.getNameOfCard();
            value += i.getValueOfCard();
        }
        return result + "And value of those cards is:" + value;
    }
}
