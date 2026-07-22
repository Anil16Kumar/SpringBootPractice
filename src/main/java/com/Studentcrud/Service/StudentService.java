package com.Studentcrud.Service;

import com.Studentcrud.Entity.Student;
import com.Studentcrud.Repository.StudentRepository;
import com.Studentcrud.dto.StudentRequest;
import com.Studentcrud.dto.StudentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentResponse createTheStudent(StudentRequest studentRequest){
        Student student=new Student();
        student.setStudentName(studentRequest.studentName());
        student.setCourse(studentRequest.course());
        student.setCourseFee(studentRequest.courseFee());
        Student savedStudent=studentRepository.save(student);
        return new StudentResponse(savedStudent.getStudentId(), savedStudent.getStudentName(), savedStudent.getCourse(),
                savedStudent.getCourseFee());
    }

    public List<StudentResponse> getAllStudentList(){
        List<Student> lst=studentRepository.findAll();
        return lst.stream().map(
            student->new StudentResponse(
                    student.getStudentId(),
                    student.getStudentName(),
                    student.getCourse(),
                    student.getCourseFee()
            )
        ).collect(Collectors.toList());
    }

    public Optional<StudentResponse> getPerticularStudent(long id){
            if(studentRepository.existsById(id)){
                Student currStudent=studentRepository.findById(id).get();
                return Optional.of(new StudentResponse(currStudent.getStudentId(),currStudent.getStudentName(),
                        currStudent.getCourse(),currStudent.getCourseFee()));
            }
            return Optional.empty();
    }

    public Optional<StudentResponse> updateStudent(long id, StudentRequest studentRequest){
            if(studentRepository.existsById(id)){
                Student student=studentRepository.findById(id).get();
                student.setStudentName(studentRequest.studentName());
                student.setCourse(studentRequest.course());
                student.setCourseFee(studentRequest.courseFee());
                Student savedStudent=studentRepository.save(student);
                return Optional.of(new StudentResponse(savedStudent.getStudentId(),
                        savedStudent.getStudentName(),
                        savedStudent.getCourse(),
                        savedStudent.getCourseFee()));
            }
            return Optional.empty();
    }

    public String deleteTheStudentData(long id){
            if(studentRepository.existsById(id)){
                studentRepository.deleteById(id);
                return "Student with id: "+id+" deleted successfully..";
            }
            return "Student with id: "+id+" not found..";
    }

}

