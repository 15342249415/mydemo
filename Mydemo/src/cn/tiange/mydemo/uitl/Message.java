package cn.tiange.mydemo.uitl;

import java.util.HashMap;

public class Message {
	
	public static HashMap<String,String> OK=new HashMap<String,String>();
	public static HashMap<String,String> FAIL=new HashMap<String,String>();
	public static HashMap<String,String> RESULT=new HashMap<String,String>();
	
	static {
		OK.put("result", "success");
		FAIL.put("result", "fail");
	}
	
}
