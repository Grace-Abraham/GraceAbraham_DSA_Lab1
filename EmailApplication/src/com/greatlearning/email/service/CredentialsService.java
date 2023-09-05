package com.greatlearning.email.service;

import java.util.Random;

import com.greatlearning.email.model.Employee;

public class CredentialsService implements ICredentialService {
	private String capitals = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private String smalls = "abcdefghijklmnopqrstuvxyz";
	private String numbers = "0123456789";
	private String specials = "!@#$%^&*()_+=";
	private String allCharacters = capitals+smalls+numbers+specials;
	private Random random = new Random();
	
	@Override
	public void generateEmail(Employee employee) {
		String email = employee.getFn() + employee.getLn() + "@" + employee.getDepartment() + "." + employee.getCompany() + ".com";
		employee.setEmail(email.toLowerCase());
	}

	@Override
	public void generatePassword(Employee employee) {
		
		String password = "";
		for(int i=0;i<8;i++) {			
			password = password+allCharacters.charAt(random.nextInt(allCharacters.length()));
		}
		employee.setPassword(password);	
	}

	@Override
	public void showCredentials(Employee employee) {		
		System.out.println("Dear "+employee.getFn()+" your generated credentials are as follows");
		System.out.println("Email    ---> "+ employee.getEmail());
		System.out.println("Password ---> "+ employee.getPassword());
	}


}
