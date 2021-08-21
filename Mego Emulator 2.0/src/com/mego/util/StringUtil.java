package com.mego.util;

public class StringUtil {
  public static boolean equal(String a,String b) {
	for(int i = 0;i<Math.max(a.length(),b.length());i++) {
		if(a.charAt(i)!=b.charAt(i))return false;
	}
	return true;
  }
}
