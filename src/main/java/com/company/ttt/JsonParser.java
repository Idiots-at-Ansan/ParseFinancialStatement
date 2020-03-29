package com.company.ttt;

import java.io.IOException;

import org.springframework.stereotype.Controller;

import com.company.dto.FinaccialResultDTO;
import com.company.dto.FinancialDTO;
import com.company.dto.SearchResultDTO;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@Controller
public class JsonParser {
	public SearchResultDTO MakeSearchResultDTOFromJSON(String json) throws JsonMappingException, JsonParseException, IOException  {
		ObjectMapper mapper = new ObjectMapper();
		SearchResultDTO result = mapper.readValue(json, SearchResultDTO.class);
		return result;
	}
	
	public FinancialDTO FinancialResultDTOFromJSON(String json) throws JsonMappingException, JsonParseException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		FinancialDTO result = mapper.readValue(json, FinancialDTO.class);
		return result;
	}
}
