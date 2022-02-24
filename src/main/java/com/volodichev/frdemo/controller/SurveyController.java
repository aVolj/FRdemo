package com.volodichev.frdemo.controller;

import com.volodichev.frdemo.entity.*;
import com.volodichev.frdemo.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/admin/surveys/")
public class SurveyController {

    @Autowired
    SurveyService surveyService;

    @PostMapping
    public Survey addSurvey(@RequestBody Survey survey){
        return surveyService.addSurvey(survey);
    }

    @PutMapping
    public Survey updateSurvey(@RequestBody Survey survey){
        return surveyService.updateSurvey(survey);
    }

    @DeleteMapping(value = "{id}")
    public boolean deleteSurvey(@PathVariable long id){
        return surveyService.deleteSurvey(id);
    }

    @GetMapping(value = "active")
    public List<Survey> getAllActiveSurvey() {
        return surveyService.getAllActiveSurvey();
    }
}
