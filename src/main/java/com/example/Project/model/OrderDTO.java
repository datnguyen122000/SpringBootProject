package com.example.Project.model;

import java.util.List;

public class OrderDTO {
	private List<OrderItemDTO> itemDTOs;

	public OrderDTO() {
		super();
	}

	public OrderDTO(List<OrderItemDTO> itemDTOs) {
		super();
		this.itemDTOs = itemDTOs;
	}

	public List<OrderItemDTO> getItemDTOs() {
		return itemDTOs;
	}

	public void setItemDTOs(List<OrderItemDTO> itemDTOs) {
		this.itemDTOs = itemDTOs;
	}

	@Override
	public String toString() {
		return "OrderDTO [itemDTOs=" + itemDTOs + "]";
	}

}
