package lk.acpt.demo.service;

import lk.acpt.demo.dto.StudentDto;
import lk.acpt.demo.entity.Student;
import lk.acpt.demo.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;

    public StudentDto saveStudent(StudentDto studentDto){
        Student save = studentRepo.save(new Student(studentDto.getName(),studentDto.getAddress(), studentDto.getMarks()));
        return new StudentDto(save.getId(),save.getName(),save.getAddress(),save.getMarks());
    }

    public void deleteStudent(){

    }

    public StudentDto updateStudent(Integer studentId, StudentDto studentDto){
        if(studentRepo.existsById(studentId)){
            Student update = studentRepo.save(new Student(studentId, studentDto.getName(), studentDto.getAddress(), studentDto.getMarks()));
            return  new StudentDto(update.getId(),update.getName(),update.getAddress(),update.getMarks());
        }
        return null;
    }

    public List<StudentDto> getStudent(){
        List<Student> all = studentRepo.findAll();
        List<StudentDto> studentDtolist = new ArrayList<>();
        // entity set eka dto walata convert karanawa

        for (Student student : all) {
            studentDtolist.add(new StudentDto(
                    student.getId(),
                    student.getName(),
                    student.getAddress(),
                    student.getMarks()
            ));
        }
        return studentDtolist;
    }
}
