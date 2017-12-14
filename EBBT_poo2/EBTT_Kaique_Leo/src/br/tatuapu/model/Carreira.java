package br.tatuapu.model;

public class Carreira {

	private String classe;
	private int nivel;
	private double salario;
	private String tipo;
	private String titulacao;
	private int ano;
	
	public Carreira(String classe, int nivel, double salario, String tipo, String titulacao, int ano) {
		
		this.classe = classe;
		this.nivel = nivel;
		this.salario = salario;
		this.tipo = tipo;
		this.titulacao = titulacao;
		this.ano = ano;
		
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getTitulacao() {
		return titulacao;
	}

	public void setTitulacao(String titulacao) {
		this.titulacao = titulacao;
	}

	public String getClasse() {
		return classe;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
}
