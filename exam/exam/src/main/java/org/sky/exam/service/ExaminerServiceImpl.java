package org.sky.exam.service;

import org.sky.exam.model.Question;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService{
    @Override
    public Set<Question> getQuestions(int amount) {
        return Set.of();
    }
}
