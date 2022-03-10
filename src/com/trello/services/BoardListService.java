package com.trello.services;

import com.trello.entities.BoardList;
import com.trello.entities.Card;

import java.util.List;

public interface BoardListService {

    public BoardList createBoardList(String name, List<Card> cards);

    public boolean deleteBoardList(Integer id);

    public void deleteBoardLists(List<BoardList> boardLists);

    public boolean moveCard(Integer cardId, BoardList moveFrom, BoardList moveTo);

    public BoardList getBoardList(Integer id);
}
