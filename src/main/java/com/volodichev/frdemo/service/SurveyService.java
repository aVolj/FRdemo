package com.volodichev.frdemo.service;

import com.volodichev.frdemo.entity.Survey;

import java.util.List;
import java.util.Set;

public interface SurveyService {
    List<Survey> getAllActiveSurvey();

    Survey addSurvey(Survey survey);

    boolean deleteSurvey(long id);

    Survey updateSurvey(Survey survey);

    List<Survey> getAllById(Set<Long> ids);
}
