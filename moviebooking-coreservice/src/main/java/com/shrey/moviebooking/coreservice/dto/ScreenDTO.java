package com.shrey.moviebooking.coreservice.dto;

import com.shrey.moviebooking.coreservice.models.Screen;
import com.shrey.moviebooking.coreservice.models.Show;

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
