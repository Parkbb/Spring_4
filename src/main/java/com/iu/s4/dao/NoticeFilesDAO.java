package com.iu.s4.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.iu.s4.model.NoticeFilesVO;

@Repository
public class NoticeFilesDAO {

	@Inject
	private SqlSession sqlsession;
	private static final String NAMESPACE="noticeFilesMapper.";
	
	public int noticefilesWrite (NoticeFilesVO noticeFilesVO) throws Exception{
		
		return sqlsession.insert(NAMESPACE+"fileWrite",noticeFilesVO);
		
	}
	
	public List<NoticeFilesVO> fileList (int num) throws Exception{
		
		return sqlsession.selectList(NAMESPACE+"fileList", num);
	}
	
	public int fileDelete(NoticeFilesVO noticeFilesVO) throws Exception{
		
		return sqlsession.delete(NAMESPACE+"fileDelete", noticeFilesVO);
		
	}
	
	public NoticeFilesVO fileSelect(NoticeFilesVO noticeFilesVO) throws Exception{
		noticeFilesVO = sqlsession.selectOne(NAMESPACE+"fileSelect", noticeFilesVO);
		return noticeFilesVO;
	}
}
