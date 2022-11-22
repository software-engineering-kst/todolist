package kz.lakida.todolist.repository;

import kz.lakida.todolist.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID>
{
}
