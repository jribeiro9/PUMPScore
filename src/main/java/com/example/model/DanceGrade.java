package com.example.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "danceGrades")
public class DanceGrade implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "level")
	private int level;

	@Column(name = "perfects")
	private int perfects;

	@Column(name = "greats")
	private int greats;
	
	@Column(name = "goods")
	private int goods;
	
	@Column(name = "bads")
	private int bads;
	
	@Column(name = "miss")
	private int miss;
	
	@Column(name = "max_combo")
	private int max_combo;
	
	@Column(name = "score")
	private int score;
	
	@Column(name = "grade")
	private String grade;
	
	@ManyToOne
	@JoinColumn(name="module_id")
	private Module module;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getPerfects() {
		return perfects;
	}

	public void setPerfects(int perfects) {
		this.perfects = perfects;
	}

	public int getGreats() {
		return greats;
	}

	public void setGreats(int greats) {
		this.greats = greats;
	}

	public int getGoods() {
		return goods;
	}

	public void setGoods(int goods) {
		this.goods = goods;
	}

	public int getBads() {
		return bads;
	}

	public void setBads(int bads) {
		this.bads = bads;
	}

	public int getMiss() {
		return miss;
	}

	public void setMiss(int miss) {
		this.miss = miss;
	}

	public int getMax_combo() {
		return max_combo;
	}

	public void setMax_combo(int max_combo) {
		this.max_combo = max_combo;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

}