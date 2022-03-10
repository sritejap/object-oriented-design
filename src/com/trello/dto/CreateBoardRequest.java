package com.trello.dto;

import com.trello.entities.BoardList;
import com.trello.entities.User;
import com.trello.enums.BoardPrivacy;

import java.util.List;

public class CreateBoardRequest {
    private String name;
    private BoardPrivacy boardPrivacy;
    private List<User> members;
    private List<BoardList> lists;

    public CreateBoardRequest(String name, List<User> members, List<BoardList> lists) {
        this.name = name;
        this.members = members;
        this.lists = lists;
    }

    public CreateBoardRequest(String name, BoardPrivacy boardPrivacy, List<User> members, List<BoardList> lists) {
        this.name = name;
        this.boardPrivacy = boardPrivacy;
        this.members = members;
        this.lists = lists;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BoardPrivacy getBoardPrivacy() {
        return boardPrivacy;
    }

    public void setBoardPrivacy(BoardPrivacy boardPrivacy) {
        this.boardPrivacy = boardPrivacy;
    }

    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }

    public List<BoardList> getLists() {
        return lists;
    }

    public void setLists(List<BoardList> lists) {
        this.lists = lists;
    }
}
