package tableBot.games.cards;

enum suits {Heart, Diamond, Club, Spade}
enum ranks {Ace (11), King (4), Queen (3), Jack (2), Ten (10), Nine (9), Eight (8), Seven (7), Six (6);
    private final int value;
    ranks(int newValue) {
        this.value = newValue;
    }
    public int getValue() {
        return value;
    }
}
public class Card {
    private suits suit;
    private ranks rank;
    public Card(int newSuit, int newRank) {
        switch (newSuit) {
            case 0 : suit = suits.Heart; break;
            case 1 : suit = suits.Diamond; break;
            case 2 : suit = suits.Club; break;
            case 3 : suit = suits.Spade; break;
            default : suit = null; System.out.println("There is no such suit here");
        }
        switch (newRank) {
            case 0 : rank = ranks.Ace; break;
            case 1 : rank = ranks.King; break;
            case 2 : rank = ranks.Queen; break;
            case 3 : rank = ranks.Jack; break;
            case 4 : rank = ranks.Six; break;
            case 5 : rank = ranks.Seven; break;
            case 6 : rank = ranks.Eight; break;
            case 7 : rank = ranks.Nine; break;
            case 8 : rank = ranks.Ten; break;
            default : rank = null; System.out.println("There is no such rank here");
        }
    }
    public String getNameOfCard() {
        return "suit: " + suit + " rank: " + rank + ";\n";
    }
    public int getValueOfCard() {
        return rank.getValue();
    }
}
/*
public class CardStorage
{

    HashMap<String, Integer> cardsValue = new HashMap<>();
        cardsValue.put("Ap", 11);
        cardsValue.put("Ab", 11);
        cardsValue.put("Ak", 11);
        cardsValue.put("Ach", 11);
        cardsValue.put("Kp", 4);
        cardsValue.put("Kb", 4);
        cardsValue.put("Kk", 4);
        cardsValue.put("Kch", 4);
        cardsValue.put("Qp", 3);
        cardsValue.put("Qb", 3);
        cardsValue.put("Qk", 3);
        cardsValue.put("Qch", 3);
        cardsValue.put("Jp", 2);
        cardsValue.put("Jb", 2);
        cardsValue.put("Jk", 2);
        cardsValue.put("Jch", 2);
        cardsValue.put("10p", 10);
        cardsValue.put("10b", 10);
        cardsValue.put("10k", 10);
        cardsValue.put("10ch", 10);
        cardsValue.put("9p", 9);
        cardsValue.put("9b", 9);
        cardsValue.put("9k", 9);
        cardsValue.put("9ch", 9);
        cardsValue.put("8p", 8);
        cardsValue.put("8b", 8);
        cardsValue.put("8k", 8);
        cardsValue.put("8ch", 8);
        cardsValue.put("7p", 7);
        cardsValue.put("7b", 7);
        cardsValue.put("7k", 7);
        cardsValue.put("7ch", 7);
        cardsValue.put("6p", 6);
        cardsValue.put("6b", 6);
        cardsValue.put("6k", 6);
        cardsValue.put("6ch", 6);

    private ArrayList<Character> usedCards;

    public CardStorage()
    {
        usedCards = new ArrayList<>();

    }

    {
        StringBuilder builder = new StringBuilder(length);
        for (int i = 0; i < k; i++)
            builder.append('?');
        return builder.toString().toCharArray();
    }
}*/
