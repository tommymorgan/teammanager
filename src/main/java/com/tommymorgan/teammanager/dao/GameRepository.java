package com.tommymorgan.teammanager.dao;

import com.tommymorgan.teammanager.domain.Game;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface GameRepository extends CrudRepository<Game, Long> {
	@Query(value = "" +
			"select g.id," +
			"       g.away_team_id," +
			"       g.home_team_id," +
			"       g.away_team_score," +
			"       g.home_team_score," +
			"       g.start_timestamp," +
			"       g.end_timestamp" +
			"  from game as g" +
			"  join team as t" +
			"    on t.id = g.away_team_id" +
			"    or t.id = g.home_team_id" +
			" where t.id = :teamId",
		nativeQuery = true)
	Iterable<Game> findByTeamId(@Param("teamId") long teamId);

	@Query(value = "" +
			"select g.id," +
			"       g.away_team_id," +
			"       g.home_team_id," +
			"       g.away_team_score," +
			"       g.home_team_score," +
			"       g.start_timestamp," +
			"       g.end_timestamp" +
			"  from game as g" +
			"  join team as t" +
			"    on t.id = g.away_team_id" +
			"    or t.id = g.home_team_id" +
			" where t.season_id = :seasonId",
			nativeQuery = true)
	Iterable<Game> findBySeasonId(@Param("seasonId") long seasonId);
}
