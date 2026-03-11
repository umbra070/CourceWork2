package org.sky.exam.service;

import org.sky.exam.controller.ExamController;
import org.sky.exam.model.Question;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ExaminerServiceImpl implements ExaminerService{
    QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService){
        this.questionService = questionService;
    }

    @Override
    public Set<Question> getQuestions(int amount) {
        if(amount > questionService.getAll().size()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("Запрошено вопросов %d, при доступных %d", amount, questionService.getAll().size()));
        }
        return Stream.generate(questionService::getRandomQuestion)
                .limit(amount * 2L)
                .distinct()
                .limit(amount)
                .collect(Collectors.toSet());
    }
}
