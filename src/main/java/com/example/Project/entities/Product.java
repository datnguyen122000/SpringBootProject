package com.example.Project.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_product")
	private int id;
	private String name;
	private String description;
	private String detail;
	private int price;
	@ManyToOne
	@JoinColumn(name = "brand_id")// tên này là tên của cột trong db
	private Brand brand;
	private int star_evalue;
	private int size;
	private String color;
	@ManyToOne
	@JoinColumn(name = "category_id")// tên này là tên của cột trong db
	private Category category;
	private int quantity;
	@OneToOne
	@JoinColumn(name = "main_img")// tên này là tên của cột trong db
	private Image image;
	private int status;

	public Product() {
		super();
	}

	public Product(int id, String name, String description, String detail, int price, Brand brand, int star_evalue,
			int size, String color, Category category, int quantity, Image image, int status) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.detail = detail;
		this.price = price;
		this.brand = brand;
		this.star_evalue = star_evalue;
		this.size = size;
		this.color = color;
		this.category = category;
		this.quantity = quantity;
		this.image = image;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public int getStar_evalue() {
		return star_evalue;
	}

	public void setStar_evalue(int star_evalue) {
		this.star_evalue = star_evalue;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", detail=" + detail
				+ ", price=" + price + ", brand=" + brand + ", star_evalue=" + star_evalue + ", size=" + size
				+ ", color=" + color + ", category=" + category + ", quantity=" + quantity + ", image=" + image
				+ ", status=" + status + "]";
	}

}
