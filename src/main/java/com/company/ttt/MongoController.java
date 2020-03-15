package com.company.ttt;

import java.io.IOException;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.company.dto.SearchResultDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import javax.servlet.http.*;


public class MongoController {
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public String Insert_SearchResultDTO(SearchResultDTO obj) throws IOException, IllegalAccessException, NoSuchFieldException {
		System.out.println(obj);
		
		MongoOperations mongoOps = (MongoOperations)mongoTemplate;
		if (mongoOps == null)
			System.out.print("mongoOps is null");
		
		mongoOps.save(obj);
		//mongoTemplate.insert(obj, "SearchResultDTO");
		//obj = mongoOps.findById(obj.getId(), SearchResultDTO.class);
//		
		//mongoOps.insert(obj,"0");
		//Query query = new Query(Criteria.where("corp_name").is(obj.corp_name));
		//mongoOps.updateFirst(query, Update.update("age",  26), user.class);
		//obj = mongoOps.findOne(query, SearchResultDTO.class);
		
		return "test";
	}
}
