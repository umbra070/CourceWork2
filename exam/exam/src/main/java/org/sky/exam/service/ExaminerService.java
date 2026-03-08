package org.sky.exam.service;

import org.sky.exam.model.Question;

import java.util.Set;

public interface ExaminerService {

    Set<Question> getQuestions(int amount);
}
