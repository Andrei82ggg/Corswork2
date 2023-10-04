package pro.sky.ind11cw2.service;

import org.springframework.stereotype.Service;
import pro.sky.ind11cw2.model.Question;

import java.util.*;
@Service
public class MathQuestionService implements QuestionService {
    private final Random random = new Random();
    private final Set<Question> questions = new HashSet<>();
    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if(questions.remove(question)){
            return question;
        }
        return null;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(questions);
    }

    @Override
    public Question getRandomeQuestion() {
        var randomIndex = random.nextInt(questions.size());
        int index = 0;
        var it = questions.iterator();
        while (it.hasNext()) {
            var question = it.next();
            if (index == randomIndex){
                return question;
            }
            index++;
        }
        throw new NoQuestionsFound();
    }
}
