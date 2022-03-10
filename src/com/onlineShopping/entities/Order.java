package com.onlineShopping.entities;

public class Order {
    private int id;

}

//User, Board, BoardPrivacy, BoardList, Card
//
//User : userId, phone, email
//
//Board: id, name, BoardPrivacy, url, List<User>, List<BoardList>
//
//BoardPrivacy: PUBLIC/PRIVATE
//
//BoardList: id, name, List<Card>
//
//Card: id, name, description, assignedTo
//
//BoardService(I): create/delete board, add/remove people, getBoard
//
//BoardListService(I): create/delete lists, moveCard(), getBoardList,
//
//CardService(I): create/delete cards, getCard
//
//UserService(I): createUser

//BoardDao: create/update/delete
//
//IdGenerator: static Map<String, Integer>








