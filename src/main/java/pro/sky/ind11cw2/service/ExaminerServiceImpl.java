package pro.sky.ind11cw2.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.ind11cw2.model.Question;
import pro.sky.ind11cw2.service.exception.NotEnoukQuestionsException;

import java.util.*;

@Service
public class ExaminerServiceImpl extends ExaminerService {
    private final Random random = new Random();
    private final QuestionService javaService;
    private final QuestionService mathService;

    public ExaminerServiceImpl(@Qualifier("java") QuestionService javaService,
                               @Qualifier("math")QuestionService mathService) {
        this.javaService = javaService;
        this.mathService = mathService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        var allMathQuestions = mathService.getAll();
        var allJavaQuestions = javaService.getAll();
        if(amount > allJavaQuestions.size() + allMathQuestions.size()){
            throw new NotEnoukQuestionsException();
        }
        if (amount == (allJavaQuestions.size() + allMathQuestions.size())){
            List<Question> result = new ArrayList<>(allJavaQuestions.size() +allMathQuestions.size())
            result.addAll(allJavaQuestions);
            result.addAll(allMathQuestions);
            return result;
        }
        Set<Question> result = new HashSet<>();
        while ((result.size() < amount)){
            Question randomQuestion = random.nextBoolean() ? javaService.getRandomeQuestion() : mathService.getRandomeQuestion();
             result.add(randomQuestion);
        }
        return null;
    }
}
