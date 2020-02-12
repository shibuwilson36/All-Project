package com.tyss.junit;

import java.util.ArrayList;

public class MyFriends {
	private ArrayList<String> a1 = new ArrayList<String>();
	public MyFriends() {

		a1.add("Nidhin");
		a1.add("Sarath");
		a1.add("Amal");
		a1.add("Amal");
	}
	public String getname() {
		if(a1.size()==0) {
			return null;
		}else {
			return a1.remove(0);
		}
	}
}
