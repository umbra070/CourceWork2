package org.sky.exam.service;

import org.sky.exam.model.Question;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface QuestionService {
    Set<Question> questions = new HashSet<>();

    public void add(Question question);
    public void add(String question, String answer);
    public void remove(Question question);
    public Set<Question> getAll();
    public Question getRandomQuestion();
}
