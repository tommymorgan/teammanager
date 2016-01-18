package com.tommymorgan.teammanager;

import com.tommymorgan.teammanager.dao.GameRepository;
import com.tommymorgan.teammanager.dao.PlayerRepository;
import com.tommymorgan.teammanager.domain.Game;
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
	PlayerRepository playerRepository;

	@Autowired
	GameRepository gameRepository;

	public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Override
    public void run(String... strings) throws Exception {
    }
}
