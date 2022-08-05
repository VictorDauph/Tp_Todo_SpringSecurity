package m2i.todoproject;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author Victor
 */
@SpringBootApplication
public class MainClass {


    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(MainClass.class , args);
        
        System.out.println("Main enabled");
        
       // IUserService userService = ctx.getBean(IUserService.class);
        
       // User user= new User("admin","admin","admin@admin.com","admin");
    }
}
