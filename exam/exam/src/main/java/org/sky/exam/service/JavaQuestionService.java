package org.sky.exam.service;

import org.sky.exam.model.Question;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class JavaQuestionService implements QuestionService{
    Set<Question> questions = new HashSet<>();

    @Override
    public void add(Question question){

    }
    @Override
    public void add(String question, String answer){

    }
    @Override
    public void remove(Question question){

    }
    @Override
    public Set<Question> getAll(){
        return questions;
    }
    @Override
    public Question getRandomQuestion(){
        Question randQuestion = new Question();
        return randQuestion;
    }
}
