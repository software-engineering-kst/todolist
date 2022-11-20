package kz.lakida.todolist.web;

import kz.lakida.todolist.model.Task;
import kz.lakida.todolist.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<GetTasksResponse> getAllTasks() {
//        var tasks = List.of(new Task("Task 1", UUID.randomUUID()), new Task("Task 2", UUID.randomUUID()));
        return ResponseEntity.ok(new GetTasksResponse(taskService.findAll()));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<String> createTask(@RequestBody Task task){
        taskService.createTask(task);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<String> deleteTask(@RequestBody Task task){
        taskService.deleteTask(task);
        return ResponseEntity.ok().build();
    }

}
