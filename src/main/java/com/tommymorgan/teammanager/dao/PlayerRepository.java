package com.tommymorgan.teammanager.dao;

import java.util.List;

import com.tommymorgan.teammanager.domain.Player;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<Player, Long> {

    List<Player> findByLastName(String lastName);
}
