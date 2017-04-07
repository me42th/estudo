import java.util.*;
public class Turma{
private int idTurma; 
private String horario;
private int horarioHrs;
private int horarioMin;
private int duracao; 
private String dataInicio;
private int diaInicio;
private int mesInicio;
private int anoInicio;
private String dataFim;
private int diaFim;
private int mesFim;
private int anoFim;
private int idInstrutor;
private int idAtividade;

public int getIdInstrutor(){
	return idInstrutor;
}
public int getIdAtividade(){
	return idAtividade;
}
public int getIdTurma(){
	return idTurma;
} 
public String getHorario(){
	return horario;
}
public int getHorarioHrs(){
	return horarioHrs;
}
public int getHorarioMin(){
	return horarioMin;
}  
public int getDuracao(){
	return duracao;
} 
public String getDataInicio(){
	return dataInicio;
}
public int getDiaInicio(){
	return diaInicio;
}
public int getMesInicio(){
	return mesInicio;
}
public int getAnoInicio(){
	return anoInicio;
} 
public String getDataFim(){
	return dataFim;
}
public int getDiaFim(){
	return diaFim;
}
public int getMesFim(){
	return mesFim;
}
public int getAnoFim(){
	return anoFim;
}  

public void setIdInstrutor(int idInstrutor){
	this.idInstrutor = idInstrutor;
}
public void setIdAtividade(int idAtividade){
	this.idAtividade = idAtividade;
}
public void setIdTurma(int idTurma){
	this.idTurma = idTurma;
} 
public void setHorario(String horario){
	this.horario = horario;
	horarioHrs = new Integer(horario.split(":")[0]).intValue();
	horarioMin = new Integer(horario.split(":")[1]).intValue();
} 
public void setDuracao(int duracao){
	this.duracao = duracao;
} 
public void setDataInicio(String dataInicio){
	this.dataInicio = dataInicio;
	this.diaInicio = new Integer(dataInicio.split("-")[0]).intValue(); 
	this.mesInicio = new Integer(dataInicio.split("-")[1]).intValue()-1;
	this.anoInicio = new Integer(dataInicio.split("-")[2]).intValue();
} 

public void setDataFim(String dataFim){
	this.dataFim = dataFim;
	this.diaFim = new Integer(dataFim.split("-")[0]).intValue(); 
	this.mesFim = new Integer(dataFim.split("-")[1]).intValue()-1;
	this.anoFim = new Integer(dataFim.split("-")[2]).intValue();
} 

}

