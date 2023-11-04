package com.tcs.training.hotel.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum RoomType {

	SINGLE("1 Single Bed"), SINGLEX("2 Single Beds"), DOUBLE("1 Double Bed"), DOUBLEX("2 Double Beds"),
	DULUX("2 Queen Beds");

	private final String name;

	public String toString() {
		return this.name;
	}

}
