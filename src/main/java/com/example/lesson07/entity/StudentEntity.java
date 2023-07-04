package com.example.lesson07.entity;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity // 이 클래스는 Entity 다
@Table(name = "new_student")  // 테이블 명에 _ 가 붙어있을떄 꼭 추가한다.
@Getter // getter
@Builder(toBuilder = true) // setter 대용
@NoArgsConstructor // 파라미터 없는 기본 생성자
@AllArgsConstructor // 모든 필드를 인자값으로 받는 생성자
@ToString // toString override  값 예쁘게출력
public class StudentEntity {
	
	@Id // 이 필드가 pk다
	@GeneratedValue(strategy =GenerationType.IDENTITY) // auto increment
	private int id;
	private String name;
	
	@Column(name="phoneNumber") // 카멜 케이스 필드면 무조건 
	private String phoneNumber;
	private String email;
	
	@Column(name="dreamJob")
	private String dreamJob;
	
	@UpdateTimestamp  // createdAt이null이면 현재 시간으로 자동으로 입력
	@Column(name="createdAt" , updatable = false) // updatable false 는 업데이트시 시간 갱신 안함
	private ZonedDateTime createdAt;
	
	@UpdateTimestamp
	@Column(name="updatedAt")
	private ZonedDateTime updatedAt;
	
}
