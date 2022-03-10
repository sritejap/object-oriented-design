package com.trello.dao;

import com.trello.entities.BoardList;
import com.trello.entities.BoardList;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class BoardListDao {
    private Map<Integer, BoardList> boardListMap = new HashMap<>();

//    public BoardListDao(Map<Integer, BoardList> boardListMap) {
//        this.boardListMap = boardListMap;
//    }

    public BoardList getBoardList(Integer boardListId) {
        return boardListMap.get(boardListId);
    }

    public boolean createBoardList(BoardList boardList) {
        if(Objects.nonNull(getBoardList(boardList.getId()))){
            return false;
        }
        boardListMap.putIfAbsent(boardList.getId(), boardList);
        return true;
    }

    public BoardList updateBoardList(BoardList boardList) {
        boardListMap.put(boardList.getId(), boardList);
        return boardList;
    }

    public boolean deleteBoardList(Integer boardListId){
        boardListMap.remove(boardListId);
        return true;
    }
}
