package com.iu.s4.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Qualifier;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.iu.s4.dao.BoardNoticeDAO;
import com.iu.s4.model.BoardVO;
import com.iu.s4.util.FileSaver;
import com.iu.s4.util.Pager;

@Service
public class BoardNoticeService implements BoardService {
	
	@Inject
	private BoardNoticeDAO boardNoticeDAO;
	
	@Override
	public List<BoardVO> boardList(Pager pager) throws Exception {
		pager.makeRow();
		pager.makePage(boardNoticeDAO.boardCount(pager));
		
		
		return boardNoticeDAO.boardList(pager);
	}

	@Override
	public BoardVO boardSelect(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return boardNoticeDAO.boardSelect(boardVO);
	}

	@Override
	public int boardWrite(BoardVO boardVO, HttpSession session) throws Exception {
		
		String realpath = session.getServletContext().getRealPath("resources/upload/notice");
		System.out.println(realpath);
		FileSaver fs = new FileSaver();
		
		String filename = fs.save(realpath, boardVO.getFile());
		
		boardVO.setFilename(filename);
		boardVO.setOriginalfilename(boardVO.getOriginalfilename());
		
		//return boardNoticeDAO.boardWrite(boardVO);
		return 0;
	}

	@Override
	public int boardUpdate(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return boardNoticeDAO.boardUpdate(boardVO);
	}

	@Override
	public int boardDelete(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return boardNoticeDAO.boardDelete(boardVO);
	}

}
