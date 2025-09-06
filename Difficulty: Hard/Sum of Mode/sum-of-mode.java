class Solution {
    public int sumOfModes(int[] arr, int k) {
        // code here
        HashMap<Integer,Integer> eletofreq = new HashMap<>();
        HashMap<Integer,TreeSet<Integer>> freqtoele = new HashMap<>();
        PriorityQueue<Integer> freq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0;i<k;i++){
            freqtoele.put(i+1,new TreeSet<>());
        }
        int sum = 0;
        for(int i = 0;i<k;i++){
            eletofreq.put(arr[i],eletofreq.getOrDefault(arr[i],0)+1);
            if(eletofreq.get(arr[i])==1){
                freq.add(1);
            }
            else{
                int f = eletofreq.get(arr[i])-1;
                freq.remove(f);
                freq.add(f+1);
            }
        }
        for(int key: eletofreq.keySet()){
            freqtoele.get(eletofreq.get(key)).add(key);
        }
        int f = freq.peek();
        sum += freqtoele.get(f).first();
        
        for(int i = k;i<arr.length;i++){
            // removed left element
            if(arr[i]==arr[i-k]){
                sum+= freqtoele.get(freq.peek()).first();
                continue;
            }
            int rem = arr[i-k];
            int oldfr = eletofreq.get(rem);
            eletofreq.put(rem,oldfr-1);
            if(eletofreq.get(rem)==0){
                eletofreq.remove(rem);
            }
            freq.remove(oldfr);
            if(oldfr!=1){
                freq.add(oldfr-1);
            }
            freqtoele.get(oldfr).remove(rem);
            if(oldfr!=1){
                freqtoele.get(oldfr-1).add(rem);
            }
            
            // adding right element
            int nw = arr[i];
            int nwfr = eletofreq.getOrDefault(nw,0);
            eletofreq.put(nw,nwfr+1);
            if(freq.contains(nwfr)){
                freq.remove(nwfr);
            }
            freq.add(nwfr+1);
            if(nwfr!=0){
                freqtoele.get(nwfr).remove(nw);
                
            }
            freqtoele.get(nwfr+1).add(nw);
            //adding mode in sum
            sum += freqtoele.get(freq.peek()).first();
        }
        return sum;
    }
}