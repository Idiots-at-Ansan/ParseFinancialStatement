package com.company.ttt.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.company.ttt.dao.HomeDAO;
@Service
public class HomeServiceImpl implements HomeService {

	@Inject
	private HomeDAO homeDAO;
	
	@Override
	public void test() throws Exception {
		// TODO Auto-generated method stub
		homeDAO.test();
	}

}
