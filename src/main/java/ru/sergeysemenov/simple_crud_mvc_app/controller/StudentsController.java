package ru.sergeysemenov.simple_crud_mvc_app.controller;

import lombok.AllArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.sergeysemenov.simple_crud_mvc_app.entity.Student;
import ru.sergeysemenov.simple_crud_mvc_app.service.StudentService;

@AllArgsConstructor
@Controller
public class StudentsController {

    private final StudentService service;

    @GetMapping("/")
    public String getAllStudents(Model model){
        model.addAttribute("students", service.findAll());
        return "index";
    }

    @GetMapping("/{id}")
    public String getStudentById(@PathVariable int id, Model model){
        model.addAttribute("student", service.findById(id));
        return "student-details";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable int id){
        service.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/show-form")
    public String showSaveForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "add-form";
    }

    @PostMapping("/")
    public String saveStudent(@ModelAttribute("student") Student student){
        service.saveStudent(student);
        return "redirect:/";
    }

    @GetMapping("/update-form/{id}")
    public String showUpdateForm(@PathVariable int id,  Model model) {
        Student student = service.findById(id);
        model.addAttribute("student", student);
        return "update-form";
    }



}
