public class Instrutor{

private int idInstrutor;
private int idTelefone; 
private int rg; 
private String nome; 
private String nascimento; 
private int diaNascimento;
private int mesNascimento;
private int anoNascimento;
private int titulacao; 
private int telefone;
private String tipoTel;

public int getIdInstrutor(){
	return idInstrutor;
	}
public int getIdTelefone(){
	return idTelefone;
	}
public int getNumTel(){
	return telefone;
	} 	
public String getTipoTel(){
	return tipoTel;
	} 	
public int getRg(){
	return rg;
	} 
public String getNome(){
	return nome;
	} 
public String getNascimento(){
	return nascimento; 
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
	
public int getTitulacao(){
	return titulacao;
	}
public void setIdInstrutor(int idInstrutor){
	this.idInstrutor = idInstrutor;
	}
public void setIdTelefone(int idTelefone){
	this.idTelefone = idTelefone;
	} 	
public void setRg(int rg){
	this.rg = rg;
	}
public void setTel(int telefone){
	this.telefone = telefone;
	}
public void setTipoTel(String tipoTel){
	this.tipoTel = tipoTel;
	}	
public void setNome(String nome){
	this.nome = nome;
	} 
public void setNascimento(String nascimento){
	this.nascimento = nascimento;
	this.diaNascimento = new Integer(nascimento.split("-")[0]).intValue(); 
	this.mesNascimento = new Integer(nascimento.split("-")[1]).intValue()-1;
	this.anoNascimento = new Integer(nascimento.split("-")[2]).intValue();
	} 
public void setTitulacao(int titulacao){
	this.titulacao = titulacao;
	}


}



