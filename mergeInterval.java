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
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval o1, Interval o2){
                return o1.start - o2.start;
            }
        });
        int i = 0;
        ArrayList<Interval> ret = new ArrayList<Interval>();
        while(i < intervals.size()){
            int j = i+1;
            while(j < intervals.size() && intervals.get(i).end >= intervals.get(j).start){
                intervals.get(i).end = Math.max(intervals.get(i).end, intervals.get(j).end);
                j++;
            }
            ret.add(intervals.get(i));
            i = j;
        }
        return ret;
    }
}