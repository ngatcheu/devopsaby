package com.abyster.tests.controllers;

import java.util.Date;

import javax.validation.Valid;

import com.abyster.tests.dtos.TodoIn;
import com.abyster.tests.entities.Todo;
import com.abyster.tests.repositories.TodoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/v1/tests")
@Api(description = "manage all tests actions")
public class TestsController {

  @Autowired
  TodoRepository repo;

  @GetMapping("")
  @ApiOperation(value = "Find all todos", response = Todo.class)
  public Iterable<Todo> all() {
    return repo.findAll();
  }

  @PostMapping("")
  @ApiOperation(value = "add todo", response = Todo.class)
  public Todo add(@Valid @RequestBody final TodoIn todoIn) {
    Todo todo = new Todo();
    todo.setTitle(todoIn.getTitle());
    todo.setCreatedAt(new Date());
    repo.save(todo);
    return todo;
  }

  @GetMapping("/{id}")
  @ApiOperation(value = "find one todo", response = Todo.class)
  public Todo findOne(@PathVariable final Long id) {
    return repo.findById(id).orElse(null);
  }

  @ApiOperation(value = "Delete todo")
  @DeleteMapping("/{id}")
  public Boolean delete(@PathVariable final Long id) {
    repo.deleteById(id);
    return true;
  }

}