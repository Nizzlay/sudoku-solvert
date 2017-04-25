package edu.niels.solver;

import java.util.ArrayList;

public class SudokuSolver {

    public static final int[] MOGELIJKE_NUMMERS = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

    public static void main(String[] args) {
	SolverUI venstert = new SolverUI();
	venstert.setSize(600, 600);
	venstert.setLocationRelativeTo(null);
	venstert.setVisible(true);
    }

    public static void initArrayList(ArrayList<Integer> array) {
	for (int i : MOGELIJKE_NUMMERS) {
	    array.add(i);
	}
    }
}
