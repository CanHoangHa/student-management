package vn.edu.hcmut.cse.adse.student_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.edu.hcmut.cse.adse.student_management.entity.Student;
import vn.edu.hcmut.cse.adse.student_management.service.StudentService;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService service;

    @GetMapping
    public String getAllStudents(@RequestParam(required = false) String keyword, Model model) {
        List<Student> students;
        if (keyword != null && !keyword.isEmpty()) {
            students = service.searchByName(keyword);
        } else {
            students = service.getAll();
        }
        model.addAttribute("dsSinhVien", students);
        return "students";
    }

    @GetMapping("/{id}")
    public String getStudentById(@PathVariable String id, Model model) {
        model.addAttribute("student", service.getById(id));
        return "student-detail";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("student", new Student());
        return "student-form";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable String id, Model model) {
        model.addAttribute("student", service.getById(id));
        return "student-form";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute Student student) {
        service.save(student);
        return "redirect:/students";
    }

    @GetMapping("/{id}/delete")
    public String deleteStudent(@PathVariable String id) {
        service.deleteById(id);
        return "redirect:/students"; 
    }

}
