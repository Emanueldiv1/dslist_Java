package com.devSuperior.dslist.repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devSuperior.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> {

}
