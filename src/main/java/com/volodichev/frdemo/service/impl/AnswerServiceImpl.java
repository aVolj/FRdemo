package com.volodichev.frdemo.service.impl;

import com.volodichev.frdemo.entity.Answer;
import com.volodichev.frdemo.repository.AnswerRepo;
import com.volodichev.frdemo.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    AnswerRepo answerRepo;

    @Override
    public Answer addAnswer(Answer answer){
        return answerRepo.save(answer);
    }

    @Override
    public List<Answer> addListAnswer(List<Answer> answers) {
        return answerRepo.saveAll(answers);
    }

    @Override
    public List<Answer> getAllAnswer() {
        return answerRepo.findAll();
    }

    @Override
    public List<Answer> getAllByIdClient(long id) {
        return answerRepo.findAnswerByClient_Id(id);
    }
}
