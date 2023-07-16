package com.devSuperior.dslist.dto;

import com.devSuperior.dslist.Projections.GameMinProjection;
import com.devSuperior.dslist.entities.Game;

public class GameMinDTO {

	private Long id;
	private String title;
	private Integer year;
	private String imgUrl;
	private String shortDescription;
	
	public GameMinDTO(){
		
	}

	public GameMinDTO(Game entity) {
		id = entity.getId();
		title = entity.getTitle();
		year = entity.getYear();
		imgUrl = entity.getImgUrl();
		shortDescription = entity.getShortDescription();
	}
	
	public GameMinDTO(GameMinProjection Projection) {
		id = Projection.getId();
		title = Projection.getTitle();
		year = Projection.getGameYear();
		imgUrl = Projection.getImgUrl();
		shortDescription = Projection.getShortDescription();
	}


	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public Integer getYear() {
		return year;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public String getShortDescription() {
		return shortDescription;
	}
	
}
