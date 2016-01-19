package com.tommymorgan.teammanager.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

	private long awayTeamId;

	private long homeTeamId;

	private Integer awayTeamScore;

	private Integer homeTeamScore;

	private Timestamp startTimestamp;

	private Timestamp endTimestamp;

	public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

	public long getAwayTeamId() {
		return awayTeamId;
	}

	public void setAwayTeamId(long awayTeamId) {
		this.awayTeamId = awayTeamId;
	}

	public long getHomeTeamId() {
		return homeTeamId;
	}

	public void setHomeTeamId(long homeTeamId) {
		this.homeTeamId = homeTeamId;
	}

	public Integer getAwayTeamScore() {
		return awayTeamScore;
	}

	public void setAwayTeamScore(Integer awayTeamScore) {
		this.awayTeamScore = awayTeamScore;
	}

	public Integer getHomeTeamScore() {
		return homeTeamScore;
	}

	public void setHomeTeamScore(Integer homeTeamScore) {
		this.homeTeamScore = homeTeamScore;
	}

	public Timestamp getStartTimestamp() {
		return startTimestamp;
	}

	public void setStartTimestamp(Timestamp startTimestamp) {
		this.startTimestamp = startTimestamp;
	}

	public Timestamp getEndTimestamp() {
		return endTimestamp;
	}

	public void setEndTimestamp(Timestamp endTimestamp) {
		this.endTimestamp = endTimestamp;
	}

	protected Game() {}

    @Override
    public String toString() {
        return String.format(
                "Game[id=%d, awayTeamId='%d', homeTeamId='%d', awayTeamScore='%d', homeTeamScore='%d', startTimestamp='%s', endTimestamp='%s']",
                id, awayTeamId, homeTeamId, awayTeamScore, homeTeamScore, startTimestamp, endTimestamp);
    }

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Game game = (Game) o;

		if (id != game.id) return false;
		if (awayTeamId != game.awayTeamId) return false;
		if (homeTeamId != game.homeTeamId) return false;
		if (awayTeamScore != null ? !awayTeamScore.equals(game.awayTeamScore) : game.awayTeamScore != null)
			return false;
		if (homeTeamScore != null ? !homeTeamScore.equals(game.homeTeamScore) : game.homeTeamScore != null)
			return false;
		if (startTimestamp != null ? !startTimestamp.equals(game.startTimestamp) : game.startTimestamp != null) return false;
		return endTimestamp != null ? endTimestamp.equals(game.endTimestamp) : game.endTimestamp == null;

	}

	@Override
	public int hashCode() {
		int result = (int) (id ^ (id >>> 32));
		result = 31 * result + (int) (awayTeamId ^ (awayTeamId >>> 32));
		result = 31 * result + (int) (homeTeamId ^ (homeTeamId >>> 32));
		result = 31 * result + (awayTeamScore != null ? awayTeamScore.hashCode() : 0);
		result = 31 * result + (homeTeamScore != null ? homeTeamScore.hashCode() : 0);
		result = 31 * result + (startTimestamp != null ? startTimestamp.hashCode() : 0);
		result = 31 * result + (endTimestamp != null ? endTimestamp.hashCode() : 0);
		return result;
	}
}

