package com.example.Project.model;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.Project.entities.Category;
import com.example.Project.services.BrandService;
import com.example.Project.services.CategoryService;
import com.example.Project.services.ImgService;

public class ProductDTO {

	private int id;
	private String name;
	private String description;
	private String detail;
	private int price;
	private int brand_id;
	private int star_evalue;
	private int size;
	private String color;
	private int category_id;
	private int quantity;
	private int main_img;
	private int status;
	private BrandDTO brand;
	private CategoryDTO category;
	private ImageDTO img;

	public BrandDTO getBrand() {
		return brand;
	}

	public void setBrand(BrandDTO brand) {
		this.brand = brand;
	}

	public CategoryDTO getCategory() {
		return category;
	}

	public void setCategory(CategoryDTO category) {
		this.category = category;
	}

	public ImageDTO getImg() {
		return img;
	}

	public void setImg(ImageDTO img) {
		this.img = img;
	}

	public ProductDTO() {
		super();
	}

	public ProductDTO(int id, String name, String description, String detail, int price, int brand_id, int star_evalue,
			int size, String color, int category_id, int quantity, int main_img, int status) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.detail = detail;
		this.price = price;
		this.brand_id = brand_id;
		this.star_evalue = star_evalue;
		this.size = size;
		this.color = color;
		this.category_id = category_id;
		this.quantity = quantity;
		this.main_img = main_img;
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

	public int getBrand_id() {
		return brand_id;
	}

	public void setBrand_id(int brand_id) {
		this.brand_id = brand_id;
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

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getMain_img() {
		return main_img;
	}

	public void setMain_img(int main_img) {
		this.main_img = main_img;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ProductDTO [id=" + id + ", name=" + name + ", description=" + description + ", detail=" + detail
				+ ", price=" + price + ", brand_id=" + brand_id + ", star_evalue=" + star_evalue + ", size=" + size
				+ ", color=" + color + ", category_id=" + category_id + ", quantity=" + quantity + ", main_img="
				+ main_img + ", status=" + status + ", brand=" + brand + ", category=" + category + ", img=" + img
				+ "]";
	}

}
