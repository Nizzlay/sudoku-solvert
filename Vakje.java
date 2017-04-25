package edu.niels.solver;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Vakje extends JPanel implements MouseListener {

    private int currentNumber;

    private ArrayList<Integer> mogelijkeNummers = new ArrayList<Integer>();

    private int region;
    private int row;
    private int col;

    public Vakje(int re, int ro, int co) {
	// init variabelen
	this.region = re;
	this.row = ro;
	this.col = co;

	SudokuSolver.initArrayList(mogelijkeNummers);

	bouwUI();
	addMouseListener(this);
    }

    public void setCurrentNumber(int nummer) {
	mogelijkeNummers.clear();
	mogelijkeNummers.add(nummer);

	this.currentNumber = nummer;

	SolverUI.calc(this.row, this.col, this.region, this.currentNumber);
	this.bouwUI();
    }

    private void bouwUI() {

	removeAll();

	// maar één optie over die op deze plek kan zijn
	if (mogelijkeNummers.size() == 1) {
	    JLabel nummerLabel = new JLabel(String.valueOf(currentNumber));
	    Font font = new Font(nummerLabel.getFont().getName(), Font.BOLD, 18);
	    nummerLabel.setFont(font);

	    setLayout(new FlowLayout(FlowLayout.CENTER));
	    add(nummerLabel);

	} else {
	    setLayout(new GridLayout(3, 3));

	    for (int i : SudokuSolver.MOGELIJKE_NUMMERS) {
		JLabel nummerLabel = new JLabel("");
		Object nummert = (Object) i;

		if (mogelijkeNummers.contains(nummert)) {
		    nummerLabel.setText(String.valueOf(i));
		}

		add(nummerLabel);
	    }
	}

	setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	setBorder(BorderFactory.createDashedBorder(Color.GRAY));
    }

    public int getCurrentNumber() {
	return currentNumber;
    }

    public int getRegion() {
	return region;
    }

    public int getRow() {
	return row;
    }

    public int getCol() {
	return col;
    }

    public void mouseClicked(MouseEvent e) {

	Object[] possibilities = new Object[this.mogelijkeNummers.size()];

	for (int i = 0; i < this.mogelijkeNummers.size(); i++) {
	    possibilities[i] = this.mogelijkeNummers.get(i);
	}

	int i = (int) JOptionPane.showInputDialog(null, "Welk nummer moet hier komen te staan?", "Customized Dialog",
		JOptionPane.PLAIN_MESSAGE, null, possibilities, possibilities[0]);

	if (i <= 9) {
	    this.setCurrentNumber(i);
	} else {
	    System.out.println(i);
	}
    }

    public void removeOptie(int nummer) {
	Object nummert = (Object) nummer;

	if (this.mogelijkeNummers.contains(nummert)) {
	    this.mogelijkeNummers.remove(nummert);
	    checkOpties();
	    this.bouwUI();
	}
    }

    private void checkOpties() {
	if (mogelijkeNummers.size() == 1) {
	    this.setCurrentNumber(mogelijkeNummers.get(0));
	}
    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }
}
