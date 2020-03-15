package com.company.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="SearchResultDTO")
public class SearchResultDTO {
	@Id
	private String id;
	public String status;
	public String message;
	public int page_no;
	public int page_count;
	public int total_count;
	public int total_page;
	public ArrayList<SearchItem> list;
	public String getId() {
		return id;
	}
	public String getCorpName() {
		if (list != null && list.size() > 0) {
			return list.get(0).corp_name;
		}
		else {
			return "No Data";
		}
	}
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
	public int getPage_no() {
		return page_no;
	}
	public void setPage_no(int page_no) {
		this.page_no = page_no;
	}
	public int getPage_count() {
		return page_count;
	}
	public void setPage_count(int page_count) {
		this.page_count = page_count;
	}
	public int getTotal_count() {
		return total_count;
	}
	public void setTotal_count(int total_count) {
		this.total_count = total_count;
	}
	public int getTotal_page() {
		return total_page;
	}
	public void setTotal_page(int total_page) {
		this.total_page = total_page;
	}
	public ArrayList<SearchItem> getList() {
		return list;
	}
	public void setList(ArrayList<SearchItem> list) {
		this.list = list;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return status + message;
	}
}
