/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        int i = 0;
        ArrayList<Interval> ret = new ArrayList<Interval>();
        while(i<intervals.size() && intervals.get(i).end < newInterval.start){
            ret.add(intervals.get(i++));
        }
        while(i<intervals.size() && intervals.get(i).start<=newInterval.end){
            newInterval.start = Math.min(intervals.get(i).start,newInterval.start);
            newInterval.end = Math.max(intervals.get(i).end,newInterval.end);
            i++;
        }
        ret.add(newInterval);
        while(i<intervals.size()){
            ret.add(intervals.get(i++));
        }
        return ret;
    }
}