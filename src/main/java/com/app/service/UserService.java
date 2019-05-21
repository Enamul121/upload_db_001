package com.app.service;

import com.app.domain.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserService {

  void saveUser(User user, MultipartFile file);

  List<User> findAllUser();

  User findUserById(int id);

  void deleteUser(int id);

}
