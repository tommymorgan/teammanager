package com.tommymorgan.teammanager.api;

import com.tommymorgan.teammanager.dao.GameRepository;
import com.tommymorgan.teammanager.dao.SeasonRepository;
import com.tommymorgan.teammanager.dao.TeamRepository;
import com.tommymorgan.teammanager.domain.Game;
import com.tommymorgan.teammanager.domain.Season;
import com.tommymorgan.teammanager.domain.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by tommy on 1/13/16.
 */
@RestController
public class SeasonController {
	@Autowired
	SeasonRepository seasonRepository;

	@Autowired
	GameRepository gameRepository;

	@Autowired
	TeamRepository teamRepository;

	@RequestMapping("/seasons")
	public Iterable<Season> seasons() {
		return seasonRepository.findAll();
	}

	@RequestMapping(value = "/seasons/{id}", method = RequestMethod.GET)
	public Season season(@PathVariable long id) {
		return seasonRepository.findOne(id);
	}

	@RequestMapping(value = "/seasons/{id}", method = RequestMethod.PUT)
	public Season season(@PathVariable long id, @RequestBody Season season) {
		return seasonRepository.save(season);
	}

	@RequestMapping(value = "/seasons/{id}/games", method = RequestMethod.GET)
	public Iterable<Game> gamesBySeasonId(@PathVariable long id) {
		return gameRepository.findBySeasonId(id);
	}

	@RequestMapping(value = "/seasons/{id}/teams", method = RequestMethod.GET)
	public Iterable<Team> teamsBySeasonId(@PathVariable long id) {
		return teamRepository.findBySeasonId(id);
	}
}
