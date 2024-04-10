<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="url" value="/"></c:url>

<div class="py-2 px-3">
	<h5 class="text-dark fs-6 my-3">Trang chủ / Quản lý loại hình /
		Thêm mới</h5>
	<form
		class="rounded-3 overflow-hidden shadow-sm bg-white px-4 py-3 needs-validation"
		novalidate method="post">
		<!-- <div class="d-flex justify-content-between"> -->
		<h5 class="mb-4">Thêm loại hình mới</h5>
		<!-- <div>
                  <button
                    class="btn bg-first btn-sm text-white"
                    data-bs-toggle="modal"
                    data-bs-target="#modalRapphim"
                  >
                    <i class="ri-file-add-line"></i> Thêm mới
                  </button>
                </div> -->
		<!-- </div> -->
		<div class="row g-3 mb-3">
			<input type="text" name="maHangGhe" value="${hangGhe.maHangGhe}"
				hidden>
			<div class="col-6">
				<div>
					<label class="form-label text-sm text-dark fw-bolder mb-1">Tên
						hàng ghế</label> <input type="text" class="form-control form-control-sm"
						required pattern="(.|\n)*\S(.|\n)*" value="${hangGhe.tenHangGhe}"
						name="tenHangGhe" placeholder="Nhập tên hàng ghế" />
					<div class="invalid-feedback text-danger" style="font-size: 12px">Tên
						hàng ghế không để trống!</div>
				</div>
			</div>
		</div>

		<div class="d-block text-end">
			<a href="${url}admin/loaihinhs"
				class="btn btn-sm bg-danger text-white">Hủy</a>
			<button formaction="updatehangghe"
				class="btn btn-sm bg-first text-white">Cập nhật</button>
		</div>
	</form>

	<div>
		<div></div>
	</div>
</div>
<script type="text/javascript">// Example starter JavaScript for disabling form submissions if there are invalid fields
(() => {
	  'use strict'

	  // Fetch all the forms we want to apply custom Bootstrap validation styles to
	  const forms = document.querySelectorAll('.needs-validation')

	  // Loop over them and prevent submission
	  Array.from(forms).forEach(form => {
	    form.addEventListener('submit', event => {
	      if (!form.checkValidity()) {
	        event.preventDefault()
	        event.stopPropagation()
	      }

	      form.classList.add('was-validated')
	    }, false)
	  })
	})()</script>