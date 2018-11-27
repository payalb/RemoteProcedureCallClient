package com.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

	public static void main(String[] args) throws IOException {
		// Socket: client code: url, port
		// ServerSocket:port
		Socket s = new Socket("127.0.0.1",1564);
		PrintWriter writer = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
		
		writer.println(3);
		writer.flush();
		writer.println(4);
		writer.flush();
		writer.println("add");
		writer.flush();
		BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
		String temp;
		while(true) {
			if(( temp=reader.readLine())!=null) {
		long result=Long.parseLong(temp);
		System.out.println(result);
			}
		}
		//s.close();
	}

}
