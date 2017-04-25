package edu.niels.solver;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Region extends JPanel {

    private int ID;
    private Vakje[] vakjes;

    public Region(int id) {
	setVariabelen(id);

	setLayout(new GridLayout(3, 3));
	buildRegion();
    }

    public int getID() {
	return ID;
    }

    public Vakje[] getVakjes() {
	return vakjes;
    }

    private void setVariabelen(int id) {
	ID = id;

	int[] rowOpties = null;
	int[] colOpties = null;

	switch (id) {
	case 1:
	    rowOpties = new int[] { 1, 2, 3 };
	    colOpties = new int[] { 1, 2, 3 };
	    break;
	case 2:
	    rowOpties = new int[] { 1, 2, 3 };
	    colOpties = new int[] { 4, 5, 6 };
	    break;
	case 3:
	    rowOpties = new int[] { 1, 2, 3 };
	    colOpties = new int[] { 7, 8, 9 };
	    break;
	case 4:
	    rowOpties = new int[] { 4, 5, 6 };
	    colOpties = new int[] { 1, 2, 3 };
	    break;
	case 5:
	    rowOpties = new int[] { 4, 5, 6 };
	    colOpties = new int[] { 4, 5, 6 };
	    break;
	case 6:
	    rowOpties = new int[] { 4, 5, 6 };
	    colOpties = new int[] { 7, 8, 9 };
	    break;
	case 7:
	    rowOpties = new int[] { 7, 8, 9 };
	    colOpties = new int[] { 1, 2, 3 };
	    break;
	case 8:
	    rowOpties = new int[] { 7, 8, 9 };
	    colOpties = new int[] { 4, 5, 6 };
	    break;
	case 9:
	    rowOpties = new int[] { 7, 8, 9 };
	    colOpties = new int[] { 7, 8, 9 };
	    break;
	}

	vakjes = new Vakje[] { new Vakje(ID, rowOpties[0], colOpties[0]), new Vakje(ID, rowOpties[0], colOpties[1]),
		new Vakje(ID, rowOpties[0], colOpties[2]), new Vakje(ID, rowOpties[1], colOpties[0]),
		new Vakje(ID, rowOpties[1], colOpties[1]), new Vakje(ID, rowOpties[1], colOpties[2]),
		new Vakje(ID, rowOpties[2], colOpties[0]), new Vakje(ID, rowOpties[2], colOpties[1]),
		new Vakje(ID, rowOpties[2], colOpties[2]) };

    }

    private void buildRegion() {

	for (Vakje v : vakjes) {
	    add(v);
	}

	setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
	setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}