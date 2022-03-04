package peaksoft.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.model.Student;
import peaksoft.service.GroupServiceImple;
import peaksoft.service.StudentServiceImple;

@Controller
@RequestMapping("/students/{id}")
public class StudentController {

    private final StudentServiceImple studentImple;
    private final GroupServiceImple groupService;

    @Autowired
    public StudentController(StudentServiceImple studentImple, GroupServiceImple groupService) {
        this.studentImple = studentImple;
        this.groupService = groupService;
    }

    @GetMapping()
    public String showStudents(Model model, @PathVariable("id") Long id) {
        model.addAttribute("studentList",studentImple.students(id));
        model.addAttribute("groupId", id);
        return "student/showStudent";
    }

    @GetMapping("/new")
    public String newStudent(Model model) {
        model.addAttribute("student", new Student());
        return "student/newStudent";
    }

    @PostMapping("/save")
    public String createStudent(@ModelAttribute("student") Student student, @PathVariable("id") Long id) {
        student.setGroup1(groupService.getGroupById(id));
        studentImple.addStudent(student);
        return "redirect:/students/{id}";
    }

    @DeleteMapping("/{id1}/delete")
    public String deleteStudentById(@PathVariable("id1") Long id1) {
        studentImple.removeStudentById(id1);
        return "redirect:/students/{id}";
    }

    @GetMapping("/{id2}/edit")
    public String edit(Model model,@PathVariable("id2")Long id2,@PathVariable("id")Long id){
        model.addAttribute("student",studentImple.getStudentById(id2));
        model.addAttribute("groupId",id);
        return "student/editStudent";

    }

    @PatchMapping("/{id3}/update")
    public String updateCourses(@ModelAttribute("student") Student student, @PathVariable("id3") Long id3) {
        studentImple.updateStudent(id3,student);
        return "redirect:/students/{id}";
    }
}
