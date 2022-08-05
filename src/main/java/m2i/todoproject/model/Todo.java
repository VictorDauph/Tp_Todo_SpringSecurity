package m2i.todoproject.model;

import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Victor
 */

@NoArgsConstructor
@Data
@Entity
@Table
public class Todo {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    
    @NotEmpty
    private String name;
    
    private String description;
    
    private LocalDate targetDate;

    public Todo(String name, String description, LocalDate targetDate) {
        this.name = name;
        this.description = description;
        this.targetDate = targetDate;
    }
    
    
}
