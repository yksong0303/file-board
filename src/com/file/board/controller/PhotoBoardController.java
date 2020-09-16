package com.file.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.file.board.service.PhotoBoardService;
import com.file.board.vo.PhotoBoardVO;

@Controller
public class PhotoBoardController {
	
	@Autowired //이걸 해줘야 인터페이스랑 컨트롤러랑 같이 맵핑해줌
	private PhotoBoardService pbService;
	
	@RequestMapping(value="/photo/list", method=RequestMethod.GET)
	public String goList() {
		return "photo/list";
	}
	@RequestMapping(value="/photo/write", method=RequestMethod.GET)
	public String goWrite() {
		return "photo/write";
	}
	@RequestMapping(value="/photo/write", method=RequestMethod.POST)
	public String doWrite(@ModelAttribute PhotoBoardVO pb,@RequestParam("pbfile") MultipartFile file) {//requestParam()값은 input태그 안에 파일의 name
//		System.out.println(file.getOriginalFilename());//오류나면 maven에서 Apache Commons FileUpload poem에 추가하고, server>context에 context랑 리소스 추가
		//추가적으로 위의 구문에서 getname을 하게되면 input name이 나오기때문에 getOriginalFilename으로 변경하게되면 오리지널 파일 이름으로 정상적으로 출력된다.
//		System.out.println(pb);
		
		pbService.insertPhotoBoard(file, pb);
		
		return "photo/write";
	}


}
