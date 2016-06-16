package com.micro.entity;

import java.util.Date;

public class House {
	private Long houseId;

	private Long houseType;

	private Long userId;

	private String houseName;

	private String houseAddress;

	private Long housePrice;

	private Integer houseArea;

	private Long houseRegion;

	private Date createTime;

	private Long ownUser;

	private Integer status;

	// 手工添加
	private String userName;

	private String type;

	private String region;

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getHouseId() {
		return houseId;
	}

	public void setHouseId(Long houseId) {
		this.houseId = houseId;
	}

	public Long getHouseType() {
		return houseType;
	}

	public void setHouseType(Long houseType) {
		this.houseType = houseType;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getHouseName() {
		return houseName;
	}

	public void setHouseName(String houseName) {
		this.houseName = houseName == null ? null : houseName.trim();
	}

	public String getHouseAddress() {
		return houseAddress;
	}

	public void setHouseAddress(String houseAddress) {
		this.houseAddress = houseAddress == null ? null : houseAddress.trim();
	}

	public Long getHousePrice() {
		return housePrice;
	}

	public void setHousePrice(Long housePrice) {
		this.housePrice = housePrice;
	}

	public Integer getHouseArea() {
		return houseArea;
	}

	public void setHouseArea(Integer houseArea) {
		this.houseArea = houseArea;
	}

	public Long getHouseRegion() {
		return houseRegion;
	}

	public void setHouseRegion(Long houseRegion) {
		this.houseRegion = houseRegion;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getOwnUser() {
		return ownUser;
	}

	public void setOwnUser(Long ownUser) {
		this.ownUser = ownUser;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}