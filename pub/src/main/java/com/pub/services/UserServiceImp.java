package com.pub.services;

import com.pub.models.User;
import com.pub.models.UserDTOOut;
import com.pub.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<UserDTOOut> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDTOOut> userDTOOuts = new ArrayList<>();
        for (User user : users) {
            userDTOOuts.add(new UserDTOOut(user));
        }
        return userDTOOuts;
    }

    @Override
    public UserDTOOut getUser(Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return new UserDTOOut(user);
    }
}
