package com.map;

public class MapCopyTest {
	public static void main(String[] args) {
		User w1 =new User();
		w1.setUserName("张三");
		User w2 = w1;
		w1.setUserName("李四");
		System.out.println(w2==w1);
		System.out.println(w1.getUserName());
		System.out.println(w2.getUserName());
	}
}

class User{
	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
