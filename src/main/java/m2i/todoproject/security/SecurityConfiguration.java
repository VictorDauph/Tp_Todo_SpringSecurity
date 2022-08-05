package m2i.todoproject.security;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import m2i.todoproject.service.TodoService;



/**
 *
 * @author Victor
 */

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    private TodoService todoService;

    public SecurityConfiguration(TodoService todoService) {
        this.todoService = todoService;
    }
   
    //Méthode pour configurer la protection des URLs
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/login") //pour aller sur la page login ou sur registration
                .permitAll() //on autorise tout le monde .
                .anyRequest().hasRole("USER")//Pour toutes les autres requêtes, on demande le role user
                .and()
                .formLogin() //On active le formulaire de login
                .loginPage("/login") //On configure notre propre page de login.
                ;
        
        http.csrf().disable(); //désactivation de la protection des attaques csrf (qui empêche le bon fonctionnement des redirections si pas configuré)
        http.headers().frameOptions().disable();
    }       

    //Méthode pour configurer le mode d'authentification en mémoire
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //pour vérifier des objets en mémoir (pas dans la DB)
        auth
                .inMemoryAuthentication() //Authentification en mémooire, pas de vérif en BDD
                .passwordEncoder(NoOpPasswordEncoder.getInstance()) //ON ne veut pas que le password soit crypté
                .withUser("admin").password("admin") //On crée l'utilisateur admin
                .roles("USER","ADMIN") //On lui assigne les roles user et admin
                .and()
                .withUser("user").password("user")
                .roles("USER")
                ;            
    }
    
     //Méthode pour configurer le mode d'authentification: authentification via user dans BDD
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//        auth.authenticationProvider(authenticationProvider());
//    }
//    
    //Ce DAO encode et decode autoimatiquement le mdp
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider(){
//        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
//        auth.setUserDetailsService(userService);
//        auth.setPasswordEncoder(passwordEncoder);
//        return auth;
//    }
    
 
}
