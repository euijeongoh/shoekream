package com.shoekream.member;

public class MemberVo {
	
	private String no;
	private String name;
	private String id;
	private String pwd;
	private String nickname;
	private String phone;
	private String joinDate;
	private String delYn;
	private String profileImage;
	private String point;
	private String penaltyYn;
	
	
	public MemberVo() {
		
	}
	
	public MemberVo(String no, String name, String id, String pwd, String nickname, String phone, String joinDate,
			String delYn, String profileImage, String point, String penaltyYn) {
		super();
		this.no = no;
		this.name = name;
		this.id = id;
		this.pwd = pwd;
		this.nickname = nickname;
		this.phone = phone;
		this.joinDate = joinDate;
		this.delYn = delYn;
		this.profileImage = profileImage;
		this.point = point;
		this.penaltyYn = penaltyYn;
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
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
		return "MemberVo [no=" + no + ", name=" + name + ", id=" + id + ", pwd=" + pwd + ", nickname=" + nickname
				+ ", phone=" + phone + ", joinDate=" + joinDate + ", delYn=" + delYn + ", profileImage=" + profileImage
				+ ", point=" + point + ", penaltyYn=" + penaltyYn + "]";
	}
	
	
	
}
