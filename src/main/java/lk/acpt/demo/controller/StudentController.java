package lk.acpt.demo.controller;

import lk.acpt.demo.entity.Student;
import lk.acpt.demo.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/studentA")
public class StudentController {

    @Autowired
    StudentRepo studentRepo;

    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){ // parameeter eken json eka alla gannawa
        Student save = studentRepo.save(student);
        return new ResponseEntity<>(save, HttpStatus.OK);
    }

    @GetMapping
    public List<Student> getAllStudent(){
        List<Student> al = studentRepo.findAll();
        return al;
    }

    @PutMapping
    public void updateStudent(){

    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<String> deleteStudent(@PathVariable Integer studentId){
        if (studentRepo.existsById(studentId)) {
            studentRepo.deleteById(studentId);
            return new ResponseEntity<>("Delete",HttpStatus.OK);
        }
        return new ResponseEntity<>("No Data Found !",HttpStatus.OK);
    }
}
