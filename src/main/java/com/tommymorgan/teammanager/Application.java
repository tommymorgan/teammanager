package com.tommymorgan.teammanager;

import com.tommymorgan.teammanager.dao.PlayerRepository;
import com.tommymorgan.teammanager.domain.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;

@SpringBootApplication
@EntityScan("com.tommymorgan.teammanager.domain")
public class Application implements CommandLineRunner {

    @Autowired
    PlayerRepository repository;
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Override
    public void run(String... strings) throws Exception {
        /*// save a couple of customers
        repository.save(new Player("Jack", "Bauer"));
        repository.save(new Player("Chloe", "O'Brian"));
        repository.save(new Player("Kim", "Bauer"));
        repository.save(new Player("David", "Palmer"));
        repository.save(new Player("Michelle", "Dessler"));*/

        // fetch all customers
        System.out.println("Players found with findAll():");
        System.out.println("-------------------------------");
        for (Player player : repository.findAll()) {
            System.out.println(player);
        }
        System.out.println();

        // fetch an individual player by ID
        Player player = repository.findOne(1L);
        System.out.println("Player found with findOne(1L):");
        System.out.println("--------------------------------");
        System.out.println(player);
        System.out.println();

        // fetch customers by last name
        System.out.println("Player found with findByLastName('Bauer'):");
        System.out.println("--------------------------------------------");
        for (Player bauer : repository.findByLastName("Bauer")) {
            System.out.println(bauer);
        }
    }

}
