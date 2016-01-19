package com.tommymorgan.teammanager.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

	private long seasonId;

	private long captainId;

	private String name;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getSeasonId() {
		return seasonId;
	}

	public void setSeasonId(long seasonId) {
		this.seasonId = seasonId;
	}

	public long getCaptainId() {
		return captainId;
	}

	public void setCaptainId(long captainId) {
		this.captainId = captainId;
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Team team = (Team) o;

		if (id != team.id) return false;
		if (seasonId != team.seasonId) return false;
		if (captainId != team.captainId) return false;
		return name.equals(team.name);

	}

	@Override
	public int hashCode() {
		int result = (int) (id ^ (id >>> 32));
		result = 31 * result + (int) (seasonId ^ (seasonId >>> 32));
		result = 31 * result + (int) (captainId ^ (captainId >>> 32));
		result = 31 * result + name.hashCode();
		return result;
	}

	public void setName(String name) {
		this.name = name;
	}
}
