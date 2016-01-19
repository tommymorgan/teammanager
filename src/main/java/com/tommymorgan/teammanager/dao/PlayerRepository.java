package com.tommymorgan.teammanager.dao;

import com.tommymorgan.teammanager.domain.Player;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PlayerRepository extends CrudRepository<Player, Long> {
	Iterable<Player> findByLastName(String lastName);
	Iterable<Player> findByEmail(String email);

	@Query(value = "" +
			"select p.id," +
			"       p.first_name," +
			"       p.last_name," +
			"       p.email" +
			"  from player as p" +
			"  join roster as r" +
			"    on r.player_id = p.id" +
			" where r.team_id = :teamId",
		nativeQuery = true)
	Iterable<Player> findByTeamId(@Param("teamId") long id);
}
