package com.file.board.dao;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.file.board.vo.PhotoBoardVO;

public interface PhotoboardDAO {

		int insertPhotoBoard(MultipartFile file, PhotoBoardVO pb);
		List<PhotoBoardVO> selectPhotoBoardList(PhotoBoardVO pb);
		int selectPhotoBoardCount(PhotoBoardVO pb);
}
