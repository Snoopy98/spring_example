package com.example.booking.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.booking.domain.Booking;

@Repository
public interface BookingMapper {
	
	public List<Booking> selectBookingList();
	
	public int deleteBookingList(int id);
	
	public int insertBookingList( // @Param = Map 으로 만들어주는 역할
			@Param("name") String name,
			@Param("date") String date, 
			@Param("day") int day, 
			@Param("headcount") int headcount, 
			@Param("phoneNumber") String phoneNumber);
	
	public List<Booking> selectBookingByNamePhoneNumber(
			@Param("name") String name, 
			@Param("phoneNumber") String phoneNumber);
	
}
