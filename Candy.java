/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/candy/
 */ 

public class Candy {
    public int candy(int[] a) {
        if(a == null) return 0;
        int n = a.length; 
        if(n <= 1) return 1; 
        int result=1,count=0,lastRating=1,decreasingStretch=0; 
        for(int i=1; i<=n-1; i++) {
            if(a[i-1] <= a[i]){ // Increasing or equal stretch
                if(decreasingStretch > 0){
                    result += decreasingStretch*(decreasingStretch+1)/2; 
                    if(lastRating <= decreasingStretch) result += (decreasingStretch-lastRating+1); 
                    lastRating=1; 
                    decreasingStretch=0; 
                }
                if(a[i-1] < a[i]) { // Increasing Stretch 
                    lastRating++;     
                    result += lastRating;
                } else { // Equal Stretch
                    lastRating = 1;
                    result += lastRating;
                }
            } else { // Decreasing Stretch
                decreasingStretch++;
            } 
        }
        if(decreasingStretch > 0){
            result += decreasingStretch*(decreasingStretch+1)/2;
            if(lastRating <= decreasingStretch) result += (decreasingStretch-lastRating+1);
        }
        return result;
    }
}