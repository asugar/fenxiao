package com.distribution.model;



import java.util.Date;


/**
 * 操作记录
 * @author oyyf
 *
 */
public class ReqRecord {
	private String pid;
	private String req_type;
	private Date create_time;
	private String req_ip;
	private String status;
	private String status_detail;
	private String req_reason;
	private String req_data;
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getReq_type() {
		return req_type;
	}
	public void setReq_type(String req_type) {
		this.req_type = req_type;
	}
	public String getReq_ip() {
		return req_ip;
	}
	public void setReq_ip(String req_ip) {
		this.req_ip = req_ip;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatus_detail() {
		return status_detail;
	}
	public void setStatus_detail(String status_detail) {
		this.status_detail = status_detail;
	}
	public String getReq_reason() {
		return req_reason;
	}
	public void setReq_reason(String req_reason) {
		this.req_reason = req_reason;
	}
	public String getReq_data() {
		return req_data;
	}
	public void setReq_data(String req_data) {
		this.req_data = req_data;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	
	
	
}
