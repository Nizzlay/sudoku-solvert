package edu.niels.solver;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class SolverUI extends JFrame {

    private static final Region[] regions = new Region[] { new Region(1), new Region(2), new Region(3), new Region(4),
	    new Region(5), new Region(6), new Region(7), new Region(8), new Region(9) };

    public SolverUI() {
	initUI();
    }

    private void initUI() {
	setTitle("Sudoku Solvert!");
	setLayout(new GridLayout(3, 3));

	for (Region r : regions) {
	    add(r);
	}

	setLocationRelativeTo(null);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void calc(int row, int col, int regio, int nummer) {
	for (Region r : regions) {
	    Vakje[] vakjes = r.getVakjes();
	    int huidigeRegio = r.getID();

	    for (Vakje v : vakjes) {
		int huidigeCol = v.getCol();
		int huidigeRow = v.getRow();

		// niet het vakje wat de calc opdracht geeft
		if (!((huidigeRegio == regio) && (huidigeCol == col) && (huidigeRow == row))) {
		    if (huidigeRegio == regio) {
			v.removeOptie(nummer);
		    }
		    if (v.getCol() == col) {
			v.removeOptie(nummer);
		    }

		    if (v.getRow() == row) {
			v.removeOptie(nummer);
		    }
		}
	    }
	}
    }
}
