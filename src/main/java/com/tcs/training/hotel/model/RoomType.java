package com.tcs.training.hotel.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum RoomType {

	SINGLE("SINGLE"), DOUBLE("DOUBLE"), DULUX("DULUX"),;

	private final String name;

	public String toString() {
		return this.name;
	}

}
