package com.example.Project;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.Project.services.impl.UserLoginServiceImpl;

@SpringBootApplication
//@EntityScan(basePackages = {"com.example.Project.entities"})
public class ProjectApplication extends WebSecurityConfigurerAdapter {

	@Autowired
	UserLoginServiceImpl loginServiceImpl;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//tắt cái chông tấn công từ cross side tự tìm hiểu thêm và mọi request đều phải xác thực,/store và /test2 thì không phải login ai cx vào được
		http.csrf().disable().authorizeRequests().antMatchers("/store").permitAll()
		.antMatchers("/test2").permitAll()
		.antMatchers("/category-management/danh-sach-category").permitAll()
		.antMatchers("/category-management/them-category").permitAll()
		//tài khoản có role là ADMIN mới được login vào category-management/categories,swagger những role khác thì k được truy cập vào
		.antMatchers("/category-management/categories").hasAnyRole("ADMIN")
		.antMatchers("/swagger").hasAnyRole("ADMIN")
		.anyRequest().authenticated().and()
		//cửa sổ login mặc định
//		.httpBasic();
		//đến một trang login khác. Nếu login thành công trả về trang store không thành công thì trả về trang login có parameter err
		//permitAll().and().logout().permitAll() tức là cho phép login và logout đều đc phép mà k cần phải xác thực
		.formLogin().loginPage("/login").defaultSuccessUrl("/store").failureUrl("/login?e=err").permitAll().and().logout().permitAll()
		//dòng dưới xử lí cho trường hợp đăng nhập với role k cho phép đăng nhập vào đường dẫn ấy thì trả về trang login vs cái lỗi "deny"
		.and().exceptionHandling().accessDeniedPage("/login?e=deny");
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		//cấu hình không cần xác thực cho những đường dẫn này
		web.ignoring().antMatchers("/css/**","/js/**","/img/**","/fonts/**","/Image/**"); //cái này ạ e de y duong dan. no bat dau /css, chu ko co /category-mângement
		
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		///đăng nhâp tại đây
		
		auth.userDetailsService(loginServiceImpl).passwordEncoder(passwordEncoder());
//		auth.inMemoryAuthentication().withUser("admin").password("{noop}123").roles("ADMIN");
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder(12);
		return bCryptPasswordEncoder;
	}
	
	@Bean 
	public ModelMapper modelMapper() {
		ModelMapper modelMapper=new ModelMapper();
		modelMapper.getConfiguration().setFieldMatchingEnabled(true).setFieldAccessLevel(Configuration.AccessLevel.PRIVATE)
		.setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapper;
	}
}
