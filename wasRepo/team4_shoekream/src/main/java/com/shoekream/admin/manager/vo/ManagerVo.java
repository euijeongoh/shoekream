package com.shoekream.admin.manager.vo;

public class ManagerVo {

	private String no;
	private String name;
	private String id;
	private String pwd;
	private String email;
	private String delYn;
	public ManagerVo() {
		
	}
	public ManagerVo(String no, String name, String id, String pwd, String email, String delYn) {
		super();
		this.no = no;
		this.name = name;
		this.id = id;
		this.pwd = pwd;
		this.email = email;
		this.delYn = delYn;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	@Override
	public String toString() {
		return "ManagerVo [no=" + no + ", name=" + name + ", id=" + id + ", pwd=" + pwd + ", email=" + email
				+ ", delYn=" + delYn + "]";
	}
	
	
	
	
}
