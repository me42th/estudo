import java.util.Scanner;
import java.util.Arrays;

public class BR324
{
	final static char carro = 'C';
	static byte gato = 0;
	final static char vacuo = '_';
	static char [][] estrada = new char[13][7];
	//Universo do felino deficiente, a primeira e ultima linha são a calcada.
	//As demais são as pistas: aonde o gatinho mia e a mamãe gato não vê!
	static 
		{
			estrada [0] = new char[] {vacuo,carro,carro,carro,carro,carro,vacuo};	
			estrada [1] = new char[] {vacuo,vacuo,vacuo,vacuo,vacuo,vacuo,vacuo};
			estrada [2] = new char[] {vacuo,vacuo,vacuo,vacuo,vacuo,vacuo,vacuo};
			estrada [3] = new char[] {vacuo,vacuo,vacuo,vacuo,vacuo,vacuo,vacuo};
			estrada [4] = new char[] {vacuo,vacuo,vacuo,vacuo,vacuo,vacuo,vacuo};
			estrada [5] = new char[] {vacuo,vacuo,vacuo,vacuo,vacuo,vacuo,vacuo};
			estrada [6] = new char[] {vacuo,vacuo,vacuo,vacuo,vacuo,vacuo,vacuo};
			estrada [7] = new char[] {vacuo,vacuo,vacuo,vacuo,vacuo,vacuo,vacuo};
			estrada [8] = new char[] {vacuo,vacuo,vacuo,vacuo,vacuo,vacuo,vacuo};
			estrada [9] = new char[] {vacuo,vacuo,vacuo,vacuo,vacuo,vacuo,vacuo};
			estrada [10] = new char[]{vacuo,vacuo,vacuo,vacuo,vacuo,vacuo,vacuo};
			estrada [11] = new char[]{vacuo,vacuo,vacuo,vacuo,vacuo,vacuo,vacuo};
			estrada [12] = new char[]{vacuo,vacuo,vacuo,vacuo,vacuo,vacuo,vacuo};

		}
	//Limite de velocidade em cada pista. 
	//Se nosso felineo procurasse uma faixa, uma autoestrada!
	static int [] velocidade /*= new int []
		{
			new Integer(new Scanner(System.in).findInLine(".*")),
			new Integer(new Scanner(System.in).findInLine(".*")),
			new Integer(new Scanner(System.in).findInLine(".*")),
			new Integer(new Scanner(System.in).findInLine(".*")),
			new Integer(new Scanner(System.in).findInLine(".*"))
		}*/;
		
	//Esse método é responsável por alterar o estado da matriz(carros)
	
	public static void goCar(){
		for(int i = estrada.length-1;i>=0;i--)
			for(int j = 1;j<estrada[i].length-1;j++)	
			{
				if(estrada[i][j] == carro)
				{
					estrada[i][j] = vacuo;
					if(i+velocidade[j-1] < estrada.length){
						estrada[i+velocidade[j-1]][j] = carro;
						estrada[0][j] = (i>=6 && i<=6+velocidade[j-1])?carro:vacuo;
					}
				}
				
			}	
	}
	
	//debug
	
	public static void print(){
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println(gato+"\t|    "+Arrays.toString(velocidade));
		for(int i = 0;i<estrada.length;i++)
			System.out.println(i+"\t| "+Arrays.toString(estrada[i]));
	}
	
	//miau!
	//Verifica o estado do nosso amiguinho...
	
	public static void goCat()
	{
				if(estrada[6][++gato] == carro)
				{	
					//print();
					System.out.println(gato);
					System.exit(0);
				}
				if(gato == 6)
				{	
					//print();
					System.out.println(0);
					System.exit(0);
				}
	}
	public static void main(String ... args){

	velocidade = new int []
		{
			new Integer(args[0]),
			new Integer(args[1]),
			new Integer(args[2]),
			new Integer(args[3]),
			new Integer(args[4])
		};
	while(gato < 7)
		{				
			//print();
			goCar();
			goCat();
			//new Scanner(System.in).findInLine(".*");;
		}
	}
}