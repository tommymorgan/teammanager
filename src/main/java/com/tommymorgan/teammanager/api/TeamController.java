package com.tommymorgan.teammanager.api;

import com.tommymorgan.teammanager.dao.GameRepository;
import com.tommymorgan.teammanager.dao.PlayerRepository;
import com.tommymorgan.teammanager.dao.TeamRepository;
import com.tommymorgan.teammanager.domain.Game;
import com.tommymorgan.teammanager.domain.Player;
import com.tommymorgan.teammanager.domain.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tommy on 1/13/16.
 */
@RestController
public class TeamController {
	@Autowired
	PlayerRepository playerRepository;

	@Autowired
	GameRepository gameRepository;

	@Autowired
	TeamRepository teamRepository;

	@RequestMapping("/teams/{id}")
	public Team team(@PathVariable long id) {
		return teamRepository.findOne(id);
	}

	@RequestMapping("/teams/{id}/players")
	public Iterable<Player> players(@PathVariable long id) {
		return playerRepository.findByTeamId(id);
	}

	@RequestMapping("/teams/{id}/games")
	public Iterable<Game> games(@PathVariable long id) {
		return gameRepository.findByTeamId(id);
	}
}
