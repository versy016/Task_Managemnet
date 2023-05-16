package com.example.demo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.example.demo.entity.Task;
import com.example.demo.repository.taskRepository;
import com.example.demo.service.taskService;

import static org.mockito.Mockito.*;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest annotation to indicate that this is a Spring Boot test
@SpringBootTest
public class TaskServiceTest {

 // @Autowired annotation to inject a TaskService object into this test
 @Autowired
 private taskService _taskService;

 // @MockBean annotation to create a Mockito mock of TaskRepository
 @MockBean
 private taskRepository _taskRepository;
 
 // @Test annotation to indicate that this is a test method
 @Test
 public void testGetTaskById() {
     // Creating a new Task object
     Task task = new Task();
     task.setId(1L);
     task.setTitle("Test Task");
     task.setDescription("Test Description");
     task.setCompleted(false);

     // Defining the behavior of the mock when the findById method is called
     when(_taskRepository.findById(1L)).thenReturn(Optional.of(task));

     // Calling the method to be tested
     Task foundTask = _taskService.getTaskById(1L);

     // Asserting that the returned Task has the same attributes as the expected Task
     assertEquals(task.getTitle(), foundTask.getTitle());
     assertEquals(task.getDescription(), foundTask.getDescription());
     assertEquals(task.isCompleted(), foundTask.isCompleted());
 }

 // Additional tests for the other methods...
}