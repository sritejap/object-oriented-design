package com.trello.services;

import com.trello.dao.BoardListDao;
import com.trello.entities.BoardList;
import com.trello.entities.Card;
import com.trello.exceptions.BoardListNotFoundException;
import com.trello.exceptions.CardMissingInListException;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class BoardListServiceImpl implements BoardListService{
    private CardService cardService;
    private BoardListDao boardListDao;
    public BoardListServiceImpl(CardService cardService, BoardListDao boardListDao){
        this.cardService = cardService;
        this.boardListDao = boardListDao;
    }
    @Override
    public BoardList createBoardList(String name, List<Card> cards){
        Integer id = getId("BoardList");
        BoardList boardList = new BoardList(id, name, cards);
        boardListDao.createBoardList(boardList);
        return boardList;
    }

    @Override
    public void deleteBoardLists(List<BoardList> boardLists){
        boardLists.forEach(boardList -> deleteBoardList(boardList.getId()));
    }

    @Override
    public boolean deleteBoardList(Integer id){
        BoardList boardList = getBoardList(id);
        cardService.deleteCards(boardList.getCards());
        boardListDao.deleteBoardList(id);
        return true;
    }

    @Override
    public boolean moveCard(Integer cardId, BoardList moveFrom, BoardList moveTo){
        Card card = removeCard(moveFrom, cardId);
        addCardTo(moveTo, card);
        return true;
    }

    private Card removeCard(BoardList boardList, Integer cardId){
        Optional<Card> cardOptional = boardList.getCards().stream().filter(card -> card.getId().equals(cardId)).findFirst();
        if(cardOptional.isPresent()){
            List<Card> cards = boardList.getCards();
            cards.remove(cardOptional.get());
            updateBoardList(boardList);
            return cardOptional.get();
        }
        throw new CardMissingInListException();
    }

    private void addCardTo(BoardList boardList, Card card){
        boardList.getCards().add(card);
        updateBoardList(boardList);
    }

    public void updateBoardList(BoardList boardList){
        validate(boardList);
        boardListDao.updateBoardList(boardList);
    }

    private boolean validate(BoardList boardList){
//        cardService.validateCards(boardList.getCards());
        return true;
    }

    @Override
    public BoardList getBoardList(Integer id){
        BoardList boardList = boardListDao.getBoardList(id);
        if(isBoardListValid(boardList)){
            return boardList;
        }
        throw new BoardListNotFoundException();
    }

    private boolean isBoardListValid(BoardList boardList){
        if(Objects.nonNull(boardList)){
            return true;
        }
        return false;
    }

    public Integer getId(String code){
        return IDGenerator.getId(code);
    }
}
