package com.company.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class SearchResultDTO {
	public String status;
	public String message;
	public int page_no;
	public int page_count;
	public int total_count;
	public int total_page;
	public ArrayList<SearchItemDTO> list;
}
