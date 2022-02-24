package com.volodichev.frdemo.controller;

import com.volodichev.frdemo.entity.Question;
import com.volodichev.frdemo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/admin/questions/")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @PostMapping
    public Question addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }

    @PutMapping
    public Question updateQuestion(@RequestBody Question question){
        return questionService.updateQuestion(question);
    }

    @DeleteMapping(value = "{id}")
    public boolean deleteQuestion(@PathVariable long id){
        return questionService.deleteQuestion(id);
    }

}
