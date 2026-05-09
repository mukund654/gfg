// User function Template for Java

class Solution {

    String roundToNearest(String s) {
        // Complete the function
     //   BigInteger num = new BigInteger(s);
        int n   = s.charAt(s.length()-1)-'0';
        String ans = s.substring(0,s.length()-1)+"0";
        if(n<=5){
            
            return ans;
        }
        else{
            int carry = 1;
            int i = 2;
            StringBuilder sb = new StringBuilder(ans);
            while(carry==1){
                if(i>sb.length()){
                    break;
                }
                int m = sb.charAt(sb.length()-i)-'0';
                if(m==9){
                    sb.setCharAt(sb.length()-i, '0');
                    i++;
                }
                else{
                    sb.replace(sb.length()-i,sb.length()-i+1, String.valueOf(m+1));
                    carry = 0;
                }
            }
            if(carry==1){
                String fin = "1" + sb.toString();
                return fin;
            }
            return sb.toString();
        }
    }
}
