package com.Models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Classe {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cid;
	private String cnome;
	
	@ManyToMany(mappedBy = "classe")
	private List<Professor> professor;
	
	public Long getCid() {
		return cid;
	}
	public void setCid(Long cid) {
		this.cid = cid;
	}
	public String getCnome() {
		return cnome;
	}
	public void setCnome(String cnome) {
		this.cnome = cnome;
	}
	public List<Professor> getProfessor() {
		return professor;
	}
	public void setProfessor(List<Professor> professor) {
		this.professor = professor;
	}
}
