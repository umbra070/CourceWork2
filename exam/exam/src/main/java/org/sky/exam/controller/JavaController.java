package org.sky.exam.controller;

import org.sky.exam.model.Question;
import org.sky.exam.service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
public class JavaController {
    QuestionService questionService;

    public JavaController(QuestionService questionService){
        this.questionService = questionService;
    }

    @GetMapping("/exam/java/add?question=QuestionText&answer=QuestionAnswer")
    public void addQuestion(@RequestParam("question") String question, @RequestParam("answer") String answer){

    }

    @GetMapping("/exam/java")
    public List<Question> getQuestions(){
        return new ArrayList<Question>();
    }

    @GetMapping("/exam/java/remove?question=QuestionText&answer=QuestionAnswer\n")
    public void removeQuestion(@RequestParam("question") String question,@RequestParam("answer") String answer){

    }
}
