package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;

import javax.swing.JTextField;

import java.awt.Insets;

import javax.swing.JTextPane;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.SystemColor;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.WindowConstants;

import weka.ResultPredictor;
import weka.StatNames;
import weka.core.Instance;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainWindow
{

	private ArrayList<Double> halfTimeStats;
	private ArrayList<Double> opponentAvg;
	private ArrayList<Double> results;
	private ArrayList<StatNames> focus;
	
	
	private JFrame frmHalftimePredictor;
	private JTextField h_PtsFor;
	private JTextField hPointsAgainst;
	private JTextField hFGPercent;
	private JTextField hFTPercent;
	private JTextField h3PTPercent;
	private JTextField h_EffFGPercent;
	private JTextField h_PtsPerWeightShot;
	private JTextField h_TurnoverRt;
	private JTextField h_Blocks;
	private JTextField h_Fouls;
	private JTextField h_OffReb;
	private JTextField h_TotRebs;
	private JTextField h_Steals;
	private JTextField h_Assists;
	private JTextField h_Possessions;
	private JTextField h_OffPPP;
	private JTextField h_DefPPP;
	private JTextField location;
	private JLabel lblLocation;
	private JLabel lblMyTeamStats;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblFg;
	private JLabel lblFt;
	private JLabel lblpt;
	private JLabel lblEffFg;
	private JLabel lblPpwShot;
	private JLabel lblTrn;
	private JLabel lblBlocks;
	private JLabel lblFouls;
	private JLabel lblOffReb;
	private JLabel lblTotRebs;
	private JLabel lblSteals;
	private JLabel lblAssists;
	private JLabel lblPoss;
	private JLabel lblOffPpp;
	private JLabel lblDefPpp;
	private JLabel lblOpponentAverages;
	private JTextField op_PtsFor;
	private JLabel lblNewLabel_2;
	private JTextField op_PtsAgainst;
	private JTextField op_FGPercent;
	private JTextField op_FTPercent;
	private JTextField op_3PTPercent;
	private JTextField op_EffFGPercent;
	private JTextField op_PPWShot;
	private JTextField op_TORate;
	private JTextField op_Blocks;
	private JTextField op_Fouls;
	private JTextField op_OffReb;
	private JTextField op_TotalRebs;
	private JTextField op_Steals;
	private JTextField op_Assists;
	private JTextField op_Possessions;
	private JTextField op_OffPPP;
	private JTextField op_DefPPP;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel lblFocus;
	private JRadioButton rdbtnRebs;
	private JRadioButton rdbtnFg;
	private JRadioButton rdbtnpt;
	private JRadioButton rdbtnOffrebs;
	private JButton btnCalculateMagicNumbers;
	private JLabel lblMagicNumbers;
	private JTextField res_PtsFor;
	private JTextField res_PtsAg;
	private JTextField res_FGPercent;
	private JTextField res_FTPercent;
	private JTextField res_3PTPercent;
	private JTextField res_EffFGPercent;
	private JTextField res_PPWShot;
	private JTextField res_TORate;
	private JTextField res_Blocks;
	private JTextField res_Fouls;
	private JTextField res_OffReb;
	private JTextField res_TotRebs;
	private JTextField res_Steals;
	private JTextField res_Assists;
	private JTextField res_Possessions;
	private JTextField res_OffPPP;
	private JTextField res_DefPPP;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private JLabel label_9;
	private JLabel label_10;
	private JLabel label_11;
	private JLabel label_12;
	private JLabel label_13;
	private JLabel label_14;
	private JLabel label_15;
	private JLabel label_16;
	private JLabel label_17;
	private JLabel label_18;
	private JLabel label_19;
	private JLabel label_20;
	private JLabel label_21;
	private JLabel label_22;
	private JLabel label_23;
	private JLabel label_24;
	private JLabel label_25;
	private JLabel label_26;
	private JLabel label_27;
	private JLabel label_28;
	private JLabel label_29;
	private JLabel label_30;
	private JLabel label_31;
	private JLabel label_32;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					MainWindow window = new MainWindow();
					window.frmHalftimePredictor.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		halfTimeStats = new ArrayList<Double>();
		opponentAvg = new ArrayList<Double>();
		results = new ArrayList<Double>();
		focus = new ArrayList<StatNames>();
		
		
		frmHalftimePredictor = new JFrame();
		frmHalftimePredictor.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frmHalftimePredictor.setMinimumSize(new Dimension(798, 496));
		frmHalftimePredictor.setTitle("Halftime Predictor");
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(798, 496));
		panel.setBackground(new Color(0, 0, 128));
		frmHalftimePredictor.getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		lblMyTeamStats = new JLabel("MY TEAM STATS");
		lblMyTeamStats.setFont(lblMyTeamStats.getFont().deriveFont(lblMyTeamStats.getFont().getStyle() | Font.BOLD));
		lblMyTeamStats.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblMyTeamStats = new GridBagConstraints();
		gbc_lblMyTeamStats.anchor = GridBagConstraints.WEST;
		gbc_lblMyTeamStats.gridwidth = 2;
		gbc_lblMyTeamStats.insets = new Insets(0, 0, 5, 5);
		gbc_lblMyTeamStats.gridx = 1;
		gbc_lblMyTeamStats.gridy = 0;
		panel.add(lblMyTeamStats, gbc_lblMyTeamStats);
		
		lblLocation = new JLabel("Location");
		lblLocation.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblLocation = new GridBagConstraints();
		gbc_lblLocation.insets = new Insets(0, 0, 5, 5);
		gbc_lblLocation.anchor = GridBagConstraints.EAST;
		gbc_lblLocation.gridx = 8;
		gbc_lblLocation.gridy = 0;
		panel.add(lblLocation, gbc_lblLocation);
		
		location = new JTextField();
		GridBagConstraints gbc_location = new GridBagConstraints();
		gbc_location.insets = new Insets(0, 0, 5, 5);
		gbc_location.fill = GridBagConstraints.HORIZONTAL;
		gbc_location.gridx = 9;
		gbc_location.gridy = 0;
		panel.add(location, gbc_location);
		location.setColumns(10);
		
		h_PtsFor = new JTextField();
		GridBagConstraints gbc_h_PtsFor = new GridBagConstraints();
		gbc_h_PtsFor.insets = new Insets(0, 0, 5, 5);
		gbc_h_PtsFor.fill = GridBagConstraints.HORIZONTAL;
		gbc_h_PtsFor.gridx = 1;
		gbc_h_PtsFor.gridy = 1;
		panel.add(h_PtsFor, gbc_h_PtsFor);
		h_PtsFor.setColumns(10);
		
		hPointsAgainst = new JTextField();
		GridBagConstraints gbc_hPointsAgainst = new GridBagConstraints();
		gbc_hPointsAgainst.fill = GridBagConstraints.HORIZONTAL;
		gbc_hPointsAgainst.insets = new Insets(0, 0, 5, 5);
		gbc_hPointsAgainst.gridx = 2;
		gbc_hPointsAgainst.gridy = 1;
		panel.add(hPointsAgainst, gbc_hPointsAgainst);
		hPointsAgainst.setColumns(10);
		
		hFGPercent = new JTextField();
		GridBagConstraints gbc_hFGPercent = new GridBagConstraints();
		gbc_hFGPercent.fill = GridBagConstraints.HORIZONTAL;
		gbc_hFGPercent.insets = new Insets(0, 0, 5, 5);
		gbc_hFGPercent.gridx = 3;
		gbc_hFGPercent.gridy = 1;
		panel.add(hFGPercent, gbc_hFGPercent);
		hFGPercent.setColumns(10);
		
		hFTPercent = new JTextField();
		GridBagConstraints gbc_hFTPercent = new GridBagConstraints();
		gbc_hFTPercent.insets = new Insets(0, 0, 5, 5);
		gbc_hFTPercent.fill = GridBagConstraints.HORIZONTAL;
		gbc_hFTPercent.gridx = 4;
		gbc_hFTPercent.gridy = 1;
		panel.add(hFTPercent, gbc_hFTPercent);
		hFTPercent.setColumns(10);
		
		h3PTPercent = new JTextField();
		GridBagConstraints gbc_h3PTPercent = new GridBagConstraints();
		gbc_h3PTPercent.insets = new Insets(0, 0, 5, 5);
		gbc_h3PTPercent.fill = GridBagConstraints.HORIZONTAL;
		gbc_h3PTPercent.gridx = 5;
		gbc_h3PTPercent.gridy = 1;
		panel.add(h3PTPercent, gbc_h3PTPercent);
		h3PTPercent.setColumns(10);
		
		h_EffFGPercent = new JTextField();
		GridBagConstraints gbc_h_EffFGPercent = new GridBagConstraints();
		gbc_h_EffFGPercent.insets = new Insets(0, 0, 5, 5);
		gbc_h_EffFGPercent.fill = GridBagConstraints.HORIZONTAL;
		gbc_h_EffFGPercent.gridx = 6;
		gbc_h_EffFGPercent.gridy = 1;
		panel.add(h_EffFGPercent, gbc_h_EffFGPercent);
		h_EffFGPercent.setColumns(10);
		
		h_PtsPerWeightShot = new JTextField();
		GridBagConstraints gbc_h_PtsPerWeightShot = new GridBagConstraints();
		gbc_h_PtsPerWeightShot.insets = new Insets(0, 0, 5, 5);
		gbc_h_PtsPerWeightShot.fill = GridBagConstraints.HORIZONTAL;
		gbc_h_PtsPerWeightShot.gridx = 7;
		gbc_h_PtsPerWeightShot.gridy = 1;
		panel.add(h_PtsPerWeightShot, gbc_h_PtsPerWeightShot);
		h_PtsPerWeightShot.setColumns(10);
		
		h_TurnoverRt = new JTextField();
		GridBagConstraints gbc_h_TurnoverRt = new GridBagConstraints();
		gbc_h_TurnoverRt.insets = new Insets(0, 0, 5, 5);
		gbc_h_TurnoverRt.fill = GridBagConstraints.HORIZONTAL;
		gbc_h_TurnoverRt.gridx = 8;
		gbc_h_TurnoverRt.gridy = 1;
		panel.add(h_TurnoverRt, gbc_h_TurnoverRt);
		h_TurnoverRt.setColumns(10);
		
		h_Blocks = new JTextField();
		GridBagConstraints gbc_h_Blocks = new GridBagConstraints();
		gbc_h_Blocks.insets = new Insets(0, 0, 5, 5);
		gbc_h_Blocks.fill = GridBagConstraints.HORIZONTAL;
		gbc_h_Blocks.gridx = 9;
		gbc_h_Blocks.gridy = 1;
		panel.add(h_Blocks, gbc_h_Blocks);
		h_Blocks.setColumns(10);
		
		h_Fouls = new JTextField();
		GridBagConstraints gbc_h_Fouls = new GridBagConstraints();
		gbc_h_Fouls.insets = new Insets(0, 0, 5, 5);
		gbc_h_Fouls.fill = GridBagConstraints.HORIZONTAL;
		gbc_h_Fouls.gridx = 10;
		gbc_h_Fouls.gridy = 1;
		panel.add(h_Fouls, gbc_h_Fouls);
		h_Fouls.setColumns(10);
		
		h_OffReb = new JTextField();
		GridBagConstraints gbc_h_OffReb = new GridBagConstraints();
		gbc_h_OffReb.insets = new Insets(0, 0, 5, 5);
		gbc_h_OffReb.fill = GridBagConstraints.HORIZONTAL;
		gbc_h_OffReb.gridx = 11;
		gbc_h_OffReb.gridy = 1;
		panel.add(h_OffReb, gbc_h_OffReb);
		h_OffReb.setColumns(10);
		
		h_TotRebs = new JTextField();
		GridBagConstraints gbc_h_TotRebs = new GridBagConstraints();
		gbc_h_TotRebs.insets = new Insets(0, 0, 5, 0);
		gbc_h_TotRebs.fill = GridBagConstraints.HORIZONTAL;
		gbc_h_TotRebs.gridx = 12;
		gbc_h_TotRebs.gridy = 1;
		panel.add(h_TotRebs, gbc_h_TotRebs);
		h_TotRebs.setColumns(10);
		
		lblNewLabel = new JLabel("Points for");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 2;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Pts Ag");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 2;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		lblFg = new JLabel("FG%");
		lblFg.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblFg = new GridBagConstraints();
		gbc_lblFg.insets = new Insets(0, 0, 5, 5);
		gbc_lblFg.gridx = 3;
		gbc_lblFg.gridy = 2;
		panel.add(lblFg, gbc_lblFg);
		
		lblFt = new JLabel("FT%");
		lblFt.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblFt = new GridBagConstraints();
		gbc_lblFt.insets = new Insets(0, 0, 5, 5);
		gbc_lblFt.gridx = 4;
		gbc_lblFt.gridy = 2;
		panel.add(lblFt, gbc_lblFt);
		
		lblpt = new JLabel("3PT%");
		lblpt.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblpt = new GridBagConstraints();
		gbc_lblpt.insets = new Insets(0, 0, 5, 5);
		gbc_lblpt.gridx = 5;
		gbc_lblpt.gridy = 2;
		panel.add(lblpt, gbc_lblpt);
		
		lblEffFg = new JLabel("Eff FG%");
		lblEffFg.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblEffFg = new GridBagConstraints();
		gbc_lblEffFg.insets = new Insets(0, 0, 5, 5);
		gbc_lblEffFg.gridx = 6;
		gbc_lblEffFg.gridy = 2;
		panel.add(lblEffFg, gbc_lblEffFg);
		
		lblPpwShot = new JLabel("PPW Shot");
		lblPpwShot.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblPpwShot = new GridBagConstraints();
		gbc_lblPpwShot.insets = new Insets(0, 0, 5, 5);
		gbc_lblPpwShot.gridx = 7;
		gbc_lblPpwShot.gridy = 2;
		panel.add(lblPpwShot, gbc_lblPpwShot);
		
		lblTrn = new JLabel("TO Rate");
		lblTrn.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblTrn = new GridBagConstraints();
		gbc_lblTrn.insets = new Insets(0, 0, 5, 5);
		gbc_lblTrn.gridx = 8;
		gbc_lblTrn.gridy = 2;
		panel.add(lblTrn, gbc_lblTrn);
		
		lblBlocks = new JLabel("Blocks");
		lblBlocks.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblBlocks = new GridBagConstraints();
		gbc_lblBlocks.insets = new Insets(0, 0, 5, 5);
		gbc_lblBlocks.gridx = 9;
		gbc_lblBlocks.gridy = 2;
		panel.add(lblBlocks, gbc_lblBlocks);
		
		lblFouls = new JLabel("Fouls");
		lblFouls.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblFouls = new GridBagConstraints();
		gbc_lblFouls.insets = new Insets(0, 0, 5, 5);
		gbc_lblFouls.gridx = 10;
		gbc_lblFouls.gridy = 2;
		panel.add(lblFouls, gbc_lblFouls);
		
		lblOffReb = new JLabel("Off Reb");
		lblOffReb.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblOffReb = new GridBagConstraints();
		gbc_lblOffReb.insets = new Insets(0, 0, 5, 5);
		gbc_lblOffReb.gridx = 11;
		gbc_lblOffReb.gridy = 2;
		panel.add(lblOffReb, gbc_lblOffReb);
		
		lblTotRebs = new JLabel("Tot Rebs");
		lblTotRebs.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblTotRebs = new GridBagConstraints();
		gbc_lblTotRebs.insets = new Insets(0, 0, 5, 0);
		gbc_lblTotRebs.gridx = 12;
		gbc_lblTotRebs.gridy = 2;
		panel.add(lblTotRebs, gbc_lblTotRebs);
		
		h_Steals = new JTextField();
		GridBagConstraints gbc_h_Steals = new GridBagConstraints();
		gbc_h_Steals.insets = new Insets(0, 0, 5, 5);
		gbc_h_Steals.fill = GridBagConstraints.HORIZONTAL;
		gbc_h_Steals.gridx = 4;
		gbc_h_Steals.gridy = 3;
		panel.add(h_Steals, gbc_h_Steals);
		h_Steals.setColumns(10);
		
		h_Assists = new JTextField();
		GridBagConstraints gbc_h_Assists = new GridBagConstraints();
		gbc_h_Assists.insets = new Insets(0, 0, 5, 5);
		gbc_h_Assists.fill = GridBagConstraints.HORIZONTAL;
		gbc_h_Assists.gridx = 5;
		gbc_h_Assists.gridy = 3;
		panel.add(h_Assists, gbc_h_Assists);
		h_Assists.setColumns(10);
		
		h_Possessions = new JTextField();
		GridBagConstraints gbc_h_Possessions = new GridBagConstraints();
		gbc_h_Possessions.insets = new Insets(0, 0, 5, 5);
		gbc_h_Possessions.fill = GridBagConstraints.HORIZONTAL;
		gbc_h_Possessions.gridx = 6;
		gbc_h_Possessions.gridy = 3;
		panel.add(h_Possessions, gbc_h_Possessions);
		h_Possessions.setColumns(10);
		
		h_OffPPP = new JTextField();
		GridBagConstraints gbc_h_OffPPP = new GridBagConstraints();
		gbc_h_OffPPP.insets = new Insets(0, 0, 5, 5);
		gbc_h_OffPPP.fill = GridBagConstraints.HORIZONTAL;
		gbc_h_OffPPP.gridx = 7;
		gbc_h_OffPPP.gridy = 3;
		panel.add(h_OffPPP, gbc_h_OffPPP);
		h_OffPPP.setColumns(10);
		
		h_DefPPP = new JTextField();
		GridBagConstraints gbc_h_DefPPP = new GridBagConstraints();
		gbc_h_DefPPP.insets = new Insets(0, 0, 5, 5);
		gbc_h_DefPPP.fill = GridBagConstraints.HORIZONTAL;
		gbc_h_DefPPP.gridx = 8;
		gbc_h_DefPPP.gridy = 3;
		panel.add(h_DefPPP, gbc_h_DefPPP);
		h_DefPPP.setColumns(10);
		
		lblSteals = new JLabel("Steals");
		lblSteals.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblSteals = new GridBagConstraints();
		gbc_lblSteals.insets = new Insets(0, 0, 5, 5);
		gbc_lblSteals.gridx = 4;
		gbc_lblSteals.gridy = 4;
		panel.add(lblSteals, gbc_lblSteals);
		
		lblAssists = new JLabel("Assists");
		lblAssists.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblAssists = new GridBagConstraints();
		gbc_lblAssists.insets = new Insets(0, 0, 5, 5);
		gbc_lblAssists.gridx = 5;
		gbc_lblAssists.gridy = 4;
		panel.add(lblAssists, gbc_lblAssists);
		
		lblPoss = new JLabel("Poss.");
		lblPoss.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblPoss = new GridBagConstraints();
		gbc_lblPoss.insets = new Insets(0, 0, 5, 5);
		gbc_lblPoss.gridx = 6;
		gbc_lblPoss.gridy = 4;
		panel.add(lblPoss, gbc_lblPoss);
		
		lblOffPpp = new JLabel("Off PPP");
		lblOffPpp.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblOffPpp = new GridBagConstraints();
		gbc_lblOffPpp.insets = new Insets(0, 0, 5, 5);
		gbc_lblOffPpp.gridx = 7;
		gbc_lblOffPpp.gridy = 4;
		panel.add(lblOffPpp, gbc_lblOffPpp);
		
		lblDefPpp = new JLabel("Def PPP");
		lblDefPpp.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblDefPpp = new GridBagConstraints();
		gbc_lblDefPpp.insets = new Insets(0, 0, 5, 5);
		gbc_lblDefPpp.gridx = 8;
		gbc_lblDefPpp.gridy = 4;
		panel.add(lblDefPpp, gbc_lblDefPpp);
		
		lblOpponentAverages = new JLabel("OPP AVERAGES");
		lblOpponentAverages.setFont(lblOpponentAverages.getFont().deriveFont(lblOpponentAverages.getFont().getStyle() | Font.BOLD));
		lblOpponentAverages.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblOpponentAverages = new GridBagConstraints();
		gbc_lblOpponentAverages.anchor = GridBagConstraints.WEST;
		gbc_lblOpponentAverages.gridwidth = 2;
		gbc_lblOpponentAverages.insets = new Insets(0, 0, 5, 5);
		gbc_lblOpponentAverages.gridx = 1;
		gbc_lblOpponentAverages.gridy = 5;
		panel.add(lblOpponentAverages, gbc_lblOpponentAverages);
		
		op_PtsFor = new JTextField();
		GridBagConstraints gbc_op_PtsFor = new GridBagConstraints();
		gbc_op_PtsFor.insets = new Insets(0, 0, 5, 5);
		gbc_op_PtsFor.fill = GridBagConstraints.HORIZONTAL;
		gbc_op_PtsFor.gridx = 1;
		gbc_op_PtsFor.gridy = 6;
		panel.add(op_PtsFor, gbc_op_PtsFor);
		op_PtsFor.setColumns(10);
		
		op_PtsAgainst = new JTextField();
		GridBagConstraints gbc_op_PtsAgainst = new GridBagConstraints();
		gbc_op_PtsAgainst.insets = new Insets(0, 0, 5, 5);
		gbc_op_PtsAgainst.fill = GridBagConstraints.HORIZONTAL;
		gbc_op_PtsAgainst.gridx = 2;
		gbc_op_PtsAgainst.gridy = 6;
		panel.add(op_PtsAgainst, gbc_op_PtsAgainst);
		op_PtsAgainst.setColumns(10);
		
		op_FGPercent = new JTextField();
		GridBagConstraints gbc_op_FGPercent = new GridBagConstraints();
		gbc_op_FGPercent.insets = new Insets(0, 0, 5, 5);
		gbc_op_FGPercent.fill = GridBagConstraints.HORIZONTAL;
		gbc_op_FGPercent.gridx = 3;
		gbc_op_FGPercent.gridy = 6;
		panel.add(op_FGPercent, gbc_op_FGPercent);
		op_FGPercent.setColumns(10);
		
		op_FTPercent = new JTextField();
		GridBagConstraints gbc_op_FTPercent = new GridBagConstraints();
		gbc_op_FTPercent.insets = new Insets(0, 0, 5, 5);
		gbc_op_FTPercent.fill = GridBagConstraints.HORIZONTAL;
		gbc_op_FTPercent.gridx = 4;
		gbc_op_FTPercent.gridy = 6;
		panel.add(op_FTPercent, gbc_op_FTPercent);
		op_FTPercent.setColumns(10);
		
		op_3PTPercent = new JTextField();
		GridBagConstraints gbc_op_3PTPercent = new GridBagConstraints();
		gbc_op_3PTPercent.insets = new Insets(0, 0, 5, 5);
		gbc_op_3PTPercent.fill = GridBagConstraints.HORIZONTAL;
		gbc_op_3PTPercent.gridx = 5;
		gbc_op_3PTPercent.gridy = 6;
		panel.add(op_3PTPercent, gbc_op_3PTPercent);
		op_3PTPercent.setColumns(10);
		
		op_EffFGPercent = new JTextField();
		GridBagConstraints gbc_op_EffFGPercent = new GridBagConstraints();
		gbc_op_EffFGPercent.insets = new Insets(0, 0, 5, 5);
		gbc_op_EffFGPercent.fill = GridBagConstraints.HORIZONTAL;
		gbc_op_EffFGPercent.gridx = 6;
		gbc_op_EffFGPercent.gridy = 6;
		panel.add(op_EffFGPercent, gbc_op_EffFGPercent);
		op_EffFGPercent.setColumns(10);
		
		op_PPWShot = new JTextField();
		GridBagConstraints gbc_op_PPWShot = new GridBagConstraints();
		gbc_op_PPWShot.insets = new Insets(0, 0, 5, 5);
		gbc_op_PPWShot.fill = GridBagConstraints.HORIZONTAL;
		gbc_op_PPWShot.gridx = 7;
		gbc_op_PPWShot.gridy = 6;
		panel.add(op_PPWShot, gbc_op_PPWShot);
		op_PPWShot.setColumns(10);
		
		op_TORate = new JTextField();
		GridBagConstraints gbc_op_TORate = new GridBagConstraints();
		gbc_op_TORate.insets = new Insets(0, 0, 5, 5);
		gbc_op_TORate.fill = GridBagConstraints.HORIZONTAL;
		gbc_op_TORate.gridx = 8;
		gbc_op_TORate.gridy = 6;
		panel.add(op_TORate, gbc_op_TORate);
		op_TORate.setColumns(10);
		
		op_Blocks = new JTextField();
		GridBagConstraints gbc_op_Blocks = new GridBagConstraints();
		gbc_op_Blocks.insets = new Insets(0, 0, 5, 5);
		gbc_op_Blocks.fill = GridBagConstraints.HORIZONTAL;
		gbc_op_Blocks.gridx = 9;
		gbc_op_Blocks.gridy = 6;
		panel.add(op_Blocks, gbc_op_Blocks);
		op_Blocks.setColumns(10);
		
		op_Fouls = new JTextField();
		GridBagConstraints gbc_op_Fouls = new GridBagConstraints();
		gbc_op_Fouls.insets = new Insets(0, 0, 5, 5);
		gbc_op_Fouls.fill = GridBagConstraints.HORIZONTAL;
		gbc_op_Fouls.gridx = 10;
		gbc_op_Fouls.gridy = 6;
		panel.add(op_Fouls, gbc_op_Fouls);
		op_Fouls.setColumns(10);
		
		op_OffReb = new JTextField();
		GridBagConstraints gbc_op_OffReb = new GridBagConstraints();
		gbc_op_OffReb.insets = new Insets(0, 0, 5, 5);
		gbc_op_OffReb.fill = GridBagConstraints.HORIZONTAL;
		gbc_op_OffReb.gridx = 11;
		gbc_op_OffReb.gridy = 6;
		panel.add(op_OffReb, gbc_op_OffReb);
		op_OffReb.setColumns(10);
		
		op_TotalRebs = new JTextField();
		GridBagConstraints gbc_op_TotalRebs = new GridBagConstraints();
		gbc_op_TotalRebs.insets = new Insets(0, 0, 5, 0);
		gbc_op_TotalRebs.fill = GridBagConstraints.HORIZONTAL;
		gbc_op_TotalRebs.gridx = 12;
		gbc_op_TotalRebs.gridy = 6;
		panel.add(op_TotalRebs, gbc_op_TotalRebs);
		op_TotalRebs.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Pts. For");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 7;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		label = new JLabel("Pts Ag");
		label.setForeground(Color.WHITE);
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 2;
		gbc_label.gridy = 7;
		panel.add(label, gbc_label);
		
		label_1 = new JLabel("FG%");
		label_1.setForeground(Color.WHITE);
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 3;
		gbc_label_1.gridy = 7;
		panel.add(label_1, gbc_label_1);
		
		label_2 = new JLabel("FT%");
		label_2.setForeground(Color.WHITE);
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 4;
		gbc_label_2.gridy = 7;
		panel.add(label_2, gbc_label_2);
		
		label_8 = new JLabel("3PT%");
		label_8.setForeground(Color.WHITE);
		GridBagConstraints gbc_label_8 = new GridBagConstraints();
		gbc_label_8.insets = new Insets(0, 0, 5, 5);
		gbc_label_8.gridx = 5;
		gbc_label_8.gridy = 7;
		panel.add(label_8, gbc_label_8);
		
		label_10 = new JLabel("Eff FG%");
		label_10.setForeground(Color.WHITE);
		GridBagConstraints gbc_label_10 = new GridBagConstraints();
		gbc_label_10.insets = new Insets(0, 0, 5, 5);
		gbc_label_10.gridx = 6;
		gbc_label_10.gridy = 7;
		panel.add(label_10, gbc_label_10);
		
		label_12 = new JLabel("PPW Shot");
		label_12.setForeground(Color.WHITE);
		GridBagConstraints gbc_label_12 = new GridBagConstraints();
		gbc_label_12.insets = new Insets(0, 0, 5, 5);
		gbc_label_12.gridx = 7;
		gbc_label_12.gridy = 7;
		panel.add(label_12, gbc_label_12);
		
		label_14 = new JLabel("TO Rate");
		label_14.setForeground(Color.WHITE);
		GridBagConstraints gbc_label_14 = new GridBagConstraints();
		gbc_label_14.insets = new Insets(0, 0, 5, 5);
		gbc_label_14.gridx = 8;
		gbc_label_14.gridy = 7;
		panel.add(label_14, gbc_label_14);
		
		label_16 = new JLabel("Blocks");
		label_16.setForeground(Color.WHITE);
		GridBagConstraints gbc_label_16 = new GridBagConstraints();
		gbc_label_16.insets = new Insets(0, 0, 5, 5);
		gbc_label_16.gridx = 9;
		gbc_label_16.gridy = 7;
		panel.add(label_16, gbc_label_16);
		
		label_18 = new JLabel("Fouls");
		label_18.setForeground(Color.WHITE);
		GridBagConstraints gbc_label_18 = new GridBagConstraints();
		gbc_label_18.insets = new Insets(0, 0, 5, 5);
		gbc_label_18.gridx = 10;
		gbc_label_18.gridy = 7;
		panel.add(label_18, gbc_label_18);
		
		label_20 = new JLabel("Off Reb");
		label_20.setForeground(Color.WHITE);
		GridBagConstraints gbc_label_20 = new GridBagConstraints();
		gbc_label_20.insets = new Insets(0, 0, 5, 5);
		gbc_label_20.gridx = 11;
		gbc_label_20.gridy = 7;
		panel.add(label_20, gbc_label_20);
		
		label_22 = new JLabel("Tot Rebs");
		label_22.setForeground(Color.WHITE);
		GridBagConstraints gbc_label_22 = new GridBagConstraints();
		gbc_label_22.insets = new Insets(0, 0, 5, 0);
		gbc_label_22.gridx = 12;
		gbc_label_22.gridy = 7;
		panel.add(label_22, gbc_label_22);
		
		op_Steals = new JTextField();
		GridBagConstraints gbc_op_Steals = new GridBagConstraints();
		gbc_op_Steals.insets = new Insets(0, 0, 5, 5);
		gbc_op_Steals.fill = GridBagConstraints.HORIZONTAL;
		gbc_op_Steals.gridx = 4;
		gbc_op_Steals.gridy = 8;
		panel.add(op_Steals, gbc_op_Steals);
		op_Steals.setColumns(10);
		
		op_Assists = new JTextField();
		GridBagConstraints gbc_op_Assists = new GridBagConstraints();
		gbc_op_Assists.insets = new Insets(0, 0, 5, 5);
		gbc_op_Assists.fill = GridBagConstraints.HORIZONTAL;
		gbc_op_Assists.gridx = 5;
		gbc_op_Assists.gridy = 8;
		panel.add(op_Assists, gbc_op_Assists);
		op_Assists.setColumns(10);
		
		op_Possessions = new JTextField();
		GridBagConstraints gbc_op_Possessions = new GridBagConstraints();
		gbc_op_Possessions.insets = new Insets(0, 0, 5, 5);
		gbc_op_Possessions.fill = GridBagConstraints.HORIZONTAL;
		gbc_op_Possessions.gridx = 6;
		gbc_op_Possessions.gridy = 8;
		panel.add(op_Possessions, gbc_op_Possessions);
		op_Possessions.setColumns(10);
		
		op_OffPPP = new JTextField();
		GridBagConstraints gbc_op_OffPPP = new GridBagConstraints();
		gbc_op_OffPPP.insets = new Insets(0, 0, 5, 5);
		gbc_op_OffPPP.fill = GridBagConstraints.HORIZONTAL;
		gbc_op_OffPPP.gridx = 7;
		gbc_op_OffPPP.gridy = 8;
		panel.add(op_OffPPP, gbc_op_OffPPP);
		op_OffPPP.setColumns(10);
		
		op_DefPPP = new JTextField();
		GridBagConstraints gbc_op_DefPPP = new GridBagConstraints();
		gbc_op_DefPPP.insets = new Insets(0, 0, 5, 5);
		gbc_op_DefPPP.fill = GridBagConstraints.HORIZONTAL;
		gbc_op_DefPPP.gridx = 8;
		gbc_op_DefPPP.gridy = 8;
		panel.add(op_DefPPP, gbc_op_DefPPP);
		op_DefPPP.setColumns(10);
		
		label_3 = new JLabel("Steals");
		label_3.setForeground(Color.WHITE);
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 4;
		gbc_label_3.gridy = 9;
		panel.add(label_3, gbc_label_3);
		
		label_25 = new JLabel("Assists");
		label_25.setForeground(Color.WHITE);
		GridBagConstraints gbc_label_25 = new GridBagConstraints();
		gbc_label_25.insets = new Insets(0, 0, 5, 5);
		gbc_label_25.gridx = 5;
		gbc_label_25.gridy = 9;
		panel.add(label_25, gbc_label_25);
		
		label_27 = new JLabel("Poss.");
		label_27.setForeground(Color.WHITE);
		GridBagConstraints gbc_label_27 = new GridBagConstraints();
		gbc_label_27.insets = new Insets(0, 0, 5, 5);
		gbc_label_27.gridx = 6;
		gbc_label_27.gridy = 9;
		panel.add(label_27, gbc_label_27);
		
		label_29 = new JLabel("Off PPP");
		label_29.setForeground(Color.WHITE);
		GridBagConstraints gbc_label_29 = new GridBagConstraints();
		gbc_label_29.insets = new Insets(0, 0, 5, 5);
		gbc_label_29.gridx = 7;
		gbc_label_29.gridy = 9;
		panel.add(label_29, gbc_label_29);
		
		label_31 = new JLabel("Def PPP");
		label_31.setForeground(Color.WHITE);
		GridBagConstraints gbc_label_31 = new GridBagConstraints();
		gbc_label_31.insets = new Insets(0, 0, 5, 5);
		gbc_label_31.gridx = 8;
		gbc_label_31.gridy = 9;
		panel.add(label_31, gbc_label_31);
		
		lblFocus = new JLabel("FOCUS");
		lblFocus.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFocus.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblFocus = new GridBagConstraints();
		gbc_lblFocus.insets = new Insets(0, 0, 5, 5);
		gbc_lblFocus.gridx = 1;
		gbc_lblFocus.gridy = 11;
		panel.add(lblFocus, gbc_lblFocus);
		
		rdbtnRebs = new JRadioButton("Rebs");
		rdbtnRebs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				res_TotRebs.setBackground(new Color(255, 0, 0));
				res_TotRebs.setForeground(new Color(255,255,255));
				focus.add(StatNames.TOT_REBS);
			}
		});
		GridBagConstraints gbc_rdbtnRebs = new GridBagConstraints();
		gbc_rdbtnRebs.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnRebs.gridx = 2;
		gbc_rdbtnRebs.gridy = 11;
		panel.add(rdbtnRebs, gbc_rdbtnRebs);
		
		rdbtnFg = new JRadioButton("FG%");
		rdbtnFg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				res_FGPercent.setBackground(new Color(255,0,0));
				res_FGPercent.setForeground(new Color(255,255,255));
				focus.add(StatNames.FG_PERCENT);
			}
		});
		GridBagConstraints gbc_rdbtnFg = new GridBagConstraints();
		gbc_rdbtnFg.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnFg.gridx = 3;
		gbc_rdbtnFg.gridy = 11;
		panel.add(rdbtnFg, gbc_rdbtnFg);
		
		rdbtnpt = new JRadioButton("3PT%");
		rdbtnpt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				res_3PTPercent.setBackground(new Color(255,0,0));
				res_3PTPercent.setForeground(new Color(255,255,255));
				focus.add(StatNames.THREE_PERCENT);
			}
		});
		GridBagConstraints gbc_rdbtnpt = new GridBagConstraints();
		gbc_rdbtnpt.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnpt.gridx = 4;
		gbc_rdbtnpt.gridy = 11;
		panel.add(rdbtnpt, gbc_rdbtnpt);
		
		rdbtnOffrebs = new JRadioButton("ORebs");
		rdbtnOffrebs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				res_OffReb.setBackground(new Color(255,0,0));
				res_OffReb.setForeground(new Color(255,255,255));
				focus.add(StatNames.OFF_REBS);
			}
		});
		GridBagConstraints gbc_rdbtnOffrebs = new GridBagConstraints();
		gbc_rdbtnOffrebs.anchor = GridBagConstraints.WEST;
		gbc_rdbtnOffrebs.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnOffrebs.gridx = 5;
		gbc_rdbtnOffrebs.gridy = 11;
		panel.add(rdbtnOffrebs, gbc_rdbtnOffrebs);
		
		btnCalculateMagicNumbers = new JButton("Calculate Magic Numbers");
		btnCalculateMagicNumbers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setUpMyStats();
				setUpOppAvgs();
				
				ResultPredictor predictor = new ResultPredictor(halfTimeStats, opponentAvg, focus,
																 location.getText());
				
				results = predictor.getResults();
				
				outputResult();
			}

			
		});
		btnCalculateMagicNumbers.setFont(new Font("Bodoni MT", Font.PLAIN, 13));
		GridBagConstraints gbc_btnCalculateMagicNumbers = new GridBagConstraints();
		gbc_btnCalculateMagicNumbers.fill = GridBagConstraints.VERTICAL;
		gbc_btnCalculateMagicNumbers.gridheight = 2;
		gbc_btnCalculateMagicNumbers.gridwidth = 3;
		gbc_btnCalculateMagicNumbers.insets = new Insets(0, 0, 5, 5);
		gbc_btnCalculateMagicNumbers.gridx = 5;
		gbc_btnCalculateMagicNumbers.gridy = 12;
		panel.add(btnCalculateMagicNumbers, gbc_btnCalculateMagicNumbers);
		
		lblMagicNumbers = new JLabel("MAGIC NUMBERS");
		lblMagicNumbers.setForeground(Color.WHITE);
		lblMagicNumbers.setFont(lblMagicNumbers.getFont().deriveFont(lblMagicNumbers.getFont().getStyle() | Font.BOLD));
		GridBagConstraints gbc_lblMagicNumbers = new GridBagConstraints();
		gbc_lblMagicNumbers.anchor = GridBagConstraints.WEST;
		gbc_lblMagicNumbers.gridwidth = 2;
		gbc_lblMagicNumbers.insets = new Insets(0, 0, 5, 5);
		gbc_lblMagicNumbers.gridx = 1;
		gbc_lblMagicNumbers.gridy = 14;
		panel.add(lblMagicNumbers, gbc_lblMagicNumbers);
		
		res_PtsFor = new JTextField();
		GridBagConstraints gbc_res_PtsFor = new GridBagConstraints();
		gbc_res_PtsFor.insets = new Insets(0, 0, 5, 5);
		gbc_res_PtsFor.fill = GridBagConstraints.HORIZONTAL;
		gbc_res_PtsFor.gridx = 1;
		gbc_res_PtsFor.gridy = 15;
		panel.add(res_PtsFor, gbc_res_PtsFor);
		res_PtsFor.setColumns(10);
		
		res_PtsAg = new JTextField();
		GridBagConstraints gbc_res_PtsAg = new GridBagConstraints();
		gbc_res_PtsAg.insets = new Insets(0, 0, 5, 5);
		gbc_res_PtsAg.fill = GridBagConstraints.HORIZONTAL;
		gbc_res_PtsAg.gridx = 2;
		gbc_res_PtsAg.gridy = 15;
		panel.add(res_PtsAg, gbc_res_PtsAg);
		res_PtsAg.setColumns(10);
		
		res_FGPercent = new JTextField();
		GridBagConstraints gbc_res_FGPercent = new GridBagConstraints();
		gbc_res_FGPercent.insets = new Insets(0, 0, 5, 5);
		gbc_res_FGPercent.fill = GridBagConstraints.HORIZONTAL;
		gbc_res_FGPercent.gridx = 3;
		gbc_res_FGPercent.gridy = 15;
		panel.add(res_FGPercent, gbc_res_FGPercent);
		res_FGPercent.setColumns(10);
		
		res_FTPercent = new JTextField();
		GridBagConstraints gbc_res_FTPercent = new GridBagConstraints();
		gbc_res_FTPercent.insets = new Insets(0, 0, 5, 5);
		gbc_res_FTPercent.fill = GridBagConstraints.HORIZONTAL;
		gbc_res_FTPercent.gridx = 4;
		gbc_res_FTPercent.gridy = 15;
		panel.add(res_FTPercent, gbc_res_FTPercent);
		res_FTPercent.setColumns(10);
		
		res_3PTPercent = new JTextField();
		GridBagConstraints gbc_res_3PTPercent = new GridBagConstraints();
		gbc_res_3PTPercent.insets = new Insets(0, 0, 5, 5);
		gbc_res_3PTPercent.fill = GridBagConstraints.HORIZONTAL;
		gbc_res_3PTPercent.gridx = 5;
		gbc_res_3PTPercent.gridy = 15;
		panel.add(res_3PTPercent, gbc_res_3PTPercent);
		res_3PTPercent.setColumns(10);
		
		res_EffFGPercent = new JTextField();
		GridBagConstraints gbc_res_EffFGPercent = new GridBagConstraints();
		gbc_res_EffFGPercent.insets = new Insets(0, 0, 5, 5);
		gbc_res_EffFGPercent.fill = GridBagConstraints.HORIZONTAL;
		gbc_res_EffFGPercent.gridx = 6;
		gbc_res_EffFGPercent.gridy = 15;
		panel.add(res_EffFGPercent, gbc_res_EffFGPercent);
		res_EffFGPercent.setColumns(10);
		
		res_PPWShot = new JTextField();
		GridBagConstraints gbc_res_PPWShot = new GridBagConstraints();
		gbc_res_PPWShot.insets = new Insets(0, 0, 5, 5);
		gbc_res_PPWShot.fill = GridBagConstraints.HORIZONTAL;
		gbc_res_PPWShot.gridx = 7;
		gbc_res_PPWShot.gridy = 15;
		panel.add(res_PPWShot, gbc_res_PPWShot);
		res_PPWShot.setColumns(10);
		
		res_TORate = new JTextField();
		GridBagConstraints gbc_res_TORate = new GridBagConstraints();
		gbc_res_TORate.insets = new Insets(0, 0, 5, 5);
		gbc_res_TORate.fill = GridBagConstraints.HORIZONTAL;
		gbc_res_TORate.gridx = 8;
		gbc_res_TORate.gridy = 15;
		panel.add(res_TORate, gbc_res_TORate);
		res_TORate.setColumns(10);
		
		res_Blocks = new JTextField();
		GridBagConstraints gbc_res_Blocks = new GridBagConstraints();
		gbc_res_Blocks.insets = new Insets(0, 0, 5, 5);
		gbc_res_Blocks.fill = GridBagConstraints.HORIZONTAL;
		gbc_res_Blocks.gridx = 9;
		gbc_res_Blocks.gridy = 15;
		panel.add(res_Blocks, gbc_res_Blocks);
		res_Blocks.setColumns(10);
		
		res_Fouls = new JTextField();
		GridBagConstraints gbc_res_Fouls = new GridBagConstraints();
		gbc_res_Fouls.insets = new Insets(0, 0, 5, 5);
		gbc_res_Fouls.fill = GridBagConstraints.HORIZONTAL;
		gbc_res_Fouls.gridx = 10;
		gbc_res_Fouls.gridy = 15;
		panel.add(res_Fouls, gbc_res_Fouls);
		res_Fouls.setColumns(10);
		
		res_OffReb = new JTextField();
		GridBagConstraints gbc_res_OffReb = new GridBagConstraints();
		gbc_res_OffReb.insets = new Insets(0, 0, 5, 5);
		gbc_res_OffReb.fill = GridBagConstraints.HORIZONTAL;
		gbc_res_OffReb.gridx = 11;
		gbc_res_OffReb.gridy = 15;
		panel.add(res_OffReb, gbc_res_OffReb);
		res_OffReb.setColumns(10);
		
		res_TotRebs = new JTextField();
		GridBagConstraints gbc_res_TotRebs = new GridBagConstraints();
		gbc_res_TotRebs.insets = new Insets(0, 0, 5, 0);
		gbc_res_TotRebs.fill = GridBagConstraints.HORIZONTAL;
		gbc_res_TotRebs.gridx = 12;
		gbc_res_TotRebs.gridy = 15;
		panel.add(res_TotRebs, gbc_res_TotRebs);
		res_TotRebs.setColumns(10);
		
		label_4 = new JLabel("Pts. For");
		label_4.setForeground(Color.WHITE);
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 1;
		gbc_label_4.gridy = 16;
		panel.add(label_4, gbc_label_4);
		
		label_5 = new JLabel("Pts Ag");
		label_5.setForeground(Color.WHITE);
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.insets = new Insets(0, 0, 5, 5);
		gbc_label_5.gridx = 2;
		gbc_label_5.gridy = 16;
		panel.add(label_5, gbc_label_5);
		
		label_6 = new JLabel("FG%");
		label_6.setForeground(Color.WHITE);
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.insets = new Insets(0, 0, 5, 5);
		gbc_label_6.gridx = 3;
		gbc_label_6.gridy = 16;
		panel.add(label_6, gbc_label_6);
		
		label_7 = new JLabel("FT%");
		label_7.setForeground(Color.WHITE);
		GridBagConstraints gbc_label_7 = new GridBagConstraints();
		gbc_label_7.insets = new Insets(0, 0, 5, 5);
		gbc_label_7.gridx = 4;
		gbc_label_7.gridy = 16;
		panel.add(label_7, gbc_label_7);
		
		label_9 = new JLabel("3PT%");
		label_9.setForeground(Color.WHITE);
		GridBagConstraints gbc_label_9 = new GridBagConstraints();
		gbc_label_9.insets = new Insets(0, 0, 5, 5);
		gbc_label_9.gridx = 5;
		gbc_label_9.gridy = 16;
		panel.add(label_9, gbc_label_9);
		
		label_11 = new JLabel("Eff FG%");
		label_11.setForeground(Color.WHITE);
		GridBagConstraints gbc_label_11 = new GridBagConstraints();
		gbc_label_11.insets = new Insets(0, 0, 5, 5);
		gbc_label_11.gridx = 6;
		gbc_label_11.gridy = 16;
		panel.add(label_11, gbc_label_11);
		
		label_13 = new JLabel("PPW Shot");
		label_13.setForeground(Color.WHITE);
		GridBagConstraints gbc_label_13 = new GridBagConstraints();
		gbc_label_13.insets = new Insets(0, 0, 5, 5);
		gbc_label_13.gridx = 7;
		gbc_label_13.gridy = 16;
		panel.add(label_13, gbc_label_13);
		
		label_15 = new JLabel("TO Rate");
		label_15.setForeground(Color.WHITE);
		GridBagConstraints gbc_label_15 = new GridBagConstraints();
		gbc_label_15.insets = new Insets(0, 0, 5, 5);
		gbc_label_15.gridx = 8;
		gbc_label_15.gridy = 16;
		panel.add(label_15, gbc_label_15);
		
		label_17 = new JLabel("Blocks");
		label_17.setForeground(Color.WHITE);
		GridBagConstraints gbc_label_17 = new GridBagConstraints();
		gbc_label_17.insets = new Insets(0, 0, 5, 5);
		gbc_label_17.gridx = 9;
		gbc_label_17.gridy = 16;
		panel.add(label_17, gbc_label_17);
		
		label_19 = new JLabel("Fouls");
		label_19.setForeground(Color.WHITE);
		GridBagConstraints gbc_label_19 = new GridBagConstraints();
		gbc_label_19.insets = new Insets(0, 0, 5, 5);
		gbc_label_19.gridx = 10;
		gbc_label_19.gridy = 16;
		panel.add(label_19, gbc_label_19);
		
		label_21 = new JLabel("Off Reb");
		label_21.setForeground(Color.WHITE);
		GridBagConstraints gbc_label_21 = new GridBagConstraints();
		gbc_label_21.insets = new Insets(0, 0, 5, 5);
		gbc_label_21.gridx = 11;
		gbc_label_21.gridy = 16;
		panel.add(label_21, gbc_label_21);
		
		label_23 = new JLabel("Tot Rebs");
		label_23.setForeground(Color.WHITE);
		GridBagConstraints gbc_label_23 = new GridBagConstraints();
		gbc_label_23.insets = new Insets(0, 0, 5, 0);
		gbc_label_23.gridx = 12;
		gbc_label_23.gridy = 16;
		panel.add(label_23, gbc_label_23);
		
		res_Steals = new JTextField();
		GridBagConstraints gbc_res_Steals = new GridBagConstraints();
		gbc_res_Steals.insets = new Insets(0, 0, 5, 5);
		gbc_res_Steals.fill = GridBagConstraints.HORIZONTAL;
		gbc_res_Steals.gridx = 4;
		gbc_res_Steals.gridy = 17;
		panel.add(res_Steals, gbc_res_Steals);
		res_Steals.setColumns(10);
		
		res_Assists = new JTextField();
		GridBagConstraints gbc_res_Assists = new GridBagConstraints();
		gbc_res_Assists.insets = new Insets(0, 0, 5, 5);
		gbc_res_Assists.fill = GridBagConstraints.HORIZONTAL;
		gbc_res_Assists.gridx = 5;
		gbc_res_Assists.gridy = 17;
		panel.add(res_Assists, gbc_res_Assists);
		res_Assists.setColumns(10);
		
		res_Possessions = new JTextField();
		GridBagConstraints gbc_res_Possessions = new GridBagConstraints();
		gbc_res_Possessions.insets = new Insets(0, 0, 5, 5);
		gbc_res_Possessions.fill = GridBagConstraints.HORIZONTAL;
		gbc_res_Possessions.gridx = 6;
		gbc_res_Possessions.gridy = 17;
		panel.add(res_Possessions, gbc_res_Possessions);
		res_Possessions.setColumns(10);
		
		res_OffPPP = new JTextField();
		GridBagConstraints gbc_res_OffPPP = new GridBagConstraints();
		gbc_res_OffPPP.insets = new Insets(0, 0, 5, 5);
		gbc_res_OffPPP.fill = GridBagConstraints.HORIZONTAL;
		gbc_res_OffPPP.gridx = 7;
		gbc_res_OffPPP.gridy = 17;
		panel.add(res_OffPPP, gbc_res_OffPPP);
		res_OffPPP.setColumns(10);
		
		res_DefPPP = new JTextField();
		GridBagConstraints gbc_res_DefPPP = new GridBagConstraints();
		gbc_res_DefPPP.insets = new Insets(0, 0, 5, 5);
		gbc_res_DefPPP.fill = GridBagConstraints.HORIZONTAL;
		gbc_res_DefPPP.gridx = 8;
		gbc_res_DefPPP.gridy = 17;
		panel.add(res_DefPPP, gbc_res_DefPPP);
		res_DefPPP.setColumns(10);
		
		label_24 = new JLabel("Steals");
		label_24.setForeground(Color.WHITE);
		GridBagConstraints gbc_label_24 = new GridBagConstraints();
		gbc_label_24.insets = new Insets(0, 0, 0, 5);
		gbc_label_24.gridx = 4;
		gbc_label_24.gridy = 18;
		panel.add(label_24, gbc_label_24);
		
		label_26 = new JLabel("Assists");
		label_26.setForeground(Color.WHITE);
		GridBagConstraints gbc_label_26 = new GridBagConstraints();
		gbc_label_26.insets = new Insets(0, 0, 0, 5);
		gbc_label_26.gridx = 5;
		gbc_label_26.gridy = 18;
		panel.add(label_26, gbc_label_26);
		
		label_28 = new JLabel("Poss.");
		label_28.setForeground(Color.WHITE);
		GridBagConstraints gbc_label_28 = new GridBagConstraints();
		gbc_label_28.insets = new Insets(0, 0, 0, 5);
		gbc_label_28.gridx = 6;
		gbc_label_28.gridy = 18;
		panel.add(label_28, gbc_label_28);
		
		label_30 = new JLabel("Off PPP");
		label_30.setForeground(Color.WHITE);
		GridBagConstraints gbc_label_30 = new GridBagConstraints();
		gbc_label_30.insets = new Insets(0, 0, 0, 5);
		gbc_label_30.gridx = 7;
		gbc_label_30.gridy = 18;
		panel.add(label_30, gbc_label_30);
		
		label_32 = new JLabel("Def PPP");
		label_32.setForeground(Color.WHITE);
		GridBagConstraints gbc_label_32 = new GridBagConstraints();
		gbc_label_32.insets = new Insets(0, 0, 0, 5);
		gbc_label_32.gridx = 8;
		gbc_label_32.gridy = 18;
		panel.add(label_32, gbc_label_32);
	}
	
	private void setUpMyStats()
	{
		halfTimeStats.add(-22.0);//to make sure that location is the 0th index
		halfTimeStats.add(Double.valueOf(h_PtsFor.getText()));
		halfTimeStats.add(Double.valueOf(hPointsAgainst.getText()));
		halfTimeStats.add(Double.valueOf(hFGPercent.getText()));
		halfTimeStats.add(Double.valueOf(hFTPercent.getText()));
		halfTimeStats.add(Double.valueOf(h3PTPercent.getText()));
		halfTimeStats.add(Double.valueOf(h_EffFGPercent.getText()));
		halfTimeStats.add(Double.valueOf(h_PtsPerWeightShot.getText()));
		halfTimeStats.add(Double.valueOf(h_TurnoverRt.getText()));
		halfTimeStats.add(Double.valueOf(h_Blocks.getText()));
		halfTimeStats.add(Double.valueOf(h_Fouls.getText()));
		halfTimeStats.add(Double.valueOf(h_OffReb.getText()));
		halfTimeStats.add(Double.valueOf(h_TotRebs.getText()));
		halfTimeStats.add(Double.valueOf(h_Steals.getText()));
		halfTimeStats.add(Double.valueOf(h_Assists.getText()));
		halfTimeStats.add(Double.valueOf(h_Possessions.getText()));
		halfTimeStats.add(Double.valueOf(h_OffPPP.getText()));
		halfTimeStats.add(Double.valueOf(h_DefPPP.getText()));
		
	}

	private void setUpOppAvgs()
	{
		opponentAvg.add(Double.valueOf(op_PtsFor.getText()));
		opponentAvg.add(Double.valueOf(op_PtsAgainst.getText()));
		opponentAvg.add(Double.valueOf(op_FGPercent.getText()));
		opponentAvg.add(Double.valueOf(op_FTPercent.getText()));
		opponentAvg.add(Double.valueOf(op_3PTPercent.getText()));
		opponentAvg.add(Double.valueOf(op_EffFGPercent.getText()));
		opponentAvg.add(Double.valueOf(op_PPWShot.getText()));
		opponentAvg.add(Double.valueOf(op_TORate.getText()));
		opponentAvg.add(Double.valueOf(op_Blocks.getText()));
		opponentAvg.add(Double.valueOf(op_Fouls.getText()));
		opponentAvg.add(Double.valueOf(op_OffReb.getText()));
		opponentAvg.add(Double.valueOf(op_TotalRebs.getText()));
		opponentAvg.add(Double.valueOf(op_Steals.getText()));
		opponentAvg.add(Double.valueOf(op_Assists.getText()));
		opponentAvg.add(Double.valueOf(op_Possessions.getText()));
		opponentAvg.add(Double.valueOf(op_OffPPP.getText()));
		opponentAvg.add(Double.valueOf(op_DefPPP.getText()));
		
	}

	private void outputResult()
	{
		if(results.size() == 0)
		{
			res_PtsFor.setText("NO");
			res_PtsAg.setText("WIN");
			res_FGPercent.setText("POSS");
			res_FTPercent.setText("IBLE");
			return;
		}
		res_PtsFor.setText(String.valueOf(Math.floor(results.get(0)*1000) / 1000d));
		res_PtsAg.setText(String.valueOf(Math.floor(results.get(1)*1000) / 1000d));
		res_FGPercent.setText(String.valueOf(Math.floor(results.get(2)*1000) / 1000d));
		res_FTPercent.setText(String.valueOf(Math.floor(results.get(3)*1000) / 1000d));
		res_3PTPercent.setText(String.valueOf(Math.floor(results.get(4)*1000) / 1000d));
		res_EffFGPercent.setText(String.valueOf(Math.floor(results.get(5)*1000) / 1000d));
		res_PPWShot.setText(String.valueOf(Math.floor(results.get(6)*1000) / 1000d));
		res_TORate.setText(String.valueOf(Math.floor(results.get(7)*1000) / 1000d));
		res_Blocks.setText(String.valueOf(Math.floor(results.get(8)*1000) / 1000d));
		res_Fouls.setText(String.valueOf(Math.floor(results.get(9)*1000) / 1000d));
		res_OffReb.setText(String.valueOf(Math.floor(results.get(10)*1000) / 1000d));
		res_TotRebs.setText(String.valueOf(Math.floor(results.get(11)*1000) / 1000d));
		res_Steals.setText(String.valueOf(Math.floor(results.get(12)*1000) / 1000d));
		res_Assists.setText(String.valueOf(Math.floor(results.get(13)*1000) / 1000d));
		res_Possessions.setText(String.valueOf(Math.floor(results.get(14)*1000) / 1000d));
		res_OffPPP.setText(String.valueOf(Math.floor(results.get(15)*1000) / 1000d));
		res_DefPPP.setText(String.valueOf(Math.floor(results.get(16)*1000) / 1000d));
		
	}

}
