package com.example.demo.model;

public class RevVO {
	private int rev_no;
	private String rev_id;
	private int rs_no;
	private String rev_time;
	private String cancel_yn;
	private String cancel_time;
	
	public int getRev_no() {
		return rev_no;
	}
	public void setRev_no(int rev_no) {
		this.rev_no = rev_no;
	}
	public String getRev_id() {
		return rev_id;
	}
	public void setRev_id(String rev_id) {
		this.rev_id = rev_id;
	}
	public int getRs_no() {
		return rs_no;
	}
	public void setRs_no(int rs_no) {
		this.rs_no = rs_no;
	}
	public String getRev_time() {
		return rev_time;
	}
	public void setRev_time(String rev_time) {
		this.rev_time = rev_time;
	}
	public String getCancel_yn() {
		return cancel_yn;
	}
	public void setCancel_yn(String cancel_yn) {
		this.cancel_yn = cancel_yn;
	}
	public String getCancel_time() {
		return cancel_time;
	}
	public void setCancel_time(String cancel_time) {
		this.cancel_time = cancel_time;
	}

}
