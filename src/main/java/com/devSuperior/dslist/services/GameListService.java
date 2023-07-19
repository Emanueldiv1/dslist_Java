package com.devSuperior.dslist.services;

import java.util.List;

import javax.xml.transform.Source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devSuperior.dslist.Projections.GameMinProjection;
import com.devSuperior.dslist.dto.GameListDTO;
import com.devSuperior.dslist.entities.GameList;
import com.devSuperior.dslist.repositores.GameListRepository;
import com.devSuperior.dslist.repositores.GameRepository;



@Service
public class GameListService {

	@Autowired
	private GameListRepository gameListRepository;
	
	@Autowired
	private GameRepository gameRepository;
	
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll(){
		List <GameList> result = gameListRepository.findAll();
		return result.stream().map(x -> new GameListDTO(x)).toList(); 
	}	
	
	@Transactional
	public void move(Long listId, int sourceIndex, int destinationIndex) {
		
		List<GameMinProjection> list = gameRepository.searchByList(listId);
		
		GameMinProjection obj = list.remove(sourceIndex);
		
		list.add(destinationIndex, obj);  
		
		int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex; 
		int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex; 
		 
		for(int i = min; i <= max; i++) {
			gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
			
		}
	}
	
}
