package bootcamp.controller;

import bootcamp.model.Student;
import bootcamp.persistencemock.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
    // TODO Add the following methods
//    @RequestMapping(value="/assign",method = RequestMethod.POST);
//    public void assign(@RequestBody Assignment assignment) throws NotFoundException {
//
//    }
    @RequestMapping("/students{id}");
    public ResponseEntity<Student> getStudent(@PathVariable("id") final int id) throws NotFoundException{
        return
    }

    // TODO 1. Method to get all the students (Method = GET : Request mapping = /students : HTTP Response OK/200)


    // TODO 2. Method to get the student details given the ID (Method = GET : Request mapping = /students/{id} : HTTP Response OK/200 :
    //         If NotFoundException is thrown, return HTTP Response 404 with the error message from the exception.
    // TODO 3. Method to get all the courses (Method = GET : Request mapping = /courses : HTTP Response OK/200)
    // TODO 4. Method to get the course title given the ID (Method = GET : Request mapping = /courses/{id} : HTTP Response OK/200 :
    //         If NotFoundException is thrown, return HTTP Response 404 with the error message from the exception.
    // TODO 5. Method to assign a student to a course (Method = POST : Request mapping = /assign : Request Body = Assignment JSON :
    //         HTTP Response Created/201 : If NotFoundException is thrown, return HTTP Response 404 with the error message from the exception.
    // TODO 6. Method to get students in a course given the course ID (Method = GET : Request mapping = /enrollment/{id} : HTTP Response OK/200 :
    //         If NotFoundException is thrown, return HTTP Response 404 with the error message from the exception.
    // TODO 7. Method to get courses a student is enrolled in given the student ID (Method = GET : Request mapping = /my-courses/{id} : HTTP Response OK/200 :
    //         If NotFoundException is thrown, return HTTP Response 404 with the error message from the exception.
}
