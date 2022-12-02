package kz.lakida.todolist.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "todo")
@Data
@NoArgsConstructor

public class Task {
    @Id
    private UUID id;
    private String name;

    public Task(String name, UUID id) {
        this.name = name;
        this.id = id;
    }
}
