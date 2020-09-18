package com.file.board.dao;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.file.board.vo.PhotoBoardVO;

public interface PhotoboardDAO {

		int insertPhotoBoard(MultipartFile file, PhotoBoardVO pb);
		List<PhotoBoardVO> selectPhotoBoardList(PhotoBoardVO pb);
		int selectPhotoBoardCount(PhotoBoardVO pb);
		int deletePhotoBoard(int[] pbNums);
		List<PhotoBoardVO> selectPhotoBoardsForDelete(int[] pbNums);
		int updatePhotoBoard(PhotoBoardVO pb);
		void updateViewCnt(int param);
		List<PhotoBoardVO> selectPhotoBoard(PhotoBoardVO pb);
}
