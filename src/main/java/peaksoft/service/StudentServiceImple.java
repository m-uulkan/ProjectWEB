package peaksoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.dao.StudentDao;
import peaksoft.model.Student;

import java.util.List;

@Service
public class StudentServiceImple implements StudentService{

    private StudentDao studentDao;

    @Autowired
    public StudentServiceImple(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public void addStudent(Student s) {
        studentDao.addStudent(s);

    }

    @Override
    public void updateStudent(Long id, Student s) {
        studentDao.updateStudent(id,s);

    }

    @Override
    public List<Student> students(Long id) {
        return studentDao.students(id);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentDao.getStudentById(id);
    }

    @Override
    public void removeStudentById(Long id) {
        studentDao.removeStudentById(id);
    }
}
