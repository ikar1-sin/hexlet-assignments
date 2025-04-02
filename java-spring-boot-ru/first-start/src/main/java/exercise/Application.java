package exercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// BEGIN
@SpringBootApplication
@RestController
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    @GetMapping("/")
    String home(@RequestParam(value = "name", defaultValue = "World!") String str) {
        return String.format("Hello, %s!", str);
    }

    @GetMapping("/about")
    String about() {
        return "Welcome to Hexlet!";
    }

}
// END
