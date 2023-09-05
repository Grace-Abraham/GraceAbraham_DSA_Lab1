package com.greatlearning.email.main;

import java.util.Scanner;

import com.greatlearning.email.model.Employee;
import com.greatlearning.email.service.CredentialsService;


public class Driver {

	public static void main(String[] args) {
		String fn = "", ln = "", department = "", company = "gl";
		Scanner sc = new Scanner(System.in);

		System.out.println("Please enter your first name:");
		fn = sc.next();

		System.out.println("Please enter your last name:");
		ln = sc.next();

		System.out.println(
				"Please enter the department from the following\n1. Technical\n2. Admin\n3. Human Resource\n4. Legal");

		while (department == "") {
			int key = sc.nextInt();
			switch (key) {
			case 1: {
				department = "tech";
				break;
			}
			case 2: {
				department = "admin";
				break;
			}
			case 3: {
				department = "hr";
				break;
			}
			case 4: {
				department = "legal";
				break;
			}
			default:
				System.out.println("Please enter valid department number");
			}
		}

		Employee emp = new Employee(fn, ln, department, company);

		CredentialsService credService = new CredentialsService();
		if(emp.getFn()!=null && emp.getFn()!=null && emp.getLn()!=null && emp.getDepartment()!=null && emp.getCompany()!=null) {			
			credService.generateEmail(emp);
			credService.generatePassword(emp);
			credService.showCredentials(emp);
		}
	}

}
