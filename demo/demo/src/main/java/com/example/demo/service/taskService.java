package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.entity.Task;
import com.example.demo.repository.taskRepository;
import java.util.List;
import java.util.Optional;

//The @Service annotation is used in your service classes
@Service
public class taskService {

 // Declaring a private final variable of type taskRepository 
 // This will be used for dependency injection
 private final taskRepository _taskRepository;

 // Constructor for the taskService class
 // It takes a taskRepository as a parameter which Spring will auto-wire for us
 public taskService(taskRepository taskRepository) {
     this._taskRepository = taskRepository;
 }

 // Method to create or update a task
 // It takes a Task object as a parameter and saves it to the database
 // It returns the saved Task object
 public Task saveTask(Task task) {
     return _taskRepository.save(task);
 }

 // Method to get a single task by id
 // It takes an id as a parameter and returns the Task object if found
 // If the task is not found, it returns null
 public Task getTaskById(Long id) {
     Optional<Task> optionalTask = _taskRepository.findById(id);
     return optionalTask.orElse(null); // return null if task not found
 }

 // Method to get all tasks
 // It returns a list of all Task objects
 public List<Task> getAllTasks() {
     return (List<Task>) _taskRepository.findAll();
 }

 // Method to update a task
 // It takes an id and a Task object (newTaskData) as parameters
 // If the task with the given id is found, it updates the task and returns the updated Task object
 // If the task is not found, it returns null
 public Task updateTask(Long id, Task newTaskData) {
     Optional<Task> optionalTask = _taskRepository.findById(id);

     if(optionalTask.isPresent()){
         Task existingTask = optionalTask.get();
         existingTask.setTitle(newTaskData.getTitle());
         existingTask.setDescription(newTaskData.getDescription());
         existingTask.setCompleted(newTaskData.isCompleted());
         return _taskRepository.save(existingTask);
     }

     return null; // return null if task not found
 }

 // Method to delete a task
 // It takes an id as a parameter and deletes the task with the given id
 public void deleteTask(Long id) {
     _taskRepository.deleteById(id);
 }
}