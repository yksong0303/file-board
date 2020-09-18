package com.file.board.dao.impl;

import java.io.File;
import java.util.List;

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
	@Override
	public List<PhotoBoardVO> selectPhotoBoard(PhotoBoardVO pb) {
		try(SqlSession ss = ssf.openSession()){
			return ss.selectOne("selectPhotoBoard",pb);
		}
	}

	@Override
	public int updatePhotoBoard(PhotoBoardVO pb) {
		int cnt = 0;
		try(SqlSession ss = ssf.openSession()){
			cnt = ss.update("PhotoBoardUpdate", pb);
		}
		return cnt;
	}
	
	
	@Override
	public List<PhotoBoardVO> selectPhotoBoardList(PhotoBoardVO pb) {
		try(SqlSession ss = ssf.openSession()){
			return ss.selectList("selectPbList",pb);
		}
		
	}
	public int selectPhotoBoardCount(PhotoBoardVO pb) {
	    try(SqlSession ss =ssf.openSession()){
	       return ss.selectOne("selectPhotoBoardCount", pb);
	    }
	 }


	@Override
	public int deletePhotoBoard(int[] pbNums) {
		 try(SqlSession ss =ssf.openSession()){
			 int cnt= 0;
			 for(int pbNum: pbNums) {
				 cnt += ss.delete("deletePhotoBoard", pbNum);
			 }
		       return cnt;
		    }
	}


	@Override
	public List<PhotoBoardVO> selectPhotoBoardsForDelete(int[] pbNums) {
		 try(SqlSession ss =ssf.openSession()){
		return ss.selectList("selectPhotoBoardforDelete", pbNums);
		 }
	}

	@Override
	public void updateViewCnt(int param) {
		 try(SqlSession ss =ssf.openSession()){
			 ss.update("PhotoBoardViewCnt", param);
		 }
		
	}

	



	
//	public static void main(String[] args) {
//		PhotoBoardVO pv = new PhotoBoardVO();
//		PhotoBoardDAOImpl pdao = new PhotoBoardDAOImpl();
//		pv.setPbNum(2);
//		
//		System.out.println(pdao.deletePhotoBoard(pv));
//		
//	}

}


