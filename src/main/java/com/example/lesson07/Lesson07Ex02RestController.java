package com.example.lesson07;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson07.dao.StudentRepository;
import com.example.lesson07.entity.StudentEntity;

@RestController
@RequestMapping("/lesson07/ex02")
public class Lesson07Ex02RestController {
	@Autowired
	private StudentRepository studentRepository;
	
	
	// 프로젝트 전까지만 BO 생략 BO  원래 꼭 만들어야함
	@GetMapping("/1")
	public List<StudentEntity> getStudentList(){
		// 1) 전체 조회
//		return studentRepository.findAll();
		
//		// 2) id 기준 내림차순 전체 조회
//		return studentRepository.findAllByOrderByIdDesc();
		
		// 3) id 기준 내림차순 이면서 2개만 조회 
//		return studentRepository.findTop2ByOrderByIdDesc();
		
		// 4) 이름이 우연이 인 데이터 조회
//		return studentRepository.findByName("우연이");
		
		// 5) in문 으로 일치하는 값 모두 조회
//		return studentRepository.findByNameIn(Arrays.asList("우연이","유재석"));
		
		// 6) 여러 컬럼값과 일치하는 데이터 조회
//		return studentRepository.findByNameAndDreamJob("유재석","래퍼");
		
		// 7) email 칼람에 naver 키워드가 포함된 데이터 조회 (like문) %naver%
//		return studentRepository.findByEmailContaining("naver");
		
		// 8) 이름이 우 로 시작하는 데이터 조회 (like) - 우 %
//		return studentRepository.findByNameStartingWith("우");
		
		// 9) where id >= 1 and id <= 5
		// id between 1 and 5
		// id 가 1 에서 5 데이터를 조회 ( between)
		return studentRepository.findByIdBetween(1,5);
		
	}
	
//	@GetMapping("/2")
//	public List<StudentEntity> getStudent(){
//		//장래희망이 미용사인 데이터 조회
//		return studentRepository.findByDreamJob("미용사");
//	}
}
