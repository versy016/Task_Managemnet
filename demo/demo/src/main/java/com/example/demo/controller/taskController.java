package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Task;
import com.example.demo.service.taskService;

//Denotes that this class is a RESTful API controller
@RestController
public class taskController {

 // Instance of the taskService
 private final taskService _taskService;

 // Constructor to initialize the taskService instance using dependency injection
 public taskController(taskService _taskService) {
     this._taskService = _taskService;
 }

 // Create a new task (HTTP POST request)
 @PostMapping
 public ResponseEntity<Task> createTask(@RequestBody Task task) {
     Task createdTask = _taskService.saveTask(task);
     return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
 }

 // Get a single task by id (HTTP GET request)
 @GetMapping("/{id}")
 public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
     Task task = _taskService.getTaskById(id);
     if (task != null) {
         return new ResponseEntity<>(task, HttpStatus.OK);
     } else {
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }
 }

 // Get all tasks (HTTP GET request)
 @GetMapping
 public ResponseEntity<List<Task>> getAllTasks() {
     List<Task> tasks = _taskService.getAllTasks();
     return new ResponseEntity<>(tasks, HttpStatus.OK);
 }

 // Update a task (HTTP PUT request)
 @PutMapping("/{id}")
 public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) {
     Task updatedTask = _taskService.updateTask(id, task);
     return new ResponseEntity<>(updatedTask, HttpStatus.OK);
 }

 // Delete a task (HTTP DELETE request)
 @DeleteMapping("/{id}")
 public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
     _taskService.deleteTask(id);
     return new ResponseEntity<>(HttpStatus.NO_CONTENT);
 }
}