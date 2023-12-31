package com.tcs.training.hotel.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum RoomStatus {

	AVAILABLE("AVAILABLE"), BOOKED("BOOKED"), RESERVED("RESERVED");

	private final String name;

	@Override
	public String toString() {
		return this.name;
	}

}
