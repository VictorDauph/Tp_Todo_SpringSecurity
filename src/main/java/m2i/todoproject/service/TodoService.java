package m2i.todoproject.service;

import java.util.List;
import m2i.todoproject.service.ITodoService;
import m2i.todoproject.model.Todo;
import m2i.todoproject.repository.TodoRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author Victor
 */
@Service
public class TodoService implements ITodoService {
    
    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public void createTodo(Todo todo) {
        todoRepository.save(todo);
    }

    @Override
    public void updateTodo(Todo todo) {
        System.out.println("updating todo: "+todo);
        todoRepository.save(todo);
    }

    @Override
    public Todo retrieveById(long id) {
        return todoRepository.findById(id).orElse(null) ;
    }
    
    @Override
    public List<Todo>retrieveAll(){
        return todoRepository.findAll();
    }
    
    @Override
    public void deleteById(long id){
        todoRepository.deleteById(id);
    }
    
}
