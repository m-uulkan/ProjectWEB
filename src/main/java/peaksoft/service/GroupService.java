package peaksoft.service;

import peaksoft.model.Group;

import java.util.List;

public interface GroupService {
    void addGroup(Group group);
    void updateGroup(Long id,Group g);
    List<Group> groupList(Long id);
    Group getGroupById(Long id);
    void removeGroupById(Long id);
}
