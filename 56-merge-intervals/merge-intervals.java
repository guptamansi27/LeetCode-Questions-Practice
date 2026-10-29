class Solution {
    public int[][] merge(int[][] intervals) {
        //sort by start time
        Arrays.sort(intervals,Comparator.comparingDouble(o->o[0]));

        List<List<Integer>> list = new ArrayList<>();

        int start = intervals[0][0];
        int end=intervals[0][1];

        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<=end){
                end = Math.max(end, intervals[i][1]);
            }else{
                list.add(new ArrayList<>(Arrays.asList(start,end)));

                start = intervals[i][0];
                end=intervals[i][1];
            }
        }
          // Add the last interval
        list.add(new ArrayList<>(Arrays.asList(start,end)));

        return list.stream()
           .sorted((a, b) -> Integer.compare(a.get(0), b.get(0)))
           .map(row -> row.stream().mapToInt(Integer::intValue).toArray())
           .toArray(int[][]::new);
    }
}