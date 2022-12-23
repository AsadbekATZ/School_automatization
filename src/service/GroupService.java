package service;

import model.Group;

import java.util.UUID;

public class GroupService extends BaseService{
    public static Group[] groups = new Group[100];
    private int index = 0;

    @Override
    public boolean add(Object object) {
        Group group = (Group) object;
        for (Group group1 : groups) {
            if(group1 != null){
                if(group1.getName().equals(group.getName())){
                    return false;
                }
            }
        }
        groups[index++] = group;
        return true;
    }

    public Group login(String groupName){
        for (Group group : groups) {
            if(group != null){
                if (group.getName().equals(groupName)){
                    return group;
                }
            }
        }
        return null;
    }
    @Override
    public Object getById(UUID id) {
        for (Group group : groups) {
            if(group != null){
                if(group.getId().equals(id)){
                    return group;
                }
            }
        }
        return null;
    }
}
