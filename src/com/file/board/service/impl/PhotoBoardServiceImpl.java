package com.file.board.service.impl;


import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.file.board.dao.PhotoboardDAO;
import com.file.board.dao.impl.PhotoBoardDAOImpl;
import com.file.board.service.PhotoBoardService;
import com.file.board.vo.PageVO;
import com.file.board.vo.PhotoBoardVO;

@Service //스프링이 없으면 동작안하는 어노테이션, 지금은 xml에 하는 방법 붙여놨ㅇ므
public class PhotoBoardServiceImpl implements PhotoBoardService{
	
	private final String uploadPath ="C:\\\\Users\\\\Administrator\\\\git\\\\file-board\\\\WebContent\\\\resources\\";
	//webcontent resources파일에 커서두고 alt+enter
	@Autowired
	private PhotoBoardDAOImpl pbdao;
	
	@Override
	public int insertPhotoBoard(MultipartFile file, PhotoBoardVO pb) {
		if(file.getOriginalFilename().trim()=="") {
			return pbdao.insertPhotoBoard(file, pb);	
		}
		String orgFileName=file.getOriginalFilename();
		int cut = orgFileName.lastIndexOf(".");
		String extName=orgFileName.substring(cut);
		String fileName = System.nanoTime()+extName;
		
		pb.setPbPhotoName(orgFileName);
		pb.setPbPhotoPath(fileName);
		int cnt = pbdao.insertPhotoBoard(file, pb);
		if(cnt ==1) {
			File f = new File(uploadPath+fileName);
			try {
				file.transferTo(f);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return cnt;
	}
	
	@Override
	public List<PhotoBoardVO> selectPhotoBoard(PhotoBoardVO pb, Model model) {
		pbdao.updateViewCnt(1);
		model.addAttribute("select",pbdao.selectPhotoBoard(pb));
		return pbdao.selectPhotoBoard(pb);
	}
	
	@Override
	public int updatePhotoBoard(MultipartFile file, PhotoBoardVO pb) {
		// TODO Auto-generated method stub
		return pbdao.updatePhotoBoard(pb);
	}

	@Override
	public List<PhotoBoardVO> selectPhotoBoardList(PhotoBoardVO pb, Model model) {
		PageVO page = pb.getPage();
		
		int startNum = (page.getPageNum()-1)*10+1;
		int endNum = startNum+(10-1);
		
		page.setLastNum(endNum);
		page.setStartNum(startNum);
		pb.setPage(page);
		
		int totalCnt = pbdao.selectPhotoBoardCount(pb);
		page.setTotalCnt(totalCnt);
		int totalPageSize = totalCnt/10;
		System.out.println(totalPageSize);
		int startBlock = (page.getPageNum()-1)/10*10+1;
		int endBlock = startBlock +(10-1);
		if(endBlock>totalPageSize) {
			endBlock = totalPageSize;
		}
		page.setStartBlock(startBlock);
		page.setEndBlock(endBlock);
		model.addAttribute("page",page);
		model.addAttribute("pbList",pbdao.selectPhotoBoardList(pb));
		return null;
	}
	//file.delete();

	@Override
	public int deletePhotoBoard(int[] pbNums) {
		List<PhotoBoardVO> pbList = pbdao.selectPhotoBoardsForDelete(pbNums);
		if(!pbList.isEmpty()) {
			for(PhotoBoardVO pb : pbList) {
				String fileName= pb.getPbPhotoPath();
				File f = new File(uploadPath+fileName);
				if(f.exists()) {
					f.delete();
				}
			}
		}
			return pbdao.deletePhotoBoard(pbNums);
	}




	
//	public static void main(String[] args) {
//		PhotoboardDAO pbdao = new PhotoBoardDAOImpl();
//		System.out.println(pbdao.selectPhotoBoardList(null));
//	}

}
