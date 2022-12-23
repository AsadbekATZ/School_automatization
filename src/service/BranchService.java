package service;

import model.Branch;

import java.util.UUID;

public class BranchService extends BaseService{
    public static Branch[] branches = new Branch[100];
    private int index = 0;


    @Override
    public boolean add(Object object) {
        Branch branch = (Branch) object;
        for (Branch branch1 : branches) {
            if(branch1 != null){
                if(branch1.getName().equals(branch.getName())){
                    return false;
                }
            }
        }
        branches[index++] = branch;
        return true;
    }

    public Branch login(String branchName){
        for (Branch branch : branches) {
            if(branch != null){
                if(branch.getName().equals(branchName)){
                    return branch;
                }
            }
        }
        return null;
    }
    @Override
    public Object getById(UUID id) {
        for (Branch branch : branches) {
            if(branch != null){
                if(branch.getId().equals(id)){
                    return branch;
                }
            }
        }
        return null;
    }
}
