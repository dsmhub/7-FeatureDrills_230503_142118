package com.example.student_demo.student;

import ch.qos.logback.core.util.StringUtil;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public Student getStudent(Long studentID){
        Optional<Student> studentOptional = studentRepository.findById(studentID);
        if(studentOptional.isPresent()){
            return studentOptional.get();
        }else{
            throw new IllegalStateException(("student with id " + studentID + " does not exist"));
        }
    }

    public void addNewStudent(Student student){
        Optional<Student> studentOptional =  studentRepository
                .findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent()){
            throw new IllegalStateException(("email already taken"));
        }else{
            studentRepository.save(student);
        }
    }

    public void deleteStudent(Long studentID){
        boolean exists = studentRepository.existsById(studentID);
        if(!exists){
            throw new IllegalStateException("student with id " + studentID + " does not exist");
        }else{
            studentRepository.deleteById(studentID);
        }
    }


    @Transactional
    public void updateStudentByReqParams(Long studentId, String name, String email){
        Student student = studentRepository.findById(studentId)
                .orElseThrow( ()-> new IllegalStateException(
                        "student with id " + studentId + " does not exist"));

        if( StringUtil.notNullNorEmpty(name) && !name.equals(student.getName()) ){
            student.setName(name);
        }

        if( studentRepository.findStudentByEmail(email).isPresent() ){
            throw new IllegalStateException("email already taken");
        }else if(
                StringUtil.notNullNorEmpty(email) &&
                        !email.equals(student.getEmail()) ){
            student.setEmail(email);
        }

    }


    @Transactional
    public void updateStudentReqBody(Long studentId, Student student){
        Optional<Student> studentOptional = studentRepository.findById(studentId);

        if(studentOptional.isPresent()){

            Student updatedRecord = studentOptional.get();
            String newName = student.getName();
            String newEmail = student.getEmail();

            if( StringUtil.notNullNorEmpty(newName) && !newName.equals(updatedRecord.getName()) ){
                updatedRecord.setName(newName);
            }

            if( studentRepository.findStudentByEmail(newEmail).isPresent() ){
                throw new IllegalStateException("email already taken");
            }else if(
                    StringUtil.notNullNorEmpty(newEmail) &&
                            !newEmail.equals(updatedRecord.getEmail()) ){
                updatedRecord.setEmail(newEmail);
            }
            //studentRepository.save(updatedRecord);

        }else{
            throw new IllegalStateException("student with id " + studentId + " does not exist");
        }
    }

}
