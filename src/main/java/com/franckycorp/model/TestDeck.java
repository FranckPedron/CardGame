package com.franckycorp.model;

import java.util.ArrayList;

public class TestDeck extends Deck{

    public TestDeck() {
        cards = new ArrayList<PlayingCard>();
        for (Suit suit: Suit.values()) {
            cards.add(new PlayingCard (Rank.ACE, suit));

                }
            }
    }
