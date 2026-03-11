package org.sky.exam.controller;

import org.sky.exam.model.Question;
import org.sky.exam.service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/questions/java")
public class JavaController {
    private final QuestionService questionService;

    public JavaController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/add")
    public void addQuestion(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        questionService.add(question, answer);
    }

    @GetMapping
    public Set<Question> getQuestions() {
        return questionService.getAll();
    }

    @GetMapping("/remove")
    public void removeQuestion(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        questionService.remove(new Question(question, answer));
    }
}
