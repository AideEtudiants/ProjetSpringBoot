package projet.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class HelloController {

    @RequestMapping("hello")
    public List<Hello> getMessage(){
        List<Hello> messageList = new ArrayList<>();
        messageList.add(new Hello("Bonjour"));
        messageList.add(new Hello("Aniesse"));
        return messageList;

    }
    
}
