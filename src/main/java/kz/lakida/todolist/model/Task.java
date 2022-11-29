package kz.lakida.todolist.model;
import javax.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Id;
import javax.persistence.*;
import java.util.UUID;
import lombok.NoArgsConstructor;
import lombok.Data;
@Entity
@Table(name = "tasks")
@Data
@NoArgsConstructor
public class Task {
    @Id
    private UUID id;
    private String title;
    private String description;
}
