package com.shoekream.member;

public class MemberVo {
	
	private String no;
	private String name;
	private String id;
	private String pwd;
	private String pwd2;
	private String nickname;
	private String email;
	private String joinDate;
	private String delYn;
	private String profileImage;
	private String point;
	private String penaltyYn;
	public MemberVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MemberVo(String no, String name, String id, String pwd, String pwd2, String nickname, String email,
			String joinDate, String delYn, String profileImage, String point, String penaltyYn) {
		super();
		this.no = no;
		this.name = name;
		this.id = id;
		this.pwd = pwd;
		this.pwd2 = pwd2;
		this.nickname = nickname;
		this.email = email;
		this.joinDate = joinDate;
		this.delYn = delYn;
		this.profileImage = profileImage;
		this.point = point;
		this.penaltyYn = penaltyYn;
	}
	public MemberVo(String name, String id, String pwd, String pwd2, String nickname, String email) {
		super();
		this.name = name;
		this.id = id;
		this.pwd = pwd;
		this.pwd2 = pwd2;
		this.nickname = nickname;
		this.email = email;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPwd2() {
		return pwd2;
	}
	public void setPwd2(String pwd2) {
		this.pwd2 = pwd2;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	public String getProfileImage() {
		return profileImage;
	}
	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}
	public String getPoint() {
		return point;
	}
	public void setPoint(String point) {
		this.point = point;
	}
	public String getPenaltyYn() {
		return penaltyYn;
	}
	public void setPenaltyYn(String penaltyYn) {
		this.penaltyYn = penaltyYn;
	}
	@Override
	public String toString() {
		return "MemberVo [no=" + no + ", name=" + name + ", id=" + id + ", pwd=" + pwd + ", pwd2=" + pwd2
				+ ", nickname=" + nickname + ", email=" + email + ", joinDate=" + joinDate + ", delYn=" + delYn
				+ ", profileImage=" + profileImage + ", point=" + point + ", penaltyYn=" + penaltyYn + "]";
	}
	
	
	
	
}
