package dd.examples;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

import dd.TestHarness;
import javax.swing.JCheckBox;

public class InteractiveDemo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InteractiveDemo frame = new InteractiveDemo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InteractiveDemo() {
		setTitle("Interactive ddmin Demo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel inputPanel = new JPanel();
		GridBagConstraints gbc_inputPanel = new GridBagConstraints();
		gbc_inputPanel.insets = new Insets(0, 0, 5, 0);
		gbc_inputPanel.fill = GridBagConstraints.BOTH;
		gbc_inputPanel.gridx = 0;
		gbc_inputPanel.gridy = 0;
		contentPane.add(inputPanel, gbc_inputPanel);
		GridBagLayout gbl_inputPanel = new GridBagLayout();
		gbl_inputPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_inputPanel.rowHeights = new int[]{0, 0};
		gbl_inputPanel.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_inputPanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		inputPanel.setLayout(gbl_inputPanel);
		
		JPanel inputSetPanel = new JPanel();
		inputSetPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_inputSetPanel = new GridBagConstraints();
		gbc_inputSetPanel.insets = new Insets(0, 0, 0, 5);
		gbc_inputSetPanel.fill = GridBagConstraints.BOTH;
		gbc_inputSetPanel.gridx = 0;
		gbc_inputSetPanel.gridy = 0;
		inputPanel.add(inputSetPanel, gbc_inputSetPanel);
		GridBagLayout gbl_inputSetPanel = new GridBagLayout();
		gbl_inputSetPanel.columnWidths = new int[]{0, 0};
		gbl_inputSetPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_inputSetPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_inputSetPanel.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		inputSetPanel.setLayout(gbl_inputSetPanel);
		
		JLabel inputSetLabel = new JLabel("Input Set");
		GridBagConstraints gbc_inputSetLabel = new GridBagConstraints();
		gbc_inputSetLabel.insets = new Insets(0, 0, 5, 0);
		gbc_inputSetLabel.gridx = 0;
		gbc_inputSetLabel.gridy = 0;
		inputSetPanel.add(inputSetLabel, gbc_inputSetLabel);
		
		JLabel inputSetExampleLabel = new JLabel("Example: \"1, 2, 3, 4\"");
		GridBagConstraints gbc_inputSetExampleLabel = new GridBagConstraints();
		gbc_inputSetExampleLabel.insets = new Insets(0, 0, 5, 0);
		gbc_inputSetExampleLabel.gridx = 0;
		gbc_inputSetExampleLabel.gridy = 1;
		inputSetPanel.add(inputSetExampleLabel, gbc_inputSetExampleLabel);
		
		final JTextArea inputSetTextArea = new JTextArea();
		GridBagConstraints gbc_inputSetTextArea = new GridBagConstraints();
		gbc_inputSetTextArea.fill = GridBagConstraints.BOTH;
		gbc_inputSetTextArea.gridx = 0;
		gbc_inputSetTextArea.gridy = 2;
		inputSetPanel.add(inputSetTextArea, gbc_inputSetTextArea);
		
		JPanel errorConstraintsPanel = new JPanel();
		errorConstraintsPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_errorConstraintsPanel = new GridBagConstraints();
		gbc_errorConstraintsPanel.insets = new Insets(0, 0, 0, 5);
		gbc_errorConstraintsPanel.fill = GridBagConstraints.BOTH;
		gbc_errorConstraintsPanel.gridx = 1;
		gbc_errorConstraintsPanel.gridy = 0;
		inputPanel.add(errorConstraintsPanel, gbc_errorConstraintsPanel);
		GridBagLayout gbl_errorConstraintsPanel = new GridBagLayout();
		gbl_errorConstraintsPanel.columnWidths = new int[]{0, 0};
		gbl_errorConstraintsPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_errorConstraintsPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_errorConstraintsPanel.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		errorConstraintsPanel.setLayout(gbl_errorConstraintsPanel);
		
		JLabel errorConstraintsLabel = new JLabel("Error Constraints");
		GridBagConstraints gbc_errorConstraintsLabel = new GridBagConstraints();
		gbc_errorConstraintsLabel.insets = new Insets(0, 0, 5, 0);
		gbc_errorConstraintsLabel.gridx = 0;
		gbc_errorConstraintsLabel.gridy = 0;
		errorConstraintsPanel.add(errorConstraintsLabel, gbc_errorConstraintsLabel);
		
		JLabel errorConstraintsExampleLabel = new JLabel("Example: \"1, 3\"");
		GridBagConstraints gbc_errorConstraintsExampleLabel = new GridBagConstraints();
		gbc_errorConstraintsExampleLabel.insets = new Insets(0, 0, 5, 0);
		gbc_errorConstraintsExampleLabel.gridx = 0;
		gbc_errorConstraintsExampleLabel.gridy = 1;
		errorConstraintsPanel.add(errorConstraintsExampleLabel, gbc_errorConstraintsExampleLabel);
		
		final JTextArea errorConstraintsTextArea = new JTextArea();
		GridBagConstraints gbc_errorConstraintsTextArea = new GridBagConstraints();
		gbc_errorConstraintsTextArea.fill = GridBagConstraints.BOTH;
		gbc_errorConstraintsTextArea.gridx = 0;
		gbc_errorConstraintsTextArea.gridy = 2;
		errorConstraintsPanel.add(errorConstraintsTextArea, gbc_errorConstraintsTextArea);
		
		JPanel controlPanel = new JPanel();
		controlPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_controlPanel = new GridBagConstraints();
		gbc_controlPanel.fill = GridBagConstraints.BOTH;
		gbc_controlPanel.gridx = 2;
		gbc_controlPanel.gridy = 0;
		inputPanel.add(controlPanel, gbc_controlPanel);
		GridBagLayout gbl_controlPanel = new GridBagLayout();
		gbl_controlPanel.columnWidths = new int[]{0, 0};
		gbl_controlPanel.rowHeights = new int[]{0, 0, 0};
		gbl_controlPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_controlPanel.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		controlPanel.setLayout(gbl_controlPanel);
		
		final JCheckBox includeErrorConstraintSupersets = new JCheckBox("Include Constraint Supersets");
		GridBagConstraints gbc_chckbxIncludeErrorConstraint = new GridBagConstraints();
		gbc_chckbxIncludeErrorConstraint.anchor = GridBagConstraints.NORTH;
		gbc_chckbxIncludeErrorConstraint.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxIncludeErrorConstraint.gridx = 0;
		gbc_chckbxIncludeErrorConstraint.gridy = 0;
		controlPanel.add(includeErrorConstraintSupersets, gbc_chckbxIncludeErrorConstraint);
		
		JButton runButton = new JButton("Run DDMIN");
		GridBagConstraints gbc_runButton = new GridBagConstraints();
		gbc_runButton.gridx = 0;
		gbc_runButton.gridy = 1;
		controlPanel.add(runButton, gbc_runButton);
		
		JPanel outputPanel = new JPanel();
		outputPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_outputPanel = new GridBagConstraints();
		gbc_outputPanel.fill = GridBagConstraints.BOTH;
		gbc_outputPanel.gridx = 0;
		gbc_outputPanel.gridy = 1;
		contentPane.add(outputPanel, gbc_outputPanel);
		GridBagLayout gbl_outputPanel = new GridBagLayout();
		gbl_outputPanel.columnWidths = new int[]{0, 0};
		gbl_outputPanel.rowHeights = new int[]{0, 0};
		gbl_outputPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_outputPanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		outputPanel.setLayout(gbl_outputPanel);
		
		
		final JTextArea outputTextArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(outputTextArea);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		GridBagConstraints gbc_outputTextArea = new GridBagConstraints();
		gbc_outputTextArea.fill = GridBagConstraints.BOTH;
		gbc_outputTextArea.gridx = 0;
		gbc_outputTextArea.gridy = 0;
		outputPanel.add(scrollPane, gbc_outputTextArea);
		
		runButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// get the input set
				String inputString = inputSetTextArea.getText();
				inputString = inputString.replace(" ", "");
				String[] inputs = inputString.split(",");
				LinkedList<Integer> input = new LinkedList<Integer>();
				HashSet<Integer> inputSet = new HashSet<Integer>();
				try {
					for(String inputElement : inputs){
						input.add(Integer.parseInt(inputElement));
						inputSet.add(Integer.parseInt(inputElement));
					}
					if(input.size() != inputSet.size()){
						throw new Exception("Set should not contain duplicates!");
					}
				} catch (Exception ex){
					JOptionPane.showMessageDialog(new JFrame(), "Invalid input set. Error: " + ex.getMessage());
					return;
				}
				
				// get the error constraint set
				String constraintString = errorConstraintsTextArea.getText();
				constraintString = constraintString.replace(" ", "").trim();
				
				final LinkedList<LinkedList<Integer>> constraintSets = new LinkedList<LinkedList<Integer>>();
				String[] functions = constraintString.split("\n");
				for(String function : functions){
					String[] errors = function.split(",");
					final LinkedList<Integer> constraints = new LinkedList<Integer>();
					HashSet<Integer> constraintSet = new HashSet<Integer>();
					try {
						for(String inputElement : errors){
							constraints.add(Integer.parseInt(inputElement));
							constraintSet.add(Integer.parseInt(inputElement));
						}
						if(constraints.size() != constraintSet.size()){
							throw new Exception("Set (" + function + ") should not contain duplicates!");
						}
					} catch (Exception ex){
						JOptionPane.showMessageDialog(new JFrame(), "Invalid error constraint set (" + function + "). Error: " + ex.getMessage());
						return;
					}
					constraintSets.add(constraints);
				}
				
				// create the test harness from the error constraints
				TestHarness<Integer> harness = new TestHarness<Integer>(){
					@Override
					public int run(List<Integer> input) {
						for(LinkedList<Integer> constraints : constraintSets){
							boolean checkEqual = input.containsAll(constraints) && (input.size() == constraints.size());
							boolean checkSupersets = input.containsAll(constraints);
							if(includeErrorConstraintSupersets.isSelected()){
								if (checkSupersets){
									return FAIL; 
								}
							} else {
								if (checkEqual){
									return FAIL; 
								}
							}
						}
						return PASS;
					}
				};
				
				// run ddmin
				VerboseDeltaDebug.ddmin(input, harness, outputTextArea);
			}
		});
	}
	
	public static class VerboseDeltaDebug {

		/**
		 * Given an input that causes a failing/error condition, this implementation of a divide and conquer
		 * algorithm splits the input data into smaller chunks and checks if the smaller input reproduces 
		 * the failing/error condition with a smaller input.

		 * @param input The pre-chunked test input to reduce
		 * @param harness A test harness implementation that returns true (pass) or false (fail/error) for a given input
		 * 
		 * @return A minimized input that reproduces the failing/error condition
		 */
		public static <E> List<E> ddmin(List<E> input, TestHarness<E> harness, JTextArea outputTextArea) {
			
			outputTextArea.setText("ddmin(" + input.toString().replace("[", "").replace("]", "") + ")\n");
			
			int n = 2;
			while(input.size() >= 2) {
				List<List<E>> subsets = split(input, n);
				boolean complementFailing = false;
				
				outputTextArea.append("testing subsets...\n");
				for(List<E> subset : subsets){
					List<E> complement = difference(input, subset);
					
					int test = harness.run(complement);
					
					outputTextArea.append("test(" + complement.toString().replace("[", "").replace("]", "") + ")=");
					if(test == TestHarness.PASS){
						outputTextArea.setText(outputTextArea.getText() + "PASS\n");
					} else if(test == TestHarness.FAIL){
						outputTextArea.append("FAIL\n");
					} else {
						outputTextArea.append("UNRESOLVED\n");
					}
					
					if (test == TestHarness.FAIL) {
						input = complement;
						n = Math.max(n - 1, 2);
						complementFailing = true;
						break;
					}
				}

				if (!complementFailing) {
					if (n == input.size()) {
						break;
					}
					
					// increase set granularity
					n = Math.min(n * 2, input.size());
					outputTextArea.append("increasing granularity\n");
				}
			}

			outputTextArea.append("result: " + input.toString());
			return input;
		}

		/**
		 * Returns the difference of set a and set b
		 * @param a
		 * @param b
		 * @return
		 */
		private static <E> List<E> difference(List<E> a, List<E> b) {
			List<E> result = new LinkedList<E>();
			result.addAll(a);
			result.removeAll(b);
			return result;
		}

		/**
		 * Splits the input set s into n subsets
		 * @param s
		 * @param n
		 * @return
		 */
		private static <E> List<List<E>> split(List<E> s, int n) {
			List<List<E>> subsets = new LinkedList<List<E>>();
			int position = 0;
			for (int i = 0; i < n; i++) {
				List<E> subset = s.subList(position, position + (s.size() - position) / (n - i));
				subsets.add(subset);
				position += subset.size();
			}
			return subsets;
		}

	}

}
