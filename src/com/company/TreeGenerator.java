package com.company;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class TreeGenerator {
    private BigInteger[] cats = null;
    private BigInteger factoriel(BigInteger n){
        BigInteger fact = BigInteger.valueOf(1);
        for(BigInteger i = BigInteger.valueOf(1); i.compareTo(n) == 0 || i.compareTo(n) < 0 ; i = i.add(BigInteger.valueOf(1))){
            fact = fact.multiply(i);
        }
        return fact;
    }

    public BigInteger catalan(BigInteger n){
        /*
            cat = (2n)!/(n+1)!n!
         */
        return factoriel(n.multiply(BigInteger.valueOf(2)))
                .divide(
                        factoriel(n.add(BigInteger.valueOf(1)))
                                .multiply(factoriel(n)));
    }

    public Node generateTree(int n){
        if( n == 0)
            return null;
        if (n == 1)
            return new Node(0, null, null, null);
        if(cats == null){
            cats = new BigInteger[n + 1];
            for(int i = 0; i <= n; i++){
                cats[i] = catalan(BigInteger.valueOf(i));
            }
        }

        List<SimpleTriplet> dec = new ArrayList<>(n);
        for(int i = 0; i < n; i++){
            dec.add(new SimpleTriplet(i, n - 1 - i, cats[n - i - 1].multiply(cats[i])));
        }
        Collections.sort(dec, (t1, t2) -> t1.count.compareTo(t2.count) * (-1));
        Random random = new Random();
        BigInteger r = BigInteger.valueOf(random.nextLong() % cats[n].intValue());
        int i = 0;

        while(r.compareTo(BigInteger.valueOf(0)) > 0){
            r = r.subtract(dec.get(i).count);
            i++;
        }
        if(i > 0)
            i--;
        return new Node(0, null, generateTree(dec.get(i).left), generateTree(dec.get(i).right));
    }
}












