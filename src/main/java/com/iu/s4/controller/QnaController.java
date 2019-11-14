package com.iu.s4.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s4.model.BoardVO;
import com.iu.s4.service.BoardQnaService;
import com.iu.s4.util.Pager;

@Controller
@RequestMapping("/qna/**")
public class QnaController {

	@Inject
	private BoardQnaService boardQnaService;
	
	@RequestMapping("qnaList")
	public ModelAndView boardList(Pager pager) throws Exception{
		List<BoardVO> ar = boardQnaService.boardList(pager);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.addObject("board", "qna");
		mv.setViewName("board/boardList");
		
		return mv;
	}
	@RequestMapping("qnaWrite")
	public ModelAndView boardWrite() throws Exception{
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("board", "qna");
		mv.setViewName("board/boardWrite");
		return mv;
	}
	
	@RequestMapping(value = "qnaWrite", method = RequestMethod.POST)
	public ModelAndView boardWrite(BoardVO boardVO) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		
		int result = boardQnaService.boardWrite(boardVO);
		
		
		if(result > 0) {
			mv.setViewName("redirect:qnaList");
		}else {
			mv.addObject("msg", "글쓰기 실패");
			mv.addObject("paht", "qnaList");
			mv.setViewName("common/common_result");
		}
		

		mv.addObject("board", "qna");
		
		return mv;
	}
}
