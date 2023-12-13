package com.shoekream.member.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shoekream.member.service.MemberService;

@WebServlet("/member/check/email")

public class EmailDupCheckController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		try {
			// data
			BufferedReader br = req.getReader();
			String str = "";
			String jsonStr = null;
			while( (str = br.readLine()) != null ) {
				jsonStr = str;
			}
			System.out.println(jsonStr);
			// json to map
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<Map<String, String>> typeReference = new TypeReference<Map<String, String>>() {};
			Map<String, String> map = mapper.readValue(jsonStr, typeReference);
			
			// service
			MemberService ms = new MemberService();
			boolean isDup = ms.checkEmailDup(map.get("strEmail"));
			
			// result
			System.out.println(isDup);
			if(isDup == true) {
				throw new Exception("이미 가입된 아이디");
			}
			
			out.write("{\"msg\" : \"ok\"}");
		} catch(Exception e) {
			out.write("{\"msg\" : \"no\"}");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
	}
	
}
