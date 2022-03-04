package peaksoft.service;

import peaksoft.model.Teacher;

import java.util.List;

public interface TeacherService {
    void addTeacher(Teacher teacher);
    void updateTeacher(Long id,Teacher teacher);
    List<Teacher> teachers(Long id);
    Teacher getTeacherById(Long id);
    void removeTeacherById(Long id);
}
