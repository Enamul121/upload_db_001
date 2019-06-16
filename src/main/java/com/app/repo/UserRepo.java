package com.app.repo;

import com.app.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {

   /* List<User> findByNameAndID(String ame, Long id);
    List<User> findByName(String name);
    List<User> countByName(String name);
    List<User> deleteByName(String name);
    @Query("select u from User u where name like '%enam'")
    List<User> likeQueryJPQL();

   */

    @Query(value = "select * from user  u where name like '%enam'",nativeQuery = true)
    List<User> likeQueryNative();



}
