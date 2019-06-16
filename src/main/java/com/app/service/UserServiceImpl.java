package com.app.service;

import com.app.domain.User;
import com.app.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;
// /home/enamul/IdeaProjects/new/upload_db_001/src/main/resources/upload
    //    /home/enamul/IdeaProjects/new/upload_db_001/image
  String upload_dir = "/home/enamul/IdeaProjects/new/upload_db_001/src/main/resources/static/img";


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
      user.setImg_dir("/img/"+modifiedName);
      userRepo.save(user);

    }

    @Override
    public List<User> findAllUser() {
        return userRepo.findAll();
    }

    @Override
    public User findUserById(Long id) {
        return userRepo.findById(id).get();
    }

    @Override
    public void deleteUser(Long id) {
      // First delete image from Directory
        User user = findUserById(id);
        File file = new File("/home/enamul/IdeaProjects/new/upload_db_001/src/main/resources/static" + user.getImg_dir());
        file.delete();
      userRepo.deleteById(id);
    }



    // JPQL TEST
   @Override
    public List<User> nativeTest() {
        return userRepo.likeQueryNative();
    }
}
