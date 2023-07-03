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
			// 가능한값 :  [], [bookingA,bookingB.....]
			List<Booking> bookingList = bookingMapper.selectBookingByNamePhoneNumber(name, phoneNumber);
			if(bookingList.isEmpty()) {
				return null;
			}
		return bookingList.get(bookingList.size() - 1); // 마지막 값을 준다. (최신 예약)	
		}
}
