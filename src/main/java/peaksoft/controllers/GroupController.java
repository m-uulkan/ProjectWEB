package peaksoft.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.model.Company;
import peaksoft.model.Group;

import peaksoft.service.CourseServiceImple;
import peaksoft.service.GroupServiceImple;

@Controller
@RequestMapping("/groups/{id}")
public class GroupController {

    private final GroupServiceImple groupService;
    private final CourseServiceImple courseService;

    @Autowired
    public GroupController(GroupServiceImple groupService, CourseServiceImple courseService) {
        this.groupService = groupService;
        this.courseService = courseService;
    }
    @GetMapping("/new")
    public String newGroup(Model model){
        model.addAttribute("group", new Group());
        return "group/newGroup";

    }
    @GetMapping()
    public String showGroup(Model model, @PathVariable("id") Long id) {
        model.addAttribute("groupList", groupService.groupList(id));
        model.addAttribute("courseId", id);
        return "group/showGroup";
    }


    @PostMapping("/save")
    public String createGroup(@ModelAttribute("group") Group group, @PathVariable("id") Long id) {
        group.addCourseToGroup(courseService.getCourseById(id));
        groupService.addGroup(group);
        return "redirect:/groups/{id}";
    }

    @DeleteMapping("/{id1}/delete")
    public String deleteCompanyById(@PathVariable("id1") Long id1) {
        groupService.removeGroupById(id1);
        return "redirect:/groups/{id}";
    }
    @GetMapping("/{id2}/edit")
    public String edit(Model model,@PathVariable("id2")Long id2,@PathVariable("id") Long id){
        model.addAttribute("group",groupService.getGroupById(id2));
        model.addAttribute("courseId",id);
        return "group/editGroup";

    }
    @PatchMapping("/{id3}/update")
    public String updateTeacher(@ModelAttribute("group") Group group, @PathVariable("id3") Long id3) {
        groupService.updateGroup(id3,group);
        return "redirect:/groups/{id}";
    }
}
