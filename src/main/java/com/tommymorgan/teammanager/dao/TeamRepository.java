package com.tommymorgan.teammanager.dao;

import com.tommymorgan.teammanager.domain.Team;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TeamRepository extends CrudRepository<Team, Long> {
	@Query(value = "" +
			"select id," +
			"       season_id," +
			"       captain_id," +
			"       name" +
			"  from team" +
			" where season_id = :seasonId",
		nativeQuery = true)
	Iterable<Team> findBySeasonId(@Param("seasonId") long seasonId);

	@Query(value = "" +
			"select t.id," +
			"       t.season_id," +
			"       t.captain_id," +
			"       t.name" +
			"  from team as t" +
			"  join roster as r" +
			"    on r.player_id = :playerId",
			nativeQuery = true)
	Iterable<Team> findByPlayerId(@Param("playerId") long playerId);
}
