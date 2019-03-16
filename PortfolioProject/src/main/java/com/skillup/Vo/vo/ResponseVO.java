package com.skillup.Vo.vo;

import java.util.HashMap;
import java.util.List;

public class ResponseVO {
	
    private Boolean success;
    private String msg = "";
    private HashMap<String,Object> data;
    private List list;
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public HashMap<String, Object> getData() {
		return data;
	}
	public void setData(HashMap<String, Object> data) {
		this.data = data;
	}
    
}