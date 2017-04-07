// Falta sobrescrever o equals e hashcode

import java.util.*;

public class Aluno{

private int idAluno;
private String dataMatricula;
private int diaMatricula;
private int mesMatricula;
private int anoMatricula;
private String nome;
private String endereco;
private int telefone;
private String dataNascimento;
private int diaNascimento;
private int mesNascimento;
private int anoNascimento;

private float altura;
private int peso; 	


public String toString(){
return new Integer(idAluno).toString()+" "+nome+" "+endereco+" "+telefone+" "+altura+" "+peso+" "+dataNascimento+" "+dataMatricula;
}

public Aluno(){

	
}	

public int getIdAluno(){
	return idAluno;
	}
public String getDataMatricula(){
	return dataMatricula;
	}
public String getNome(){
	return nome;
	}
public String getEndereco(){
	return endereco;
	}
public int getTelefone(){
	return telefone;
	}
public String getDataNascimento(){
	return dataNascimento;
	}
public float getAltura(){
	return altura;
	}
public int getPeso(){
	return peso;
	}

public int getDiaMatricula(){
	return diaMatricula;	
	}
public int getMesMatricula(){
	return mesMatricula;	
	}
public int getAnoMatricula(){
	return anoMatricula;	
	}
public int getDiaNascimento(){
	return diaNascimento;
	}
public int getMesNascimento(){
	return mesNascimento;
	}
public int getAnoNascimento(){
	return anoNascimento;
	}

	
	
public void setDataMatricula(String dataMatricula){
	this.dataMatricula = dataMatricula;
	this.diaMatricula = new Integer(dataMatricula.split("-")[0]).intValue(); 
	this.mesMatricula = new Integer(dataMatricula.split("-")[1]).intValue()-1;
	this.anoMatricula = new Integer(dataMatricula.split("-")[2]).intValue();
	}
public void setNome(String nome){
	this.nome = nome; 
	}
public void setEndereco(String endereco){
	this.endereco = endereco; 
	}
public void setTelefone(int telefone){
	this.telefone = telefone; 
	}
public void setDataNascimento(String dataNascimento){
	this.dataNascimento = dataNascimento;
	this.diaNascimento = new Integer(dataNascimento.split("-")[0]).intValue(); 
	this.mesNascimento = new Integer(dataNascimento.split("-")[1]).intValue()-1;
	this.anoNascimento = new Integer(dataNascimento.split("-")[2]).intValue();
}
public void setAltura(float altura){
	this.altura = altura; 
	}
public void setPeso(int peso){
	this.peso = peso; 
	}
public void setIdAluno(int idAluno){
	this.idAluno = idAluno; 
	}	
}