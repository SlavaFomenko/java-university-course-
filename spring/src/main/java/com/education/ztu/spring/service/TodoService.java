package com.education.ztu.spring.service;

import com.education.ztu.spring.entity.TodoItem;
import com.education.ztu.spring.respository.TodoItemRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class TodoService {

    private final TodoItemRepository todoItemRepository;


    public void deleteTodoById(Long id) {
        todoItemRepository.deleteById(id);
    }

    public TodoItem updateStatus(Long id, boolean completed) {
        TodoItem todo = todoItemRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Todo not found"));
        todo.setCompleted(completed);
        return todoItemRepository.save(todo);
    }
    public TodoService(TodoItemRepository todoItemRepository) {
        this.todoItemRepository = todoItemRepository;
    }

    public List<TodoItem> getAllTodoItems() {
        Iterable<TodoItem> itemsIterator = todoItemRepository.findAll();
        return StreamSupport.stream(itemsIterator.spliterator(), false)
                .collect(Collectors.toList());
    }

    public void saveTodoItem(TodoItem todoItem) {
        todoItemRepository.save(todoItem);
    }
}
