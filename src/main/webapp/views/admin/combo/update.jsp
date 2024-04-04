<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="url" value="/"></c:url>

<div class="py-2 px-3">
	<h5 class="text-dark fs-6 my-3">Trang chủ / Quản lý combo - đồ ăn
		/ Thêm mới</h5>
	<form class="rounded-3 overflow-hidden shadow-sm bg-white px-4 py-3" method="post">
		<!-- <div class="d-flex justify-content-between"> -->
		<h5 class="mb-4">Thêm combo - đồ ăn mới</h5>
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
			<input type="text" value="${combo.maCombo}" name="maCombo" hidden>
			<div class="col-6">
				<div>
					<label class="form-label text-sm text-dark fw-bolder mb-1">Tên
						combo - đồ ăn</label> <input type="text" value="${combo.tenCombo}"
						class="form-control form-control-sm" name="tenCombo"
						placeholder="Nhập tên combo - đồ ăn" />
				</div>
			</div>
			<div class="col-6">
				<div>
					<label class="form-label text-sm text-dark fw-bolder mb-1">Mô
						tả</label> <input type="text" class="form-control form-control-sm" value="${combo.moTa}"
						name="moTa" placeholder="Nhập mô tả" />
				</div>
			</div>
			<div class="col-6">
				<div>
					<label class="form-label text-sm text-dark fw-bolder">Mã
						giá combo - đồ ăn</label> <input type="number" value="${combo.giaCombo}"
						class="form-control form-control-sm" name="giaCombo"
						placeholder="Nhập giá combo - đồ ăn" />
				</div>
			</div>
		</div>

		<div class="d-block text-end">
			<a href="${url}admin/combos"
				class="btn btn-sm bg-danger text-white">Hủy</a>
			<button formaction="updatecombo" class="btn btn-sm bg-first text-white">Cập nhật</button>
		</div>
	</form>

	<div>
		<div></div>
	</div>
</div>