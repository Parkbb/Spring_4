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
	
	public NoticeFilesVO fileSelect(NoticeFilesVO noticeFilesVO) throws Exception{
		return noticeFilesDAO.fileSelect(noticeFilesVO);
	}
	
	
	@Override
	public List<BoardVO> boardList(Pager pager) throws Exception {
		pager.makeRow();
		pager.makePage(boardNoticeDAO.boardCount(pager));
		
		
		return boardNoticeDAO.boardList(pager);
	}
	
	public int fileDelete(NoticeFilesVO noticeFilesVO) throws Exception{
		
		return noticeFilesDAO.fileDelete(noticeFilesVO);
	}
	
	@Override
	public BoardVO boardSelect(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		//boardVO = boardNoticeDAO.boardSelect(boardVO);
		
		//BoardNoticeVO boardNoticeVO = (BoardNoticeVO)boardVO;
		
		//List<NoticeFilesVO> ar =noticeFilesDAO.fileList(boardVO.getNum());
		
		//boardNoticeVO.setFiles(ar);
		
		//return boardNoticeVO;
		
		return boardNoticeDAO.boardSelect(boardVO);
	}

	@Override
	public int boardWrite(BoardVO boardVO, HttpSession session) throws Exception {
		
		String realpath = session.getServletContext().getRealPath("resources/upload/notice");
		

		int result = boardNoticeDAO.boardWrite(boardVO);
		
		if(boardVO.getFile() !=null){
			for (int i = 0; i < boardVO.getFile().length; i++) {
				if(boardVO.getFile()[i].getSize()>0) {
					
					NoticeFilesVO noticeFilesVO = new NoticeFilesVO();
					String filename = fs.save2(realpath, boardVO.getFile()[i]);
			
					noticeFilesVO.setNum(boardVO.getNum());
					noticeFilesVO.setFname(filename);
					noticeFilesVO.setOname(boardVO.getFile()[i].getOriginalFilename());
			
					noticeFilesDAO.noticefilesWrite(noticeFilesVO);
				}
			}
		}
		return result;
	}

	@Override
	public int boardUpdate(BoardVO boardVO, HttpSession session) throws Exception {
		
		String realpath = session.getServletContext().getRealPath("resources/upload/notice");
		
		int result =boardNoticeDAO.boardUpdate(boardVO);
		
		if(boardVO.getFile() != null) {
			
			for (MultipartFile file : boardVO.getFile()) {
				if (file.getSize() >0) {
					
				NoticeFilesVO noticeFilesVO = new NoticeFilesVO();
				String filename = fs.save2(realpath, file);
				
				noticeFilesVO.setNum(boardVO.getNum());
				noticeFilesVO.setOname(file.getOriginalFilename());
				noticeFilesVO.setFname(filename);
				
				noticeFilesDAO.noticefilesWrite(noticeFilesVO);
				}
			}
		}
		
		
		return result;
	}

	@Override
	public int boardDelete(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return boardNoticeDAO.boardDelete(boardVO);
	}

}
