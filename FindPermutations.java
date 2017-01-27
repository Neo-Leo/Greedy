/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/find-permutation/
 */ 

public class FindPermutations {
    public void reverse(int[] arr, int start, int end) {
        int temp; 
        while(start < end){
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp; 
            start++;
            end--;
        }
    }
    
    public int[] findPermutation(String s) {
        if(s==null || s.length() == 0) {
            return new int[0]; 
        }
        int n = s.length();
        int[] arr = new int[n+1]; 
        for(int i=0; i<=n; i++){
            arr[i] = i+1; 
        }
        int start=0, end=0; 
        while(end <= s.length()-1) {
            start=end; 
            while((end <= s.length()-1) && (s.charAt(start) == s.charAt(end))) {
                end++; 
            }
            if(s.charAt(end-1) == 'D') {
                reverse(arr,start,end);
            }
        }
        return arr; 
    }
}
