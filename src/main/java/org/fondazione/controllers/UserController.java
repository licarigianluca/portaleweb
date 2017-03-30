package org.fondazione.controllers;

import org.fondazione.domain.User;
import org.fondazione.services.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {


    private UserRepository userRepository;
    private EntityManagerFactory emf;

    @Autowired
    public UserController(UserRepository userRepository, EntityManagerFactory emf) {
        this.userRepository = userRepository;
        this.emf = emf;
    }

    @RequestMapping("/show/{username}")
    public Integer showUsers(@PathVariable String username) {

//        List<User> users = userRepository.findByUsername(username);

        List<User> users = userRepository.findByUsernameAndVersion(username,1);

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(new User("pippo"));
        em.getTransaction().commit();


        return userRepository.countByUsername(username);




    }
}
