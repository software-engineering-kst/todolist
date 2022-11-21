package kz.lakida.todolist.web;

import kz.lakida.todolist.model.Task;
import kz.lakida.todolist.repository.TaskRepository;
import kz.lakida.todolist.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/")
    public String index(Model model) {
        Iterable<Task> todoList = taskService.findAll();
        model.addAttribute("items", new GetTasksResponse(todoList));
        model.addAttribute("newTask", new Task());
        return "index";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Task task) {
        Task item = new Task(task.getTitle());
        taskService.saveTask(item);
        return "redirect:/";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute GetTasksResponse getTasksResponse) {
        for (Task requestItem : getTasksResponse.getTaskList() ) {
            Task item = new Task( requestItem.getTitle());
            item.setDone(requestItem.getDone());
            item.setId(requestItem.getId());
            taskService.saveTask(item);
        }
        return "redirect:/";
    }
}
