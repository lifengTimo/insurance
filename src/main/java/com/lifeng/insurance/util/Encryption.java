package com.lifeng.insurance.util;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;

public class Encryption {

	public static String getMD5x32(String pwd){
		String result= Hashing.md5().newHasher().putString(pwd, Charsets.UTF_8).hash().toString();
		return result;
	}
	public static String getMD5x16(String pwd){
		String result= Hashing.md5().newHasher().putString(pwd, Charsets.UTF_8).hash().toString();
		return result.substring(8,24);
	}
	public static String getSHA1(String pwd){
		String result= Hashing.sha1().newHasher().putString(pwd, Charsets.UTF_8).hash().toString();
		return result;
	}
}
