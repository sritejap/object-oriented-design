package com.trello.services;

import com.trello.dao.CardDao;
import com.trello.entities.Card;
import com.trello.entities.User;
import com.trello.exceptions.CardNotFoundException;

import java.util.List;
import java.util.Objects;

public class CardServiceImpl implements CardService{
    private CardDao cardDao;
    private UserService userService;

    public CardServiceImpl(CardDao cardDao, UserService userService){
        this.cardDao = cardDao;
        this.userService = userService;
    }
    @Override
    public Card createCard(String name, String description, User assignTo){
        validate(assignTo);
        Integer id = getId("CARD");
        Card card = new Card(id,name, description, assignTo);
        cardDao.createCard(card);
        return card;
    }

    private void validate(User user){
    }

    @Override
    public boolean deleteCard(Integer cardId){
        Card card = getCard(cardId);
        cardDao.deleteCard(cardId);
        return true;
    }

    @Override
    public boolean deleteCards(List<Card> cards){
        cards.forEach(card -> deleteCard(card.getId()));
        return true;
    }

    private boolean isCardValid(Card card){
        if(Objects.nonNull(card)){
            return true;
        }
        return false;
    }

    @Override
    public boolean assignUser(User user, Integer cardId){
        Card card = getCard(cardId);
        validate(user);
        card.setAssignedTo(user);
        updateCard(card);
        return true;
    }

    @Override
    public Card updateCard(Card card){
        cardDao.updateCard(card);
        return card;
    }

    @Override
    public boolean unassignUser(Integer cardId){
        Card card = getCard(cardId);
        card.setAssignedTo(null);
        updateCard(card);
        return true;
    }

    @Override
    public Card getCard(Integer cardId){
        Card card = cardDao.getCard(cardId);
        if(isCardValid(card)){
            return card;
        }
        throw new CardNotFoundException();
    }

    public Integer getId(String code){
        return IDGenerator.getId(code);
    }
}
