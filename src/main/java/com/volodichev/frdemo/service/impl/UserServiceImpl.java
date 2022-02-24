package com.volodichev.frdemo.service.impl;

import com.volodichev.frdemo.entity.Answer;
import com.volodichev.frdemo.entity.Role;
import com.volodichev.frdemo.entity.Survey;
import com.volodichev.frdemo.entity.User;
import com.volodichev.frdemo.repository.RoleRepo;
import com.volodichev.frdemo.repository.UserRepo;
import com.volodichev.frdemo.service.AnswerService;
import com.volodichev.frdemo.service.QuestionService;
import com.volodichev.frdemo.service.SurveyService;
import com.volodichev.frdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private final AnswerService answerService;
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepo userRepo, RoleRepo roleRepo, BCryptPasswordEncoder passwordEncoder, QuestionService questionService, SurveyService surveyService, AnswerService answerService) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.passwordEncoder = passwordEncoder;
        this.answerService = answerService;
    }

    @Override
    public User register(User user) {
        Role roleUser = roleRepo.findByName("ROLE_USER");
        List<Role> userRoles = new ArrayList<>();
        userRoles.add(roleUser);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(userRoles);

        return userRepo.save(user);
    }

    @Override
    public List<User> getAll() {
        return userRepo.findAll();
    }

    @Override
    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public User findById(Long id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public Set<Survey> getAllDetailedAnswer(long id) {
        List<Answer> answers = answerService.getAllByIdClient(id);
        Set<Survey> surveys = new HashSet<>();
        for (Answer answer : answers) {
            surveys.add(answer.getQuestion().getSurvey());
        }
        return surveys;
    }
}
