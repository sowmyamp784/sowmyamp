package com.training.bean;

public class RegisterBean {

	private String fName;
	private String lName;
	private String email;
	private String tel;
	private String add1;
	private String add2;
	private String city;
	private String pcode;
	private String country;
	private String region;
	private String password;
	private String confirmPass;

	public RegisterBean() {
	}

	public RegisterBean(String fName, String lName, String email, String tel, String add1, String add2, String city,
			String pcode, String country, String region, String password, String confirmPass) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.tel = tel;
		this.add1 = add1;
		this.add2 = add2;
		this.city = city;
		this.pcode = pcode;
		this.country = country;
		this.region = region;
		this.password = password;
		this.confirmPass = confirmPass;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAdd1() {
		return add1;
	}

	public void setAdd1(String add1) {
		this.add1 = add1;
	}

	public String getAdd2() {
		return add2;
	}

	public void setAdd2(String add2) {
		this.add2 = add2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPass() {
		return confirmPass;
	}

	public void setConfirmPass(String confirmPass) {
		this.confirmPass = confirmPass;
	}

	public String toString() {
		return "RegisterBean [fName=" + fName + ", lName=" + lName + ", email=" + email + ", tel=" + tel + ", addr1="
				+ add1 + ", addr2=" + add2 + ", city=" + city + ", pcode=" + pcode + ", country=" + country
				+ ", region=" + region + ", password=" + password + ", confirmpassword=" + confirmPass + "]";
	}
}
