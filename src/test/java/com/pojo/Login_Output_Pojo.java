package com.pojo;

public class Login_Output_Pojo {
	public int status;
	public String message;
	public Data data;
	public String refer_msg;
	public int cart_count;
	public String role;

	public int getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public Data getData() {
		return data;
	}

	public String getRefer_msg() {
		return refer_msg;
	}

	public int getCart_count() {
		return cart_count;
	}

	public String getRole() {
		return role;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public void setRefer_msg(String refer_msg) {
		this.refer_msg = refer_msg;
	}

	public void setCart_count(int cart_count) {
		this.cart_count = cart_count;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
