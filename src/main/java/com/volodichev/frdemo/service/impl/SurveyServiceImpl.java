package com.volodichev.frdemo.service.impl;

import com.volodichev.frdemo.entity.Survey;
import com.volodichev.frdemo.repository.SurveyRepo;
import com.volodichev.frdemo.service.SurveyService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

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
        } else throw new EntityNotFoundException("Не найдена запись с id = " + newSurvey.getId());
    }

    @Override
    public List<Survey> getAllById(Set<Long> ids) {
        return surveyRepo.findAllById(ids);
    }


}
