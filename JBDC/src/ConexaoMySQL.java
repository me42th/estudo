import java.sql.*;
import java.util.*;

public class ConexaoMySQL{ 
public static String status = "Não conectou..."; 

public void makeMatricula(Aluno a,Turma t) throws Exception{
	
	//ConexaoMySQL cms = new ConexaoMySQL();
	//cms.getConexaoMySQL();
	String sql = "insert into matricula" +
                " (idAluno,idTurma)" +
                " values (?,?)";
        PreparedStatement stmt = new ConexaoMySQL().getConexaoMySQL().prepareStatement(sql);
        // preenche os valores
        stmt.setInt(1, a.getIdAluno());
        stmt.setInt(2, t.getIdTurma());
		// executa
        stmt.execute();
        stmt.close();
        
		Thread.sleep(500);
	
}

public void gravaAluno(Aluno a) throws Exception{
	
	//ConexaoMySQL cms = new ConexaoMySQL();
	//cms.getConexaoMySQL();
	String sql = "insert into aluno" +
                " (dataMatricula,nome,endereco,telefone,dataNascimento,altura,peso)" +
                " values (?,?,?,?,?,?,?)";
        PreparedStatement stmt = new ConexaoMySQL().getConexaoMySQL().prepareStatement(sql);
        // preenche os valores
        //stmt.setInt(1, a.getIdAluno());
        Calendar c = Calendar.getInstance(); 
		c.set(Calendar.YEAR,a.getAnoMatricula()); 
		c.set(Calendar.MONTH,a.getMesMatricula()); 
		c.set(Calendar.DAY_OF_MONTH,a.getDiaMatricula());
		stmt.setDate(1, new java.sql.Date(c.getTimeInMillis()));
        stmt.setString(2, a.getNome());
        stmt.setString(3, a.getEndereco());
		stmt.setInt(4, a.getTelefone());
		Calendar c2 = Calendar.getInstance(); 
		c2.set(Calendar.YEAR,a.getAnoNascimento()); 
		c2.set(Calendar.MONTH,a.getMesNascimento()); 
		c2.set(Calendar.DAY_OF_MONTH,a.getDiaNascimento());
		stmt.setDate(5,new java.sql.Date(c2.getTimeInMillis()));
		stmt.setFloat(6, a.getAltura());
		stmt.setInt(7, a.getPeso());
        // executa
        stmt.execute();
        stmt.close();
        
		Thread.sleep(500);
}
public void gravaTurma(Turma t) throws Exception{
	
	//ConexaoMySQL cms = new ConexaoMySQL();
	//cms.getConexaoMySQL();
	String sql = "insert into turma" +
                " (horario,duracao,dataInicio,dataFim,idAtividade,idInstrutor)" +
                " values (?,?,?,?,?,?)";
        PreparedStatement stmt = new ConexaoMySQL().getConexaoMySQL().prepareStatement(sql);
        // preenche os valores
        
		stmt.setTime(1, new java.sql.Time(t.getHorarioHrs(),t.getHorarioMin(),0));
        stmt.setInt(2, t.getDuracao());
        Calendar c = Calendar.getInstance(); 
		c.set(Calendar.YEAR,t.getAnoInicio()); 
		c.set(Calendar.MONTH,t.getMesInicio()); 
		c.set(Calendar.DAY_OF_MONTH,t.getDiaInicio());
		stmt.setDate(3,new java.sql.Date(c.getTimeInMillis()));
		Calendar c2 = Calendar.getInstance(); 
		c2.set(Calendar.YEAR,t.getAnoFim()); 
		c2.set(Calendar.MONTH,t.getMesFim()); 
		c2.set(Calendar.DAY_OF_MONTH,t.getDiaFim());
		stmt.setDate(4,new java.sql.Date(c2.getTimeInMillis()));
		stmt.setInt(5, t.getIdAtividade());
		stmt.setInt(6, t.getIdInstrutor());
		
        // executa
        stmt.execute();
        stmt.close();
        
		Thread.sleep(500);
}
public void gravaInstrutor(Instrutor i) throws Exception{
	
	//ConexaoMySQL cms = new ConexaoMySQL();
	//cms.getConexaoMySQL();
	String sql = "insert into instrutor" +
                " (rg,nome,nascimento,titulacao)" +
                " values (?,?,?,?)";
        PreparedStatement stmt = new ConexaoMySQL().getConexaoMySQL().prepareStatement(sql);
        // preenche os valores
        
		stmt.setInt(1,i.getRg());
        stmt.setString(2, i.getNome());
        Calendar c = Calendar.getInstance(); 
		c.set(Calendar.YEAR,i.getAnoNascimento()); 
		c.set(Calendar.MONTH,i.getMesNascimento()); 
		c.set(Calendar.DAY_OF_MONTH,i.getDiaNascimento());
		stmt.setDate(3,new java.sql.Date(c.getTimeInMillis()));
		stmt.setInt(4, i.getTitulacao());

		
        // executa
        stmt.execute();
		sql = "select idinstrutor from instrutor where rg = "+i.getRg();
		stmt = new ConexaoMySQL().getConexaoMySQL().prepareStatement(sql);
		ResultSet worker = stmt.executeQuery();
		worker.next();
		i.setIdInstrutor(new Integer(worker.getString("idInstrutor")).intValue());
		sql = "insert into telefone_instrutor" +
                " (numero,tipo,idinstrutor)" +
                " values (?,?,?)";
		stmt = new ConexaoMySQL().getConexaoMySQL().prepareStatement(sql);
		stmt.setInt(1,i.getNumTel());
        stmt.setString(2, i.getTipoTel());
		stmt.setInt(3,i.getIdInstrutor());
		stmt.execute();
		stmt.close();
        Thread.sleep(500);
}
public void gravaAtividade(Atividade a) throws Exception{
	
	//ConexaoMySQL cms = new ConexaoMySQL();
	//cms.getConexaoMySQL();
	String sql = "insert into atividade" +
                " (nome)" +
                " values (?)";
        PreparedStatement stmt = new ConexaoMySQL().getConexaoMySQL().prepareStatement(sql);
        // preenche os valores
        
		stmt.setString(1,a.getNome());
		
        // executa
        stmt.execute();
        stmt.close();
        
		Thread.sleep(500);
}

public String getTurmasAluno(String value) throws Exception{
	String resposta = "\n\nMatriculada nas turmas de:\n";
	String sql = "de brinks";
	PreparedStatement stmt = null;
      
  
		 Integer.parseInt(value);  
		 sql = "select * from (((aluno a join matricula b on a.idaluno = b.idaluno) join turma c on c.idturma = b.idturma) join atividade d on c.idatividade = d.idatividade) join instrutor e on e.idinstrutor = c.idinstrutor where a.idAluno = "+value;
		 stmt = new ConexaoMySQL().getConexaoMySQL().prepareStatement(sql);	

		 
	
	ResultSet worker = stmt.executeQuery();
	int cont = 1;
    try{
	while(worker.absolute(cont++))
	{
	resposta = resposta 
				+"\n"+worker.getString("idturma")+"|"+worker.getString("d.nome")
				+"\n Horario "+worker.getString("c.horario")
				+"\n Inicio "+worker.getString("c.dataInicio") 
				+"\n Termina "+worker.getString("c.dataFim")
				+"\n Instrutor "+worker.getString("e.nome")+"\n";
	}
	}catch(Exception ex){resposta = "";}
	stmt.close();
    return resposta;
}

public String getTurmasInstrutor(String value) throws Exception{
	String resposta = "\n\nResp pelas turmas:\n";
	String sql = "de brinks";
	PreparedStatement stmt = null;
      
  
		 Integer.parseInt(value);  
		 sql = "select * from (instrutor a join turma b on a.idinstrutor = b.idinstrutor) join atividade d on b.idatividade = d.idatividade where a.idinstrutor = "+value;
		 stmt = new ConexaoMySQL().getConexaoMySQL().prepareStatement(sql);	

		 
	
	ResultSet worker = stmt.executeQuery();
	int cont = 1;
    try{
	while(worker.absolute(cont++))
	{
	resposta = resposta 
				+"\n"+worker.getString("idturma")+"|"+worker.getString("d.nome")
				+"\n Horario "+worker.getString("b.horario")
				+"\n Inicio "+worker.getString("b.dataInicio") 
				+"\n Termina "+worker.getString("b.dataFim")+"\n";
	}
	}catch(Exception ex){resposta = "";}
	stmt.close();
    return resposta;
}


public String getAlunosTurma(String value) throws Exception{
	String resposta = "";
	String sql = "de brinks";
	PreparedStatement stmt = null;
    
		 Integer.parseInt(value);  
		 sql = "select * from ((turma a join matricula b on a.idturma = b.idturma) join aluno c on c.idaluno = b.idaluno) join instrutor d on a.idinstrutor = d.idinstrutor where a.idTurma = "+value;
		 stmt = new ConexaoMySQL().getConexaoMySQL().prepareStatement(sql);	
	
	//colocar o get do instrutor	
	ResultSet worker = stmt.executeQuery();
	int cont = 1;
    try{
	while(worker.absolute(cont++))
	{
	if(cont == 2)	
	resposta = "\nInstrutor :"+worker.getString("d.nome");	
	resposta = resposta				
				+"\n"+worker.getString("c.idaluno")+"|"+worker.getString("c.nome");
	}
	}catch(Exception ex){}
	stmt.close();
    return resposta;
}


public ArrayList<String> getAlunos(String value) throws Exception{
	ArrayList<String> resposta = new ArrayList<String>();
	String sql = "de brinks";
	PreparedStatement stmt = null;
      
	try
	{  
		 Integer.parseInt(value);  
		 sql = "select * from aluno where idAluno = ?";
		 stmt = new ConexaoMySQL().getConexaoMySQL().prepareStatement(sql);	
		 stmt.setInt(1,new Integer(value).intValue());

	}
	catch(NumberFormatException e)
	{  
		 sql = "select * from aluno where nome like '"+value+"%' ";
		 stmt = new ConexaoMySQL().getConexaoMySQL().prepareStatement(sql);
		

	}
	ResultSet worker = stmt.executeQuery();
	int cont = 1;
    while(worker.absolute(cont++))
	{
	resposta.add(
						worker.getString("idAluno")+"|"+worker.getString("nome")
						+" Nasc "+worker.getString("dataNascimento")
						+" Alt "+worker.getString("altura")
						+" Peso "+worker.getString("peso")
						+"\n  End "+worker.getString("endereco")
						+" Tel "+worker.getString("telefone")
						+"\n  Matr "+worker.getString("dataMatricula") 
						+getTurmasAluno(worker.getString("idAluno"))
						);
	}
	stmt.close();
   
	
	return resposta;
}

public ArrayList<String> getInstrutores(String value) throws Exception{
	ArrayList<String> resposta = new ArrayList<String>();
	String sql = "de brinks";
	PreparedStatement stmt = null;
      
	try
	{  
		 Integer.parseInt(value);  
		 sql = "select a.*,b.numero,b.tipo from instrutor a join telefone_instrutor b on a.idInstrutor = b.idInstrutor where a.idInstrutor = ?";
		 stmt = new ConexaoMySQL().getConexaoMySQL().prepareStatement(sql);	
		 stmt.setInt(1,new Integer(value).intValue());

	}
	catch(NumberFormatException e)
	{  
		 sql = "select a.*,b.numero,b.tipo from instrutor a join telefone_instrutor b on a.idInstrutor = b.idInstrutor where a.nome like '"+value+"%' ";
		 stmt = new ConexaoMySQL().getConexaoMySQL().prepareStatement(sql);
		

	}
	ResultSet worker = stmt.executeQuery();
	int cont = 1;
    while(worker.absolute(cont++))
	{
	resposta.add(
						worker.getString("idInstrutor")+"| "+worker.getString("nome")
						+" Nasccimento "+worker.getString("nascimento")
						+" Titulacao "+worker.getString("titulacao")
						+" RG "+worker.getString("rg")
						+"\n    Telefone "+worker.getString("tipo")+" "+worker.getString("numero")
						+getTurmasInstrutor(worker.getString("idInstrutor")));
	}
	stmt.close();
   
	
	return resposta;
}

public ArrayList<String> getTurmas(String value) throws Exception{
	ArrayList<String> resposta = new ArrayList<String>();
	String sql = "de brinks";
	PreparedStatement stmt = null;
      
	try
	{  
		 Integer.parseInt(value);  
		 sql = "select a.*,b.nome from turma a join atividade b on a.idatividade = b.idatividade where a.idTurma = ?";
		 stmt = new ConexaoMySQL().getConexaoMySQL().prepareStatement(sql);	
		 stmt.setInt(1,new Integer(value).intValue());

	}
	catch(NumberFormatException e)
	{  
		 sql = "select a.*,b.nome from turma a join atividade b on a.idatividade = b.idatividade where b.nome like '"+value+"%' ";
		 stmt = new ConexaoMySQL().getConexaoMySQL().prepareStatement(sql);
	}
	ResultSet worker = stmt.executeQuery();
	int cont = 1;
    while(worker.absolute(cont++))
	{
	resposta.add(
				worker.getString("idturma")+"| Turma de "+worker.getString("nome")
				+"\nHorario "+worker.getString("horario")
				+"\nDuração "+worker.getString("duracao")+" hrs"
				+"\nInicio "+worker.getString("dataInicio") 
				+"\nTermina "+worker.getString("dataFim")
				+getAlunosTurma(worker.getString("idturma"))
			);
	}
	stmt.close();
   
	
	return resposta;
}

public ArrayList<String> getAtividades(String value) throws Exception{
	ArrayList<String> resposta = new ArrayList<String>();
	String sql = "de brinks";
	PreparedStatement stmt = null;
      
	try
	{  
		 Integer.parseInt(value);  
		 sql = "select * from atividade where idatividade = ?";
		 stmt = new ConexaoMySQL().getConexaoMySQL().prepareStatement(sql);	
		 stmt.setInt(1,new Integer(value).intValue());

	}
	catch(NumberFormatException e)
	{  
		 sql = "select * from atividade where nome like '"+value+"%' ";
		 stmt = new ConexaoMySQL().getConexaoMySQL().prepareStatement(sql);
	}
	ResultSet worker = stmt.executeQuery();
	int cont = 1;
    while(worker.absolute(cont++))
	{
	resposta.add(
				worker.getString("idatividade")+" | "+worker.getString("nome")
				);
	}
	stmt.close();
   
	
	return resposta;
}

public void delMatricula(int value,String campo) throws Exception{
	String sql = "de brinks";
	PreparedStatement stmt = null;
    sql = "delete from matricula where id"+campo+" = ?";
	stmt = new ConexaoMySQL().getConexaoMySQL().prepareStatement(sql);	
	stmt.setInt(1,value);
	stmt.execute();
	stmt.close();
   
}

public void delMatricula(String campoAluno,String campoTurma) throws Exception{
	String sql = "de brinks";
	PreparedStatement stmt = null;
    sql = "delete from matricula where idaluno = "+campoAluno+" and idturma = "+campoTurma;
	stmt = new ConexaoMySQL().getConexaoMySQL().prepareStatement(sql);	
	stmt.execute();
	stmt.close();
   
}

public void delTelefone(int value) throws Exception{
	String sql = "de brinks";
	PreparedStatement stmt = null;
	sql = "select idtelefone from telefone_instrutor where idinstrutor = "+value;
	stmt = new ConexaoMySQL().getConexaoMySQL().prepareStatement(sql);
	ResultSet worker = stmt.executeQuery();
	worker.next();
	sql = "delete from telefone_instrutor where idtelefone = ?";
	stmt = new ConexaoMySQL().getConexaoMySQL().prepareStatement(sql);	
	stmt.setInt(1,new Integer(worker.getString("idtelefone")).intValue());
	stmt.execute();
	stmt.close();
   
}

public void delInstrutor(int value) throws Exception{
	String sql = "de brinks";
	try{
	delTelefone(value);
	}catch(Exception ex){}
	PreparedStatement stmt = null;
    sql = "delete from Instrutor where idInstrutor = ?";
	stmt = new ConexaoMySQL().getConexaoMySQL().prepareStatement(sql);	
	stmt.setInt(1,value);
	stmt.execute();
	stmt.close();
   
}

public void delAluno(int value) throws Exception{
	String sql = "de brinks";
	delMatricula(value,"aluno");
	PreparedStatement stmt = null;
    sql = "delete from aluno where idaluno = ?";
	stmt = new ConexaoMySQL().getConexaoMySQL().prepareStatement(sql);	
	stmt.setInt(1,value);
	stmt.execute();
	stmt.close();
   
}

public void delTurma(int value) throws Exception{
	String sql = "de brinks";
	delMatricula(value,"turma");
	PreparedStatement stmt = null;
	sql = "delete from turma where idturma = ?";
	stmt = new ConexaoMySQL().getConexaoMySQL().prepareStatement(sql);	
	stmt.setInt(1,value);
	stmt.execute();
	stmt.close();
   
}

public void delAtividade(int value) throws Exception{

	String sql = "de brinks";
	PreparedStatement stmt = null;	
	sql = "select idturma from turma where idatividade = ? ";
	stmt = new ConexaoMySQL().getConexaoMySQL().prepareStatement(sql);
	try{
	stmt.setInt(1,value);
	ResultSet worker = stmt.executeQuery();
	worker.next();
	delTurma(new Integer(worker.getString("idturma")).intValue());
	}catch(Exception ex){}
	sql = "delete from atividade where idatividade = ?";
	stmt = new ConexaoMySQL().getConexaoMySQL().prepareStatement(sql);
	stmt.setInt(1,value);
	stmt.execute();
	stmt.close();
   
}

public void updateAluno(Aluno a) throws Exception{
	
	//ConexaoMySQL cms = new ConexaoMySQL();
	//cms.getConexaoMySQL();
	String sql = "update aluno set dataMatricula = ?,nome = ?,endereco = ?,telefone = ?,dataNascimento = ?,altura = ?,peso = ? where idaluno = "+a.getIdAluno(); 
                 
        PreparedStatement stmt = new ConexaoMySQL().getConexaoMySQL().prepareStatement(sql);
        // preenche os valores
        //stmt.setInt(1, a.getIdAluno());
        Calendar c = Calendar.getInstance(); 
		c.set(Calendar.YEAR,a.getAnoMatricula()); 
		c.set(Calendar.MONTH,a.getMesMatricula()); 
		c.set(Calendar.DAY_OF_MONTH,a.getDiaMatricula());
		stmt.setDate(1, new java.sql.Date(c.getTimeInMillis()));
        stmt.setString(2, a.getNome());
        stmt.setString(3, a.getEndereco());
		stmt.setInt(4, a.getTelefone());
		Calendar c2 = Calendar.getInstance(); 
		c2.set(Calendar.YEAR,a.getAnoNascimento()); 
		c2.set(Calendar.MONTH,a.getMesNascimento()); 
		c2.set(Calendar.DAY_OF_MONTH,a.getDiaNascimento());
		stmt.setDate(5,new java.sql.Date(c2.getTimeInMillis()));
		stmt.setFloat(6, a.getAltura());
		stmt.setInt(7, a.getPeso());
        // executa
        stmt.execute();
        stmt.close();
        
		
}

public void updateInstrutor(Instrutor i) throws Exception{
	
	//ConexaoMySQL cms = new ConexaoMySQL();
	//cms.getConexaoMySQL();
	String sql = "update instrutor set nascimento = ?,nome = ?,rg = ?,titulacao = ? where idinstrutor = "+i.getIdInstrutor(); 
                 
        PreparedStatement stmt = new ConexaoMySQL().getConexaoMySQL().prepareStatement(sql);
        // preenche os valores
        //stmt.setInt(1, a.getIdAluno());
        Calendar c = Calendar.getInstance(); 
		c.set(Calendar.YEAR,i.getAnoNascimento()); 
		c.set(Calendar.MONTH,i.getMesNascimento()); 
		c.set(Calendar.DAY_OF_MONTH,i.getDiaNascimento());
		stmt.setDate(1, new java.sql.Date(c.getTimeInMillis()));
        stmt.setString(2, i.getNome());
        stmt.setInt(3, i.getRg());
		stmt.setInt(4, i.getTitulacao());
		// executa
        stmt.execute();
		sql = "update telefone_instrutor set numero = ?,tipo = ? where idtelefone = "+i.getIdTelefone(); 
        stmt = new ConexaoMySQL().getConexaoMySQL().prepareStatement(sql);
		stmt.setInt(1, i.getNumTel());
		stmt.setString(2, i.getTipoTel());
		// executa
        stmt.execute();
		stmt.close();
        
		
}

public void updateTurma(Turma t) throws Exception{
	
	//ConexaoMySQL cms = new ConexaoMySQL();
	//cms.getConexaoMySQL();
	String sql = "update turma set horario = ?,duracao = ?,dataInicio = ?,dataFim = ? where idturma = "+t.getIdTurma(); 
                 
        PreparedStatement stmt = new ConexaoMySQL().getConexaoMySQL().prepareStatement(sql);
        // preenche os valores
        //stmt.setInt(1, a.getIdAluno());stmt.setTime(1, new java.sql.Time(t.getHorarioHrs(),t.getHorarioMin(),0));
        stmt.setTime(1, new java.sql.Time(t.getHorarioHrs(),t.getHorarioMin(),0));
		stmt.setInt(2, t.getDuracao());
        Calendar c = Calendar.getInstance(); 
		c.set(Calendar.YEAR,t.getAnoInicio()); 
		c.set(Calendar.MONTH,t.getMesInicio()); 
		c.set(Calendar.DAY_OF_MONTH,t.getDiaInicio());
		stmt.setDate(3,new java.sql.Date(c.getTimeInMillis()));
		Calendar c2 = Calendar.getInstance(); 
		c2.set(Calendar.YEAR,t.getAnoFim()); 
		c2.set(Calendar.MONTH,t.getMesFim()); 
		c2.set(Calendar.DAY_OF_MONTH,t.getDiaFim());
		stmt.setDate(4,new java.sql.Date(c2.getTimeInMillis()));
		// executa
        stmt.execute();
		stmt.close();
        
		
}

public ArrayList<String> selectAluno(String value) throws Exception{
	
	ArrayList<String> resposta = new ArrayList<String>();
	String sql = "de brinks";
	PreparedStatement stmt = null;
    Integer.parseInt(value);  
	sql = "select * from aluno where idAluno = ?";
	stmt = new ConexaoMySQL().getConexaoMySQL().prepareStatement(sql);	
	stmt.setInt(1,new Integer(value).intValue());
	ResultSet worker = stmt.executeQuery();
	worker.next();
	resposta.add(worker.getString("nome"));
	resposta.add(worker.getString("dataNascimento"));
	resposta.add(worker.getString("altura"));
	resposta.add(worker.getString("peso"));
	resposta.add(worker.getString("endereco"));
	resposta.add(worker.getString("telefone"));
	resposta.add(worker.getString("dataMatricula")); 
	resposta.add(worker.getString("idaluno"));
	stmt.close();
   	return resposta;
}

public ArrayList<String> selectAtividade(String value) throws Exception{
	
	ArrayList<String> resposta = new ArrayList<String>();
	String sql = "de brinks";
	PreparedStatement stmt = null;
    Integer.parseInt(value);  
	sql = "select * from atividade where idAtividade = ?";
	stmt = new ConexaoMySQL().getConexaoMySQL().prepareStatement(sql);	
	stmt.setInt(1,new Integer(value).intValue());
	ResultSet worker = stmt.executeQuery();
	worker.next();
	resposta.add(worker.getString("nome"));
	resposta.add(worker.getString("idatividade"));
	stmt.close();
   	return resposta;
}

public void updateAtividade(Atividade a) throws Exception{
	
	//ConexaoMySQL cms = new ConexaoMySQL();
	//cms.getConexaoMySQL();
	String sql = "update atividade set nome = ? where idatividade = "+a.getIdAtividade(); 
                 
        PreparedStatement stmt = new ConexaoMySQL().getConexaoMySQL().prepareStatement(sql);
        // preenche os valores
        //stmt.setInt(1, a.getIdAluno());stmt.setTime(1, new java.sql.Time(t.getHorarioHrs(),t.getHorarioMin(),0));
         stmt.setString(1, a.getNome());
		// executa
        stmt.execute();
		stmt.close();
        
		
}


public ArrayList<String> selectTurma(String value) throws Exception{
	
	ArrayList<String> resposta = new ArrayList<String>();
	String sql = "de brinks";
	PreparedStatement stmt = null;
    Integer.parseInt(value);  
	sql = "select * from turma where idturma = ?";
	stmt = new ConexaoMySQL().getConexaoMySQL().prepareStatement(sql);	
	stmt.setInt(1,new Integer(value).intValue());
	ResultSet worker = stmt.executeQuery();
	worker.next();
	resposta.add(worker.getString("horario"));
	resposta.add(worker.getString("duracao"));
	resposta.add(worker.getString("dataInicio"));
	resposta.add(worker.getString("dataFim"));
	resposta.add(worker.getString("idatividade"));
	resposta.add(worker.getString("idinstrutor"));
	resposta.add(worker.getString("idturma"));
	stmt.close();
   	return resposta;
}


public ArrayList<String> selectInstrutor(String value) throws Exception{
	ArrayList<String> resposta = new ArrayList<String>();
	String sql = "de brinks";
	PreparedStatement stmt = null;
    Integer.parseInt(value);  
	sql = "select * from instrutor where idInstrutor = ?";
	stmt = new ConexaoMySQL().getConexaoMySQL().prepareStatement(sql);	
	stmt.setInt(1,new Integer(value).intValue());
	ResultSet worker = stmt.executeQuery();
	worker.next();
	resposta.add(worker.getString("rg"));
	resposta.add(worker.getString("nome"));
	resposta.add(worker.getString("nascimento"));
	resposta.add(worker.getString("titulacao"));
	resposta.add(worker.getString("idInstrutor"));
	sql = "select * from telefone_instrutor where idInstrutor = ?";
	stmt = new ConexaoMySQL().getConexaoMySQL().prepareStatement(sql);	
	stmt.setInt(1,new Integer(value).intValue());
	worker = stmt.executeQuery();
	worker.next();
	resposta.add(worker.getString("numero"));
	resposta.add(worker.getString("tipo"));	
	resposta.add(worker.getString("idtelefone"));
	stmt.close();
   	return resposta;
}



public static void main(String ...args)throws Exception{




}
//Método de Conexão
public static java.sql.Connection getConexaoMySQL() 
{ 
Connection connection = null; 

//atributo do tipo Connection 
try { 
String driverName = "com.mysql.jdbc.Driver";  
Class.forName(driverName);
// Configurando a nossa conexão com um banco de dados// 
String serverName = "localhost"; 
//caminho do servidor do BD 
String mydatabase ="ap_ii"; 
//nome do seu banco de dados 
String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
String username = "root";//nome de um usuário de seu BD 
String password = ""; //sua senha de acesso 
connection = DriverManager.getConnection(url, username, password); 
//Testa sua conexão// 
if (connection != null) { 
status = ("STATUS--->Conectado com sucesso!")
; 
}
 else 
 { 
status = ("STATUS--->Não foi possivel realizar conexão")
; 
} 
return connection; 
} 
catch (ClassNotFoundException e) 
{ 
//Driver não encontrado 
System.out.println("O driver expecificado nao foi encontrado."); 
return null; 
} 
catch (SQLException e) { 
//Não conseguindo se conectar ao banco 
System.out.println("Nao foi possivel conectar ao Banco de Dados."); 
return null; 
} 

}

//Método que retorna o status da sua conexão// 
public static String statusConection() { return status; }
//Método que fecha sua conexão// 
public static boolean FecharConexao() {
	try {
		ConexaoMySQL.getConexaoMySQL().close(); 
		return true; 
	} 
	catch (SQLException e) { 
		return false; 
	} 
} 
//Método que reinicia sua conexão// 
public static java.sql.Connection ReiniciarConexao() {
	FecharConexao(); 
	return ConexaoMySQL.getConexaoMySQL(); 
	} 
}


