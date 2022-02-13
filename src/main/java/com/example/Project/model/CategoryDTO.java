package com.example.Project.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

//DTO la class co the tuy bien them nhieu thuoc tinh ... cho phu hop voi logic
//DTO la class su li du lieu tu controller day sang view
//class entity chi lam viec o lop dao con tu lop control tro len thi lam viec voi lop DTO
//lop service dong vai tro convert du lieu giua 2 class
public class CategoryDTO {
	private int id;
	//đổi "name" trong postman thành "tên". Thuộc tính này để cx đc mà k để cx đc nếu k để thì mặc định nó là tên gốc (name)
	@JsonProperty(value="tên")
	private String name;
	//đổi "status" trong postman thành "trạng_thái". Thuộc tính này để cx đc mà k để cx đc nếu k để thì mặc định nó là tên gốc (status)
	@JsonProperty(value="trạng_thái")
	private int status;
	private List<ProductDTO> productDTOs;

	public List<ProductDTO> getProductDTOs() {
		return productDTOs;
	}

	public void setProductDTOs(List<ProductDTO> productDTOs) {
		this.productDTOs = productDTOs;
	}

	public CategoryDTO() {
		super();
	}

	public CategoryDTO(int id, String name, int status) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "CategoryDTO [id=" + id + ", name=" + name + ", status=" + status + "]";
	}

}
