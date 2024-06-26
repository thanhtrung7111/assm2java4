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
@Table(name = "LoaiGhe")
public class LoaiGhe {
	@Id
	@Column(name = "maLoaiGhe")
	@GenericGenerator(name = "sequence_loaighe_id",strategy = "helper.LoaiGheGeneratorID")
	@GeneratedValue(generator = "sequence_loaighe_id")
	private String maLoaiGhe;
	
	@Column(name = "tenLoaiGhe")
	private String tenLoaiGhe;
	
	@Column(name = "chiPhi")
	private Double chiPhi;
	
	@OneToMany(mappedBy = "loaiGhe")
	private List<Ghe> ghes;

	public LoaiGhe() {
		
	}

	public String getMaLoaiGhe() {
		return maLoaiGhe;
	}

	public void setMaLoaiGhe(String maLoaiGhe) {
		this.maLoaiGhe = maLoaiGhe;
	}

	public String getTenLoaiGhe() {
		return tenLoaiGhe;
	}

	public void setTenLoaiGhe(String tenLoaiGhe) {
		this.tenLoaiGhe = tenLoaiGhe;
	}

	public Double getChiPhi() {
		return chiPhi;
	}

	public void setChiPhi(Double chiPhi) {
		this.chiPhi = chiPhi;
	}

	public List<Ghe> getGhes() {
		return ghes;
	}

	public void setGhes(List<Ghe> ghes) {
		this.ghes = ghes;
	}

	/**
	 * @param maLoaiGhe
	 * @param tenLoaiGhe
	 * @param chiPhi
	 * @param ghes
	 */
	public LoaiGhe(String maLoaiGhe, String tenLoaiGhe, Double chiPhi) {
		super();
		this.maLoaiGhe = maLoaiGhe;
		this.tenLoaiGhe = tenLoaiGhe;
		this.chiPhi = chiPhi;
	}
	
	
	
}
