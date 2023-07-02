package com.example.booking;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.booking.bo.BookingBO;
import com.example.booking.domain.Booking;

@Controller
public class BookingController {
	@Autowired
	private BookingBO bookingBO;
	
	
	
	// 예약 목록 화면
	@GetMapping("/booking_Site_View")
public String siteView(Model model) {
		
		List<Booking> bookingList = bookingBO.getBookingList();
		model.addAttribute("bookingList",bookingList);
		return "booking/bookingSiteView";
	}
	// ajax 삭제
	@ResponseBody
	@DeleteMapping("/delete_list")
	public Map<String,Object> deleteList(
			@RequestParam("id") int id){
		Map<String,Object> result = new HashMap<>();
		// delete
		int deleteRow = bookingBO.deleteBookingList(id);
		
		if(deleteRow > 0) {
			result.put("result", "성공");
			result.put("code", 1);
		}else{
			result.put("result", "실패");
			result.put("code", 500);
		}
		
		return result;
	}	
	
	// 예약 하기 화면
	@GetMapping("/makeBooking")
	public String makeBooking() {
		return "booking/makeBooking";
	}
	
	//ajax 인서트
	
	@PostMapping("/booking_success")
	@ResponseBody
	public Map<String,Object> bookingInsert(
			@RequestParam("name") String name,
			@RequestParam("date") String date,
			@RequestParam("day") int day,
			@RequestParam("headcount") int headcount,
			@RequestParam("phoneNumber") String phoneNumber){
		Map<String,Object> result = new HashMap<>();
		int insertRow = bookingBO.addBookingList(name, date, day, headcount, phoneNumber);
				if(insertRow > 0) {
					result.put("result", "성공");	
				}else {
					result.put("result", "실패");	
				}
		return result;
	}
	
	// 예약 확인 뷰
	@GetMapping("/search_booking_view")
	public String searchBookingView() {
		return"booking/searchBooking";
	}
	
	// ajax 예약 확인
	@ResponseBody
	@PostMapping("/reservation_check")
	public Map<String, Object> checking(
			@RequestParam("name") String name,
			@RequestParam("phoneNumber") String phoneNumber,
			Model model){
		Map<String,Object> result = new HashMap<>();
		Booking booking = bookingBO.getBookingByNamePhoneNumber(name, phoneNumber); 
		int row = bookingBO.isBookingByNamePhoneNumber(name, phoneNumber);
		model.addAttribute("booking",booking);
		if(row > 0) {
			result.put("result", "성공");
		}else {
			result.put("result", "실패");
		}
		
		return result;
	}
		
	}


