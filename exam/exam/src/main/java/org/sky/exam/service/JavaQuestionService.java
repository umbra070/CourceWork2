package org.sky.exam.service;

import org.sky.exam.controller.JavaController;
import org.sky.exam.model.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService{
    Set<Question> questions = new HashSet<>();

    @Override
    public void add(Question question){
        questions.add(question);
    }
    @Override
    public void add(String question, String answer){
        questions.add(new Question(question, answer));
    }
    @Override
    public void remove(Question question){
        questions.remove(question);
    }
    @Override
    public Set<Question> getAll(){
        return questions;
    }

    @Override
    public Question getRandomQuestion(){
        return questions.stream()
                .toList().get(new Random().nextInt(0, questions.size()));
    }
}
