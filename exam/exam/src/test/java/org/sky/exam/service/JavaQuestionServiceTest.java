package org.sky.exam.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.sky.exam.model.Question;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тестирование класса JavaQuestionService")
public class JavaQuestionServiceTest {
    private JavaQuestionService javaQuestionService;
    private Question question1;
    private Question question2;
    private Question question3;

    @BeforeEach
    void SetUp(){
        javaQuestionService = new JavaQuestionService();
        question1 = new Question("Java Вопрос1", "Java Ответ1");
        question2 = new Question("Java Вопрос2", "Java Ответ2");
        question3 = new Question("Java Вопрос3", "Java Ответ3");
    }

    @DisplayName("Тестирование добавления вопроса через объект Question")
    @Test
    void addQuestionsByQuestionObject(){
        javaQuestionService.add(question1);
        javaQuestionService.add(question2);
        javaQuestionService.add(question3);
        assertEquals(3, javaQuestionService.getAll().size());
        assertTrue(javaQuestionService.getAll().contains(question1));
        assertTrue(javaQuestionService.getAll().contains(question2));
        assertTrue(javaQuestionService.getAll().contains(question3));
    }
    @DisplayName("Тестирование добавления вопроса через строковое представление")
    @Test
    void addQuestionsByString(){
        javaQuestionService.add("Java Вопрос4", "Java Ответ4");
        javaQuestionService.add("Java Вопрос5", "Java Ответ5");
        javaQuestionService.add("Java Вопрос6", "Java Ответ6");
        System.out.println(javaQuestionService.getAll().size());
        assertEquals(3, javaQuestionService.getAll().size());
        assertTrue(javaQuestionService.getAll().contains(new Question("Java Вопрос4", "Java Ответ4")));
        assertTrue(javaQuestionService.getAll().contains(new Question("Java Вопрос5", "Java Ответ5")));
        assertTrue(javaQuestionService.getAll().contains(new Question("Java Вопрос6", "Java Ответ6")));
    }

    @DisplayName("Тестирование удаления вопроса")
    @Test
    void removeQuestion(){
        javaQuestionService.add(question1);
        javaQuestionService.add(question2);
        javaQuestionService.add(question3);
        javaQuestionService.remove(question2);
        assertEquals(2, javaQuestionService.getAll().size());
        assertTrue(javaQuestionService.getAll().contains(question1));
        assertTrue(javaQuestionService.getAll().contains(question3));
        assertFalse(javaQuestionService.getAll().contains(question2));
    }
}
