package com.trello.services;

import com.trello.dao.BoardDao;
import com.trello.dto.CreateBoardRequest;
import com.trello.entities.Board;
import com.trello.entities.User;
import com.trello.exceptions.BoardNotFoundException;
import com.trello.utils.URLGenerator;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class BoardServiceImpl implements BoardService{
    private BoardDao boardDao;
    private BoardListService boardListService;
    private UserService userService;
    public BoardServiceImpl(BoardListService boardListService, BoardDao boardDao, UserService userService){
        this.boardListService = boardListService;
        this.boardDao = boardDao;
        this.userService = userService;
    }
    @Override
    public Integer createBoard(CreateBoardRequest createBoardRequest){
        validate(createBoardRequest);
        Integer id = getId("BOARD");
        String url = URLGenerator.generateBoardURL(id);
        Board board = new Board(id, createBoardRequest.getName(), createBoardRequest.getBoardPrivacy(), url, createBoardRequest.getMembers(), createBoardRequest.getLists());
        boardDao.createBoard(board);
        return id;
    }

    private void validate(CreateBoardRequest createBoardRequest){
        return;
    }

    @Override
    public boolean deleteBoard(Integer boardId){
        Board board = getBoard(boardId);
        boardListService.deleteBoardLists(board.getLists());
        boardDao.deleteBoard(boardId);
        return true;
    }

    @Override
    public boolean addMember(User user, Integer boardId){
        Board board = getBoard(boardId);
        List<User> members = board.getMembers();
        userService.validateUser(user.getUserId());
        members.add(user);
        boardDao.updateBoard(board);
        return true;
    }

    @Override
    public boolean removeMember(Integer userId, Integer boardId){
        Board board = getBoard(boardId);
        List<User> members = board.getMembers();
        userService.validateUser(userId);
        members = members.stream().filter(member -> !member.getUserId().equals(userId)).collect(Collectors.toList());
        boardDao.updateBoard(board);
        return true;
    }

    @Override
    public Board getBoard(Integer boardId){
        Board board = boardDao.getBoard(boardId);
        if(Objects.isNull(board)){
            throw new BoardNotFoundException();
        }
        return board;
    }

    public Integer getId(String code){
        return IDGenerator.getId(code);
    }
}
