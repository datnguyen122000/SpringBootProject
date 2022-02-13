<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<title>Electro - HTML Ecommerce Template</title>


<!-- Bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<!-- Font Awesome Icon -->
<link rel="stylesheet"
	href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
	integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p"
	crossorigin="anonymous" />

<!-- Custom stlylesheet -->
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css" />


</head>
<!-- This snippet uses Font Awesome 5 Free as a dependency. You can download it at fontawesome.io! -->

<body
	style="background-color:#D10024;">
	<div class="container">
		<div class="row">
			<div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
				<div class="card border-0 shadow rounded-3 my-5">
					<div class="card-body p-4 p-sm-5">
						<h5 class="card5-title text-center mb-5 fw-light fs-5">Sign In</h5>
						<form action="<%=request.getContextPath()%>/login" method="post">
							<c:if test="${e=='error' }">Tài khoản và mật khẩu không đúng</c:if>
							<c:if test="${e=='deny' }">Tài khoản không có quyền truy cập</c:if>
							<div class="form-floating mb-3">
							<!-- trong sercurity mặc định tên biến username phải là username, mặc định tên biến password phải là password, tên khác không nhận được -->
								<input type="text" class="form-control" id="floatingInput"
									placeholder="name@example.com" name="username"> <label
									for="floatingInput">Username</label>
							</div>
							<div class="form-floating mb-3">
								<input type="password" class="form-control"
									id="floatingPassword" placeholder="Password" name="password"> <label
									for="floatingPassword">Password</label>
							</div>

							<div class="form-check mb-3">
								<input class="form-check-input" type="checkbox" value=""
									id="rememberPasswordCheck"> <label
									class="form-check-label" for="rememberPasswordCheck">
									Remember password </label>
							</div>
							<div class="d-grid">
								<button class="btn btn-primary btn-login text-uppercase fw-bold"
									type="submit">Sign in</button>
							</div>
							<hr class="my-4">
							<div class="d-grid mb-2">
								<button class="btn btn-google btn-login text-uppercase fw-bold"
									type="submit">
									<i class="fab fa-google me-2"></i> Sign in with Google
								</button>
							</div>
							<div class="d-grid">
								<button
									class="btn btn-facebook btn-login text-uppercase fw-bold"
									type="submit">
									<i class="fab fa-facebook-f me-2"></i> Sign in with Facebook
								</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
