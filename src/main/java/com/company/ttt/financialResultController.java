package com.company.ttt;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.company.dto.FinaccialResultDTO;
import com.company.dto.FinancialDTO;
import com.company.dto.SearchItem;
import com.company.dto.SearchResultDTO;

public class financialResultController{
//https://hellogk.tistory.com/116
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */

	
	public static ModelAndView FinancialResultView(@ModelAttribute("FinancialDTO")FinancialDTO finacialDTO, Model model){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("financialResultView");
		modelAndView.addObject("FinancialDTO",finacialDTO);
		ArrayList<FinaccialResultDTO> result = finacialDTO.getList();
		model.addAttribute("result", result);
		modelAndView.addObject("items", finacialDTO.getList());
		return modelAndView;
	}
}