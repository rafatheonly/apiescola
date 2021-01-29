package com.escola.apiescola.models;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TB_GABARITO")
public class Gabarito implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotNull
	private char r1, r2, r3, r4, r5, r6, r7, r8, r9, r10;

	@OneToOne(cascade = CascadeType.ALL)
	private Prova prova;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public char getR1() {
		return r1;
	}

	public void setR1(char r1) {
		this.r1 = r1;
	}

	public char getR2() {
		return r2;
	}

	public void setR2(char r2) {
		this.r2 = r2;
	}

	public char getR3() {
		return r3;
	}

	public void setR3(char r3) {
		this.r3 = r3;
	}

	public char getR4() {
		return r4;
	}

	public void setR4(char r4) {
		this.r4 = r4;
	}

	public char getR5() {
		return r5;
	}

	public void setR5(char r5) {
		this.r5 = r5;
	}

	public char getR6() {
		return r6;
	}

	public void setR6(char r6) {
		this.r6 = r6;
	}

	public char getR7() {
		return r7;
	}

	public void setR7(char r7) {
		this.r7 = r7;
	}

	public char getR8() {
		return r8;
	}

	public void setR8(char r8) {
		this.r8 = r8;
	}

	public char getR9() {
		return r9;
	}

	public void setR9(char r9) {
		this.r9 = r9;
	}

	public char getR10() {
		return r10;
	}

	public void setR10(char r10) {
		this.r10 = r10;
	}

	public Prova getProva() {
		return prova;
	}

	public void setProva(Prova prova) {
		this.prova = prova;
	}

}
