package com.devSuperior.dslist.repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devSuperior.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long> {

}
