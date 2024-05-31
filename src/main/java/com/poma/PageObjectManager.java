package com.poma;

import com.POM.AdminPOM;
import com.POM.LoginPOM;
import com.base.BaseClass;

public class PageObjectManager extends BaseClass{
	
	private LoginPOM lp;
	private AdminPOM ap;
	
	public  LoginPOM getLoginpage() {
		if(lp == null) {
			lp = new LoginPOM(driver);
		}
	return lp;
	}
	
	public AdminPOM getAdminpage() {
		if(ap==null) {
			ap = new AdminPOM(driver);
			}
		return ap;
	}
	

	
}
