package com.example.demo.repository;


import org.springframework.data.repository.CrudRepository;
import com.example.demo.entity.Task;

//Interface for the Task repository
//This interface extends CrudRepository, providing several methods for working with the persistence layer.
//The first type parameter, Task, is the type of the Entity, and the second type parameter, Long, is the type of the Entity's ID.
public interface taskRepository extends CrudRepository<Task, Long> {
}
