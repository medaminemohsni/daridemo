package com.example.demo.service;

import com.example.demo.entities.User;
import com.example.demo.request.UserRequest;

public interface UserService {

	User save(UserRequest userRequest);

}
