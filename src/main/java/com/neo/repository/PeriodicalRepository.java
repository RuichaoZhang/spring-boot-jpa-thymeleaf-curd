package com.neo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neo.entity.Periodical;

public interface PeriodicalRepository extends JpaRepository<Periodical, Long> {

}