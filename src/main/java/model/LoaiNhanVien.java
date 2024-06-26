package model;

import java.util.List;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "LoaiNhanVien")
public class LoaiNhanVien {

	@Id
	@Column(name = "maLoaiNhanVien")
	@GenericGenerator(name = "sequence_loainhanvien_id",strategy = "helper.LoaiNhanVienGeneratorID")
	@GeneratedValue(generator = "sequence_loainhanvien_id")
	private String maLoaiNhanVien;
	
	@Column(name = "tenLoaiNhanVien")
	private String tenLoaiNhanVien;
	
	@OneToMany(mappedBy = "loaiNhanVien")
	List<NhanVien> nhanViens;

	public LoaiNhanVien() {
		
	}

	public String getMaLoaiNhanVien() {
		return maLoaiNhanVien;
	}

	public void setMaLoaiNhanVien(String maLoaiNhanVien) {
		this.maLoaiNhanVien = maLoaiNhanVien;
	}

	public String getTenLoaiNhanVien() {
		return tenLoaiNhanVien;
	}

	public void setTenLoaiNhanVien(String tenLoaiNhanVien) {
		this.tenLoaiNhanVien = tenLoaiNhanVien;
	}

	public List<NhanVien> getNhanViens() {
		return nhanViens;
	}

	public void setNhanViens(List<NhanVien> nhanViens) {
		this.nhanViens = nhanViens;
	}
	
	
}
