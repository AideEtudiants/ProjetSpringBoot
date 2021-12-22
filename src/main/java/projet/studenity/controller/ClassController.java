package projet.studenity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import projet.studenity.model.Class;
import projet.studenity.model.ClassUser;
import projet.studenity.service.ClassService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value="/class")
public class ClassController {

    @Autowired
    private ClassService classService;

    @PostMapping(value="/listClassByUser")
    public List<Class> listClassByUser(@RequestBody int idUser){
        return classService.listClassByUser(idUser);
    }

    @PostMapping(value="/delete")
    public boolean deleteUserFromClass(@RequestBody ClassUser classUser){
        return classService.deleteUserFromClass(classUser);
    }

    @PostMapping(value="/create")
    public boolean addClass(@RequestBody Class c){
        return classService.addClass(c);
    }

    @PostMapping(value="/update")
    public boolean updateClass(@RequestBody Class c){
        return classService.updateClass(c);
    }

    @PostMapping(value="/addUserToClass")
    public boolean addUserToClass(@RequestBody ClassUser classUser){
        return classService.addUserToClass(classUser);
    }

    @PostMapping(value="/deleteClass")
    public boolean deleteClass(@RequestBody int idClass){return classService.deleteClass(idClass);}

    @GetMapping(value="/list")
    public List<Class> listClass(){
        return classService.listClass();
    }

    @GetMapping(value="/test")
    public
    List<Class> test() {
        Class classes = new Class();
        classes.setId(1);
        classes.setStartDate("15/12/2021");
        classes.setDescription("Examen prepare");
        classes.setName("Programmation Concurrente");
        return classService.listClassByUser(4);
    }
}