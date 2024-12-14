package com.education.ztu.spring.controller;

import com.education.ztu.spring.configuration.TodoConfiguration;
import com.education.ztu.spring.entity.TodoItem;
import com.education.ztu.spring.respository.TodoItemRepository;
import com.education.ztu.spring.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller("/")
public class MainPageController {

    private final TodoService todoService;
    private final TodoConfiguration todoConfiguration;

    public MainPageController(TodoService todoService,
                              TodoConfiguration todoConfiguration) {
        this.todoService = todoService;
        this.todoConfiguration = todoConfiguration;
    }

    @GetMapping
    public String getMainPage(Model model) {
        model.addAttribute("todo", new TodoItem());
        model.addAttribute("title", todoConfiguration.getTitle());
        model.addAttribute("todos", todoService.getAllTodoItems());
        return "index.html";
    }

    @PostMapping
    public String todoItemSubmit(@ModelAttribute TodoItem item, Model model) {
        todoService.saveTodoItem(item);
        return "redirect:/";
    }
}
