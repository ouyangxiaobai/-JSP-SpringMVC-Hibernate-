package com.xafdy.entity;
// Generated 2018-4-23 22:10:40 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Foods generated by hbm2java
 */
@Entity
@Table(name = "foods", catalog = "lvyou")
public class Foods implements java.io.Serializable {

	private Integer id;
	private Item item;
	private String name;
	private String path;

	public Foods() {
	}

	public Foods(Item item, String name) {
		this.item = item;
		this.name = name;
	}

	public Foods(Item item, String name, String path) {
		this.item = item;
		this.name = name;
		this.path = path;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "item_id", nullable = false)
	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Column(name = "name", nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "path", length = 65535)
	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
