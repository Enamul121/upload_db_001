package com.app.service;


import com.app.UploadDb001Application;
import com.app.domain.User;
import com.app.repo.UserRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UploadDb001Application.class)
public class UserServiceImplTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserRepo repo;
   @Autowired
    UserService service;

    @Autowired
    EntityManager em;

    @Test
    @Transactional
    public void findByID() {
        Optional<User> user = repo.findById(13l);
        User uu = new User();
        assert true;
        logger.info("Is That TRUE ??? ->{}",user);

    }

    @Test
    public void sort() {
        Sort sort = new Sort(Sort.Direction.ASC,"name");
        logger.info("SSS -> {}", repo.findAll(sort));
    }


    @Test
    //@Transactional
    public void JPql() {
        TypedQuery<User> query = (TypedQuery<User>) em.createQuery("select u from User u where name like '%enam'");
        List<User> userList = query.getResultList();
        logger.info("JPQL :: ->{}", userList);
    }


    @Test
    public void nativeTestt() {
        logger.info("NAT ::-> {}",service.nativeTest());
    }
}