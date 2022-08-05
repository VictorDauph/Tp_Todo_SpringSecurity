package m2i.todoproject.service;

import java.util.List;
import m2i.todoproject.model.Todo;


/**
 *
 * @author Victor
 */
public interface ITodoService {
    
    public void createTodo(Todo todo);
    
    public void updateTodo(Todo todo);
    
    public Todo retrieveById(long id);
    
    public List<Todo>retrieveAll();
    
    public void deleteById(long id);
}
