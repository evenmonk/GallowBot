package tableBot.games.cards;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private ArrayList <Card> cards = new ArrayList<Card>(36);
    Deck() {
        for(int i = 0; i <= 3; i++) {
            for(int j = 0; j <= 8; j++) {
                cards.add(new Card(i, j));
            }
        }
    }
    Card getCardFromDeck() {
        Random random = new Random();
        Card draw = cards.get(random.nextInt(cards.size()));
        cards.remove(draw);
        return draw;
    }
}
