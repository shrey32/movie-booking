package com.shrey.moviebooking.commons.dto;

import com.shrey.moviebooking.commons.model.Screen;
import com.shrey.moviebooking.commons.model.Show;

/**
 * 
 * @author Shrey
 *
 */
public class ScreenDTO {

	private Screen screen;
	private Show show;

	public Screen getScreen() {
		return screen;
	}

	public void setScreen(Screen screen) {
		this.screen = screen;
	}

	public Show getShow() {
		return show;
	}

	public void setShow(Show show) {
		this.show = show;
	}

}
