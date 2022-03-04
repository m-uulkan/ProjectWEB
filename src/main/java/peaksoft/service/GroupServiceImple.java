package peaksoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.dao.GroupDao;
import peaksoft.model.Group;

import java.util.List;

@Service
public class GroupServiceImple implements GroupService{

    private GroupDao groupDao;

    @Autowired
    public GroupServiceImple(GroupDao groupDao) {
        this.groupDao = groupDao;
    }

    @Override
    public void addGroup(Group group) {
        groupDao.addGroup(group);

    }

    @Override
    public void updateGroup(Long id, Group g) {
        Group group=getGroupById(id);
        group.setNameGroup(g.getNameGroup());
        group.setDateOfFinish(g.getDateOfFinish());
        group.setDateOfStart(g.getDateOfStart());
        groupDao.updateGroup(id,group);
    }

    @Override
    public List<Group> groupList(Long id) {
        return groupDao.groupList(id);
    }

    @Override
    public Group getGroupById(Long id) {
        return groupDao.getGroupById(id);
    }

    @Override
    public void removeGroupById(Long id) {
        groupDao.removeGroupById(id);

    }
}
