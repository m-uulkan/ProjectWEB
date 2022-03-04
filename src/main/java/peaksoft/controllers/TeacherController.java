package peaksoft.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.model.Group;
import peaksoft.model.Teacher;
import peaksoft.service.CourseServiceImple;
import peaksoft.service.GroupServiceImple;
import peaksoft.service.TeacherDaoServiceImple;

@Controller
@RequestMapping("/teachers/{id}")
public class TeacherController {

    private final TeacherDaoServiceImple teacherService;
    private final CourseServiceImple courseService;


    public TeacherController(TeacherDaoServiceImple teacherService, CourseServiceImple courseService) {


        this.teacherService = teacherService;
        this.courseService = courseService;
    }
    @GetMapping("/new")
    public String newTeacher(Model model){
        model.addAttribute("teacher", new Teacher());
        return "teacher/newTeacher";

    }
    @GetMapping()
    public String showTeachers(Model model, @PathVariable("id") Long id) {
        model.addAttribute("teacherList", teacherService.teachers(id));
        model.addAttribute("courseId", id);
        return "teacher/showTeacher";
    }


    @PostMapping("/save")
    public String createTeacher(@ModelAttribute("teacher") Teacher teacher, @PathVariable("id") Long id) {
        teacher.setCourse1(courseService.getCourseById(id));
        teacherService.addTeacher(teacher);
        return "redirect:/teachers/{id}";
    }

    @DeleteMapping("/{id1}/delete")
    public String deleteCompanyById(@PathVariable("id1") Long id1) {
        teacherService.removeTeacherById(id1);
        return "redirect:/teachers/{id}";
    }
//
    @GetMapping("/{id2}/edit")
    public String edit(Model model,@PathVariable("id2")Long id2,@PathVariable("id") Long id){
        model.addAttribute("teacher",teacherService.getTeacherById(id2));
        model.addAttribute("courseId",id);
        return "teacher/editTeacher";

    }

    @PatchMapping("/{id3}/update")
    public String updateTeacher(@ModelAttribute("teacher") Teacher teacher, @PathVariable("id3") Long id3) {
        teacherService.updateTeacher(id3, teacher);
        return "redirect:/teachers/{id}";
    }


}
