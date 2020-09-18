package pl.szymonleyk.restclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import pl.szymonleyk.restclient.model.Todo;

@SpringBootApplication
public class RestClientApplication {
    private static final Logger log = LoggerFactory.getLogger(RestClientApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(RestClientApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }


    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            Todo todo = restTemplate.getForObject("https://jsonplaceholder.typicode.com/todos/1", Todo.class);
            log.info(todo.toString());
        };
    }


}
