package kz.lakida.todolist.web;

import kz.lakida.todolist.model.Task;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @GetMapping
    public ResponseEntity<GetTasksResponse> getAllTasks() {
        var tasks = List.of(new Task("Task 1"), new Task("Task 2"));

        return ResponseEntity.ok(new GetTasksResponse(tasks));
    }
}
