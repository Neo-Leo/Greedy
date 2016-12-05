/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/non-overlapping-intervals/
 */ 

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) return 0; 
        Arrays.sort(intervals, new Comparator<Interval>(){
           public int compare(Interval a, Interval b){
               return (a.start - b.start); 
           } 
        }); 
        // Now intervals is sorted based on start time
        int count = 0, time = intervals[0].end; 
        for(int i=1; i<=intervals.length-1; i++){
            if(intervals[i].start < time){
                time = Math.min(time, intervals[i].end);
                count++; 
            } else {
                time = intervals[i].end; 
            }
        }
        return count; 
    }
}