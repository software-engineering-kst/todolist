package kz.lakida.todolist.web;

import kz.lakida.todolist.model.Task;
import lombok.Data;
import java.util.List;

@Data
public class GetTasksResponse {
    private final List<Task> tasks;

}
