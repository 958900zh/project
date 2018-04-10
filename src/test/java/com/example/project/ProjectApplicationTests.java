package com.example.project;

import com.example.project.entity.User;
import com.example.project.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectApplicationTests {

    @Autowired
    private UserRepository repository;
    @Test
    public void contextLoads() {
        User one = repository.findOne(1L);
        System.out.println(one);
    }

}
