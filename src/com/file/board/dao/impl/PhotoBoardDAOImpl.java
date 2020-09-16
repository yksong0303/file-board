package com.file.board.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.file.board.dao.PhotoboardDAO;
import com.file.board.vo.PhotoBoardVO;

@Repository
public class PhotoBoardDAOImpl implements PhotoboardDAO {

	@Autowired
	private PhotoboardDAO pbdao;
	
	@Override
	public int insertPhotoBoard(MultipartFile file, PhotoBoardVO pb) {
		return pbdao.insertPhotoBoard(file, pb);
	}

}
