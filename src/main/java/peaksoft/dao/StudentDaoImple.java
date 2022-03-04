package peaksoft.dao;

import org.springframework.stereotype.Repository;
import peaksoft.model.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class StudentDaoImple implements StudentDao{

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void addStudent(Student s) {
        entityManager.merge(s);

    }

    @Override
    public void updateStudent(Long id, Student s) {
        Student student=getStudentById(id);
        student.setName(s.getName());
        student.setSurname(s.getSurname());
        student.setEmail(s.getEmail());
        student.setStudyFormat(s.getStudyFormat());
        entityManager.merge(student);
    }

    @Override
    public List<Student> students(Long id) {
        List<Student> studentList =entityManager.createQuery("select c from Student c where c.group.id=:id",Student. class).setParameter("id",id).getResultList();
        return studentList;
    }

    @Override
    public Student getStudentById(Long id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public void removeStudentById(Long id) {
        entityManager.remove(getStudentById(id));
    }
}
