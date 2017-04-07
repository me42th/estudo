import java.util.*;
// Listar turmas de um aluno e alunos de uma turma
// Cadastrar o telefone do instrutor
public class Main{
private static final String menuInicial = 				"Informe! Alunos A     |Instrutores I |Turmas T     |Atividades AT";
private static final String menuPrincipalAlunos =		"         Cadastro A1  |Busca A2      |Inscricao A3 |Del Inscricao A4 |Voltar V";
private static final String menuPrincipalInstrutores = 	"         Cadastro I1  |Busca I2      |Voltar V";
private static final String menuPricipalTurmas =		"         Cadastro T1  |Busca T2      |Inscricao A3 |Del Inscricao A4 |Voltar V";
private static final String menuPrincipalAtividades =	"         Cadastro AT1 |Busca AT2     |Voltar V ";
private static final String menuBuscaAlunos =			"         Buscar AB    |Excluir AD    |Alterar AA";
private static final String menuBuscaInstrutores =		"         Buscar IB    |Excluir ID    |Alterar IA";
private static final String menuBuscaTurmas =			"         Buscar TB    |Excluir TD    |Alterar TA";
private static final String menuBuscaAtividades =		"         Buscar ATB   |Excluir ATD   |Alterar ATA";
private static String entrada = "V";
private static ConexaoMySQL conexao = new ConexaoMySQL();
public static void main(String...args) throws Exception {
foo :
while(true){

	printLogo();
	System.out.println(menuInicial);
	if((entrada.length() >= 2) && entrada.substring(0,2).equals("AT")){
		System.out.println(menuPrincipalAtividades);
		switch(entrada){
			case "AT1":
			    conexao.gravaAtividade(atividadeFactory());
				entrada = "AT";
				continue foo;
			case "AT2":
				System.out.println(menuBuscaAtividades);
				break;
			case "ATB":
				System.out.println(menuBuscaAtividades);
				search(entrada);
				entrada = "AT2";
				continue foo;
			case "ATD":
				System.out.println(menuBuscaAtividades);
				delete(entrada);
				entrada = "AT2";
				continue foo;
			case "ATA":
				System.out.println(menuBuscaAtividades);
				update(entrada);
				entrada = "AT2";
				continue foo;	
		}
	}
	else if(entrada.substring(0,1).equals("T")){
		System.out.println(menuPricipalTurmas);
		switch(entrada){
			case "T1":
			    conexao.gravaTurma(turmaFactory());
				entrada = "T";
				continue foo;
			case "T2":
				System.out.println(menuBuscaTurmas);
				break;
			case "TB":
				System.out.println(menuBuscaTurmas);
				search(entrada);
				entrada = "T2";
				continue foo;
			case "TD":
				System.out.println(menuBuscaTurmas);
				delete(entrada);
				entrada = "T2";
				continue foo;
			case "TA":
				System.out.println(menuBuscaTurmas);
				update(entrada);
				entrada = "T2";
				continue foo;	

		}
	}	
	else if(entrada.substring(0,1).equals("I")){
		System.out.println(menuPrincipalInstrutores);
		switch(entrada){
			case "I1":
				conexao.gravaInstrutor(instrutorFactory());
				entrada = "I";
				continue foo;
				case "I2":
				System.out.println(menuBuscaInstrutores);
				break;
			case "IB":
				System.out.println(menuBuscaInstrutores);
				search(entrada);
				entrada = "I2";
				continue foo;
			case "ID":
				System.out.println(menuBuscaInstrutores);
				delete(entrada);
				entrada = "I2";
				continue foo;
			case "IA":
				System.out.println(menuBuscaInstrutores);
				update(entrada);
				entrada = "I2";
				continue foo;	
		}
	}
	else if(entrada.substring(0,1).equals("A")){
		System.out.println(menuPrincipalAlunos);
		switch(entrada){
			case "A1":
				conexao.gravaAluno(alunoFactory());
				entrada = "A";
				continue foo;
			case "A2":
				System.out.println(menuBuscaAlunos);
				break;
			case "A3":
			    Aluno tempA;
				if((tempA = simpleAlunoFactory()).getIdAluno() == 0 ) 
				{	
					entrada = "V";
					continue foo;
				}
				conexao.makeMatricula(tempA,simpleTurmaFactory());
				continue foo;
			case "A4":
			    cancelMatricula();	
				entrada = "A";
				continue foo;
				case "AB":
				System.out.println(menuBuscaAlunos);
				search(entrada);
				entrada = "A2";
				continue foo;
			case "AD":			
				System.out.println(menuBuscaAlunos);
				delete(entrada);
				entrada = "A2";
				continue foo;
			case "AA":
				System.out.println(menuBuscaAlunos);
				update(entrada);
				entrada = "A2";
				continue foo;	
		}
	}	
            
	entrada = new Scanner(System.in).next();
}

}

private static void search(String value) throws Exception{
	String resposta = null;
	String menuPrincipal = value.equals("AB")?menuPrincipalAlunos:value.equals("IB")?menuPrincipalInstrutores:value.equals("TB")?menuPricipalTurmas:value.equals("ATB")?menuPrincipalAtividades:"notYet";
	String menuBusca = value.equals("AB")?menuBuscaAlunos:value.equals("IB")?menuBuscaInstrutores:value.equals("TB")?menuBuscaTurmas:value.equals("ATB")?menuBuscaAtividades:"notYet";
	System.out.println();
	System.out.println("Informe o cod ou o nome ou '.' para sair : ");
	if((resposta = new Scanner(System.in).findInLine(".*")).equals(".")) return;
	while(true){
		printLogo();
		System.out.println(menuInicial);
		System.out.println(menuPrincipal);
		System.out.println(menuBusca);
		if(value.equals("AB")) for (String resultado : conexao.getAlunos(resposta)) System.out.println("\n"+resultado);
	    else if(value.equals("IB"))	for (String resultado : conexao.getInstrutores(resposta)) System.out.println("\n"+resultado);
		else if(value.equals("TB"))	for (String resultado : conexao.getTurmas(resposta)) System.out.println("\n"+resultado);
		else if(value.equals("ATB"))for (String resultado : conexao.getAtividades(resposta)) System.out.println("\n"+resultado);
		System.out.println();
		System.out.println("Informe o cod ou o nome ou '.' para sair : ");
		if((resposta = new Scanner(System.in).findInLine(".*")).equals(".")) return;
	}
}

private static void delete(String value) throws Exception{
	String resposta = null;
	String menuPrincipal = value.equals("AD")?menuPrincipalAlunos:value.equals("ID")?menuPrincipalInstrutores:value.equals("TD")?menuPricipalTurmas:value.equals("ATD")?menuPrincipalAtividades:"notYet";
	String menuBusca = value.equals("AD")?menuBuscaAlunos:value.equals("ID")?menuBuscaInstrutores:value.equals("TD")?menuBuscaTurmas:value.equals("ATD")?menuBuscaAtividades:"notYet";
	System.out.println();
	System.out.println("Informe o cod ou '.' para sair : ");
	if((resposta = new Scanner(System.in).findInLine(".*")).equals(".")) return;
	while(true){
		printLogo();
		System.out.println(menuInicial);
		System.out.println(menuPrincipal);
		System.out.println(menuBusca);
		if(value.equals("AD")) conexao.delAluno(new Integer(resposta).intValue());
	    else if(value.equals("ID"))	conexao.delInstrutor(new Integer(resposta).intValue());
		else if(value.equals("TD")) conexao.delTurma(new Integer(resposta).intValue());
		else if(value.equals("ATD"))conexao.delAtividade(new Integer(resposta).intValue());
		System.out.println();
		System.out.println("Malfeito feito! Informe o cod ou '.' para sair : ");
		if((resposta = new Scanner(System.in).findInLine(".*")).equals(".")) return;
	}
}

private static void update(String value) throws Exception{
	String resposta = null;
	String menuPrincipal = value.equals("AA")?menuPrincipalAlunos:value.equals("IA")?menuPrincipalInstrutores:value.equals("TA")?menuPricipalTurmas:value.equals("ATA")?menuPrincipalAtividades:"notYet";
	String menuBusca = value.equals("AA")?menuBuscaAlunos:value.equals("IA")?menuBuscaInstrutores:value.equals("TA")?menuBuscaTurmas:value.equals("ATA")?menuBuscaAtividades:"notYet";
	System.out.println();
	System.out.println("Informe o cod ou '.' para sair : ");
	if((resposta = new Scanner(System.in).findInLine(".*")).equals(".")) return;
	while(true){
		printLogo();
		System.out.println(menuInicial);
		System.out.println(menuPrincipal);
		System.out.println(menuBusca);
		if(value.equals("AA")) conexao.updateAluno(updateAlunoFactory(resposta));
	    else if(value.equals("IA"))	conexao.updateInstrutor(updateInstrutorFactory(resposta));
		else if(value.equals("TA")) conexao.updateTurma(updateTurmaFactory(resposta));
		else if(value.equals("ATA"))conexao.updateAtividade(updateAtividadeFactory(resposta));
		System.out.println();
		System.out.println("Malfeito feito! Informe o cod ou '.' para sair : ");
		if((resposta = new Scanner(System.in).findInLine(".*")).equals(".")) return;
	}
}
private static Turma updateTurmaFactory(String value) throws Exception{
	Turma newTurma = new Turma();	
	ArrayList<String> oldTurma = conexao.selectTurma(value);
	String resp;
	System.out.println();
	System.out.println("Deseja manter o horario("+oldTurma.get(0).split(":")[0]+":"+oldTurma.get(0).split(":")[1]+")?\nInforme '.' ou a nova entrada(hh:mm)! ");
    if((resp = new Scanner(System.in).findInLine(".*")).equals(".")) newTurma.setHorario(oldTurma.get(0)); else newTurma.setHorario(resp);
	printLogo();
	System.out.println(menuInicial);
	System.out.println(menuPricipalTurmas);
	System.out.println(menuBuscaTurmas);
	System.out.println();
	System.out.println("Deseja manter a data de inicio("+oldTurma.get(2).split("-")[2]+"-"+oldTurma.get(2).split("-")[1]+"-"+oldTurma.get(2).split("-")[0]+")?\nInforme '.' ou a nova entrada(dd-mm-aaaa)! ");
	if((resp = new Scanner(System.in).findInLine(".*")).equals(".")) newTurma.setDataInicio(oldTurma.get(2).split("-")[2]+"-"+oldTurma.get(2).split("-")[1]+"-"+oldTurma.get(2).split("-")[0]); else newTurma.setDataInicio(resp);
	printLogo();
	System.out.println(menuInicial);
	System.out.println(menuPricipalTurmas);
	System.out.println(menuBuscaTurmas);
	System.out.println();
	System.out.println("Deseja manter a data de termino("+oldTurma.get(3).split("-")[2]+"-"+oldTurma.get(3).split("-")[1]+"-"+oldTurma.get(3).split("-")[0]+")?\nInforme '.' ou a nova entrada(dd-mm-aaaa)! ");
	if((resp = new Scanner(System.in).findInLine(".*")).equals(".")) newTurma.setDataFim(oldTurma.get(3).split("-")[2]+"-"+oldTurma.get(3).split("-")[1]+"-"+oldTurma.get(3).split("-")[0]); else newTurma.setDataFim(resp);
	printLogo();
	System.out.println(menuInicial);
	System.out.println(menuPricipalTurmas);
	System.out.println(menuBuscaTurmas);
	System.out.println();
	System.out.println("Deseja manter a duracao("+oldTurma.get(1)+")?\nInforme '.' ou a nova entrada(somente numeros)! ");
	if((resp = new Scanner(System.in).findInLine(".*")).equals(".")) newTurma.setDuracao(new Integer(oldTurma.get(1)).intValue()); else newTurma.setDuracao(new Integer(resp).intValue());
	newTurma.setIdAtividade(new Integer(oldTurma.get(4)).intValue());
	newTurma.setIdInstrutor(new Integer(oldTurma.get(5)).intValue());
	newTurma.setIdTurma(new Integer(oldTurma.get(6)).intValue());
	printLogo();
	System.out.println(menuInicial);
	System.out.println(menuPricipalTurmas);
	System.out.println(menuBuscaTurmas);
	System.out.println();
	return newTurma;
}


private static Instrutor updateInstrutorFactory(String value) throws Exception{
	Instrutor newInstrutor = new Instrutor();	
	ArrayList<String> oldInstrutor = conexao.selectInstrutor(value);
	String resp;
	System.out.println();
	System.out.println("Deseja manter o nome("+oldInstrutor.get(1)+")?\nInforme '.' ou a nova entrada! ");
    if((resp = new Scanner(System.in).findInLine(".*")).equals(".")) newInstrutor.setNome(oldInstrutor.get(1)); else newInstrutor.setNome(resp);
	printLogo();
	System.out.println(menuInicial);
	System.out.println(menuPrincipalInstrutores);
	System.out.println(menuBuscaInstrutores);
	System.out.println();
	System.out.println("Deseja manter a data de nascimento("+oldInstrutor.get(2).split("-")[2]+"-"+oldInstrutor.get(2).split("-")[1]+"-"+oldInstrutor.get(2).split("-")[0]+")?\nInforme '.' ou a nova entrada(dd-mm-aaaa)! ");
	if((resp = new Scanner(System.in).findInLine(".*")).equals(".")) newInstrutor.setNascimento(oldInstrutor.get(2).split("-")[2]+"-"+oldInstrutor.get(2).split("-")[1]+"-"+oldInstrutor.get(2).split("-")[0]); else newInstrutor.setNascimento(resp);
	printLogo();
	System.out.println(menuInicial);
	System.out.println(menuPrincipalInstrutores);
	System.out.println(menuBuscaInstrutores);
	System.out.println();
	System.out.println("Deseja manter o rg("+oldInstrutor.get(0)+")?\nInforme '.' ou a nova entrada(somente numeros)! ");
	if((resp = new Scanner(System.in).findInLine(".*")).equals(".")) newInstrutor.setRg(new Integer(oldInstrutor.get(0))); else newInstrutor.setRg(new Integer(resp).intValue());
	printLogo();
	System.out.println(menuInicial);
	System.out.println(menuPrincipalInstrutores);
	System.out.println(menuBuscaInstrutores);
	System.out.println();
	System.out.println("Deseja manter a titulacao("+oldInstrutor.get(3)+")?\nInforme '.' ou a nova entrada(somente numeros)! ");
	if((resp = new Scanner(System.in).findInLine(".*")).equals(".")) newInstrutor.setTitulacao(new Integer(oldInstrutor.get(3)).intValue()); else newInstrutor.setTitulacao(new Integer(resp).intValue());
	printLogo();
	System.out.println(menuInicial);
	System.out.println(menuPrincipalInstrutores);
	System.out.println(menuBuscaInstrutores);
	System.out.println();
	newInstrutor.setIdTelefone(new Integer(oldInstrutor.get(7)).intValue());
	System.out.println("Deseja manter o telefone("+oldInstrutor.get(5)+")?\nInforme '.' ou a nova entrada(somente numeros)! ");
	if((resp = new Scanner(System.in).findInLine(".*")).equals(".")) newInstrutor.setTel(new Integer(oldInstrutor.get(5)).intValue()); else newInstrutor.setTel(new Integer(resp).intValue());
	printLogo();
	System.out.println(menuInicial);
	System.out.println(menuPrincipalInstrutores);
	System.out.println(menuBuscaInstrutores);
	System.out.println();
	System.out.println("Deseja manter o tipo do telefone("+oldInstrutor.get(6)+")?\nInforme '.' ou a nova entrada! ");
	if((resp = new Scanner(System.in).findInLine(".*")).equals(".")) newInstrutor.setTipoTel(oldInstrutor.get(6)); else newInstrutor.setTipoTel(resp);
	newInstrutor.setIdInstrutor(new Integer(oldInstrutor.get(4)).intValue());
	printLogo();
	System.out.println(menuInicial);
	System.out.println(menuPrincipalAlunos);
	System.out.println(menuBuscaInstrutores);
	System.out.println();
	return newInstrutor;
}


private static Atividade updateAtividadeFactory(String value) throws Exception{
	Atividade newAtividade = new Atividade();	
	ArrayList<String> oldAtividade = conexao.selectAtividade(value);
	String resp;
	System.out.println();
	System.out.println("Deseja manter o nome("+oldAtividade.get(0)+")?\nInforme '.' ou a nova entrada! ");
    if((resp = new Scanner(System.in).findInLine(".*")).equals(".")) newAtividade.setNome(oldAtividade.get(0)); else newAtividade.setNome(resp);
	newAtividade.setIdAtividade(new Integer(oldAtividade.get(1)).intValue());
	printLogo();
	System.out.println(menuInicial);
	System.out.println(menuPrincipalAtividades);
	System.out.println(menuBuscaAtividades);
	System.out.println();
	return newAtividade;
}

private static Aluno alunoFactory(){
	Aluno temp = new Aluno();	
	System.out.println();
	System.out.println("Informe o nome do aluno: ");
    temp.setNome(new Scanner(System.in).findInLine(".*"));
	printLogo();
	System.out.println(menuInicial);
	System.out.println(menuPrincipalAlunos);
	System.out.println();
	System.out.println("Informe a data do nascimento(dd-mm-aaaa): ");
	temp.setDataNascimento(new Scanner(System.in).findInLine(".*"));
	printLogo();
	System.out.println(menuInicial);
	System.out.println(menuPrincipalAlunos);
	System.out.println();
	System.out.println("Informe o endereço: ");
	temp.setEndereco(new Scanner(System.in).findInLine(".*"));
	printLogo();
	System.out.println(menuInicial);
	System.out.println(menuPrincipalAlunos);
	System.out.println();
	System.out.println("Informe o telefone(somente numeros): ");
	temp.setTelefone(new Integer(new Scanner(System.in).findInLine(".*")).intValue());	
	printLogo();
	System.out.println(menuInicial);
	System.out.println(menuPrincipalAlunos);
	System.out.println();
	System.out.println("Informe a altura: ");
	temp.setAltura(new Float(new Scanner(System.in).findInLine(".*")).floatValue());
	printLogo();
	System.out.println(menuInicial);
	System.out.println(menuPrincipalAlunos);
	System.out.println();
	System.out.println("Informe o peso: ");
	temp.setPeso(new Integer(new Scanner(System.in).findInLine(".*")).intValue());
	printLogo();
	System.out.println(menuInicial);
	System.out.println(menuPrincipalAlunos);
	System.out.println();
	System.out.println("Informe a data da matricula(dd-mm-aaaa): ");	
	temp.setDataMatricula(new Scanner(System.in).findInLine(".*"));
    return temp;
}

private static Aluno updateAlunoFactory(String value) throws Exception{
	Aluno newAluno = new Aluno();	
	ArrayList<String> oldAluno = conexao.selectAluno(value);
	String resp;
	System.out.println();
	System.out.println("Deseja manter o nome("+oldAluno.get(0)+")?\nInforme '.' ou a nova entrada! ");
    if((resp = new Scanner(System.in).findInLine(".*")).equals(".")) newAluno.setNome(oldAluno.get(0)); else newAluno.setNome(resp);
	printLogo();
	System.out.println(menuInicial);
	System.out.println(menuPrincipalAlunos);
	System.out.println(menuBuscaAlunos);
	System.out.println();
	System.out.println("Deseja manter a data de nascimento("+oldAluno.get(1).split("-")[2]+"-"+oldAluno.get(1).split("-")[1]+"-"+oldAluno.get(1).split("-")[0]+")?\nInforme '.' ou a nova entrada(dd-mm-aaaa)! ");
	if((resp = new Scanner(System.in).findInLine(".*")).equals(".")) newAluno.setDataNascimento(oldAluno.get(1).split("-")[2]+"-"+oldAluno.get(1).split("-")[1]+"-"+oldAluno.get(1).split("-")[0]); else newAluno.setDataNascimento(resp);
	printLogo();
	System.out.println(menuInicial);
	System.out.println(menuPrincipalAlunos);
	System.out.println(menuBuscaAlunos);
	System.out.println();
	System.out.println("Deseja manter o endereco("+oldAluno.get(4)+")?\nInforme '.' ou a nova entrada! ");
	if((resp = new Scanner(System.in).findInLine(".*")).equals(".")) newAluno.setEndereco(oldAluno.get(4)); else newAluno.setEndereco(resp);
	printLogo();
	System.out.println(menuInicial);
	System.out.println(menuPrincipalAlunos);
	System.out.println(menuBuscaAlunos);
	System.out.println();
	System.out.println("Deseja manter o telefone("+oldAluno.get(5)+")?\nInforme '.' ou a nova entrada(somente numeros)! ");
	if((resp = new Scanner(System.in).findInLine(".*")).equals(".")) newAluno.setTelefone(new Integer(oldAluno.get(5)).intValue()); else newAluno.setTelefone(new Integer(resp).intValue());
	printLogo();
	System.out.println(menuInicial);
	System.out.println(menuPrincipalAlunos);
	System.out.println(menuBuscaAlunos);
	System.out.println();
	System.out.println("Deseja manter a altura("+oldAluno.get(2)+")?\nInforme '.' ou a nova entrada(somente numeros)! ");
	if((resp = new Scanner(System.in).findInLine(".*")).equals(".")) newAluno.setAltura(new Float(oldAluno.get(2)).floatValue()); else newAluno.setAltura(new Float(resp).floatValue());
	printLogo();
	System.out.println(menuInicial);
	System.out.println(menuPrincipalAlunos);
	System.out.println(menuBuscaAlunos);
	System.out.println();
	System.out.println("Deseja manter o peso("+oldAluno.get(3)+")?\nInforme '.' ou a nova entrada(somente numeros)! ");
	if((resp = new Scanner(System.in).findInLine(".*")).equals(".")) newAluno.setPeso(new Integer(oldAluno.get(3)).intValue()); else newAluno.setPeso(new Integer(resp).intValue());
	printLogo();
	System.out.println(menuInicial);
	System.out.println(menuPrincipalAlunos);
	System.out.println(menuBuscaAlunos);
	System.out.println();
	System.out.println("Deseja manter a data de matricula("+oldAluno.get(6).split("-")[2]+"-"+oldAluno.get(6).split("-")[1]+"-"+oldAluno.get(6).split("-")[0]+")?\nInforme '.' ou a nova entrada(dd-mm-aaaa)! ");
	if((resp = new Scanner(System.in).findInLine(".*")).equals(".")) newAluno.setDataMatricula(oldAluno.get(6).split("-")[2]+"-"+oldAluno.get(6).split("-")[1]+"-"+oldAluno.get(6).split("-")[0]); else newAluno.setDataMatricula(resp);
	newAluno.setIdAluno(new Integer(oldAluno.get(7)).intValue());
	printLogo();
	System.out.println(menuInicial);
	System.out.println(menuPrincipalAlunos);
	System.out.println(menuBuscaAlunos);
	System.out.println();
	return newAluno;
}

private static Aluno simpleAlunoFactory(){
	Aluno temp = new Aluno();
	printLogo();
	System.out.println(menuInicial);
	System.out.println(menuPrincipalAlunos);
	System.out.println();
	System.out.println("Informe o cod do aluno(somente numeros) ou '0' para sair : ");
	temp.setIdAluno(new Integer(new Scanner(System.in).findInLine(".*")).intValue());	
	return temp;
}

private static void cancelMatricula() throws Exception{

	int cont = 0;
	foo:
	while(true){
	String idAluno;	
	String idTurma;
	printLogo();
	System.out.println(menuInicial);
	System.out.println(menuPrincipalAlunos);
	System.out.println();
	if(cont++ == 0)
	System.out.println("Informe o cod do aluno ou '.' para sair : ");
	else
	System.out.println("Malfeito feito! Informe o cod do aluno ou '.' para sair : ");
	if((idAluno = new Scanner(System.in).findInLine(".*")).equals(".")) return;
	
	printLogo();
	System.out.println(menuInicial);
	System.out.println(menuPricipalTurmas);
	System.out.println();
	System.out.println("Informe o cod da turma ou '.' para sair : ");
	if((idTurma = new Scanner(System.in).findInLine(".*")).equals(".")) 
	{ 
	System.out.println("OSHI 2");
	break;
	}
		
	
	conexao.delMatricula(idAluno,idTurma);
	}
}
private static Turma simpleTurmaFactory(){
	Turma temp = new Turma();
	printLogo();
	System.out.println(menuInicial);
	System.out.println(menuPricipalTurmas);
	System.out.println();
	System.out.println("Informe o cod da turma(somente numeros): ");
	temp.setIdTurma(new Integer(new Scanner(System.in).findInLine(".*")).intValue());	
	return temp;
}

private static Instrutor instrutorFactory(){
	Instrutor temp = new Instrutor();	
	System.out.println();
	System.out.println("Informe o nome do Instrutor: ");
    temp.setNome(new Scanner(System.in).findInLine(".*"));
	printLogo();
	System.out.println(menuInicial);
	System.out.println(menuPrincipalInstrutores);
	System.out.println();
	System.out.println("Informe a data do nascimento(dd-mm-aaaa): ");
	temp.setNascimento(new Scanner(System.in).findInLine(".*"));
	printLogo();
	System.out.println(menuInicial);
	System.out.println(menuPrincipalInstrutores);
	System.out.println();
	System.out.println("Informe o rg(somente numeros): ");
	temp.setRg(new Integer(new Scanner(System.in).findInLine(".*")).intValue());
	printLogo();
	System.out.println(menuInicial);
	System.out.println(menuPrincipalInstrutores);
	System.out.println();
	System.out.println("Informe a titulacao(somente numeros): ");
	temp.setTitulacao(new Integer(new Scanner(System.in).findInLine(".*")).intValue());	
   	printLogo();
	System.out.println(menuInicial);
	System.out.println(menuPrincipalInstrutores);
	System.out.println();
	System.out.println("Informe o numero de telefone(somente numeros): ");
	temp.setTel(new Integer(new Scanner(System.in).findInLine(".*")).intValue());	
	printLogo();
	System.out.println(menuInicial);
	System.out.println(menuPrincipalInstrutores);
	System.out.println();
	System.out.println("Informe o tipo do telefone: ");
	temp.setTipoTel(new Scanner(System.in).findInLine(".*"));
   return temp;
}

private static Atividade atividadeFactory(){
	Atividade temp = new Atividade();	
	System.out.println();
	System.out.println("Informe o nome da atividade: ");
    temp.setNome(new Scanner(System.in).findInLine(".*"));
    return temp;
}

private static Turma turmaFactory(){
	Turma temp = new Turma();	
	System.out.println();
	System.out.println("Informe o horario da turma(hr:min): ");
    temp.setHorario(new Scanner(System.in).findInLine(".*"));
	printLogo();
	System.out.println(menuInicial);
	System.out.println(menuPricipalTurmas);
	System.out.println();
	System.out.println("Informe a duracao da turma(somente numeros): ");
	temp.setDuracao(new Integer(new Scanner(System.in).findInLine(".*")).intValue());
	printLogo();
	System.out.println(menuInicial);
	System.out.println(menuPricipalTurmas);
	System.out.println();
	System.out.println("Informe a data do inicio(dd-mm-aaaa): ");	
	temp.setDataInicio(new Scanner(System.in).findInLine(".*"));
	printLogo();
	System.out.println(menuInicial);
	System.out.println(menuPricipalTurmas);
	System.out.println();
	System.out.println("Informe a data do fim(dd-mm-aaaa): ");	
	temp.setDataFim(new Scanner(System.in).findInLine(".*"));
	printLogo();
	System.out.println(menuInicial);
	System.out.println(menuPricipalTurmas);
	System.out.println();
	System.out.println("Informe o cod do instrutor(somente numeros): ");
	temp.setIdInstrutor(new Integer(new Scanner(System.in).findInLine(".*")).intValue());
	printLogo();
	System.out.println(menuInicial);
	System.out.println(menuPricipalTurmas);
	System.out.println();
	System.out.println("Informe o cod da atividade(somente numeros): ");
	temp.setIdAtividade(new Integer(new Scanner(System.in).findInLine(".*")).intValue());
    return temp;
}


private static void printLogo(){
int contGamb = 0;	
while(contGamb++ < 50) System.out.println(" ");
System.out.println("                     .                    ________            .");
System.out.println("      /\\            / \\                   \\        \\         / \\ ");
System.out.println("    /    \\        /  .  \\       _____      \\  ____   \\     /  .  \\ ");
System.out.println("  / | \\    \\    /   / \\___\\    /    /      |  |   \\  |   /   / \\___\\ ");
System.out.println(" |  |   \\   |   |  |          /    /       |  |   |  |   |  | ");
System.out.println(" |  |    \\  |   |  |         /    /_____   |  |   |  |   |  |");
System.out.println(" |  |____|  |   |  |        /          /   |  |   |  |   |  |");
System.out.println(" |  ______  |   |  |       /_____     /    |  |   |  |   |  |");
System.out.println(" |  |    |  |   |  |            /    /     |  |   |  |   |  |");
System.out.println(" |  |    |  |   |  |   ___      /   /      |  |   /  |   |  |   ___ ");
System.out.println(" |  |    |  |   \\   \\./  /      /  /       |  |__/   |   \\   \\./  / ");
System.out.println("/   \\   /   \\     \\     /       / /        /        /      \\     / ");
System.out.println(" \\./     \\./        \\./          /        /________/         \\./  ");
System.out.println("");
System.out.println("Banco de Dados - David & Bruna & Guilherme");
System.out.println("");
System.out.println("");	
}
}