package com.trello.entities;

public class Card {
    private Integer id;
    private String name;

    public Card(Integer id, String name, String description, User assignedTo) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.assignedTo = assignedTo;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", assignedTo=" + assignedTo +
                '}';
    }

    public User getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(User assignedTo) {
        this.assignedTo = assignedTo;
    }

    private String description;
    private User assignedTo;
}
