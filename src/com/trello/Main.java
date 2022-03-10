package com.trello;

import com.trello.dao.BoardDao;
import com.trello.dao.BoardListDao;
import com.trello.dao.CardDao;
import com.trello.dao.UserDao;
import com.trello.dto.CreateBoardRequest;
import com.trello.entities.BoardList;
import com.trello.entities.Card;
import com.trello.entities.User;
import com.trello.services.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // write your code here
        UserDao userDao = new UserDao();
        UserService userService = new UserServiceImpl(userDao);
        List<User> users = new ArrayList<>();
        users.add(userService.createUser("Teja","cml"));
        users.add(userService.createUser("Sweetie","sml"));
//        users.add(userService.createUser("Kitty","kml"));
//        System.out.println(userService.createUser("Teja","cml").toString());
        System.out.println(userService.createUser("Sweetie","sml").toString());
        System.out.println(userService.createUser("Kitty","kml").toString());
        CardDao cardDao = new CardDao();
        CardService cardService = new CardServiceImpl(cardDao, userService);
        List<Card> cards = new ArrayList<>();
        Card card = cardService.createCard("card1", "card1_desc",users.get(0));
        cards.add(card);
        Card card2 = cardService.createCard("card2", "card2_desc",users.get(1));
        System.out.println(card2);
        System.out.println(card);
//        cards.add(card);
        BoardListDao boardListDao = new BoardListDao();
        BoardListService boardListService = new BoardListServiceImpl(cardService,boardListDao);
        BoardList boardList = boardListService.createBoardList("boardlist1", cards);
        List<Card> cardList = new ArrayList<>();
        cardList.add(card2);
        BoardList boardList2 = boardListService.createBoardList("boardlist2",cardList);
        List<BoardList> boardLists = new ArrayList<>();
        boardLists.add(boardList2);
        boardLists.add(boardList);
        CreateBoardRequest createBoardRequest = new CreateBoardRequest("Board1", users, boardLists);
        BoardDao boardDao = new BoardDao();
        BoardService boardService = new BoardServiceImpl(boardListService,boardDao,userService);
        Integer boardId = boardService.createBoard(createBoardRequest);
        boardListService.moveCard(card.getId(),boardList, boardList2);
        System.out.println(boardListService.getBoardList(boardList2.getId()).toString());
        System.out.println(boardId);
        System.out.println(boardService.getBoard(boardId).toString());

        //Test for exception
//        boardService.getBoard(2);

    }
}
