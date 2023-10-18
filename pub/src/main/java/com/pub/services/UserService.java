package com.pub.services;

import com.pub.models.User;
import com.pub.models.UserDTOOut;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public List<UserDTOOut> getAllUsers();
    public UserDTOOut getUser(Integer id);

}
