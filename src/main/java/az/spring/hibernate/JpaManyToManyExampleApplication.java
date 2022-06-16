package az.spring.hibernate;

import az.spring.hibernate.model.Post;
import az.spring.hibernate.model.Tag;
import az.spring.hibernate.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class JpaManyToManyExampleApplication implements CommandLineRunner {

    @Autowired
    PostRepository postRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpaManyToManyExampleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Post post1 = new Post("Jpa Many to Many", "Jpa many to many is easy to understand");
        Post post2 = new Post("Jpa Many to Many 2", "Jpa many to many is easy to understand");


        Tag springboot=new Tag("spring boot");
        Tag hibernate=new Tag("hibernate");

        post1.getTags().add(springboot);
        post1.getTags().add(hibernate);

        springboot.getPosts().add(post1);
        hibernate.getPosts().add(post1);

        springboot.getPosts().add(post2);
        post2.getTags().add(springboot);


        postRepository.save(post1);
        postRepository.save(post2);


    }
}
