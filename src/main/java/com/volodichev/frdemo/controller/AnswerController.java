package com.volodichev.frdemo.controller;

import com.volodichev.frdemo.entity.Answer;
import com.volodichev.frdemo.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/answers/")
public class AnswerController {

    @Autowired
    AnswerService answerService;

    @GetMapping
    public ResponseEntity<List<Answer>> getAllAnswer() {
        List<Answer> result = answerService.getAllAnswer();

        if (result.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    @PostMapping
    public Answer addAnswer(@RequestBody Answer answer) {
        return answerService.addAnswer(answer);
    }

    @PostMapping(value = "list")
    public ResponseEntity<List<Answer>> addListAnswer(@RequestBody List<Answer> answers) {
        List<Answer> result = answerService.addListAnswer(answers);
        if (result.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }
}
