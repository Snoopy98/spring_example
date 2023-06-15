package com.example.practice.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.practice.dao.CompanyMapper;
import com.example.practice.domain.Company;

@Service
public class CompanyBO {
	@Autowired
	private CompanyMapper companyMapper;
	
	
	public List<Company> CompanyBO(){
		return companyMapper.selectCompanyList();
	}
}
