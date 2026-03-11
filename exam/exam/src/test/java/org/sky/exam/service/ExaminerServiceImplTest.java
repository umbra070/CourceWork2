package org.sky.exam.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.sky.exam.model.Question;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@DisplayName("Тестирование класса ExaminerServiceImpl")
public class ExaminerServiceImplTest {
    private Question question1;
    private Question question2;
    private Question question3;
    private Question question4;
    private Question question5;
    private Question question6;
    @Mock
    private QuestionService questionService;
    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @BeforeEach
    void SetUp(){
        MockitoAnnotations.openMocks(this);
        question1 = new Question("Java Вопрос1", "Java Ответ1");
        question2 = new Question("Java Вопрос2", "Java Ответ2");
        question3 = new Question("Java Вопрос3", "Java Ответ3");
        question4 = new Question("Java Вопрос4", "Java Ответ4");
        question5 = new Question("Java Вопрос5", "Java Ответ5");
        question6 = new Question("Java Вопрос6", "Java Ответ6");
    }

    @DisplayName("Тестирование уникальной выдачи n количества вопросов")
    @Test
    void testingReturnSomeQuestions(){
        Set<Question> questionsSet = Set.of(question1, question2, question3, question4, question5, question6);
        when(questionService.getRandomQuestion()).thenReturn(question1)
                .thenReturn(question2)
                .thenReturn(question3)
                .thenReturn(question4)
                .thenReturn(question5)
                .thenReturn(question6);
        when(questionService.getAll()).thenReturn(questionsSet);
        assertEquals(4, examinerService.getQuestions(4).size());
        verify(questionService, times(1)).getAll();
        verify(questionService, times(4)).getRandomQuestion();
    }

    @DisplayName("Тестирование вызова исключения при превышении количества вопросов")
    @Test
    void testingThrowException(){
        Set<Question> questionsSet = Set.of(question1, question2, question3, question4, question5, question6);
        when(questionService.getRandomQuestion()).thenReturn(question1)
                .thenReturn(question2)
                .thenReturn(question3)
                .thenReturn(question4)
                .thenReturn(question5)
                .thenReturn(question6);
        when(questionService.getAll()).thenReturn(questionsSet);
        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> examinerService.getQuestions(8));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getStatusCode());
        verify(questionService, never()).getRandomQuestion();
    }
}
