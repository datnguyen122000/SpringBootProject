package com.example.Project.services.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Project.dao.BrandDao;
import com.example.Project.dao.CategoryDao;
import com.example.Project.dao.ImgDao;
import com.example.Project.dao.ProductDao;
import com.example.Project.entities.Category;
import com.example.Project.entities.Product;
import com.example.Project.model.ProductDTO;
import com.example.Project.repository.BrandRepository;
import com.example.Project.repository.CategoryRepository;
import com.example.Project.repository.ImgRepository;
import com.example.Project.repository.ProductRepository;
import com.example.Project.services.BrandService;
import com.example.Project.services.CategoryService;
import com.example.Project.services.ImgService;
import com.example.Project.services.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private BrandRepository brandRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ImgRepository imgRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	private CategoryDao categoryDao;

	@Autowired
	private ImgDao imgDao;

	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private BrandDao brandDao;
	
	@Autowired
	private BrandService brandService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ImgService imgService;
	
	@Override
	public void addProduct(ProductDTO productDTO) {
		Product product=new Product();
		product.setName(productDTO.getName());
		product.setDescription(productDTO.getDescription());
		product.setDetail(productDTO.getDetail());
		product.setPrice(productDTO.getPrice());
		product.setBrand(brandDao.getBrand(productDTO.getBrand_id()));
		product.setStar_evalue(0);
		product.setSize(productDTO.getSize());
		product.setColor(productDTO.getColor());
		product.setCategory(categoryDao.getCategory(productDTO.getCategory_id()));
		product.setQuantity(productDTO.getQuantity());
		product.setImage(imgDao.getImage(productDTO.getMain_img()));
		product.setStatus(1);
		
		
		productDao.addProduct(product);
	}

	@Override
	public List<ProductDTO> getAllProduct() {
		List<Product> products=productDao.getAllProduct();
		List<ProductDTO> productDTOs=new ArrayList<ProductDTO>();
		for (Product p : products) {
			ProductDTO productDTO=new ProductDTO();
			productDTO.setId(p.getId());
			productDTO.setName(p.getName());
			productDTO.setDescription(p.getDescription());
			productDTO.setDetail(p.getDetail());
			productDTO.setPrice(p.getPrice());
			productDTO.setBrand_id(p.getBrand().getId());
			productDTO.setStar_evalue(p.getStar_evalue());
			productDTO.setSize(p.getSize());
			productDTO.setColor(p.getColor());
			productDTO.setCategory_id(p.getCategory().getId());
			productDTO.setQuantity(p.getQuantity());
			productDTO.setMain_img(p.getImage().getId());
			productDTO.setStatus(p.getStatus());
			
			productDTO.setBrand(brandService.getBrand(p.getBrand().getId()));
			productDTO.setCategory(categoryService.getCategory(p.getCategory().getId()));
			productDTO.setImg(imgService.getImage(p.getImage().getId()));
			
			productDTOs.add(productDTO);
		}
		return productDTOs;
	}

	@Override
	public void updateProduct(ProductDTO productDTO) {
		Product product=productRepository.getById(productDTO.getId());
		if(product!=null) {
			product=modelMapper.map(productDTO, Product.class);
			product.setBrand(brandRepository.getById(productDTO.getBrand_id()));
			product.setCategory(categoryRepository.getById(productDTO.getCategory_id()));
			product.setImage(imgRepository.getById(productDTO.getMain_img()));;
			productRepository.save(product);
		}
	}

	@Override
	public ProductDTO getById(int id) {
		// TODO Auto-generated method stub
		Product product=productRepository.getById(id);
		ProductDTO productDTO =modelMapper.map(product, ProductDTO.class);
		return productDTO;
		
	}

	@Override
	public List<ProductDTO> productSearch(String txtSearch) {
		// TODO Auto-generated method stub
		List<Product> productSearch=productRepository.findByNameLike(txtSearch);
		
		List<ProductDTO> productDTOSearch=new ArrayList<ProductDTO>();
		for (Product p : productSearch) {
			ProductDTO productDTO =modelMapper.map(p, ProductDTO.class);
			productDTOSearch.add(productDTO);
		}
		return productDTOSearch;
	}
	
	

}
