package vn.edu.hcmut.cse.adse.student_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.hcmut.cse.adse.student_management.entity.Student;
import vn.edu.hcmut.cse.adse.student_management.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repository;

    public List<Student> getAll() {
        return repository.findAll();
    }
    public Student getById(String id) {
        return repository.findById(id).orElse(null);
    }

    public List<Student> searchByName(String keyword) {
        return repository.findAll()
                .stream()
                .filter(student -> student.getName().equalsIgnoreCase(keyword))
                .toList();
    }
}
