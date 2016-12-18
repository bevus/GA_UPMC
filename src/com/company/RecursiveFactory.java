package com.company;

import java.math.BigInteger;
import java.util.Random;

public class RecursiveFactory implements NodeFactory {
	private int bits;
	private int[] catalan;
	
	@Override
	public Node generate(int n) {
		bits = 0;
		if (n == 0)
			return null;
		if (n == 1)
			return new Node(0,null,null,null);
		
		// Pr�calcul de la suite de Catalan
		catalan = new int[n];
		catalan[0] = 1;
		catalan[1] = 1;
		
		for (int i = 2; i <= n; i++) {
			// Calcul de Catalan de i
			for (int j = 0; j <= i-1; j++)
				catalan[i] += catalan[j]*catalan[i-1-j];
		}
		
		for (int i=0;i < catalan.length;i++) {
			System.out.println(catalan[i]);
		}
		
		return generateRec(n);
	}
	
	public Node generateRec(int n) {
		if (n == 1)
			return new Node(0,null,null,null);
		
		// Tirage de r
		bits += Math.ceil(Math.log(catalan[n])/Math.log(2));
//		int r = Tools.RandInt(catalan[n]);
		Random gen = new Random();
		int r = gen.nextInt(catalan[n]);
		
		// Remplir le tableau dec
		int dec[] = new int[n+2];
		dec[0] = catalan[n-1];
		dec[1] = catalan[n-1];
		
		// Cf pseudocode cours
		
		return null;
	}
	
	@Override
	public int getBits() {
		return bits;
	}
}
