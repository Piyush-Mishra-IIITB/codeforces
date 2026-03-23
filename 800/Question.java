// All question of 800 ratings are here

B. Seating in a Bus

class Main {
    public static void seating(int n, int arr[]) {
        boolean vis[] = new boolean[n + 2]; // safe bounds

        vis[arr[0]] = true;

        for (int k = 1; k < n; k++) {
            int seat = arr[k];

            if (vis[seat - 1] || vis[seat + 1]) {
                vis[seat] = true;
            } else {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }

    public static void main(String[] args) {
        int arr[] = {2, 3, 1};
        seating(3, arr);
    }
}


// A. Favorite Sequence

class Main {
    public static void seating(int n, int arr[]) {
        int i=0;
        int j;
        if(n%2==0){
            j=n-1;
        }else{
            j=n-2;
        }
        int ans[]=new int[n];
        int k=0;
        while(i<n){
            ans[k]=arr[i];
            i+=2;
            k++;
        }
        while(j>=1){
            ans[k]=arr[j];
            k++;
            j-=2;
        }
        
        for(int p=0;p<n;p++){
        System.out.println(ans[p]);
        }
    }

    public static void main(String[] args) {
        int arr[] = {2, 3, 1};
        seating(3, arr);
    }
}


// A. Sereja and Dima

class Main {
    public static void seating(int n, int arr[]) {
         
         int s=0;
         int d=0;
         int i=0;
         int j=n-1;
         while(i<=j){
             
             int max=Math.max(arr[i],arr[j]);
             s+=max;
             if(max==arr[i]){
                 i++;
             }else{
                 j--;
             }
             if(i>j){
                  System.out.print("sereja " + s + "dima"+d);
                 return;
             }
             int secMax=Math.max(arr[i],arr[j]);
             d+=secMax;
             if(secMax==arr[i]){
                 i++;
             }else{
                 j--;
             }
         }
         System.out.print("sereja +" + s + "dima"+d);
    }

    public static void main(String[] args) {
        int arr[] = {2, 3, 1};
        seating(3, arr);
    }
}

B. Discounts(1000 qood ques)
import java.util.*;

class Main {

    public static long sol(int prices[], int vouchers[]) {
        Arrays.sort(prices);
        Arrays.sort(vouchers);

        int n = prices.length;

        long total = 0;
        for (int x : prices) total += x;

        int left = 0;
        int right = n - 1;

        for (int i = 0; i < vouchers.length; i++) {
            int k = vouchers[i];

            if (k == 1) {
               
                total -= prices[right];
                right--;
            } else {
                left += (k - 1);

                total -= prices[left];
                left++;
            }
        }

        return total;
    }

    public static void main(String[] args) {
        int prices[] = {18, 3, 7, 2, 9};
        int vouchers[] = {3, 1, 1};

        System.out.println(sol(prices, vouchers)); 
    }
}




// leetcode-80
class Solution {
    public int removeDuplicates(int[] arr) {
        int i = 0;
        int count = 1;

        for (int j = 1; j < arr.length; j++) {
            if (arr[j] == arr[j - 1]) {
                count++;
            } else {
                count = 1;
            }

            if (count <= 2) {
                i++;
                arr[i] = arr[j];
            }
        }

        return i + 1;
    }
}


C. Equal Values
// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class Main {
    public static int prices(int arr[]){
        
        int output=Integer.MAX_VALUE;
        HashMap<Integer,Integer>hm=new HashMap<>();
        for(int i=0;i<=arr.length-1;i++){
            if(hm.containsKey(arr[i])){
                hm.put(arr[i],hm.get(arr[i]));
            }else{
                hm.put(arr[i],1);
            }
        }
        int ans[]=new int[hm.size()];
        int n=arr.length;
     int  p=0;
        for(Integer i:hm.keySet()){
            int out=findHighestSequence(arr,i);
            // now prices
            ans[p]=(n-out)*i;
            p++;
        }
        // finding min in array
        for(int i=0;i<ans.length;i++){
            output=Math.min(output,ans[i]);
        }
        return output;
    }
    public static int findHighestSequence(int arr[],int no){
        int max=1;
        int current=1;
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]==arr[i+1] && arr[i]==no){
                current++;
                max=Math.max(max,current);
            }
            else{
                current=1;
            }
            
        }
        return max;
    }
    public static void main(String[] args) {
       int arr[]={7, 5, 5, 5, 10, 9, 9, 4, 6, 10};
       System.out.print(prices(arr));
    }
}



//C. Alice, Bob and Chocolate
class Main {
    public static void helper(int arr[]) {

        int n = arr.length;
        int i = 0, j = n - 1;

        int timeA = 0, timeB = 0;
        int countA = 0, countB = 0;

        while (i <= j) {

            if (timeA <= timeB) {
                timeA += arr[i];
                i++;
                countA++;
            } else {
                timeB += arr[j];
                j--;
                countB++;
            }
        }

        System.out.println(countA + " " + countB);
    }

    public static void main(String[] args) {
        int arr[] = {2, 9, 8, 2, 7};
        helper(arr);
    }
}


// max subarray sum with size k

class Main {
    public static int subarray(int arr[],int p){
        int i=0;
        int j=p-1;
        int n=arr.length-1;
        int maxSum=0;
        for (int k=0;k<=j;k++){
                maxSum +=arr[k];
            }
            int currSum=maxSum;
        while(j<n){
            j++;
            currSum=currSum+arr[j]-arr[i];
            maxSum=Math.max(maxSum,currSum);
            i++;
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int arr[]={1,5,2,9,3,5};
        System.out.println(subarray(arr,3));
    }
}

// min length of subarray whose sum>=target
class Main {
    public static int subarray(int arr[],int target){
        int low=0;
         int high;
         int sum=0;
         int length=arr.length;
        for(high=0;high<arr.length;high++){
           sum =sum+arr[high];
           while(sum>=target){
               int l=high-low+1;
               length=Math.min(l,length);
               sum=sum-arr[low];
               low++;
           }
        }
        return length;
    }
    public static void main(String[] args) {
        int arr[]={1,5,2,9,3,5};
        System.out.println(subarray(arr,10));
    }
}

// leetcode-3

class Solution {
    public int lengthOfLongestSubstring(String s) {

       int low=0;
       int high=0;
       int length=0;
       HashMap<Character,Integer>hm=new HashMap<>();
       for(high=0;high<s.length();high++){
         if(hm.containsKey(s.charAt(high))){
            hm.put(s.charAt(high),hm.get(s.charAt(high))+1);
         }
         else{
            hm.put(s.charAt(high),1);
         }
         
         if(hm.size()==high-low+1){
            length=Math.max(hm.size(),length);
         }
         while(hm.size()<high-low+1){
            int a=hm.get(s.charAt(low));
            if(a==1){
                hm.remove(s.charAt(low));
            } else{
                hm.remove(s.charAt(low));
                hm.put(s.charAt(low),a-1);
            }
            low++;
         }
         
       }
       return length;
    }
}

//=- kadanes algorithm


// find max subarray sum

class Main {
    public static int MaxSum(int arr[]){
       
       int best_ending=arr[0];
       int ans=arr[0];
        for(int i=1;i<arr.length;i++){
           int v1=best_ending+arr[i];
           int v2=arr[i];
           best_ending=Math.max(v1,v2);
           ans=Math.max(ans,best_ending);
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[]={-2,4,1,-9,10};
        System.out.println(MaxSum(arr));
    }
}

// max product of subarray


// find max subarray product

class Main {
    public static int MaxProduct(int arr[]){
       int possitive =arr[0];
       int negative=arr[0];
       int ans=arr[0];
       for(int i=1;i<arr.length;i++){
          int v1=arr[i];
          int v2=arr[i]*possitive;
          int v3=arr[i]*negative;
          possitive=Math.max(v1,Math.max(v2,v3));
          negative=Math.min(v1,Math.min(v3,v2));
          ans=Math.max(ans,Math.max(possitive,negative));
       }
       return ans;
    }
    public static void main(String[] args) {
        int arr[]={-2,4,1,-9,10};
        System.out.println(MaxProduct(arr));
    }
}