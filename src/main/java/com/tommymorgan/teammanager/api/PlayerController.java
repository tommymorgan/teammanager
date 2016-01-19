package com.tommymorgan.teammanager.api;

import com.tommymorgan.teammanager.dao.PlayerRepository;
import com.tommymorgan.teammanager.dao.TeamRepository;
import com.tommymorgan.teammanager.domain.Player;
import com.tommymorgan.teammanager.domain.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by tommy on 4/21/15.
 */
@RestController
public class PlayerController {
	@Autowired
	PlayerRepository playerRepository;

	@Autowired
	TeamRepository teamRepository;

	@RequestMapping(value = "/players/{id}", method = RequestMethod.GET)
	public Player player(@PathVariable long id) {
		return playerRepository.findOne(id);
	}

	@RequestMapping(value = "/players/{id}", method = RequestMethod.PUT)
	public Player player(@PathVariable long id, @RequestBody Player player) {
		return playerRepository.save(player);
	}

	@RequestMapping(value = "/players/{id}/teams", method = RequestMethod.GET)
	public Iterable<Team> teams(@PathVariable long id) {
		return teamRepository.findByPlayerId(id);
	}

	@RequestMapping(value = "/players/findByLastName/{lastName}", method = RequestMethod.GET)
	public Iterable<Player> playersByLastName(@PathVariable String lastName) {
		return playerRepository.findByLastName(lastName);
	}

	@RequestMapping(value = "/players/findByEmail/{email}", method = RequestMethod.GET)
	public Iterable<Player> playersByEmail(@PathVariable String email) {
		return playerRepository.findByEmail(email);
	}
}
