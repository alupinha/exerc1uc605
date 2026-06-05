package pt.exerc1uc605.backend.Service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import pt.exerc1uc605.backend.Enums.Category;
import pt.exerc1uc605.backend.Model.Course;
import pt.exerc1uc605.backend.Model.Lesson;
import pt.exerc1uc605.backend.Repository.CourseRepository;

@SpringBootApplication
public class EscolaApplication {

    public static void main(String[] args) {
        SpringApplication.run(EscolaApplication.class, args);
    }

    @Bean
    @Profile("dev")
    CommandLineRunner initDatabase(CourseRepository courseRepository) {

        return args -> {

            for (int i = 0; i < 10; i++) {

                Course course = new Course(null);
                course.setName("Java com Spring " + i);
                course.setCategory(Category.BACKEND);

                Lesson lesson = new Lesson();
                lesson.setName("Introdução ao Spring Boot " + i);
                lesson.setYoutubeUrl("https://www.youtube.com/watch?v=oCEvr8OpY64");

                course.getLessons().add(lesson);

                Lesson lesson2 = new Lesson();
                lesson2.setName("Spring Data JPA " + i);
                lesson2.setYoutubeUrl("https://www.youtube.com/watch?v=oCEvr8OpY64");

                course.getLessons().add(lesson2);

                courseRepository.save(course);
            }
        };
    }
}