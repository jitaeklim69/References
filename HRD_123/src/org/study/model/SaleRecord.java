package org.study.model;

public class SaleRecord {

	private Integer member_num;
	private String member_name;
	private String member_title;
	private Integer sale_total;

	public Integer getMember_num() {
		return member_num;
	}

	public void setMember_num(Integer member_num) {
		this.member_num = member_num;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public String getMember_title() {
		return member_title;
	}

	public void setMember_title(String member_title) {
		this.member_title = member_title;
	}

	public Integer getSale_total() {
		return sale_total;
	}

	public void setSale_total(Integer sale_total) {
		this.sale_total = sale_total;
	}

	@Override
	public String toString() {
		return "SaleRecord [member_num=" + member_num + ", member_name=" + member_name + ", member_title="
				+ member_title + ", sale_total=" + sale_total + "]";
	}

}
