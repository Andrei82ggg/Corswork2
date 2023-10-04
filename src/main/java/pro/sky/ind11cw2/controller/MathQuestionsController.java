package pro.sky.ind11cw2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.ind11cw2.model.Question;
import pro.sky.ind11cw2.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/math")
public class MathQuestionsController {
    private final MathQuestionsController questionService;

    public MathQuestionsController(MathQuestionsController questionService){
        this.questionService = questionService;
    }
    @GetMapping("/add")
    public Question add(@RequestParam String question, @RequestParam String answer){
        return questionService.add(question, answer);
    }
    @GetMapping("/remove")
    public Question remove(@RequestParam String question, @RequestParam String answer){
        return questionService.remove(new Question(question, answer));
    }


    @GetMapping()
    public Collection<Question> all() {
        return questionService.getAll();
    }
}
