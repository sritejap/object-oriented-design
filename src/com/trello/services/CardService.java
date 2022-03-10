package com.trello.services;

import com.trello.entities.Card;
import com.trello.entities.User;

import java.util.List;

public interface CardService {
    public Card createCard(String name, String description, User assignTo);

    public boolean deleteCard(Integer cardId);

    public boolean deleteCards(List<Card> cards);

    public Card updateCard(Card card);

    public boolean assignUser(User user, Integer cardId);

    public boolean unassignUser(Integer cardId);

    public Card getCard(Integer cardId);
}
