package pt.exerc1uc605.backend.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.NonNull;
import pt.exerc1uc605.backend.Model.Course;
import pt.exerc1uc605.backend.Service.CourseService;

@RequestMapping("/api/courses")
public class CourseController {
    
    private final CourseService service;

    private CourseController(CourseService service) {
      this.service = service;
    }    

    @GetMapping
    public List<Course> buscaCourses (){
       return this.service.findAll();
    }

    @GetMapping("/{id}")
    public Course buscaCoursePorId( @PathVariable  @NotNull  @Positive Long id){

        return this.service.findById(id);
    }

    @PostMapping
        public ResponseEntity<Course> createdCourse(@RequestBody @Valid Course course){
            Course localCourse = this.service.createdCourse(course);
                        
            return ResponseEntity.status(HttpStatus.CREATED).body(localCourse);

        }
    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @NonNull @Positive Long id) {
        this.service.deleteCourse(id);
    }

    @PutMapping("/{id}")
    public Course putMethodName(@PathVariable @Positive @NonNull Long id, @RequestBody @Valid Course course){

        return this.service.updateCourse(id, course);
    }

}


