package kz.lakida.todolist.service;

import kz.lakida.todolist.model.Task;
import kz.lakida.todolist.repository.TaskRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void createTask (Task task){
        if(task.getTitle() == null || task.getTitle().length()<1) throw new RuntimeException("Task is not correct");
    }

    public List<Task> findAll() {
        return taskRepository.findAll() ;
    }

    public void deleteTask(UUID id){
        taskRepository.deleteById(id);
    }
}
