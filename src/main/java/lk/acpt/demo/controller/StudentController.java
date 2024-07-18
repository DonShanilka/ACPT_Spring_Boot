package lk.acpt.demo.controller;

import lk.acpt.demo.dto.StudentDto;
import lk.acpt.demo.entity.Student;
import lk.acpt.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/studentA")
public class StudentController {

    @Autowired
    StudentService studentService;


    @PostMapping
    public ResponseEntity<StudentDto> saveStudent(@RequestBody StudentDto studentDto){ // parameeter eken json eka alla gannawa
        StudentDto student = studentService.saveStudent(studentDto);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping
    public List<StudentDto> getAllStudent(){
        List<StudentDto> al = studentService.getStudent();
        return al;
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<Object> updateStudent(@PathVariable Integer studentId, @RequestBody StudentDto student){
        StudentDto studentDto = studentService.updateStudent(studentId,student);
        if (studentDto == null) {
            return new ResponseEntity<>("No Student Found",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(studentDto,HttpStatus.OK);
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<String> deleteStudent(@PathVariable Integer studentId){
        String msg = studentService.deleteStudent(studentId);
        return new ResponseEntity<>(msg,HttpStatus.OK);
    }
}
