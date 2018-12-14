package org.study.model;

import java.sql.Date;

public class Member {

	private Integer member_num;
	private String member_name;
	private String member_pw;
	private String member_phone;
	private String member_address;
	private Date member_join_date;
	private String member_title;
	private String member_city;

	public Integer getMember_num() {
		return member_num;
	}

	public void setMember_num(Integer member_num) {
		this.member_num = member_num;
	}

	
	public String getMember_pw() {
		return member_pw;
	}

	public void setMember_pw(String member_pw) {
		this.member_pw = member_pw;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public String getMember_phone() {
		return member_phone;
	}

	public void setMember_phone(String member_phone) {
		this.member_phone = member_phone;
	}

	public String getMember_address() {
		return member_address;
	}

	public void setMember_address(String member_address) {
		this.member_address = member_address;
	}

	public Date getMember_join_date() {
		return member_join_date;
	}

	public void setMember_join_date(Date member_join_date) {
		this.member_join_date = member_join_date;
	}

	public String getMember_title() {
		return member_title;
	}

	public void setMember_title(String member_title) {
		this.member_title = member_title;
	}

	public String getMember_city() {
		return member_city;
	}

	public void setMember_city(String member_city) {
		this.member_city = member_city;
	}

	@Override
	public String toString() {
		return "Member [member_num=" + member_num + ", member_name=" + member_name + ", member_pw=" + member_pw
				+ ", member_phone=" + member_phone + ", member_address=" + member_address + ", member_join_date="
				+ member_join_date + ", member_title=" + member_title + ", member_city=" + member_city + "]";
	}

}
