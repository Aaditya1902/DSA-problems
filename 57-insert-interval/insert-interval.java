class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        
        List<int[]> merged = new ArrayList<>();

        int i=0;
        int n=intervals.length;

        // if(n<1){
        //     merged.add(newInterval);
        //     return merged.toArray(new int[merged.size()][]);
        // }
        while(i<n && intervals[i][1]  < newInterval[0]){
            merged.add(intervals[i]);
            i++;
        }

       
        while(i<n  && intervals[i][0] <= newInterval[1]){

            if(newInterval[0] >= intervals[i][0]){
                newInterval[0]=intervals[i][0];
            }
        

            if(intervals[i][1] > newInterval[1]){
                newInterval[1]=intervals[i][1];
            
            }
            i++;

        }

        merged.add(newInterval);

        while(i<n ){
            merged.add(intervals[i]);
            i++;
        }

        return merged.toArray(new int[merged.size()][]);


    }
}