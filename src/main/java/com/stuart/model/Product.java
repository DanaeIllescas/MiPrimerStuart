package com.stuart.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")

public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idproduct")
	private int idproduct;

	@Column(name = "title", nullable = false, length = 100)
	private String title;

	@Column(name = "technique", nullable = false, length = 45)
	private String technique;

	@Column(name = "materials", nullable = false, length = 45)
	private String materials;

	@Column(name = "width", nullable = false)
	private int width;

	@Column(name = "height", nullable = false)
	private int height;

	@Column(name = "depth", nullable = false)
	private int depth;

	@Column(name = "description_product", nullable = false, length = 250)
	private String description_product;

	@Column(name = "price", nullable = false)
	private float price;

	@Column(name = "terms_conditions", nullable = false)
	private boolean terms_conditions;
	
	@Column(name = "url", nullable = false, length = 250)
	private String url;

	@OneToOne(mappedBy="product")
	private Order order;

	@ManyToOne
	@JoinColumn(name = "artist_idartist")
	private Artist artist;

	public Product() {
		super();
	}

	public Product(int idproduct, String title, String technique, String materials, int width, int height, int depth,
			String description_product, float price, boolean terms_conditions, String url, Order order, Artist artist) {
		super();
		this.idproduct = idproduct;
		this.title = title;
		this.technique = technique;
		this.materials = materials;
		this.width = width;
		this.height = height;
		this.depth = depth;
		this.description_product = description_product;
		this.price = price;
		this.terms_conditions = terms_conditions;
		this.url = url;
		this.order = order;
		this.artist = artist;
	}

	public int getIdproduct() {
		return idproduct;
	}

	public void setIdproduct(int idproduct) {
		this.idproduct = idproduct;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTechnique() {
		return technique;
	}

	public void setTechnique(String technique) {
		this.technique = technique;
	}

	public String getMaterials() {
		return materials;
	}

	public void setMaterials(String materials) {
		this.materials = materials;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public String getDescription_product() {
		return description_product;
	}

	public void setDescription_product(String description_product) {
		this.description_product = description_product;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public boolean isTerms_conditions() {
		return terms_conditions;
	}

	public void setTerms_conditions(boolean terms_conditions) {
		this.terms_conditions = terms_conditions;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	@Override
	public String toString() {
		return "Product [idproduct=" + idproduct + ", title=" + title + ", technique=" + technique + ", materials="
				+ materials + ", width=" + width + ", height=" + height + ", depth=" + depth + ", description_product="
				+ description_product + ", price=" + price + ", terms_conditions=" + terms_conditions + ", url=" + url
				+ ", order=" + order + ", artist=" + artist + "]";
	}
}