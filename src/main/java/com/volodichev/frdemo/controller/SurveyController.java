package com.volodichev.frdemo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.volodichev.frdemo.entity.*;
import com.volodichev.frdemo.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class SurveyController {

    @Autowired
    SurveyService surveyService;

    @PostMapping(value = "surveys")
    public Survey addSurvey(@RequestBody Survey survey){
        return surveyService.addSurvey(survey);
    }

    @PutMapping(value = "surveys")
    public Survey updateSurvey(@RequestBody Survey survey){
        return surveyService.updateSurvey(survey);
    }

    @DeleteMapping(value = "surveys/{id}")
    public boolean deleteSurvey(@PathVariable long id){
        return surveyService.deleteSurvey(id);
    }

    @GetMapping(value = "active-survey")
    public List<Survey> getAllActiveSurvey() {
        return surveyService.getAllActiveSurvey();
    }
}
