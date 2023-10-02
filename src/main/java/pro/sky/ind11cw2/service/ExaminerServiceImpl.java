package pro.sky.ind11cw2.service;

import org.springframework.stereotype.Service;
import pro.sky.ind11cw2.model.Question;
import pro.sky.ind11cw2.service.exception.NotEnoukQuestionsException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl extends ExaminerService {
    private final QuestionService service;

    public ExaminerServiceImpl(QuestionService service) {
        this.service = service;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        var allQuestions = service.getAll();
        if(amount > allQuestions.size()){
            throw new NotEnoukQuestionsException();
        }
        if (amount == allQuestions.size()){
            return allQuestions;
        }
        Set<Question> result = new HashSet<>();
        while ((result.size() < amount)){
         result.add((service.getRandomeQuestion()));
        }
        return null;
    }
}
