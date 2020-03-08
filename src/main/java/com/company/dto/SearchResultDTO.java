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
	public ArrayList<SearchItemDTO> list;
}
