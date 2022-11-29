package kz.lakida.todolist.web;

import kz.lakida.todolist.model.Task;
import kz.lakida.todolist.repository.TaskRepository;
import kz.lakida.todolist.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

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
    public ResponseEntity<String> createTask(@RequestBody Task task) {
        taskService.createTask(task);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity<String> deleteTask(@RequestBody DeleteTaskRequest deleteTaskRequest){
        taskService.deleteTask(deleteTaskRequest.getId());
        return ResponseEntity.ok().build();
    }
}
