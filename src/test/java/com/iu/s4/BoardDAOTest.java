package com.iu.s4;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;

import com.iu.s4.dao.BoardNoticeDAO;
import com.iu.s4.dao.BoardQnaDAO;
import com.iu.s4.model.BoardVO;

public class BoardDAOTest extends TestAbstractCase{
	
	@Inject
	BoardNoticeDAO notice;
	
	@Inject
	BoardQnaDAO qna;
	
	@Test
	public void test() throws Exception{
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle("testt");
		boardVO.setWriter("testw");
		boardVO.setContents("testc");
		
		int result = notice.boardWrite(boardVO);
		int result2 = qna.boardWrite(boardVO);

		assertEquals(1, result);
		assertEquals(1, result2);
		
	}

}
