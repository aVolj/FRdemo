package com.volodichev.frdemo.service.impl;

import com.volodichev.frdemo.entity.Question;
import com.volodichev.frdemo.repository.QuestionRepo;
import com.volodichev.frdemo.service.QuestionService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    QuestionRepo questionRepo;

    @Override
    public Question addQuestion(Question question) {
        return questionRepo.save(question);
    }

    @Override
    public Question updateQuestion(Question question) {
        if (questionRepo.findById(question.getId()).isPresent()) {
            return questionRepo.save(question);
        } else throw new EntityNotFoundException("Не найдена запись с id = " + question.getId());
    }

    @Override
    public boolean deleteQuestion(long id) {
        if (questionRepo.existsById(id)) {
            questionRepo.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Question> getAllById(Set<Long> ids) {
        return questionRepo.findAllById(ids);
    }
}
