package com.file.board.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.file.board.dao.PhotoboardDAO;
import com.file.board.vo.PhotoBoardVO;

@Repository
public class PhotoBoardDAOImpl implements PhotoboardDAO {

	@Autowired
	private SqlSessionFactory ssf;
	
	
	@Override
	public int insertPhotoBoard(MultipartFile file, PhotoBoardVO pb) {
		int cnt = 0;
		try(SqlSession ss = ssf.openSession()){
				cnt = ss.insert("insertPb",pb);
				if(cnt==0) {
					System.out.println("실패");
					return 0;
				}
		}
		
		return cnt;
	}

}
