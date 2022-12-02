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

    public TaskService (TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public void createTask (Task task){
        if (task.getName() == null || task.getName().length() < 1 ) throw new RuntimeException("Task is invalid");
        taskRepository.save(task);
    }

    public void deleteTask(UUID id){
        try {
            taskRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ignored) {

        }
    }

    public List<Task> findAll(){
        return taskRepository.findAll();
    }
}
