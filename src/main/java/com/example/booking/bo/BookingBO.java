package com.example.booking.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.booking.dao.BookingMapper;
import com.example.booking.domain.Booking;

@Service

public class BookingBO {
	@Autowired
	 private BookingMapper bookingMapper;
		public List<Booking> getBookingList(){
			return bookingMapper.selectBookingList();
		}
		
		public int deleteBookingList(int id) {
			return bookingMapper.deleteBookingList(id);
		}
		
		public int addBookingList(String name, String date, int day, int headcount, String phoneNumber) {
			return bookingMapper.insertBookingList(name, date, day, headcount, phoneNumber);
		}
		
		public Booking getBookingByNamePhoneNumber(String name, String phoneNumber) {
			return bookingMapper.selectBookingByNamePhoneNumber(name, phoneNumber);
		}
		public int isBookingByNamePhoneNumber(String name, String phoneNumber) {
			return bookingMapper.isBookingByNamePhoneNumber(name, phoneNumber);
		}
}
