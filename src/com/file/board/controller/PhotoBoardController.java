package com.file.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.file.board.vo.PhotoBoardVO;

@Controller
public class PhotoBoardController {
	
	@RequestMapping(value="/photo/list", method=RequestMethod.GET)
	public String goList() {
		return "photo/list";
	}
	@RequestMapping(value="/photo/write", method=RequestMethod.GET)
	public String goWrite() {
		return "photo/write";
	}
	@RequestMapping(value="/photo/write", method=RequestMethod.POST)
	public String doWrite(@ModelAttribute PhotoBoardVO pb,@RequestParam("pbPhotoName") MultipartFile file) {//requestParam()값은 input태그 안에 파일의 name
		System.out.println(file.getName());//오류나면 maven에서 Apache Commons FileUpload poem에 추
		System.out.println(pb);
		
		return "photo/write";
	}


}
