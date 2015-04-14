package weka;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.xml.transform.stax.StAXSource;

import weka.core.FastVector;
import weka.core.Instance;
import weka.core.Attribute;
import weka.core.Instances;
import weka.core.converters.ArffLoader.ArffReader;
import weka.core.converters.ArffSaver;

public class ResultPredictor
{
	private Instance winAttempt;
	private MLP winClassifier;
	private ArrayList<StatNames> focusList;
	private Instances averages;//the instances loaded from the data
	private Instance myAverages;//my team averages
	private static double maxRebs;
	private static double maxORebs;
	private static double maxFGPercent;
	private static double max3Percent;
	private static Random random;
	private Instances testInstances;
	
	public ResultPredictor()
	{
		
	}
	
	public ResultPredictor(ArrayList<Double> myStats, ArrayList<Double> theirStats, 
							ArrayList<StatNames> focus, String where)
	{
		random = new Random(System.currentTimeMillis());
		BufferedReader reader;
		try
		{
			reader = new BufferedReader(new FileReader("byu_avgs.arff"));
			ArffReader arff = new ArffReader(reader);
			averages = arff.getData();
			myAverages = averages.instance(0);
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		max3Percent = 34 + 5;//magic numbers here, the first comes from looking up the highest season
		//stat for the team whose averages we are loading, the second is a buffer to allow a little bit
		//of growth for the stat above the previous high
		maxFGPercent = 39 + 5;
		maxORebs = 10 + 5;
		maxRebs = 32 + 5;
		focusList = focus;
		winClassifier = new MLP();
		winAttempt = new Instance(36);
		
		//Set up Dataset and Features
		//create the location attribute
		FastVector fvLocationValue = new FastVector(3); 
		fvLocationValue.addElement("h");
		fvLocationValue.addElement("a");
		fvLocationValue.addElement("n");
		Attribute location = new Attribute("location", fvLocationValue);
				
		Attribute points_for = new weka.core.Attribute("points_for");
		Attribute points_against = new weka.core.Attribute("points_against");
		Attribute field_goal_percent = new weka.core.Attribute("field_goal_percent");
		Attribute free_throw_percent = new weka.core.Attribute("free_throw_percent");
		Attribute three_point_percent = new weka.core.Attribute("three_point_percent");
		Attribute efficient_field_goal_percent = new weka.core.Attribute("efficient_field_goal_percent");
		Attribute points_per_weighted_shot = new weka.core.Attribute("points_per_weighted_shot");
		Attribute turnover_rate = new weka.core.Attribute("turnover_rate");
		Attribute blocks = new weka.core.Attribute("blocks");
		Attribute fouls = new weka.core.Attribute("fouls");
		Attribute offensive_rebounds = new weka.core.Attribute("offensive_rebounds");
		Attribute total_rebounds = new weka.core.Attribute("total_rebounds");
		Attribute steals = new weka.core.Attribute("steals");
		Attribute assists = new weka.core.Attribute("assists");
		Attribute possessions = new weka.core.Attribute("possessions");
		Attribute offensive_points_per_possession = new weka.core.Attribute("offensive_points_per_possession");
		Attribute defensive_points_per_possession = new weka.core.Attribute("defensive_points_per_possession");
		Attribute opp_points_for = new weka.core.Attribute("opp_points_for");
		Attribute opp_points_against = new weka.core.Attribute("opp_points_against");
		Attribute opp_field_goal_percent = new weka.core.Attribute("opp_field_goal_percent");
		Attribute opp_free_throw_percent = new weka.core.Attribute("opp_free_throw_percent");
		Attribute opp_three_point_percent = new weka.core.Attribute("opp_three_point_percent");
		Attribute opp_efficient_field_goal_percent = new weka.core.Attribute("opp_efficient_field_goal_percent");
		Attribute opp_points_per_weighted_shot = new weka.core.Attribute("opp_points_per_weighted_shot");
		Attribute opp_turnover_rate = new weka.core.Attribute("opp_turnover_rate");
		Attribute opp_blocks = new weka.core.Attribute("opp_blocks");
		Attribute opp_fouls = new weka.core.Attribute("opp_fouls");
		Attribute opp_offensive_rebounds = new weka.core.Attribute("opp_offensive_rebounds");
		Attribute opp_total_rebounds = new weka.core.Attribute("opp_total_rebounds");
		Attribute opp_steals = new weka.core.Attribute("opp_	steals");
		Attribute opp_assists = new weka.core.Attribute("opp_assists");
		Attribute opp_possessions = new weka.core.Attribute("opp_possessions");
		Attribute opp_offensive_points_per_possession = new weka.core.Attribute("opp_offensive_points_per_possession");
		Attribute opp_defensive_points_per_possession = new weka.core.Attribute("opp_defensive_points_per_possession");
		
		//create the class attribute
		FastVector fvClassValue = new FastVector(2); 
		fvClassValue.addElement("w");
		fvClassValue.addElement("l");
		Attribute outcome = new Attribute("outcome", fvClassValue);
		
		//Declare the feature vector
		FastVector fvMyFeatures = new FastVector(36);
		fvMyFeatures.addElement(location);
		fvMyFeatures.addElement(points_for);
		fvMyFeatures.addElement(points_against);
		fvMyFeatures.addElement(field_goal_percent);
		fvMyFeatures.addElement(free_throw_percent);
		fvMyFeatures.addElement(three_point_percent);
		fvMyFeatures.addElement(efficient_field_goal_percent);
		fvMyFeatures.addElement(points_per_weighted_shot);
		fvMyFeatures.addElement(turnover_rate);
		fvMyFeatures.addElement(blocks);
		fvMyFeatures.addElement(fouls);
		fvMyFeatures.addElement(offensive_rebounds);
		fvMyFeatures.addElement(total_rebounds);
		fvMyFeatures.addElement(steals);
		fvMyFeatures.addElement(assists);
		fvMyFeatures.addElement(possessions);
		fvMyFeatures.addElement(offensive_points_per_possession);
		fvMyFeatures.addElement(defensive_points_per_possession);
		
		fvMyFeatures.addElement(opp_points_for);
		fvMyFeatures.addElement(opp_points_against);
		fvMyFeatures.addElement(opp_field_goal_percent);
		fvMyFeatures.addElement(opp_free_throw_percent);
		fvMyFeatures.addElement(opp_three_point_percent);
		fvMyFeatures.addElement(opp_efficient_field_goal_percent);
		fvMyFeatures.addElement(opp_points_per_weighted_shot);
		fvMyFeatures.addElement(opp_turnover_rate);
		fvMyFeatures.addElement(opp_blocks);
		fvMyFeatures.addElement(opp_fouls);
		fvMyFeatures.addElement(opp_offensive_rebounds);
		fvMyFeatures.addElement(opp_total_rebounds);
		fvMyFeatures.addElement(opp_steals);
		fvMyFeatures.addElement(opp_assists);
		fvMyFeatures.addElement(opp_possessions);
		fvMyFeatures.addElement(opp_offensive_points_per_possession);
		fvMyFeatures.addElement(opp_defensive_points_per_possession);
		fvMyFeatures.addElement(outcome);
		
		//create the dataset
		testInstances = new Instances("WinAttempts", fvMyFeatures, 2);
		testInstances.setClassIndex(testInstances.numAttributes() - 1);
		
		
		//populate the instance to test, MAKE SURE LOCATION IS ATTRIBUTE 0 IN myStats
		winAttempt.setValue((Attribute) fvMyFeatures.elementAt(0), where);
		winAttempt.setValue((Attribute) fvMyFeatures.elementAt(1), myStats.get(1));
		
		if(myStats.get(2) > myAverages.value(1))//this will degrade any abnormal first half values
		//so as to not skew the rest of the numbers
		{
			winAttempt.setValue((Attribute) fvMyFeatures.elementAt(2), myAverages.value(1));
		}
		else {
			winAttempt.setValue((Attribute) fvMyFeatures.elementAt(2), myStats.get(2));
			
		}
		
		if(myStats.get(3) > myAverages.value(2))
		{
			winAttempt.setValue((Attribute) fvMyFeatures.elementAt(3), myAverages.value(2));
		}
		else {
			winAttempt.setValue((Attribute) fvMyFeatures.elementAt(3), myStats.get(3));
		}
		
		if(myStats.get(4) > myAverages.value(3))
		{
			winAttempt.setValue((Attribute) fvMyFeatures.elementAt(4), myAverages.value(3));
		}
		else {
			winAttempt.setValue((Attribute) fvMyFeatures.elementAt(4), myStats.get(4));
		}
		
		if(myStats.get(5) > myAverages.value(4))
		{
			winAttempt.setValue((Attribute) fvMyFeatures.elementAt(5), myAverages.value(4));
		}
		else
		{
			winAttempt.setValue((Attribute) fvMyFeatures.elementAt(5), myStats.get(5));
		}
		
		winAttempt.setValue((Attribute) fvMyFeatures.elementAt(6), myStats.get(6));
		winAttempt.setValue((Attribute) fvMyFeatures.elementAt(7), myStats.get(7));
		winAttempt.setValue((Attribute) fvMyFeatures.elementAt(8), myStats.get(8));
		winAttempt.setValue((Attribute) fvMyFeatures.elementAt(9), myStats.get(9));
		winAttempt.setValue((Attribute) fvMyFeatures.elementAt(10), myStats.get(10));
		winAttempt.setValue((Attribute) fvMyFeatures.elementAt(11), myStats.get(11));
		winAttempt.setValue((Attribute) fvMyFeatures.elementAt(12), myStats.get(12));
		winAttempt.setValue((Attribute) fvMyFeatures.elementAt(13), myStats.get(13));
		winAttempt.setValue((Attribute) fvMyFeatures.elementAt(14), myStats.get(14));
		winAttempt.setValue((Attribute) fvMyFeatures.elementAt(15), myStats.get(15));
		winAttempt.setValue((Attribute) fvMyFeatures.elementAt(16), myStats.get(16));
		winAttempt.setValue((Attribute) fvMyFeatures.elementAt(17), myStats.get(17));
		
		winAttempt.setValue((Attribute) fvMyFeatures.elementAt(18), theirStats.get(0));
		winAttempt.setValue((Attribute) fvMyFeatures.elementAt(19), theirStats.get(1));
		winAttempt.setValue((Attribute) fvMyFeatures.elementAt(20), theirStats.get(2));
		winAttempt.setValue((Attribute) fvMyFeatures.elementAt(21), theirStats.get(3));
		winAttempt.setValue((Attribute) fvMyFeatures.elementAt(22), theirStats.get(4));
		winAttempt.setValue((Attribute) fvMyFeatures.elementAt(23), theirStats.get(5));
		winAttempt.setValue((Attribute) fvMyFeatures.elementAt(24), theirStats.get(6));
		winAttempt.setValue((Attribute) fvMyFeatures.elementAt(25), theirStats.get(7));
		winAttempt.setValue((Attribute) fvMyFeatures.elementAt(26), theirStats.get(8));
		winAttempt.setValue((Attribute) fvMyFeatures.elementAt(27), theirStats.get(9));
		winAttempt.setValue((Attribute) fvMyFeatures.elementAt(28), theirStats.get(10));
		winAttempt.setValue((Attribute) fvMyFeatures.elementAt(29), theirStats.get(11));
		winAttempt.setValue((Attribute) fvMyFeatures.elementAt(30), theirStats.get(12));
		winAttempt.setValue((Attribute) fvMyFeatures.elementAt(31), theirStats.get(13));
		winAttempt.setValue((Attribute) fvMyFeatures.elementAt(32), theirStats.get(14));
		winAttempt.setValue((Attribute) fvMyFeatures.elementAt(33), theirStats.get(15));
		winAttempt.setValue((Attribute) fvMyFeatures.elementAt(34), theirStats.get(16));
		
		
		winAttempt.setDataset(testInstances);
		winAttempt.setClassValue("l");
		
	}
	
	public ArrayList<Double> getResults()
	{
		ArrayList<Double> results = new ArrayList<Double>();
		boolean acceptableResult = false;//to make sure that the loop is entered first
		double result = -2.0;
		while(!acceptableResult)
		{
			try
			{
				result = winClassifier.getResult(winAttempt);
			}
			catch (Exception e)
			{
				e.printStackTrace();
				System.out.println("Aha! an error: " + e.getMessage());
			}
			
			if(result == -1.0)
			{
				acceptableResult = true;
			}
			else if(result == 0.0)
			{
				acceptableResult = true;
			}
			else
			{
				if(updateWinAttempt(winAttempt))
				{
					result = winClassifier.getResult(winAttempt);
					acceptableResult = true;
				}
			}
		}
		
		if(result == -1.0)
		{
			return results;
		}
		//populate the ArrayList from final winAttempt Instance
		ArffSaver saver = new ArffSaver();
		saver.setInstances(testInstances);
		try
		{
			saver.setFile(new File("./byuResult1.arff"));
			saver.writeBatch();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 1; i < 18; i++)
		{
			results.add(winAttempt.value(i));
		}
		return results;
	}

	private boolean updateWinAttempt(Instance winAttempt)
	{
		//check for focus values
		boolean maxedOut = false;//used as a marker, if all stats are maxed out this will be true
		//at the end of the function and we will stop trying to win i.e. unfortunately a win is 
		//impossible to obtain with this classifier and the current max values
		
		//GO THROUGH EACH STAT THAT ISN'T A POSSIBLE FOCUS VALUE
		maxedOut =instanceUpdate(StatNames.PTS_FOR, 3, false, 
				 myAverages.value(StatNames.PTS_FOR.ordinal()) + 5);
		maxedOut =instanceUpdate(StatNames.PTS_AGAINST, 2, false, 
				 myAverages.value(StatNames.PTS_AGAINST.ordinal()) + 5);
		maxedOut =instanceUpdate(StatNames.FT_PERCENT, 1, false, 
				 myAverages.value(StatNames.FT_PERCENT.ordinal()) + 7);
		maxedOut =instanceUpdate(StatNames.EFF_PERCENT, 1, false, 
				 myAverages.value(StatNames.EFF_PERCENT.ordinal()) + 5);
		maxedOut =instanceUpdate(StatNames.PPWS, 0.01, false, 
				 myAverages.value(StatNames.PPWS.ordinal()) + 0.5);
		maxedOut =instanceUpdate(StatNames.TO_RATE, 0.001, false,//non desirable, increase slowly 
				 myAverages.value(StatNames.TO_RATE.ordinal()));
		maxedOut =instanceUpdate(StatNames.BLOCKS, 1, false, 
				 myAverages.value(StatNames.BLOCKS.ordinal()) + 5);
		maxedOut =instanceUpdate(StatNames.FOULS, 0.5, false,//non desirable 
				 myAverages.value(StatNames.FOULS.ordinal()));
		maxedOut =instanceUpdate(StatNames.STEALS, 1, false, 
				 myAverages.value(StatNames.STEALS.ordinal()) + 5);
		maxedOut =instanceUpdate(StatNames.ASSISTS, 1, false, 
				 myAverages.value(StatNames.ASSISTS.ordinal()) + 7);
		maxedOut =instanceUpdate(StatNames.POSS, 2, false, 
				 myAverages.value(StatNames.POSS.ordinal()) + 10);//max is bigger here to account for
		//changes in pace
		double pppDiff = winAttempt.value(StatNames.OFF_PPP.ordinal() + 1) - 
							(winAttempt.value(StatNames.PTS_FOR.ordinal() + 1)) / 
								(winAttempt.value(StatNames.POSS.ordinal() + 1));
		if(pppDiff < 0.01)
		{
			pppDiff = 0.01;
		}
		maxedOut =instanceUpdate(StatNames.OFF_PPP, pppDiff, false, 
				 myAverages.value(StatNames.OFF_PPP.ordinal()) + 0.5);
		maxedOut =instanceUpdate(StatNames.DEF_PP, 0.001, false,//non desirable 
				 myAverages.value(StatNames.DEF_PP.ordinal()));
		
		
		if(focusList.contains(StatNames.OFF_REBS))
		{
			maxedOut =instanceUpdate(StatNames.OFF_REBS, 1, true, maxORebs);
		}
		else 
		{
			maxedOut =instanceUpdate(StatNames.OFF_REBS, 0.5, false, 
									 myAverages.value(StatNames.OFF_REBS.ordinal()) + 5);
		}
		
		if(focusList.contains(StatNames.TOT_REBS))
		{
			maxedOut =instanceUpdate(StatNames.TOT_REBS, 1.5, true, maxRebs);
		}
		else 
		{
			maxedOut =instanceUpdate(StatNames.TOT_REBS, 0.5, false,
									 myAverages.value(StatNames.TOT_REBS.ordinal()) + 5);
		}
		
		if(focusList.contains(StatNames.THREE_PERCENT))
		{
			maxedOut =instanceUpdate(StatNames.THREE_PERCENT, 1.5, true, max3Percent);
		}
		else 
		{
			maxedOut =instanceUpdate(StatNames.THREE_PERCENT, 0.5, false,
									 myAverages.value(StatNames.THREE_PERCENT.ordinal()) + 5);
		}
		
		if(focusList.contains(StatNames.FG_PERCENT))
		{
			maxedOut =instanceUpdate(StatNames.FG_PERCENT, 1.5, true, maxFGPercent);
		}
		else 
		{
			maxedOut =instanceUpdate(StatNames.FG_PERCENT,0.5, false,
									 myAverages.value(StatNames.FG_PERCENT.ordinal()) + 5);
		}
		return maxedOut;
	}

	private boolean instanceUpdate(StatNames statFocus, double i, boolean isFocus, double thisMax)
	{
		double currentValue = winAttempt.value(statFocus.ordinal() + 1);
		double average = myAverages.value(statFocus.ordinal());
		
		if(currentValue < average)
		{
			winAttempt.setValue(statFocus.ordinal() + 1, currentValue + i);
		}
		else if(currentValue >= average) 
		{
			if(isFocus)
			{
				if(currentValue >= thisMax)
				{
					return true;
				}
				else 
				{
					winAttempt.setValue(statFocus.ordinal() + 1, currentValue + i);
				}
			}
			else 
			{
				if(currentValue >= thisMax)
				{
					return true;
				}
				else
				{
					//randomly update 25%(?) of the time- can play with this randomness
					int randInt = random.nextInt();
					if(randInt % 4 == 0)
					{
						winAttempt.setValue(statFocus.ordinal() + 1, currentValue + i);
					}
				}
				
			}
		}
		return false;
	}

	

}
