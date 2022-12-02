package kz.lakida.todolist.model;
import javax.persistence.Entity;
import lombok.Data;
import javax.persistence.Id;
import javax.persistence.*;
import java.util.UUID;
import lombok.Data;

@Entity
@Table(name = "tasks")
@Data
public class Task {
    @Id
    private UUID id;
    private String title;
    private String sub;
    
    public Task(UUID id, String title, String sub) {
        this.id = id;
        this.title = title;
        this.sub = sub;
    }
}
