package com.tcs.training.hotel.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum RoomStatus {

	AVAILABLE("AVAILABLE"), BOOKED("BOOKED");

	private final String name;

	public String toString() {
		return this.name;
	}

}