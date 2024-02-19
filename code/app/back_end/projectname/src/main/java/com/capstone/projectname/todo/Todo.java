package com.capstone.projectname.todo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Todo {
    @Id
    private int id;
    
    public Todo() {
    
    }
    
    public Todo(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                '}';
    }
}
