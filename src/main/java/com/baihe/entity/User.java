package com.baihe.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@ApiModel("用户实体类")
@Table(name = "user")
public class User{

	@ApiModelProperty("用户编号")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String userid;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@ApiModelProperty("返回的token")
	@Transient
	private String newPassword;

	@ApiModelProperty("用户简介")
	@Column(name = "userinfo")
	private String userinfo;

	@Column(name = "sex")
	private String sex;
	@Column(name = "age")
	private Integer age;

	@ApiModelProperty("用户所在地区")
	@Column(name = "region")
	private String region;
	@Column(name = "phone")
	private String phone;

	@ApiModelProperty("用户地址")
	@Column(name = "address")
	private String address;

	@ApiModelProperty("出生日期")
	@Column(name = "userdate")
	private String userdate;

	@ApiModelProperty("用户身份")
	@Column(name = "identity")
	private String identity;

	@ApiModelProperty("用户身份标号")
	@Column(name = "level")
	private Integer level;

	@ApiModelProperty("验证码")
	private String code;

	public String getName() {
		return username;
	}
	public void setName(String name) {
		this.username = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserinfo() {
		return userinfo;
	}
	public void setUserinfo(String nickName) {
		this.userinfo = nickName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getUserdate() {
		return userdate;
	}
	public void setUserdate(String birthday) {
		this.userdate = birthday;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

    public void setId(String id) {
        this.userid = id;
    }
    public String getId() {
        return this.userid;
    }

}
