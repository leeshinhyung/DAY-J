package com.capstone.projectname.todo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodoController {
    TodoRepository todoRepository;
    
    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping("/test-todo")
    public List<Todo> returnTestTodo() {
        List<Todo> todos = todoRepository.findAll();
        return todos;
    }
}
