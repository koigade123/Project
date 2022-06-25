package com.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rooms")

public class Room 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="room_no")
	private long roomNo;
	
	@Column(name="location")
	private String location;

	public Room(String location) {
		super();
		this.location = location;
	}

	public long getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(long roomNo) {
		this.roomNo = roomNo;
	}
	
	
	
}
