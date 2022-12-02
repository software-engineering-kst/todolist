package kz.lakida.todolist.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kz.lakida.todolist.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, UUID>

{
}
