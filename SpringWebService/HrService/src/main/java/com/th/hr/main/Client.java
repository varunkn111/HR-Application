package com.th.hr.main;

import org.springframework.web.client.RestTemplate;

import com.th.hr.model.Login;

public class Client {

	public static void main(String[] args) {
		String uri = "http://localhost:8083/HrService/login" ;
		RestTemplate rt = new RestTemplate();
		Login login = rt.getForObject(uri, Login.class);
		

	}

}
