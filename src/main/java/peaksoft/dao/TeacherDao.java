package peaksoft.dao;

import peaksoft.model.Course;
import peaksoft.model.Teacher;

import java.util.List;

public interface TeacherDao {
    void addTeacher(Teacher teacher);
    void updateTeacher(Long id,Teacher teacher);
    List<Teacher>teachers(Long id);
    Teacher getTeacherById(Long id);
    void removeTeacherById(Long id);
}
