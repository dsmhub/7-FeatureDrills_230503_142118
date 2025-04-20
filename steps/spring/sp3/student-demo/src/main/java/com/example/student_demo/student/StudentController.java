package com.example.student_demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {


    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping(path = "api/v1/student")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @GetMapping(path = "api/v1/student/{studentId}")
    public Student getStudent(@PathVariable("studentId") Long id){
        return studentService.getStudent(id);
    }

    @PostMapping(path = "api/v1/registration")
    public void resgisterNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "api/v1/student/{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long id){
        studentService.deleteStudent(id);
    }

    @PutMapping(path = "api/v1/update/{studentId}")
    public void updateStudentReqParams(@PathVariable("studentId") Long id,
                                       @RequestParam(required=false) String name,
                                       @RequestParam(required=false) String email){
        studentService.updateStudentByReqParams(id, name, email);
    }

    @PutMapping(path = "api/v2/update/{studentId}")
    public void updateStudentReqBody(@PathVariable("studentId") Long id,
                              @RequestBody Student student){
        studentService.updateStudentReqBody(id, student);
    }

}
