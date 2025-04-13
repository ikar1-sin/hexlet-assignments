package exercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

import exercise.daytime.Daytime;
import exercise.daytime.Day;
import exercise.daytime.Night;

// BEGIN
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.annotation.RequestScope;
// END
@RequestScope
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // BEGIN
    @Bean
    public Daytime getDayTime() {
        var timeNow = LocalDateTime.now();
        if (timeNow.getHour() > 6 && timeNow.getHour() < 22) {
            return new Day();
        } else {
            return new Night();
        }
    }
    // END
}
