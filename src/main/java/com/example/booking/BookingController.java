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
			result.put("errorMessage", "삭제될 데이터가 없습니다.");
			result.put("code", 500);
		}
		
		return result;
	}	
	
	// 예약 하기 화면
	@GetMapping("/makeBooking")
	public String makeBooking() {
		return "booking/makeBooking";
	}
	
	// ajax 인서트
	
	@PostMapping("/booking_success")
	@ResponseBody
	public Map<String,Object> bookingInsert(
			@RequestParam("name") String name,
			@RequestParam("date") String date, //@DateTimeFormat 을 붙이고 Date 객체로 받아와도 된다.
			@RequestParam("day") int day,
			@RequestParam("headcount") int headcount,
			@RequestParam("phoneNumber") String phoneNumber){
		Map<String,Object> result = new HashMap<>();
		int insertRow = bookingBO.addBookingList(name, date, day, headcount, phoneNumber);
				if(insertRow > 0) {
					result.put("result", "성공");	
					result.put("code", 1);
				}else {
					result.put("code", "500");	
					result.put("errorMessage", "예약 데이터가 추가되지 못했습니다.");	
				}
		return result;
	}
	
	// 예약 확인 뷰
	@GetMapping("/search_booking_view")
	public String searchBookingView() {
		return"booking/searchBooking";
	}
	
	// ajax 예약 확인
	@ResponseBody     // model 사용 x 바디가 없이 리턴타입이 jsp일경우만 model 사용 가능 
	@PostMapping("/reservation_check")
	public Map<String, Object> checking(
			@RequestParam("name") String name,
			@RequestParam("phoneNumber") String phoneNumber
			){
		// db select 
		Booking booking = bookingBO.getBookingByNamePhoneNumber(name, phoneNumber);
		// 응답 JSON
		Map<String,Object> result = new HashMap<>();
		 if(booking == null) {
			 result.put("code", 300);
			 result.put("errorMessage", "예약 내역이 없습니다.");
		 }else {
			 result.put("code", 1);
			 result.put("booking", booking);
		 }
		
		return result;
	}
		
	}


