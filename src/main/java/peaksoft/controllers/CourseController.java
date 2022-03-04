package peaksoft.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.model.Course;
import peaksoft.service.CompanyServiceImple;
import peaksoft.service.CourseServiceImple;
import peaksoft.service.TeacherDaoServiceImple;

@Controller
@RequestMapping("/courses/{id}")
public class CourseController {


    private final CourseServiceImple imple;
    private final CompanyServiceImple companyServiceImple;
    private final TeacherDaoServiceImple teacherImple;

    @Autowired
    public CourseController(CourseServiceImple imple, CompanyServiceImple companyServiceImple, TeacherDaoServiceImple teacherImple) {
        this.imple = imple;
        this.companyServiceImple = companyServiceImple;
        this.teacherImple = teacherImple;
    }

    @GetMapping()
    public String getAllCourses(Model model, @PathVariable("id") Long id) {
        model.addAttribute("courseLists", imple.courseList(id));
        model.addAttribute("companyId", id);
        return "course/getCourses";
    }

    @GetMapping("/newCourses")
    public String newCourse(Model model) {
        model.addAttribute("course", new Course());
        return "course/newPage";
    }

    @PostMapping("/addCourses")
    public String createCourse(@ModelAttribute("course") Course course, @PathVariable("id") Long id) {
        course.setCompany(companyServiceImple.getCompanyById(id));
        imple.addCourse(course);
        return "redirect:/courses/{id}";
    }

    @DeleteMapping("/{id1}/delete")
    public String deleteCompanyById(@PathVariable("id1") Long id1) {
        imple.removeCourseById(id1);
        return "redirect:/courses/{id}";
    }

    @GetMapping("/{id2}/edit")
    public String edit(Model model,@PathVariable("id2")Long id2,@PathVariable("id")Long id){
        model.addAttribute("course",imple.getCourseById(id2));
        model.addAttribute("companyId",id);
        return "course/editCourse";

    }
//
    @PatchMapping("/{id3}/update")
    public String updateCourses(@ModelAttribute("course") Course course, @PathVariable("id3") Long id3) {
        imple.updateCourse(id3, course);
        return "redirect:/courses/{id}";
    }

}