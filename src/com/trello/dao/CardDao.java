package com.trello.dao;

import com.trello.entities.Card;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CardDao {
    private Map<Integer, Card> cardMap = new HashMap<>();
//
//    public CardDao(Map<Integer, Card> cardMap) {
//        this.cardMap = cardMap;
//    }

    public Card getCard(Integer cardId) {
        return cardMap.get(cardId);
    }

    public boolean createCard(Card card) {
        if(Objects.nonNull(getCard(card.getId()))){
            return false;
        }
        cardMap.putIfAbsent(card.getId(), card);
        return true;
    }

    public Card updateCard(Card card) {
        cardMap.put(card.getId(), card);
        return card;
    }

    public boolean deleteCard(Integer cardId){
        cardMap.remove(cardId);
        return true;
    }
}
