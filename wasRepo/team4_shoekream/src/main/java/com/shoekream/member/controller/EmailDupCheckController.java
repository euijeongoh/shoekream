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

import com.google.gson.Gson;
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
			Gson gson = new Gson();
			Map<String, String> map = gson.fromJson(jsonStr, Map.class);
			
			// service
			MemberService ms = new MemberService();
			boolean isDup = ms.checkEmailDup(map.get("strEmail"));
			
			// result
			System.out.println(isDup);
			if(isDup == true) {
				throw new Exception("이미 가입된 아이디");
			}
			
			out.write("{\"reply\" : \"ok\"}");
		} catch(Exception e) {
			out.write("{\"reply\" : \"no\"}");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
	}
	
}
