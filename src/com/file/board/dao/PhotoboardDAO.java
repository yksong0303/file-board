package com.file.board.dao;

import org.springframework.web.multipart.MultipartFile;

import com.file.board.vo.PhotoBoardVO;

public interface PhotoboardDAO {

		int insertPhotoBoard(MultipartFile file, PhotoBoardVO pb);
}
