package service;

import model.Question;

import java.util.Set;

public interface QuestionService {
    Set<Question> getQuestions (int amount);
    void removeQuestion();
    void addQuestion();
    Set<Question> getAllQuestions();
}
