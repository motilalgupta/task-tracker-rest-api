package org.cfs.todotrackerapi.controller;

import org.apache.coyote.Response;
import org.cfs.todotrackerapi.entity.Task;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    public Map<Long, Task> dbTask = new HashMap<>();

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks(@RequestBody Task task){
        return ResponseEntity.ok(new ArrayList<>(dbTask.values()));
    }
    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        dbTask.put(task.getId(),task);
        return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id){
        Task task = dbTask.get(id);
        if(task==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(task);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Task> putTask(@RequestBody Task task, @PathVariable Long id){
        Task existing = dbTask.get(id);
        if(existing == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        dbTask.put(id,task);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PatchMapping("/{id}/title")
    public ResponseEntity<Task> updateTitle(@PathVariable Long id,@RequestParam String newTitle){
        Task existing = dbTask.get(id);
        if(existing == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        existing.setTitle(newTitle);
        dbTask.put(id,existing);

        return ResponseEntity.ok(existing);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Task> deleteTask(@PathVariable Long id){
        Task remove = dbTask.remove(id);
        if(remove == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.noContent().build();
    }

}
