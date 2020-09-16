package com.file.board.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.file.board.dao.impl.PhotoBoardDAOImpl;
import com.file.board.service.PhotoBoardService;
import com.file.board.vo.PhotoBoardVO;

@Service //스프링이 없으면 동작안하는 어노테이션, 지금은 xml에 하는 방법 붙여놨ㅇ므
public class PhotoBoardServiceImpl implements PhotoBoardService{
	
	@Autowired
	private PhotoBoardService pbser;
	
	@Override
	public int insertPhotoBoard(MultipartFile file, PhotoBoardVO pb) {
		return pbser.insertPhotoBoard(file, pb);
	}

}
