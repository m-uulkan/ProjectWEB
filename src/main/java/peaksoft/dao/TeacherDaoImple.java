package peaksoft.dao;

import org.springframework.stereotype.Repository;
import peaksoft.model.Course;
import peaksoft.model.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class TeacherDaoImple implements TeacherDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addTeacher(Teacher teacher) {
        entityManager.merge(teacher);

    }

    @Override
    public void updateTeacher(Long id, Teacher teacher) {
        Teacher t=getTeacherById(id);
        t.setName(teacher.getName());
        t.setSurname(teacher.getSurname());
        t.setEmail(teacher.getEmail());
        entityManager.merge(teacher);

    }

    @Override
    public List<Teacher> teachers(Long id) {
        List<Teacher>teacherLists=entityManager.createQuery("select t from Teacher t where t.course.id=:id",Teacher. class).setParameter("id",id).getResultList();
        return teacherLists;
    }

    @Override
    public Teacher getTeacherById(Long id) {
        return entityManager.find(Teacher.class,id);
    }

    @Override
    public void removeTeacherById(Long id) {
      entityManager.remove(getTeacherById(id));
    }
}
