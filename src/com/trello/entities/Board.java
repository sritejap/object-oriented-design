package com.trello.entities;

import com.trello.enums.BoardPrivacy;

import java.util.List;

public class Board {
    private Integer id;
    private String name;
    private BoardPrivacy boardPrivacy;
    private String url;
    private List<User> members;
    private List<BoardList> lists;

    public Board(Integer id, String name, BoardPrivacy boardPrivacy, String url, List<User> members, List<BoardList> lists) {
        this.id = id;
        this.name = name;
        this.boardPrivacy = boardPrivacy;
        this.url = url;
        this.members = members;
        this.lists = lists;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Board{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", boardPrivacy=" + boardPrivacy +
                ", url='" + url + '\'' +
                ", members=" + members +
                ", lists=" + lists +
                '}';
    }

    public void setBoardPrivacy(BoardPrivacy boardPrivacy) {
        this.boardPrivacy = boardPrivacy;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
