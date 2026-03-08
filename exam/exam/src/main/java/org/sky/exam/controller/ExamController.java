package org.sky.exam.controller;

import org.sky.exam.model.Question;
import org.sky.exam.service.ExaminerService;
import org.sky.exam.service.ExaminerServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class ExamController {
    ExaminerService examinerService;

    public ExamController(ExaminerServiceImpl examinerService){
        this.examinerService = examinerService;
    }

    @GetMapping("/exam/get/{amount}")
    public Set<Question> getQuestions(int amount){
        return examinerService.getQuestions(amount);
    }
}

