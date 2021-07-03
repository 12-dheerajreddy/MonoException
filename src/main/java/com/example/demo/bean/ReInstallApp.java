package com.example.demo.bean;

public class ReInstallApp {
	private Integer locationCode;
	private Integer orderNumber;
	private Integer mtnNo;
	private String installationType;
	private String currentDate;

	public ReInstallApp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReInstallApp(Integer locationCode, Integer orderNumber, Integer mtnNo, String installationType,
			String currentDate) {
		super();
		this.locationCode = locationCode;
		this.orderNumber = orderNumber;
		this.mtnNo = mtnNo;
		this.installationType = installationType;
		this.currentDate = currentDate;
	}

	public Integer getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(Integer locationCode) {
		this.locationCode = locationCode;
	}

	public Integer getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Integer getMtnNo() {
		return mtnNo;
	}

	public void setMtnNo(Integer mtnNo) {
		this.mtnNo = mtnNo;
	}

	public String getInstallationType() {
		return installationType;
	}

	public void setInstallationType(String installationType) {
		this.installationType = installationType;
	}

	public String getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}

	@Override
	public String toString() {
		return "ReInstallApp [locationCode=" + locationCode + ", orderNumber=" + orderNumber + ", mtnNo=" + mtnNo
				+ ", installationType=" + installationType + ", currentDate=" + currentDate + "]";
	}
	
	
	
	
	
	
	
	
	
}
