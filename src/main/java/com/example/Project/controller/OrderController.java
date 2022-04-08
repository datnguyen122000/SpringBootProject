package com.example.Project.controller;

import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Project.entities.Product;
import com.example.Project.model.OrderDTO;
import com.example.Project.model.OrderItemDTO;
import com.example.Project.model.ProductDTO;
import com.example.Project.services.ProductService;

@Controller
public class OrderController {
	@Autowired
	private ProductService productService;
	
	@GetMapping("add-to-cart")
	public String addToCart(HttpSession session,@RequestParam("id") int id) {
		ProductDTO productDTO=productService.getById(id);
		if(session.getAttribute("order")== null){
			OrderItemDTO orderItemDTO=new OrderItemDTO();
			orderItemDTO.setNumber(1);
			orderItemDTO.setProductDTO(productDTO);
			
			List<OrderItemDTO> orderItemDTOs=new ArrayList<OrderItemDTO>();
			orderItemDTOs.add(orderItemDTO);
			
			OrderDTO orderDTO=new OrderDTO();
			orderDTO.setItemDTOs(orderItemDTOs);
			
			System.out.println(orderDTO);
			
			session.setAttribute("order", orderDTO);
		}else {
			OrderDTO orderDTO=(OrderDTO) session.getAttribute("order");
			boolean flag=false; //biến flag để đánh dấu xem sản phẩm product đã tồn tại trong giỏ hàng chưa, false là chưa tồn tại, true là đã tồn tại
			for (OrderItemDTO o : orderDTO.getItemDTOs()) {
				if(o.getProductDTO().getId()==id) {
					o.setNumber(o.getNumber()+1);
					flag=true;
				}
			}
			
			if(!flag) {//trường hợp sản phẩm không có trong giỏ hàng
				OrderItemDTO orderItemDTO=new OrderItemDTO();
				orderItemDTO.setNumber(1);
				orderItemDTO.setProductDTO(productDTO);
				
				orderDTO.getItemDTOs().add(orderItemDTO);
			}
			session.setAttribute("order", orderDTO);
		}
		
		return "redirect:/view-cart";
	}
	
	@GetMapping("/delete-cart/{id}")
	public String deleteCart(HttpSession session, @RequestParam(value="id",required = true) int id) {
		if(session.getAttribute("order")!=null) {
			OrderDTO orderDTO=(OrderDTO) session.getAttribute("order");
			for (int i = 0; i < orderDTO.getItemDTOs().size(); i++) {
				if(orderDTO.getItemDTOs().get(i).getProductDTO().getId()==id) {
					orderDTO.getItemDTOs().remove(i);
					break;
				}
			}
//			if(orderDTO.getItemDTOs().isEmpty()) {
//				session.removeAttribute("cart");
//			}
			session.setAttribute("order", orderDTO);
		}
		return "redirect:/view-cart";
	}
	
	@GetMapping("/view-cart")
	public String viewCart(HttpSession session,HttpServletRequest request) {
		
		OrderDTO orderDTO=(OrderDTO) session.getAttribute("order");
		// tính tông tiền
		int total=0;
		for (OrderItemDTO o  : orderDTO.getItemDTOs()) {
			total+=o.getNumber()*o.getProductDTO().getPrice();
		}
		
		request.setAttribute("total", total);
		request.setAttribute("order", orderDTO);
		return "cart";
	}
	
}
