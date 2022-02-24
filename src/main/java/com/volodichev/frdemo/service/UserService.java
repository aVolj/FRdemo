package com.volodichev.frdemo.service;

import com.volodichev.frdemo.entity.Answer;
import com.volodichev.frdemo.entity.Question;
import com.volodichev.frdemo.entity.Survey;
import com.volodichev.frdemo.entity.User;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface UserService {
    User register(User user);

    List<User> getAll();

    User findByUsername(String username);

    User findById(Long id);

    void delete(Long id);

    Set<Survey> getAllDetailedAnswer(long id);
}
