package com.cc.practice.divideTwoIntegers;

class Solution {
    /*public int divide(int dividend, int divisor) {
        int current = Math.abs(dividend);
        int d = Math.abs(divisor);
        int result = 0;
        while (current >= d) {
            current -= d;
            result++;
        }
        return result * ((dividend < 0) != (divisor < 0) ? -1 : 1);
    }*/

    //solution by performing binary long division
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE ) {
            if(divisor == -1) {
                return Integer.MAX_VALUE;
            } else if(divisor == 1) {
                return Integer.MIN_VALUE;
            }
        }

        long lDividend = dividend;
        long dividendAbs =  Math.abs(lDividend);
        long divisorAbs = Math.abs((long) divisor); //abs value of divisor
        long dividendAbsPos = 63; //starting at the most significant bit of the dividence
        long partialDividend = 0; //the portion of the dividend (starting at the left (most significant bits)) that we are looking at right now
        long result = 0;

        while(dividendAbsPos > 0) {
            while(partialDividend < divisorAbs && dividendAbsPos > 0) {
                partialDividend <<= 1;
                partialDividend += (((dividendAbs) >> (dividendAbsPos - 1)) & 1);
                dividendAbsPos--;
            }

            dividendAbsPos++;

            if(partialDividend == divisorAbs) {
                result |= 1 << dividendAbsPos - 1;
                partialDividend = 0;
                dividendAbsPos--;
            } else {
                int partialQuotient = 0;
                while(partialDividend >= divisorAbs) {
                    partialDividend -= divisorAbs;
                    partialQuotient += 1;
                }
                result |= (partialQuotient) << (dividendAbsPos - 1);
                dividendAbsPos--;
                //in this case, partialDividend is the amount left over after subtracting the product of the divisor and the greatest factor that produces a product less than the partialDividend
            }
        }

        return (int) (dividend < 0 == divisor < 0 ? result : -1 * result);
    }
}
