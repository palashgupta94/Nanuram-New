package com.projectNanuram.entity;

public class ColorTest {

	@Override
	public String toString() {
		return "ColorTest [colorId=" + colorId + ", colorCode=" + colorCode + "]";
	}
	public String getColorId() {
		return colorId;
	}
	public void setColorId(String colorId) {
		this.colorId = colorId;
	}
	public String getColorCode() {
		return colorCode;
	}
	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}
	
	public ColorTest() {};
	
	public ColorTest(String colorId, String colorCode) {
		super();
		this.colorId = colorId;
		this.colorCode = colorCode;
	}
	String colorId;
	String colorCode;
}
