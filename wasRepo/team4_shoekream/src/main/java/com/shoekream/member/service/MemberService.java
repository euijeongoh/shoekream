package com.shoekream.member.service;

import java.security.SecureRandom;
import java.sql.Connection;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shoekream.db.util.JDBCTemplate;
import com.shoekream.member.MemberVo;
import com.shoekream.member.dao.MemberDao;
import com.shoekream.member.util.GenerateTempPwd;

public class MemberService {

	// 로그인
	public MemberVo login(MemberVo vo) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		MemberDao dao = new MemberDao();
		MemberVo loginMember = dao.login(conn, vo);
	
		// close
		JDBCTemplate.close(conn);
		
		return loginMember;
	}
	
	// 아이디 중복 체크
	public boolean checkIdDup(String memberId) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		MemberDao dao = new MemberDao();
		boolean isDup = dao.checkIdDup(conn, memberId);
		
		// close
		JDBCTemplate.close(conn);
		
		return isDup;
	}

	public int quit(MemberVo loginMember) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		MemberDao dao = new MemberDao();
		// 탈퇴 가능 여부 확인
		boolean canQuit = dao.checkPenaltyYn(conn, loginMember);
		
		int quitNo = 0;
		if(canQuit) {
			int result = dao.updateStatus(conn, loginMember);
			
			// tx
			if(result==1) {
				quitNo = 1; // update 작업 성공
				JDBCTemplate.commit(conn);
			} else {
				quitNo = -1; // update 작업 실패
				JDBCTemplate.rollback(conn);
			}
			
		} else {
			quitNo = -2; // 패널티로 인해 탈퇴가 불가능한 회원
		}
		
		// close
		JDBCTemplate.close(conn);
		
		return quitNo;
	}

	public boolean checkEmailDup(String email) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		MemberDao dao = new MemberDao();
		boolean isDup = dao.checkEmailDup(conn, email);
		
		// close
		JDBCTemplate.close(conn);
		
		return isDup;
	}

	public MemberVo searchId(String email) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		MemberDao dao = new MemberDao();
		MemberVo vo = dao.searchId(conn, email);
		
		// close
		JDBCTemplate.close(conn);
		
		return vo;
	}

	public int join(MemberVo vo) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// business logic
		// 이름 한글 2-5자
		boolean nameOk = vo.getName().matches("[ㄱ-ㅣ가-힣]{2,5}");
		if(!nameOk) {
			throw new Exception("이름 형식");
		}
		// 아이디 중복 체크
		MemberDao dao = new MemberDao();
		boolean idDup = dao.checkIdDup(conn, vo.getId());
		if(idDup==true) {
			throw new Exception("아이디 중복");
		}
		// 아이디 6자 이상
		if(vo.getId().length() <6) {
			throw new Exception("아이디 길이 6자 미만");
		}
		
		// 비밀번호 정규표현식 검사
		boolean pwdOk = vo.getPwd().matches("(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,16}");
		if(!pwdOk) {
			throw new Exception("비밀번호 형식");
		}
		
		// 비밀번호 일치 확인
		boolean pwdSame = vo.getPwd().equals(vo.getPwd2());
		if(!pwdSame) {
			throw new Exception("비밀번호 일치여부 문제");
		}
		
		// 닉네임 3-5자 사이 한글
		boolean nickOk = vo.getNickname().matches("[ㄱ-ㅣ가-힣]{3,5}");
		if(!nickOk) {
			throw new Exception("닉네임 형식 문제");
		}
		
		// 이메일 중복 체크
		boolean emailDup = dao.checkEmailDup(conn, vo.getEmail());
		if(emailDup==true) {
			throw new Exception("이메일 중복");
		}
		
		// 이메일 유효성 체크
		boolean emailOk = vo.getEmail().matches("[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}");
		if(!emailOk) {
			throw new Exception("이메일 형식문제");
		}

		// 회원가입 작업
		int result = dao.join(conn, vo);
		
		// tx
		if(result == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		// close
		JDBCTemplate.close(conn);
		
		return result;
	}

	// 임시 비밀번호 발급
	public int sendPwdEmail(MemberVo vo) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		MemberDao dao = new MemberDao();
		boolean memberExists = dao.searchMemberByIdEmail(conn, vo);
	
		if(memberExists==false) {
			throw new Exception("일치하는 회원정보 없음");
		}
		
		// email server
		String emailFrom = "shoekream4@gmail.com";
		String username = "shoekream";
		
		// email client
		String emailTo = vo.getEmail();
		
		final String smtpEmail = "shoekream4@gmail.com";
		final String password = "tlqkmvllkldryzck";
		
		// smtp server 정보
		Properties props = new Properties();
		props.put("mail.transport.protocal", "smtp");
		props.put("mail.smtp.host", "smtp.gmail.com"); // host 정보 네이버에서 갖고 오기
		props.put("mail.smtp.port", 587);
		props.put("mail.smtp.auth", "true");
		props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		props.put("mail.smtp.quitwait", "false");
		props.put("mail.smtp.socketFactory.port", "587");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "true");
		props.put("mail.smtp.starttls.enable", "true");
		
		// 비밀번호 생성(일단 이메일 가는 거 보고)
		GenerateTempPwd tempPwd = new GenerateTempPwd();
		String tempPwd_ = tempPwd.executeGenerate();
		
		// email 내용
		String emailTitle = "[SHOEKREAM] 임시 비밀번호 발급";
		String emailContent = "임시 비밀번호 : " + tempPwd_;
		
		Session session = Session.getInstance(props);
		session.setDebug(true);
		
		MimeMessage mail = new MimeMessage(session);
		mail.setContent(emailContent, "text/plain; charset=utf-8");
		InternetAddress from = new InternetAddress(emailFrom, "shoekream@naver.com");
		InternetAddress to = new InternetAddress(emailTo);
		
		// email 정보
		mail.setSubject(emailTitle);
		mail.setFrom(from);
		mail.setRecipient(Message.RecipientType.TO, to);
		mail.setText(emailContent);
		
		// email 전송
		Transport t = session.getTransport("smtp");
		t.connect(smtpEmail, password);
		t.sendMessage(mail, mail.getAllRecipients());
		t.close();
		System.out.println("이메일 전송 완료");
		
		boolean emailSent = true;
		
		// 임시 비밀번호로 비밀번호 update
		int result = dao.updatePwd(conn, vo, tempPwd_);
		
		// tx
		if(result == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		// conn close
		JDBCTemplate.close(conn);
		
		
		return result;
	}

}
