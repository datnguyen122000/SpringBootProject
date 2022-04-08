package com.example.Project.entities;




import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "category")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_category")
	private int id;
	private String name;
	private int status;

	// cái này có hoặc không đều được (optional) giúp lấy tất cả trong product một
	// cách nhanh
	// chóng hơn
	// lazy loading nghĩa là khi nào dùng thì mới gọi đến hàm getProducts để lấy
	// thôi
	
	//thay đổi thằng có khóa chính trước mới thay đổi thằng con(khóa phụ) không có chiều ngược lại
	@OneToMany(mappedBy = "category", fetch = FetchType.LAZY,cascade = CascadeType.ALL) // là tên của thuộc tính
																							// private Category category
																							// trong lớp product; nhớ có
																							// hàm get set
	
	//LƯU Ý VỀ CASCADE :
//	 lưu ý thêm nếu sử dung :cascade =CascadeType.ALL là thay đổi dữ liệu gì ở
//	 bảng này thì bảng khác liên kết cùng cx sẽ ảnh hưởng tương tự ví dụ xóa
//	 category "thể thao" thì nhưng product "thể thao" cũng sẽ bị xóa theo, thay
//	 đổi dữ liệu ví dụ tên "thể thao" thành "abcxyz" thì dữ liệu ở product mà cx
//	 có "thể thao" cx sẽ đổi thành "abcxyz"
	
//	đã test thử trong trường hợp có cascade nếu xóa 1 thằng category thì nó cx xóa luôn những thằng product nằm trong category đó, còn nếu k có cascade thì java nó sẽ báo lỗi vì xóa category thì những thằng product khác trong category đấy bị ảnh hưởng phải xóa tay hết những thằng product trong category đấy thì sau đó mới xóa đươc category ấy

//	nhớ là cascade chỉ hoạt động theo chiều: thay đổi gì trong bảng giữ khóa chính thì những bảng còn reference tới nó sẽ thay đổi theo, chứ phải thay đổi trong bảng con (bảng giữ khóa phụ) thì bảng cha (bảng giữ khóa chính) thay đổi theo nên khi đó nó sẽ báo lỗi "child row hay child column gì đó"
	private List<Product> products;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_date")
	private Date createdDate;
	public Category() {
		super();
	}

	public Category(String name) {
		super();
		this.name = name;
	}

	public Category(String name, int status) {
		super();
		this.name = name;
		this.status = status;
	}

	public Category(int id, String name, int status) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
	}
	

	public Category(int id, String name, int status, List<Product> products, Date createdDate) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
		this.products = products;
		this.createdDate = createdDate;
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

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", status=" + status + ", products=" + products
				+ ", createdDate=" + createdDate + "]";
	}

	

}
