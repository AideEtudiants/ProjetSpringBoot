package projet.studenity.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projet.studenity.model.Class;
import projet.studenity.model.ClassUser;
import projet.studenity.repository.ClassRepository;
import projet.studenity.repository.ClassUserRepository;
import projet.studenity.service.ClassService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {
    @Autowired
    ClassRepository classRepo;

    @Autowired
    ClassUserRepository classUserRepo;

    @Override
    public Class findClassById(int idClass) {
        List<Class> classes = classRepo.findAll();
        for(Class c: classes){
            if(c.getId() == idClass){
                return c;
            }
        }
        return null;
    }

    @Override
    public boolean addClass(Class c) {
        classRepo.save(c);
        return true;
    }

    @Override
    public boolean deleteUserFromClass(ClassUser classUser) {
        List<ClassUser> classeUsers = classUserRepo.findAll();
        for(ClassUser c: classeUsers){
            if(c.getClassId() == classUser.getClassId() && c.getUserId()==classUser.getUserId()){
                classUserRepo.delete(c);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteClass(int idClass) {
        classRepo.deleteById(idClass);
        return true;
    }

    @Override
    public boolean updateClass(Class c) {
        classRepo.save(c);
        return true;
    }

    @Override
    public boolean addUserToClass(ClassUser classUser) {
        classUserRepo.save(classUser);
        return true;
    }

    @Override
    public List<Class> listClass() {
        try {
            return classRepo.findAll();
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public List<Class> listClassByUser(int idUser) {
        List<ClassUser> classUsers = classUserRepo.findAll();
        List<Class> classes = new ArrayList<>();
        for(ClassUser classUser: classUsers){
            if(classUser.getUserId() == idUser){
                classes.add(findClassById(classUser.getClassId()));
            }
        }
        if(classes.isEmpty()) return null;
        return classes;
    }
}
