package com.trello.services;

import com.trello.dto.CreateBoardRequest;
import com.trello.entities.Board;
import com.trello.entities.User;

public interface BoardService {
    public Integer createBoard(CreateBoardRequest createBoardRequest);
    public boolean deleteBoard(Integer boardId);
    public boolean addMember(User user, Integer boardId);
    public boolean removeMember(Integer userId, Integer boardId);
    public Board getBoard(Integer boardId);
}
