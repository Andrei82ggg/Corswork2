package pro.sky.ind11cw2.service;

import pro.sky.ind11cw2.model.Question;

import java.util.Collection;

public interface QuestionService {
    Question add(String question, String answer);
    Question add(Question question);
    Question remove(Question question);
    Collection<Question> getAll();
    Question getRandomeQuestion();
}
