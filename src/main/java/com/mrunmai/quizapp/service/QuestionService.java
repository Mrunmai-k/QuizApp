package com.mrunmai.quizapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrunmai.quizapp.Question;
import com.mrunmai.quizapp.dao.QuestionDao;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public List<Question> getAllQuestions() {
        return questionDao.findAll();
    }

    public List<Question> getQuestionsByCategory(String category) {
        return questionDao.findByCategory(category);
    }
}
