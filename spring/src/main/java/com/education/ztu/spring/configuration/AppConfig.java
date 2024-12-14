import com.education.ztu.spring.service.TodoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public TodoService todoService(TodoRepository todoRepository) {
        return new TodoService(todoRepository);
    }
}
