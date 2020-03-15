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
	public int getPageNo() {
		return page_no;
	}
	public int getPageCount() {
		return page_count;
	}
	public int getTotalCount() {
		return total_count;
	}
	public int getTotalPage() {
		return total_page;
	}
	public ArrayList<SearchItem> getList(){
		return list;
	}
	public String getMessage() {
		return message;
	}
	@Override
	public String toString() {
		return status + message;
	}
}
