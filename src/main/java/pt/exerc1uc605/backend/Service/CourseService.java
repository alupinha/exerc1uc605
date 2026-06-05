package pt.exerc1uc605.backend.Service;

import java.util.List;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import pt.exerc1uc605.backend.Exception.ResourceNotFoundException;
import pt.exerc1uc605.backend.Model.Course;
import pt.exerc1uc605.backend.Repository.CourseRepository;

@Service
@Validated

public class CourseService {

   private final CourseRepository repository;
   
   public CourseService (CourseRepository repository){

       this.repository = repository; 
   } 

   public List<Course> findAll(){
     return repository.findAll();
   }

   public Course findById(@NonNull Long id) {
      Course course = repository.findById(id).orElseThrow(() ->
      new ResourceNotFoundException("Course Not Found with Id: " + id));
      return course;
   }

   public Course createdCourse(@NonNull Course course) {
      return this.repository.save(course);
   }

   public void deleteCourse(@NonNull @Positive Long id){
      this.repository.findById(id).map(data -> {
         this.repository.deleteById(id);
         return true;
      }).orElseThrow(() -> new ResourceNotFoundException("Course ja deletado ou inexistente" + id));

   }

}
