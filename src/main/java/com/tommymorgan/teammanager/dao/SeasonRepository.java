package com.tommymorgan.teammanager.dao;

import com.tommymorgan.teammanager.domain.Season;
import org.springframework.data.repository.CrudRepository;

public interface SeasonRepository extends CrudRepository<Season, Long> {
}
