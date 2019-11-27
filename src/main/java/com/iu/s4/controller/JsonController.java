package com.iu.s4.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s4.model.BoardVO;
import com.iu.s4.service.BoardNoticeService;
import com.iu.s4.util.Pager;


@RestController
public class JsonController {
	
	@Inject
	private BoardNoticeService boardNoticeService;
	
	@GetMapping("/getJson1")
	public ModelAndView getJson1() throws Exception{
		//name=iu, age=27
		String jmsg = "{\"name\":\"iu\", \"age\":27}";
		
		System.out.println(jmsg);
		ModelAndView mv = new ModelAndView();
		mv.addObject("result", jmsg);
		mv.setViewName("common/common_ajaxResult");
		
		return mv;
		
	}
	
	@GetMapping("/getJson2")
	public BoardVO getJson2(BoardVO boardVO) throws Exception{
		
		boardVO = boardNoticeService.boardSelect(boardVO);
		
		
		
		return boardVO;
		
	}
	@GetMapping("/getJson3")
	public List<BoardVO> getJson3(Pager pager) throws Exception{
		
		List<BoardVO> ar = boardNoticeService.boardList(pager);
		
		
		return ar;
		
	}
}
