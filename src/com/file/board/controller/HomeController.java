package com.file.board.controller;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

//	@Autowired **테스트용임. 아래내용도 
//	private DataSource ds; //javax.sql, 먼저 xml에서 오라클정보 적고 넘어옴
	//SqlSessionFactoryBean치면 xml클래스에 넣는 주소위에 나옴 그거복붙
	
	@Autowired
	private SqlSessionFactory ssf; //maven spring jdbc 스프링 버전이랑 같은 버전 poem에 긁어넣기
	
	@RequestMapping("/")
	public String goHome(Model model) {
//		System.out.println(ds);// 먼저 ds값 메모리가 정상적으로 생성이 됐는지 확인후에
//		try {
//			Connection con = ds.getConnection();
//			System.out.println(con);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		System.out.println(ssf);
		
		SqlSession ss= ssf.openSession();
		System.out.println(ss);
		
		
		model.addAttribute("msg","Hello~");
		return "index"; //servlet_context url
	}

}
