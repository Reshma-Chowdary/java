package com.reshma;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoanController {
	LoanService lserv;

	@Autowired
	public LoanController(LoanService lserv) {
		this.lserv = lserv;
	}

	@RequestMapping(value = "/adminlogin", method = RequestMethod.GET)
	public String adminlogin() {

		return "adminlogin";
	}

	@RequestMapping(value = "/verify", method = RequestMethod.GET)
	public String verify(Credentials cred, Model mod) {

		if (!lserv.verifycredentials(cred.getUser(), cred.getPassword()))
			return "adminlogin";
		else {
			if ("admin".equals(lserv.verifyUser(cred.getUser(), cred.getPassword()))) {
				mod.addAttribute("userid", lserv.findUserId(cred.getUser(), cred.getPassword()));
				return "adminhome";
			} else {
				mod.addAttribute("userid", lserv.findUserId(cred.getUser(), cred.getPassword()));
				return "userhome";
			}
		}
	}

	@RequestMapping(value = "/customerlogin", method = RequestMethod.GET)
	public String customerlogin() {

		return "customerlogin";
	}

	@RequestMapping(value = "/customerverify", method = RequestMethod.GET)
	public String customerverify() {

		return "customerlogin";
	}

	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	public String customer() {

		return "customerinfo";
	}

	@RequestMapping(value = "/loaninfo", method = RequestMethod.GET)
	public String loan() {

		return "loaninfo";
	}
}
