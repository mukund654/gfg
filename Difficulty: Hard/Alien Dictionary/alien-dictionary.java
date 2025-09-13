class Solution {
    public String findOrder(String[] words) {
        // code here
         if(words.length==1){
            int[] check = new int[26];
            for(int i = 0;i<words[0].length();i++){
                check[words[0].charAt(i)-'a']=1;
            }
            StringBuilder sb = new StringBuilder();
            for(int i = 0;i<26;i++){
                if(check[i]==1){
                    sb.append((char)(i+'a'));
                }
            }
            return sb.toString();
        }
        HashMap<Character,ArrayList<Character>> map = new HashMap<>();
        int[] vis = new int[26];
        for(int i = 0;i<words.length-1;i++){
            int n = words[i].length();
            int m = words[i+1].length();
            int t = Math.min(m,n);
            int l = Math.max(m,n);
            String a = words[i];
            String b = words[i+1];
            int flag = 0;
            for(int j = 0;j<l;j++){
                if(flag==0 && j<t&& a.charAt(j)!=b.charAt(j)){
                    if(!map.containsKey(a.charAt(j))){
                        map.put(a.charAt(j),new ArrayList<>());
                    }
                    map.get(a.charAt(j)).add(b.charAt(j));
                    
                    flag =1;
                }
                if(j<a.length()){
                    vis[a.charAt(j)-'a']=1;
                }
                if(j<b.length()){
                    vis[b.charAt(j)-'a']=1;
                }
                
                if(j==t-1){
                    if(t==m && t!=n && flag==0){
                        return "";
                    }
                }
            }
            
        } 
        int [][]mat = new int[26][26];
        for(char key: map.keySet()){
            int n = map.get(key).size();
            for(int i = 0;i<n;i++){
                mat[key-'a'][map.get(key).get(i)-'a']=1;
            }
        }
        
      
        
        
        
        for(int i = 0;i<26;i++){
            for(int j = 0;j<26;j++){
                if(mat[i][j]>0){
                    
                    
                        for(int k = 0;k<26;k++){
                            if(mat[k][i]>0){
                                mat[k][j] = Math.max(mat[k][j], mat[k][i]+mat[i][j]);
                            }
                            
                        }
                    
                    
                }
            }
        }
        
        for(int i = 0;i<26;i++){
            if(mat[i][i]>0){
                return "";
            }
        }
       // int[]loop = new int[26];
        Stack<Character>st = new Stack<>();
        for(int i = 0;i<26;i++){
            if(vis[i]==1){
                findans(map,st,i,vis);
                    
                
                
            }
        }
        
        StringBuilder sb = new StringBuilder();
         //sb.append('e');
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
       
        return sb.toString();
        
       
        
        // int row = -1;
        // int max = 0;
        // for(int i = 0;i<26;i++){
        //     for(int j = 0;j<26;j++){
        //         if(mat[i][j]>max){
        //             max = mat[i][j];
        //             row = i;
        //         }
        //     }
        // }
        // StringBuilder sb = new StringBuilder();
        // sb.append((char)(row-'a'));
        // while(true){
        //     int min = 100;
        //     int col = -1;
        //     for(int i = 0;i<26;i++){
        //         if(mat[row][i]==0){
        //             continue;
        //         }
        //         else if(mat[row][i]<min){
        //             min = mat[row][i];
        //             col = i;
        //             mat[row][i] = 0;
        //         }
        //     }
        //     if(col==-1){
        //         break;
        //     }
        //     sb.append((char)(col-'a'));
            
            
        // }
        //  return sb.toString();
        
        
    }
    
    public void findans(HashMap<Character,ArrayList<Character>> map, Stack<Character>st,int i, int[] vis){
        vis[i] = 0;
       
        //loop[i] = 1;
        char ch = (char)('a'+i);
        if(map.containsKey((char)('a'+i))){
            
            for(int j = 0;j<map.get(ch).size();j++){
                char pass = map.get(ch).get(j);
                if(vis[pass-'a']==1){
                    findans(map,st,pass-'a',vis);
                    
                    
                    
                }
            }
        }
        st.push(ch);
       // loop[i] = 0;
        //return true;
    }
    
    
}