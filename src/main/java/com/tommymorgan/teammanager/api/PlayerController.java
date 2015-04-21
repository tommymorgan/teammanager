package com.tommymorgan.teammanager.api;

import com.tommymorgan.teammanager.dao.PlayerRepository;
import com.tommymorgan.teammanager.domain.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tommy on 4/21/15.
 */
@RestController
public class PlayerController {
	@Autowired
	PlayerRepository playerRepository;

	@RequestMapping("/players/{id}")
	public Player player(@PathVariable long id) {
		Player p = playerRepository.findOne(id);
		return p;
	}
}
