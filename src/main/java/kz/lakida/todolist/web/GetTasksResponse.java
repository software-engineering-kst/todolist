package kz.lakida.todolist.web;

        import kz.lakida.todolist.model.Task;
        import lombok.Data;

        import java.util.ArrayList;
        import java.util.List;

@Data
public class GetTasksResponse {

    private List<Task> taskList;

    public GetTasksResponse() {
    }

    public GetTasksResponse(List<Task> taskList) {
        this.taskList = taskList;
    }

    public List<Task> getTaskList() {
        return taskList;
    }
    public GetTasksResponse(Iterable<Task> items) {
        items.forEach(taskList:: add);
    }
    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }
}
