package com.tejaswani.student_management_api.service;

import com.tejaswani.student_management_api.dto.StudentDTO;
import com.tejaswani.student_management_api.entity.Student;
import com.tejaswani.student_management_api.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // CREATE
    public StudentDTO saveStudent(StudentDTO dto) {

        Student student = new Student();
        student.setName(dto.getName());
        student.setEmail(dto.getEmail());

        Student saved = studentRepository.save(student);

        return new StudentDTO(
                saved.getId(),
                saved.getName(),
                saved.getEmail()
        );
    }

    // READ ALL
    public Page<StudentDTO> getAllStudents(Pageable pageable) {

        Page<Student> studentPage = studentRepository.findAll(pageable);

        return studentPage.map(student ->
                new StudentDTO(
                        student.getId(),
                        student.getName(),
                        student.getEmail()
                )
        );
    }

    // READ BY ID
    public StudentDTO getStudentById(Long id) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        return new StudentDTO(
                student.getId(),
                student.getName(),
                student.getEmail()
        );
    }

    // UPDATE
    public StudentDTO updateStudent(Long id, StudentDTO dto) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        student.setName(dto.getName());
        student.setEmail(dto.getEmail());

        Student updated = studentRepository.save(student);

        return new StudentDTO(
                updated.getId(),
                updated.getName(),
                updated.getEmail()
        );
    }

    // DELETE
    public void deleteStudent(Long id) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        studentRepository.delete(student);
    }
    public List<Student> searchStudents(String name) {
        return studentRepository.findByNameContainingIgnoreCase(name);
    }

    public Page<Student> getStudentsWithPagination(int page, int size) {
        return studentRepository.findAll(PageRequest.of(page, size));
    }
}












