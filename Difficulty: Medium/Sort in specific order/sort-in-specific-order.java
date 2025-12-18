class Solution {
    public void sortIt(int[] arr) {
        // code here
         Arrays.sort(arr);
        int ind = arr.length-1;
        for(int i = arr.length-1;i>=0;i--){
            if(arr[i]%2==0){
                int temp = arr[ind];
                arr[ind] = arr[i];
                arr[i] = temp;
                ind--;
            }
        }
        if(ind==-1){
            return;
        }
        Arrays.sort(arr,0,ind+1);
        for(int i = 0;i<=ind/2;i++){
            int temp = arr[i];
            arr[i] = arr[ind-i];
            arr[ind-i] = temp;
        }
    }
}
