package com.franckycorp;

import com.franckycorp.model.Deck;
import com.franckycorp.model.NormalDeck;
import com.franckycorp.model.SmallDeck;
import com.franckycorp.model.TestDeck;

public class DeckFactory {
    public enum DeckType {
        Normal,
        Small,
        Test
    };

    public static Deck makeDeck(DeckType type) {
        switch (type) {
            case Normal: return new NormalDeck();
            case Small: return new SmallDeck();
            case Test: return new TestDeck();
        }

        return new NormalDeck();
    }
}
