package vn.edu.hcmut.cse.adse.student_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.hcmut.cse.adse.student_management.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
}
