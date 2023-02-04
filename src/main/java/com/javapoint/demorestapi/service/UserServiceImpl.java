package com.javapoint.demorestapi.service;

import com.javapoint.demorestapi.model.User;
import com.javapoint.demorestapi.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService
{

    @Autowired
    private UserRepository userRepository;

    /**
     * @param user
     * @return
     */
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    /**
     * @param userId
     * @return
     */
    @Override
    public User getUserById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        return optionalUser.get();
    }

    /**
     * @return
     */
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * @param user
     * @return
     */
    @Override
    public User updateUser(User user) {
        User existingUser = userRepository.findById(user.getId()).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        User updatedUser = userRepository.save(existingUser);
        return updatedUser;
    }

    /**
     * @param userId
     */
    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
