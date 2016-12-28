package org.library.util;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonUtil {
	
	public static String toJson(Object obj){
		return new Gson().toJson(obj);
	}
	
	public static String toJson(Object obj,String dateFormat){
		if(dateFormat==null){
			return new Gson().toJson(obj);
		}
		
		GsonBuilder builder=new GsonBuilder();
		Gson gson=builder.setDateFormat(dateFormat).create();
		return  gson.toJson(obj);
	}
}
