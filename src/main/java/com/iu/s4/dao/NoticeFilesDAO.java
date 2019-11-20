package com.iu.s4.dao;

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
	
}
