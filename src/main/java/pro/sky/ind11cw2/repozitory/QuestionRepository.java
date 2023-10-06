package pro.sky.ind11cw2.repozitory;

import pro.sky.ind11cw2.model.Question;

import java.util.Collection;

public interface QuestionRepository {
    Question add(String question, String answer);
    Question add(Question question);
    Question remove(Question question);
    Collection<Question> getAll();
    }
