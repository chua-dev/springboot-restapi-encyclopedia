package com.javaspring.springbootrestapi.encyclopedia.controller;

import com.javaspring.springbootrestapi.encyclopedia.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//@Controller
//@ResponseBody
@RestController
@RequestMapping(path = "/student")
public class StudentController {

    // http://localhost:8080/student
    @RequestMapping(method = RequestMethod.GET, path = "/student")
    //@GetMapping(path = "/student")
    public Student getStudent() {
        Student student = Student.builder()
                .id(1)
                .firstName("Jack")
                .lastName("Cherson")
                .build();

        return student;
    }

    // Return List as Json
    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> students = new ArrayList<Student>();
        students.add(Student.builder().id(1).firstName("first").lastName("student").build());
        students.add(Student.builder().id(2).firstName("second").lastName("student").build());
        students.add(Student.builder().id(3).firstName("third").lastName("student").build());

        //return new ResponseEntity<>(students, HttpStatus.OK);
        //return ResponseEntity.created(students);
        return ResponseEntity.ok(students);
    }

    // Path Variable
    // {id} - URI Template variable
    // http://localhost:8080/student/1
    @GetMapping("/student/{id}")
    public Student getStudentPathVariable(@PathVariable int id) {
        return new Student(id, "Ram", "Gay");
    }

    // Path Variable Different Naming
    @GetMapping("/studentId/{id}")
    public Student getStudentPathVariableDifferentName(@PathVariable("id") int studentId) {
        return new Student(studentId, "Ramesy", "gayset");
    }

    // Path Variable Multiple
    @GetMapping("/student/{id}/{first-name}/{last-name}")
    public Student getStudentPathVariables(@PathVariable int id,
                                                  @PathVariable("first-name") String firstName,
                                                  @PathVariable("last-name") String lastName) {
        return new Student(id, firstName, lastName);
    }


    // Query Parameter
    // http://localhost:8080/students/query?id=1
    @GetMapping("/students/query")
    public Student studentRequestParam(@RequestParam int id) {
        return new Student(id, "Chew", "Api");
    }

    // http://localhost:8080/students/query?id=1&firstName=Chew&lastName=Factro
    @GetMapping("/students/query-with-name")
    public Student studentRequestParams(@RequestParam int id,
                                        @RequestParam String firstName,
                                        @RequestParam String lastName) {
        return new Student(id, firstName, lastName);
    }

    // PostMapping
    // @RequestBody retrieve HTTP request convert to Java object
    @RequestMapping(method = RequestMethod.POST, path = "/student")
    @ResponseStatus(HttpStatus.CREATED) // Default Response Status
    public Student createStudent(@RequestBody Student student) { // JSON convert > Java object
        System.out.println("student = " + student);
        return student;
    }

    // HTTP PUT Request
    @RequestMapping(method = RequestMethod.PUT, path = "/student/{id}")
    public Student updateStudent(@RequestBody Student student, @PathVariable(name = "id") int studentID) {
        System.out.println("Updating Student for id: " + studentID);
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

    // HTTP DELETE Request
    @DeleteMapping("/student/{id}")
    public String deleteStudent(@PathVariable(name = "id") int studentId){
        return "Student deleted successfully, id: " + studentId;
    }

    // ResponseEntity to create complete HTTP Response
    // Include ResponseHeader, ResponseBody and StatusCode
    @GetMapping("/student/re")
    public ResponseEntity<Student> getStudentResponseEntity() {
        Student student = Student.builder()
                .id(1)
                .firstName("Jesyy")
                .lastName("Jum")
                .build();

        //return new ResponseEntity<Student>(student, HttpStatus.OK); Body + Code
        //return ResponseEntity.ok(student); Body + Code
        return ResponseEntity.ok().header("custom-header", "jessy")
                .body(student); // Header + Body + Code
    }

}
