package com.example.practice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.practice.bo.CompanyBO;
import com.example.practice.domain.Company;

@RestController
public class CompanyRestController {
	@Autowired
	private CompanyBO companyBO;
	@RequestMapping("/practice/company")
	public List<Company> company(){
		return companyBO.CompanyBO();
	}
}
