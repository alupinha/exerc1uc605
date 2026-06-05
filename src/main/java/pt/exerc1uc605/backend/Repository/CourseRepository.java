package pt.exerc1uc605.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pt.exerc1uc605.backend.Model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
    
}

