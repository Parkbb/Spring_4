package com.iu.s4.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Qualifier;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.s4.dao.BoardNoticeDAO;
import com.iu.s4.dao.NoticeFilesDAO;
import com.iu.s4.model.BoardNoticeVO;
import com.iu.s4.model.BoardVO;
import com.iu.s4.model.NoticeFilesVO;
import com.iu.s4.util.FileSaver;
import com.iu.s4.util.Pager;

@Service
public class BoardNoticeService implements BoardService {
	
	@Inject
	private BoardNoticeDAO boardNoticeDAO;
	@Inject
	private FileSaver fs;
	@Inject
	private NoticeFilesDAO noticeFilesDAO;
	
	@Override
	public List<BoardVO> boardList(Pager pager) throws Exception {
		pager.makeRow();
		pager.makePage(boardNoticeDAO.boardCount(pager));
		
		
		return boardNoticeDAO.boardList(pager);
	}

	@Override
	public BoardVO boardSelect(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		boardVO = boardNoticeDAO.boardSelect(boardVO);
		
		BoardNoticeVO boardNoticeVO = (BoardNoticeVO)boardVO;
		
		List<NoticeFilesVO> ar =noticeFilesDAO.fileList(boardVO.getNum());
		
		boardNoticeVO.setFiles(ar);
		
		return boardNoticeVO;
	}

	@Override
	public int boardWrite(BoardVO boardVO, HttpSession session) throws Exception {
		
		String realpath = session.getServletContext().getRealPath("resources/upload/notice");
		

		int result = boardNoticeDAO.boardWrite(boardVO);
		
		if(boardVO.getFile() !=null)
		{
		for (int i = 0; i < boardVO.getFile().length; i++) {
			NoticeFilesVO noticeFilesVO = new NoticeFilesVO();
			String filename = fs.save2(realpath, boardVO.getFile()[i]);
			
			noticeFilesVO.setNum(boardVO.getNum());
			noticeFilesVO.setFname(filename);
			noticeFilesVO.setOname(boardVO.getFile()[i].getOriginalFilename());
			
			noticeFilesDAO.noticefilesWrite(noticeFilesVO);
		}
		}
		return result;
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
