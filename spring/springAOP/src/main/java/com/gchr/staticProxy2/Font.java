package com.gchr.staticProxy2;

public class Font {
	private String name;
	
	private Integer type;

	
	public Font(String name, Integer type) {
		super();
		this.name = name;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Font [name=" + name + ", type=" + type + "]";
	}
	
}
