package com.iu.s4.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s4.model.BoardVO;
import com.iu.s4.service.BoardNoticeService;
import com.iu.s4.util.Pager;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {

	@Inject
	private BoardNoticeService boardNoticeService;
	
	@RequestMapping("noticeList")
	public ModelAndView boardList(Pager pager) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		List<BoardVO> ar =boardNoticeService.boardList(pager);
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.addObject("board", "notice");
		mv.setViewName("board/boardList");
		
		return mv;
	}
	@RequestMapping("noticeWrite")
	public ModelAndView boardWrite() throws Exception{
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("board", "notice");
		mv.setViewName("board/boardWrite");
		return mv;
	}
	
	@RequestMapping(value = "noticeWrite", method = RequestMethod.POST)
	public ModelAndView boardWrite(BoardVO boardVO) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		
		int result = boardNoticeService.boardWrite(boardVO);
		
		if(result > 0) {
			mv.setViewName("redirect:noticeList");
		}else {
			mv.addObject("msg", "글쓰기 실패");
			mv.addObject("paht", "noticeList");
			mv.setViewName("common/common_result");
		}
		

		mv.addObject("board", "notice");
		
		return mv;
	}
}
