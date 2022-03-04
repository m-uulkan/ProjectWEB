package peaksoft.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import peaksoft.model.Company;
import peaksoft.model.Course;
import peaksoft.service.CompanyService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CourseDaoImple implements CourseDao{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void addCourse(Course course) {
        entityManager.merge(course);

    }

    @Override
    public void updateCourse(Long id,Course c) {
        Course course=getCourseById(id);
        course.setCourseName(c.getCourseName());
        course.setDuration(c.getDuration());
        entityManager.merge(course);
    }


    @Override
    public List<Course> courseList(Long id) {
        List<Course> courseList =entityManager.createQuery("select c from Course c where c.company.id=:id",Course. class).setParameter("id",id).getResultList();
        return courseList;
    }

    @Override
    public Course getCourseById(Long id) {
        return entityManager.find(Course.class,id);

    }

    @Override
    public void removeCourseById(Long id) {
        entityManager.remove(getCourseById(id));
    }

    @Override
    public List<Course> getAll() {
        return null;
    }


}
