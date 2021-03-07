package com.shrey.moviebooking.metadataservice.models;

/**
 * 
 * @author Shrey
 *
 */
public class Rating {

	private Long likes;
	private Long dislikes;

	public Long getLikes() {
		return likes;
	}

	public void setLikes(Long likes) {
		this.likes = likes;
	}

	public Long getDislikes() {
		return dislikes;
	}

	public void setDislikes(Long dislikes) {
		this.dislikes = dislikes;
	}

}
