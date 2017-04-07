import java.util.*;
import java.util.regex.*;
import java.io.*;

public class Matriz {
	
	List<Ponto> tudo = new ArrayList<Ponto>();
	List<String> resultado = new ArrayList<String>();
	int fronteira = 0;	
	public Matriz(String file){
		String linha,frag = "A";
		try	
		{
			BufferedReader br = new BufferedReader(new FileReader(file));
				while ((linha = br.readLine()) != null ){			    		 
					if(linha.contains("David Meth")){
						frag="B";
						fronteira = Ponto.getCont();
						continue;
					}
			tudo.add(new Ponto(new Integer(linha.split(";")[0]),new Integer(linha.split(";")[1]),frag));	 
		}  
		
		}
		catch(Throwable _l_){_l_.printStackTrace();}
		for(int contA = 0; contA < fronteira; contA++)
			for(int contB = fronteira; contB < tudo.size(); contB++)
				resultado.add(tudo.get(contA).toString()+tudo.get(contB).toString());
	}
	
   public Ponto searchPonto(Ponto p){
	   return tudo.get(tudo.indexOf(p));	   
   }
   
   public int entrePontos(String s){
	   String array[] = new String[2];
	   Pattern pattern = Pattern.compile("[AB]\\d+");
	   Matcher matcher = pattern.matcher(s);
	   for (int cont = 0;matcher.find();cont++) 
			array[cont] = matcher.group();	
	   return searchPonto(new Ponto(array[0])).getDistancia(searchPonto(new Ponto(array[1])));
   }
   
   
   public static void main(String ... args){
	  showArchive();
	  
   }	
   public static void showArchive(){
	   Matriz m = new Matriz("C:\\Users\\David\\Desktop\\dX.csv");
	   int cont = 0;
	   String saida = "(.)(.)";
	   System.out.println("Fronteira: "+m.fronteira+" Cont: "+Ponto.getCont()+" Size: "+m.tudo.size()+"\n");
	   for(String s : m.resultado)
	   {
		   System.out.println(s+" "+m.entrePontos(s));
		   
	}
   }   
}

class Ponto /*implements Comparable<Ponto>*/{
	private static int cont = 0;
	private static String flag = "A";
	private String grupo;
	private int x,y,id;
	Ponto(String dados){
		this(dados.substring(0, 1),new Integer(dados.substring(1)));
	}
	Ponto(String grupo,int id){
		this.id = id;
		this.grupo = grupo;
	}
	Ponto(int x, int y,String frag){
		this.x = x;
		this.y = y;
		cont = flag.equals(frag)?cont:0;
		grupo = frag;
		flag = frag;
		id = cont++;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public static int getCont(){
		return cont;
	}
	public int getID(){
		return id;
	}
	public int getDistancia(Ponto outroPonto){
		return (int) Math.sqrt(Math.pow(this.getX() - outroPonto.getX(),2) + Math.pow(this.getY() - outroPonto.getY(),2));
	}
	@Override
	public String toString(){
		return grupo+id;
	}
	public String tiuIstringui(){
		return grupo+id+" x: "+getX()+" y: "+getY();
	}
	public boolean equals(Object outroPonto) {
	    if (!(outroPonto instanceof Ponto)) return false;	    
	    return this.getID() == ((Ponto)outroPonto).getID() && this.grupo.equals(((Ponto)outroPonto).grupo);
	}

	/*public int compareTo(Ponto o) {
		// TODO Auto-generated method stub
		return 0;
	}*/
}