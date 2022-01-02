package projet.studenity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import projet.studenity.model.Answer;
import projet.studenity.model.Forum;
import projet.studenity.service.ForumAnswerService;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value="/question")
public class ForumAnswerController {
    @Autowired
    private ForumAnswerService forumAnswerService;

    @PostMapping(value="/deleteForum")
    public boolean deleteForum(@RequestBody Forum forum){
        return forumAnswerService.deleteForum(forum);
    }

    @PostMapping(value="/deleteAnswer")
    public boolean deleteAnswer(@RequestBody Answer answer){
        return forumAnswerService.deleteAnswer(answer);
    }

    @PostMapping(value="/createForum")
    public boolean addForum(@RequestBody Forum forum){
        return forumAnswerService.addForum(forum);
    }

    @PostMapping(value="/addAnswerToForum")
    public boolean addAnswerToForum(@RequestBody Answer answer){
        return forumAnswerService.addAnswerToForum(answer);
    }

    @PostMapping(value="/updateForum")
    public boolean updateForum(@RequestBody Forum forum){
        return forumAnswerService.updateForum(forum);
    }

    @PostMapping(value="/updateAnswer")
    public boolean updateAnswer(@RequestBody Answer answer){
        return forumAnswerService.updateAnswer(answer);
    }

    @GetMapping(value="/listForum")
    public List<Forum> getAllForums(){
        return forumAnswerService.getForums();
    }

    @PostMapping(value="/listAnswerByForum")
    public List<Answer> listAnswerByForum(@RequestBody int idForum){
        return forumAnswerService.listAnswerByForum(idForum);
    }

    @GetMapping(value="/test")
    public List<Forum> test() {

        return forumAnswerService.getAllForums();
    }
}