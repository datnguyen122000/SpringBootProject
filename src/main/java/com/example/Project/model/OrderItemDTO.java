package com.example.Project.model;

public class OrderItemDTO {
	private int number;
	private ProductDTO productDTO;

	public OrderItemDTO() {
		super();
	}

	public OrderItemDTO(int number, ProductDTO productDTO) {
		super();
		this.number = number;
		this.productDTO = productDTO;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public ProductDTO getProductDTO() {
		return productDTO;
	}

	public void setProductDTO(ProductDTO productDTO) {
		this.productDTO = productDTO;
	}

	@Override
	public String toString() {
		return "OrderItemDTO [number=" + number + ", productDTO=" + productDTO + "]";
	}

}
