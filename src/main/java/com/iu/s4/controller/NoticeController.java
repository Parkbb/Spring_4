package com.iu.s4.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

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
	public ModelAndView boardWrite(BoardVO boardVO, HttpSession session) throws Exception{
		System.out.println("a");
		ModelAndView mv = new ModelAndView();
		
		int result = boardNoticeService.boardWrite(boardVO, session);
		System.out.println("b");
		if(result > 0) {
			mv.setViewName("redirect:noticeList");
		}else {
			mv.addObject("msg", "글쓰기 실패");
			mv.addObject("path", "noticeList");
			mv.setViewName("common/common_result");
		}
		

		mv.addObject("board", "notice");
		
		return mv;
	}
	
	@RequestMapping("noticeSelect")
	public ModelAndView boardSelect(BoardVO boardVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("dto", boardNoticeService.boardSelect(boardVO));
		mv.addObject("board", "notice");
		mv.setViewName("board/boardSelect");
		
		return mv;
	}
	
	@RequestMapping(value = "noticeUpdate", method = RequestMethod.GET)
	public ModelAndView boardUpdate(BoardVO boardVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		
		mv.addObject("dto", boardNoticeService.boardSelect(boardVO));
		
		mv.setViewName("board/boardUpdate");
		return mv;
	}
	
	@RequestMapping(value = "noticeUpdate", method = RequestMethod.POST)
	public ModelAndView boardUpdate(BoardVO boardVO, ModelAndView mv) throws Exception{
		
		
		int result = boardNoticeService.boardUpdate(boardVO);
		
		if(result > 0) {
			mv.setViewName("redirect:noticeList");
		}else {
			mv.addObject("msg", "수정 실패");
			mv.addObject("path", "noticeList");
			mv.setViewName("common/common_result");
		}
		

		mv.addObject("board", "notice");
		
		return mv;
	}
	
	@RequestMapping("noticeDelete")
	public ModelAndView boardDelete(BoardVO boardVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		int result = boardNoticeService.boardDelete(boardVO);
		if(result>0) {
			mv.addObject("msg", "삭제 성공");
		
		}else {
			mv.addObject("msg", "삭제 실패");
		}
		
		mv.addObject("path", "noticeList");
		mv.addObject("board", "notice");
		mv.setViewName("common/common_result");
		return mv;
	}
}
