package kz.lakida.todolist.web;

import kz.lakida.todolist.model.Task;
import kz.lakida.todolist.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return ResponseEntity.ok(new GetTasksResponse(taskService.findAll()));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<String> createTask(@RequestBody Task task){
        taskService.createTask(task);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity<String> deleteTask(@RequestBody DeleteTaskRequest request) {
        taskService.deleteTask(request.getId());
        return ResponseEntity.ok().build();
    }

}
