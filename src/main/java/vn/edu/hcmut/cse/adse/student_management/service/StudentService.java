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

    public void save(Student student) { repository.save(student); }

    public void deleteById(String id) { repository.deleteById(id); }

    public List<Student> searchByName(String keyword) {
        return repository.findByNameContainingIgnoreCase(keyword);
    }
}
