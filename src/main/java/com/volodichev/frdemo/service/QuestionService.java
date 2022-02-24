package com.volodichev.frdemo.service;

import com.volodichev.frdemo.entity.Question;

import java.util.List;
import java.util.Set;

public interface QuestionService {
    Question addQuestion(Question question);

    Question updateQuestion(Question question);

    boolean deleteQuestion(long id);

    List<Question> getAllById(Set<Long> ids);
}
