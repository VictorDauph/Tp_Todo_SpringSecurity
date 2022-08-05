package m2i.todoproject.controller;

import java.util.List;
import m2i.todoproject.model.Todo;
import m2i.todoproject.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Victor
 */
@Controller
public class ToDoController {
    
    private TodoService todoService;

    public ToDoController(TodoService todoService) {
        this.todoService = todoService;
    }
    
    
    
    @GetMapping("/list-todos")
    public String getListTodo(ModelMap model){
        List<Todo> todoList=todoService.retrieveAll();
        model.addAttribute("todoList",todoList);
        return "list-todos";
    }
    
    @GetMapping("/add-todo")
    public String getTodoForm(ModelMap model){      
        model.addAttribute("todo", new Todo()); //Besoin pour faire marcher le formulaire
        System.out.println("new Todo id"+new Todo().getId() );
        return "todo";
    }
    
    @PostMapping("/add-todo")
    public String addTodo(ModelMap model, @ModelAttribute("todo") Todo todo){      
        todoService.createTodo(todo);
        return "redirect:/list-todos";
    }
    
    @GetMapping("/update-todo/{id}")
    public String getUpdateForm(ModelMap model,@PathVariable Long id){
        
        Todo todo= todoService.retrieveById(id);
        System.out.println("---------- update todo : "+todo);
        model.addAttribute("todo", todo);
        return "todo";
    }
    
    @PostMapping("/update-todo")
    public String updateToDO(ModelMap model,@ModelAttribute("todo") Todo todo){
        todoService.updateTodo(todo);
        return "redirect:/list-todos";
    }
    
    @GetMapping("/delete-todo/{id}")
    public String deleteTodo(ModelMap model,@PathVariable Long id){
        
        todoService.deleteById(id);
        List<Todo> todoList=todoService.retrieveAll();
        model.addAttribute("todoList",todoList);
        return "redirect:/list-todos";
    }
}
