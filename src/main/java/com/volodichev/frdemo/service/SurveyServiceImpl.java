package com.volodichev.frdemo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.volodichev.frdemo.entity.Question;
import com.volodichev.frdemo.entity.Survey;
import com.volodichev.frdemo.repo.SurveyRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SurveyServiceImpl implements SurveyService {
    @Autowired
    SurveyRepo surveyRepo;

    @Override
    public List<Survey> getAllActiveSurvey() {
        return surveyRepo.findAllByEndIsNull();
    }

    @Override
    public Survey addSurvey(Survey survey) {
        survey.getQuestions().forEach(question -> question.setSurvey(survey));
        return surveyRepo.save(survey);
    }

    @Override
    public boolean deleteSurvey(long id) {
        if (surveyRepo.existsById(id)) {
            surveyRepo.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Survey updateSurvey(Survey newSurvey) {
        Optional<Survey> oldSurvey = surveyRepo.findById(newSurvey.getId());
        if (oldSurvey.isPresent()) {
            newSurvey.setStart(oldSurvey.get().getStart());
            return surveyRepo.save(newSurvey);
        } else throw new EntityNotFoundException();
    }
}
