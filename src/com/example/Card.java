package com.example;

public enum Card {
    SUIT_SPADES("Spades"),
    SUIT_HEARTS("Hearts"),
    SUIT_CLUB("Club"),
    SUIT_DIAMONDS("Diamonds")
    ;

    private String suitName;

    private Card(String suitName) {
        this.suitName = suitName;
    }

    public String getSuitName() {
        return suitName;
    }
}
