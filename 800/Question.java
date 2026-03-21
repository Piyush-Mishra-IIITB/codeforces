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