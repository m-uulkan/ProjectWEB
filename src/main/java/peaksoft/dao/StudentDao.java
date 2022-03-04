package peaksoft.dao;

import peaksoft.model.Group;
import peaksoft.model.Student;

import java.util.List;

public interface StudentDao {
    void addStudent(Student s);
    void updateStudent(Long id,Student s);
    List<Student>students(Long id);
    Student getStudentById(Long id);
    void removeStudentById(Long id);
}
