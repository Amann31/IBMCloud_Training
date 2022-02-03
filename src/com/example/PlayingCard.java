package com.example;

public class PlayingCard {
    private int rank;
    private Card card;

    public PlayingCard(Card card, int rank) {
        this.rank = rank;
        this.card = card;
    }

    public int getRank() {
        return rank;
    }

    public static void main(String[] args){
        PlayingCard card1 = new PlayingCard(Card.SUIT_SPADES,2);
        System.out.println("Card 1 is the " + card1.getRank()+ " of " +Card.SUIT_SPADES.getSuitName());
        PlayingCard card2 = new PlayingCard(Card.SUIT_CLUB,1);
        System.out.println("Card 2 is the " + card2.getRank()+ " of " +Card.SUIT_CLUB.getSuitName());
    }
}
