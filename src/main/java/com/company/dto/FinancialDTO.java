package com.company.dto;

import java.util.ArrayList;

public class FinancialDTO {
	private String status;
	private String message;
	private ArrayList<FinancialResultDTO> list;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ArrayList<FinancialResultDTO> getList() {
		return list;
	}
	public void setList(ArrayList<FinancialResultDTO> list) {
		this.list = list;
	}
	
	
}
