package com.shoekream.admin.manager.vo;

public class ManagerVo {

	private String no;
	private String name;
	private String id;
	private String pwd;
	private String phone;
	private String delYn;
	public ManagerVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ManagerVo(String no, String name, String id, String pwd, String phone, String delYn) {
		super();
		this.no = no;
		this.name = name;
		this.id = id;
		this.pwd = pwd;
		this.phone = phone;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	@Override
	public String toString() {
		return "ManagerVo [no=" + no + ", name=" + name + ", id=" + id + ", pwd=" + pwd + ", phone=" + phone
				+ ", delYn=" + delYn + "]";
	}
	
	
	
	
}
