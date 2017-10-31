package com.kirmanak;

public class FacesSession {
	private final String id;

	public FacesSession (final String id) {
		this.id = id;
	}

	public String getId () {
		return this.id;
	}
}