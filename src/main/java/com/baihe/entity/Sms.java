package com.baihe.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@ApiModel("短信发送类")
@Table(name = "sms")
public class Sms  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@ApiModelProperty("验证码")
	@Column(name = "code")
	private String code;

	@Column(name = "phone")
	private String phone;

	@ApiModelProperty("短信类型")
	@Column(name = "type")
	private String type;



	@Column(name = "ip")
	private String ip;
	@Column(name = "time")
	private String time;

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPhone() {
		return phone;
	}

	public void setType(String type) {
		this.type = type;
	}
	public String getType() {
		return type;
	}


    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return this.id;
    }

}
