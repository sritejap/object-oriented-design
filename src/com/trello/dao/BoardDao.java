package com.trello.dao;

import com.trello.entities.Board;
import com.trello.entities.BoardList;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class BoardDao {
    private Map<Integer, Board> boardMap = new HashMap<>();

//    public BoardDao(Map<Integer, Board> boardMap) {
//        this.boardMap = boardMap;
//    }

    public Board getBoard(Integer boardId) {
        return boardMap.get(boardId);
    }

    public boolean createBoard(Board board) {
        if(Objects.nonNull(getBoard(board.getId()))){
            return false;
        }
        boardMap.putIfAbsent(board.getId(), board);
        return true;
    }

    public Board updateBoard(Board board) {
        boardMap.put(board.getId(), board);
        return board;
    }

    public boolean deleteBoard(Integer boardListId){
        boardMap.remove(boardListId);
        return true;
    }
}
