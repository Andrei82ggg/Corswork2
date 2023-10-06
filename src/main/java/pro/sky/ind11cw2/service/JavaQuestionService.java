package pro.sky.ind11cw2.service;

import org.springframework.stereotype.Service;
import pro.sky.ind11cw2.model.Question;
import pro.sky.ind11cw2.repozitory.QuestionRepository;

import java.util.*;

@Service("math")
public class JavaQuestionService implements QuestionService{
    private final Random random = new Random();
    private final QuestionRepository repository;

    public JavaQuestionService(QuestionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Question add(String question, String answer) {
        return repository.add(new Question(question,answer));
    }

    @Override
    public Question add(Question question) {
                return repository.add(question);
    }

    @Override
    public Question remove(Question question) {
                return repository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return repository.getAll();
    }

    @Override
    public Question getRandomeQuestion() {
        var questions = repository.getAll();
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

    public JavaQuestionServiceTest getRandomQuestion() {
        return null;
    }
}
