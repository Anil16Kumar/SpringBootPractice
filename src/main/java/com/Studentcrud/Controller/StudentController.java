package com.Studentcrud.Controller;

import com.Studentcrud.Service.StudentService;
import com.Studentcrud.dto.StudentRequest;
import com.Studentcrud.dto.StudentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/student")
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/add")
    public StudentResponse createTheStudentData(@RequestBody StudentRequest studentRequest){
        return studentService.createTheStudent(studentRequest);
    }

    @GetMapping("/getAll")
    public List<StudentResponse> getAllStudentData(){
        return studentService.getAllStudentList();
    }

    @GetMapping("/get/{id}")
    public Optional<StudentResponse> getStudent(@PathVariable long id){
        return studentService.getPerticularStudent(id);
    }

    @PutMapping("/update/{id}")
    public Optional<StudentResponse> updateTheStudent(@PathVariable long id, @RequestBody StudentRequest studentRequest){
        return studentService.updateStudent(id, studentRequest);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTheStudent(@PathVariable long id){
        return studentService.deleteTheStudentData(id);
    }
}
