import org.encog.platformspecific.j2se.data.image.*;
import org.encog.util.downsample.*;
import org.encog.neural.som.*;
import org.encog.neural.som.training.basic.*;
import org.encog.neural.som.training.basic.neighborhood.*;
import org.encog.ml.data.*;
import org.encog.ml.data.basic.*;
import java.io.*;
import javax.imageio.*;

public class Kohonem{
	
RGBDownsample downsample;
ImageMLData image;
ImageMLDataSet training; 
SOM network = new SOM(50*50*3,2);

{
	network.reset();
}
		
private Kohonem initImg() throws Exception
{		
	downsample = new SimpleIntensityDownsample ( );	
	image = new ImageMLData (ImageIO.read (new File("imagem.png"))) ;
	training = new ImageMLDataSet ( downsample , false , 1 , -1);	
	training.add(image);
	training.downsample(50,50);
	return this;
}

private Kohonem treinamento()
{
	BasicTrainSOM train = new BasicTrainSOM
		(
			network,
			0.7,
			training,
			new NeighborhoodSingle()
		);
	System.out.println("Treinamento!");
	for(int iteration = 0;iteration<=50;iteration++)
		{
			train.iteration();
			//System.out.println("Passo : " + iteration + ", Error : " + train.getError());
		}	
	return this;
}

public static void main(String ...args) throws Exception{
	Kohonem worker = new Kohonem().initImg().treinamento();
	MLData data = new BasicMLData(3);
	data.setData(0, -1);
	data.setData(1, -1);
	data.setData(2, -1);

	System.out.println("Preto :"+worker.network.classify(data));//new ImageMLData (ImageIO.read (new File("marrom.png")))));
	
	data = new BasicMLData(3);
	data.setData(0, 1);
	data.setData(1, 1);
	data.setData(2, 1);
	System.out.println("Branco :"+worker.network.classify(data));//new ImageMLData (ImageIO.read (new File("rosa.png")))));

	System.out.println("OK!");
}
}