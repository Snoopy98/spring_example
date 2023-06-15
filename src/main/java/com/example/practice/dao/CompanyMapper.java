package com.example.practice.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.practice.domain.Company;

@Repository
public interface CompanyMapper {
	
	public List<Company> selectCompanyList();
	
}
