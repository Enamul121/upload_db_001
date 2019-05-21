package com.app.service;

import com.app.domain.User;
import com.app.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;
// /home/enamul/IdeaProjects/new/upload_db_001/src/main/resources
    // /upload
  String upload_dir = "/img";


  public void imgStore(MultipartFile file, String modifiedFileName){
    //  String fileName = file.getOriginalFilename();
   //   String modifiedName = fileName.substring(0,fileName.lastIndexOf("."))+"_" + System.nanoTime() +"_"+
           //                 fileName.substring(fileName.lastIndexOf("."));
      try (InputStream in = file.getInputStream()){
           Files.copy(in, Paths.get(this.upload_dir + "/" + modifiedFileName), StandardCopyOption.REPLACE_EXISTING);
      }catch (Exception e){e.printStackTrace();}

  }

    @Override
    public void saveUser(User user,MultipartFile file) {

      String fileName = file.getOriginalFilename();
        String modifiedName = fileName.substring(0,fileName.lastIndexOf("."))+"_" + System.nanoTime() +"_"+
                fileName.substring(fileName.lastIndexOf("."));

      imgStore(file, modifiedName);
      user.setImg(modifiedName);
      user.setImg_dir(upload_dir+"/"+modifiedName);
      userRepo.save(user);

    }

    @Override
    public List<User> findAllUser() {
        return userRepo.findAll();
    }

    @Override
    public User findUserById(int id) {
        return null;
    }

    @Override
    public void deleteUser(int id) {

    }
}
