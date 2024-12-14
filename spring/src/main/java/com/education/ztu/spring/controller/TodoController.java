package com.education.ztu.spring.controller;

import com.education.ztu.spring.entity.TodoItem;
import com.education.ztu.spring.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/todos")
public class TodoController {


    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @DeleteMapping("/{id}")
    public String deleteTodo(@PathVariable Long id) {
//         todoService.deleteById(id);
        return "redirect:/todos";
    }

    // Редагування TodoItem
    @PostMapping("/{id}/edit")
    public String editTodo(
            @PathVariable Long id,
            @ModelAttribute TodoItem todoItem,
            Model model
    ) {
        // todoService.update(id, todoItem);
        model.addAttribute("todo", todoItem);
        return "todo-detail";
    }
}
