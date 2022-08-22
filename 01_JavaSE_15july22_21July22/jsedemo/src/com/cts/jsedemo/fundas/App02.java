package com.cts.jsedemo.fundas;

public class App02 {

	public static void main(String[] args) {

		String s1 = "Hello";
		String s2 = "Hello";
		
		System.out.println(s1.hashCode() +"\t" + System.identityHashCode(s1));
		System.out.println(s2.hashCode() +"\t" + System.identityHashCode(s2));
		
		String s3="";
		
		for(int i=0;i<s1.length();i++) {
			s3 = s3+s1.charAt(i);
			System.out.println(s3.hashCode() +"\t" + System.identityHashCode(s3)+"\t"+s3);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<s1.length();i++) {
			sb.append(s1.charAt(i));
			System.out.println(sb.hashCode() +"\t" + System.identityHashCode(sb)+"\t"+sb);
		}
	}

}
