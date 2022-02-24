package com.volodichev.frdemo.service;

import com.volodichev.frdemo.entity.Answer;
import com.volodichev.frdemo.entity.Question;
import com.volodichev.frdemo.entity.Survey;

import java.util.List;
import java.util.Map;

public interface AnswerService {
    Answer addAnswer(Answer answer);

    List<Answer> addListAnswer(List<Answer> answers);

    List<Answer> getAllAnswer();

    List<Answer> getAllByIdClient(long id);

}
