package com.reshma;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanService {
	LoanDAOContractor lcon;

	@Autowired
	public LoanService(LoanDAOContractor lcon) {
		this.lcon = lcon;
	}

	public boolean verifycredentials(String user, String password) {
		boolean check = false;
		List<User> ls = lcon.getAllCredentials();
		for (User c : ls) {
			if (c.getUsername().equals(user) && c.getPassword().equals(password)) {
				check = true;
				break;
			}
		}
		return check;
	}

	public String verifyUser(String user, String password) {
		String type = "";
		List<User> ls = lcon.getAllCredentials();
		for (User c : ls) {
			if (c.getUsername().equals(user) && c.getPassword().equals(password)) {
				type = c.getUsertype();
				break;
			}
		}
		return type;
	}

	public int findUserId(String user, String password) {
		List<User> ls = lcon.getAllCredentials();
		for (User c : ls) {
			if (c.getUsername().equals(user) && c.getPassword().equals(password)) {
				return c.getUserid();
			}
		}
		return 0;
	}
}
