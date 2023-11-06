package com.mrunmai.quizapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mrunmai.quizapp.dao.QuestionDao;
import com.mrunmai.quizapp.dao.QuizDao;
import com.mrunmai.quizapp.model.Question;
import com.mrunmai.quizapp.model.Quiz;

@Service
public class QuizService {
    
    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

        List<Question> questions =  questionDao.findRandomQuestionByCategory(category,numQ);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);
        return new ResponseEntity<>("Succces",HttpStatus.CREATED);
    }
}
