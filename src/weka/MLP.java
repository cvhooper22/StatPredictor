package weka;

import weka.classifiers.Classifier;
import weka.core.Instance;

public class MLP
{
	private Classifier resultPredictor;
	
	public MLP()
	{
		try
		{
			resultPredictor = (Classifier) weka.core.SerializationHelper.read("2015-tourney-mlp.model");
		}
		catch (Exception e)
		{
			System.out.println("Error Importing the classifier");
			e.printStackTrace();
		}
	}
	
	public double getResult(Instance attempt)
	{
		try
		{
			return resultPredictor.classifyInstance(attempt);
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1.0;
		}
	}
}
