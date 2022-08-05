package m2i.todoproject.repository;

import m2i.todoproject.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Victor
 */
@Repository
public interface TodoRepository extends JpaRepository<Todo,Long> {

}
