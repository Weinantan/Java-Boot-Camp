package bootcamp.controller;

import bootcamp.model.Assignment;
import bootcamp.model.Course;
import bootcamp.model.Student;
import bootcamp.persistencemock.NotFoundException;
import bootcamp.persistencemock.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    private Store store;

    @RequestMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = store.getStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @RequestMapping("/students/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable("id") final int id) throws NotFoundException {
        Student student = store.getStudent(id);
//        if (student == null) {
//            throw new NotFoundException(id, "Not found");
//        }
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @RequestMapping("/courses")
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> course = store.getCourses();
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @RequestMapping("/courses/{id}")
    public ResponseEntity<Course> getCourseTitle(@PathVariable("id") final int id) throws NotFoundException {
        Course courseById = store.getCourse(id);
//        if (courseById == null) {
//            throw new NotFoundException(id, "Not found");
//        }
        return new ResponseEntity<>(courseById, HttpStatus.OK);
    }

    @RequestMapping(value = "/assign", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void assign(@RequestBody Assignment assignment) throws NotFoundException {
//        List<Student> allStudents = store.getStudents();
//        List<Course> allCourse = store.getCourses();
//        if (!allStudents.contains(store.getStudent(assignment.getStudentId()))){
//            throw new NotFoundException(assignment.getStudentId(),"");
//        }
//        if (!allCourse.contains(store.getCourse(assignment.getCourseId()))){
//            throw new NotFoundException(assignment.getCourseId(),"");
//        }
        store.assignStudentToACourse(assignment.getStudentId(), assignment.getCourseId());
    }

    @RequestMapping("/enrollment/{id}")
    public ResponseEntity<List<Student>> getStudentInACourse(@PathVariable("id") final int id) throws NotFoundException {
        return new ResponseEntity<>(store.getStudentsInACourse(id), HttpStatus.OK);
    }

    @RequestMapping("/my-courses/{id}")
    public ResponseEntity<List<Course>> getCourseAStudentEnrolledIn(@PathVariable("id") final int id) throws NotFoundException {
        return new ResponseEntity<>(store.getCoursesForAStudent(id), HttpStatus.OK);
    }

}


// TODO 1. Method to get all the students (Method = GET : Request mapping = /students : HTTP Response OK/200)
// TODO 2. Method to get the student details given the ID (Method = GET : Request mapping = /students/{id} : HTTP Response OK/200 :
// TODO 3. Method to get all the courses (Method = GET : Request mapping = /courses : HTTP Response OK/200)
// TODO 4. Method to get the course title given the ID (Method = GET : Request mapping = /courses/{id} : HTTP Response OK/200 :
//         If NotFoundException is thrown, return HTTP Response 404 with the error message from the exception.
// TODO 5. Method to assign a student to a course (Method = POST : Request mapping = /assign : Request Body = Assignment JSON :
//         HTTP Response Created/201 : If NotFoundException is thrown, return HTTP Response 404 with the error message from the exception.
// TODO 6. Method to get students in a course given the course ID (Method = GET : Request mapping = /enrollment/{id} : HTTP Response OK/200 :
//         If NotFoundException is thrown, return HTTP Response 404 with the error message from the exception.
// TODO 7. Method to get courses a student is enrolled in given the student ID (Method = GET : Request mapping = /my-courses/{id} : HTTP Response OK/200 :
//         If NotFoundException is thrown, return HTTP Response 404 with the error message from the exception.