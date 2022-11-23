package kz.lakida.todolist.service;

import kz.lakida.todolist.model.Task;
import kz.lakida.todolist.repository.TaskRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void createUser(Task task) {
        // if (task == null ) throw new RuntimeException("Task is null");
        taskRepository.save(task);
    }

    public List<Task> findAll() {
        var list = new ArrayList<Task>();
        for (Task task : taskRepository.findAll()) {
            list.add(task);
        }
        return list;
    }

    public void saveTask(Task task) {
        if (task == null) throw new RuntimeException("User name is invalid");
        taskRepository.save(task);
    }
}
