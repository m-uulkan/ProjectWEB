package peaksoft.dao;

import org.springframework.stereotype.Repository;
import peaksoft.model.Course;
import peaksoft.model.Group;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class GroupDaoImple implements GroupDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addGroup(Group group) {
        entityManager.merge(group);
    }

    @Override
    public void updateGroup(Long id,Group g) {
       Group group=getGroupById(id);
       group.setNameGroup(g.getNameGroup());
       group.setDateOfStart(g.getDateOfStart());
       group.setDateOfFinish(g.getDateOfFinish());
       entityManager.merge(group);

    }


    @Override
    public List<Group> groupList(Long courseId) {
        List<Group> groups = entityManager.createQuery("select c.groupList from Course c where c.id = ?1").setParameter(1, courseId).getResultList();
        return groups;

    }

    @Override
    public Group getGroupById(Long id) {
        return entityManager.find(Group.class,id);
    }

    @Override
    public void removeGroupById(Long id) {
      entityManager.remove(getGroupById(id));
    }
}
