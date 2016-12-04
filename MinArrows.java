// Greedy Appraoch - O(nlogn)
/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
 */ 

public class MinArrows {
    public int findMinArrowShots(int[][] points) {
        if(points == null || points.length == 0 || points[0].length == 0) return 0; 
        Arrays.sort(points, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[0] - b[0];
            }
        });
        int count = 1; 
        int timeOfShooting = points[0][1]; 
        for(int i=1; i<=points.length-1; i++){
            if(points[i][0] <= timeOfShooting) { 
                timeOfShooting = Math.min(timeOfShooting,points[i][1]); 
            } else {
                count++; 
                timeOfShooting = points[i][1];
            }
        }
        return count; 
    }
}