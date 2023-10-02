package pro.sky.ind11cw2.service;

import pro.sky.ind11cw2.model.Question;

import java.util.Collection;

public abstract class ExaminerService {
    public abstract Collection<Question> getQuestions(int imount);
}
