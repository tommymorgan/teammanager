package com.tommymorgan.teammanager.api;

import com.tommymorgan.teammanager.dao.GameRepository;
import com.tommymorgan.teammanager.domain.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by tommy on 1/13/16.
 */
@RestController
public class GameController {
	@Autowired
	GameRepository gameRepository;

	@RequestMapping(value = "/games/{id}", method = RequestMethod.GET)
	public Game game(@PathVariable long id) {
		return gameRepository.findOne(id);
	}

	@RequestMapping(value = "/games/{id}", method = RequestMethod.PUT)
	public Game game(@PathVariable long id, @RequestBody Game game) {
		return gameRepository.save(game);
	}
}
