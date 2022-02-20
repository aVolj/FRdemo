package com.volodichev.frdemo.service;

import com.volodichev.frdemo.entity.Survey;

import java.util.List;

public interface SurveyService {
    List<Survey> getAllActiveSurvey();
    Survey addSurvey(Survey survey);
    boolean deleteSurvey(long id);
    Survey updateSurvey(Survey survey);
}
