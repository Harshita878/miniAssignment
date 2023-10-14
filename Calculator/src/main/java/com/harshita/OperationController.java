package com.harshita;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.harshita.services.CalculatorService;




@Controller
public class OperationController {
	
	CalculatorService as = new CalculatorService();

	@RequestMapping(value="/process",params="action1",method=RequestMethod.POST)
	public ModelAndView add(@RequestParam("t1")int i,@RequestParam("t2")int j, HttpServletRequest request, HttpServletResponse response)
	{

		int k = as.add(i, j);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("display");
		mv.addObject("result",k);
		
		
		return mv;
	}

@RequestMapping(value="/process",params="action2",method=RequestMethod.POST)
public ModelAndView sub(@RequestParam("t1")int i,@RequestParam("t2")int j, HttpServletRequest request, HttpServletResponse response)
{

	int k=as.sub(i, j);
	
	ModelAndView mv = new ModelAndView();
	mv.setViewName("display");
	mv.addObject("result",k);
	
	
	return mv;
}

@RequestMapping(value="/process",params="action3",method=RequestMethod.POST)
public ModelAndView multiply(@RequestParam("t1")int i,@RequestParam("t2")int j, HttpServletRequest request, HttpServletResponse response)
{

	int k = as.multiply(i, j);
	
	ModelAndView mv = new ModelAndView();
	mv.setViewName("display");
	mv.addObject("result",k);
	
	
	return mv;
}

@RequestMapping(value="/process",params="action4",method=RequestMethod.POST)
public ModelAndView divide(@RequestParam("t1")int i,@RequestParam("t2")int j, HttpServletRequest request, HttpServletResponse response)
{
	int k=as.divide(i, j);
	
	ModelAndView mv = new ModelAndView();
	mv.setViewName("display");
	mv.addObject("result",k);
	
	
	return mv;
}
}