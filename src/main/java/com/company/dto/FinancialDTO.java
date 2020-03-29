package com.company.dto;

import java.util.ArrayList;

public class FinancialDTO {
	private String status;
	private String message;
	private ArrayList<FinaccialResultDTO> list;
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
	public ArrayList<FinaccialResultDTO> getList() {
		return list;
	}
	public void setList(ArrayList<FinaccialResultDTO> list) {
		this.list = list;
	}
	
	
}
