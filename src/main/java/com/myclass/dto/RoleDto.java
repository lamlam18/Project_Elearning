package com.myclass.dto;

public class RoleDto {
	private int		id;
	private String	name;
	private	String	descripiton;
	
	public RoleDto() {}
	
	public RoleDto(int id, String name, String descripiton) {
		super();
		this.id = id;
		this.name = name;
		this.descripiton = descripiton;
	}

	public RoleDto(String name, String descripiton) {
		super();
		this.name = name;
		this.descripiton = descripiton;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescripiton() {
		return descripiton;
	}

	public void setDescripiton(String descripiton) {
		this.descripiton = descripiton;
	}
	
}
