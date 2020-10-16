package com.anton.service;

import com.anton.model.User;
import com.anton.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.stream.StreamSupport;

@Service
public class UserService {

    private final UserRepo userRepo;


    @Autowired
    public UserService(UserRepo userRepo){
        this.userRepo = userRepo;
    }

   // public User getUserByLogin(String login) {
  //      return userRepository.getUserByLogin(login).orElseThrow(RuntimeException::new);
   // }

   // public List<User> getAll() {
     //   return userRepository.getAll();
   // }

   // public boolean isUserLoginExist(String login) {
   //     return userRepository.getUserByLogin(login).isPresent();
  //  }

   // public void save(String userName, String password) {
   //     userRepository.save( new User(userName, password));
   // }

    public User getUserByName(String name){
        return StreamSupport.stream(userRepo.findAll().spliterator(), false).filter(user -> user.getName().equals(name)).findFirst().get();
    }
    public long getIdByName(String name){
        return StreamSupport.stream(userRepo.findAll().spliterator(), false).filter(user -> user.getName().equals(name)).findFirst().get().getId();
    }
}
