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

// circular max sum

class Main {
    public static int maxCircularSum(int arr[]) {
        int totalSum = 0;

        int maxEnding = arr[0], maxSum = arr[0];
        int minEnding = arr[0], minSum = arr[0];

        for (int i = 0; i < arr.length; i++) {
            totalSum += arr[i];
            maxEnding = Math.max(arr[i], maxEnding + arr[i]);
            maxSum = Math.max(maxSum, maxEnding);
            minEnding = Math.min(arr[i], minEnding + arr[i]);
            minSum = Math.min(minSum, minEnding);
        }
        if (maxSum < 0) return maxSum;

        return Math.max(maxSum, totalSum - minSum);
    }

    public static void main(String[] args) {
        int arr[] = {5, -3, 5};
        System.out.println(maxCircularSum(arr)); // 10
    }
}


// subarray Sum equal to K-> here negative ellements are allowed
import java.util.*;
class Main {
    public static int findLength(int arr[],int k){
         HashMap<Integer,Integer>hm =new HashMap<>();
        hm.put(0,1);
        int output=0;
        int sum=0;
        for(int i=0;i<arr.length;i++){
         sum +=arr[i];
         int find=sum-k;
         if(hm.containsKey(find)){
             output+=hm.get(find);
         }
         if(hm.containsKey(sum)){
             hm.put(sum,hm.get(sum)+1);
         }else{
             hm.put(sum,1);
         }
    }
    return output;
    }
    public static void main(String[] args) {
       int arr[]={-1,3,5,-4};
       System.out.println(findLength(arr,4));
}}



// subarray sum divisible by k-> here negative ellements are allowed
import java.util.*;
class Main {
    public static int findLength(int arr[],int k){
         HashMap<Integer,Integer>hm =new HashMap<>();
        hm.put(0,1);
        int output=0;
        int sum=0;
        for(int i=0;i<arr.length;i++){
         sum +=arr[i];
         int find=sum%k;
         if(find<0){
             find=find+k;
         }
         if(hm.containsKey(find)){
             output +=hm.get(find);
         }
         if(hm.containsKey(find)){
             hm.put(find,hm.get(find)+1);
         }else{
         hm.put(find,1);
    }}
    return output;
    }
    public static void main(String[] args) {
       int arr[]={-1,3,5,-4};
       System.out.println(findLength(arr,4));
}}

//862. Shortest Subarray with Sum at Least K

import java.util.*;

class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;

        long[] parr = new long[n + 1]; 
        for (int i = 0; i < n; i++) {
            parr[i + 1] = parr[i] + nums[i]; 
        }

        Deque<Integer> dq = new LinkedList<>();
        int op = n + 1;

        for (int i = 0; i <= n; i++) {
            while (!dq.isEmpty() && parr[i] - parr[dq.peekFirst()] >= k) {
                op = Math.min(op, i - dq.pollFirst());
            }

            
            while (!dq.isEmpty() && parr[i] <= parr[dq.peekLast()]) {
                dq.pollLast();
            }

            dq.offerLast(i);
        }

        return op <= n ? op : -1;
    }
}


//525. Contiguous Array


import java.util.*;

class Solution {
    public int findMaxLength(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) arr[i] = -1;
        }

        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, -1);

        int sum = 0;
        int output = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (hm.containsKey(sum)) {
                output = Math.max(output, i - hm.get(sum));
            } else {
                hm.put(sum, i);
            }
        }

        return output;
    }
}

// 34. Find First and Last Position of Element in Sorted Array


class Solution {
    public int[] searchRange(int[] arr, int target) {
        
        int n=arr.length;
        int start=0;
        int end=n-1;
        int op[]=new int[2];
        op[0]=-1;
        op[1]=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            int min=mid;
            int max=mid;
            if(arr[mid]==target){
               op[0]=mid;
               end=mid-1;
            }
            else if(arr[mid]>target){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
       int s=0;
       int e=n-1;
       while(s<=e){
        int m=s+(e-s)/2;
        if(arr[m]==target){
            op[1]=m;
            s=m+1;
        }else if(arr[m]>target){
            e=m-1;
        }else{
            s=m+1;
        }
       }
       return op;
    }  
}

//852. Peak Index in a Mountain Array

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int start=0;
        int end=arr.length-1;
        while(start<end){
            int mid=start+(end-start)/2;
            if(arr[mid]>arr[mid+1]){
                end=mid;
            }
            else if(arr[mid]<arr[mid+1]){
                start=mid+1;
            }

        }
        return end;
    }
}

// 33. Search in Rotated Sorted Array

class Solution {
    public int search(int[] arr, int target) {
     int start=0;
     int end=arr.length-1;
     while(start<=end){
        int mid=start+(end-start)/2;
        if(arr[mid]==target){
            return mid;
        }
        if(arr[mid]>=arr[start]){
            if(arr[start]<=target && arr[mid]>=target){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }else{
            if(arr[mid]<=target && arr[end]>=target){
                 start=mid+1;
            }else{
                end=mid-1;
            }
        }
     }
return -1;
    }
}

//153. Find Minimum in Rotated Sorted Array



class Solution {
    public int findMin(int[] arr) {
        int start=0;
        int end=arr.length-1;
        int lowest=Integer.MAX_VALUE;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[start]<=arr[mid]){
                lowest=Math.min(lowest,arr[start]);
                start=mid+1;
            }else{
                 lowest=Math.min(lowest,arr[mid+1]);
                 end=mid;
            }
        }
        return lowest;
    }
}



//154. Find Minimum in Rotated Sorted Array II


class Solution {
    public int findMin(int[] arr) {
        int min=Integer.MAX_VALUE;
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            min=Math.min(min,arr[mid]);
            if(arr[start]==arr[mid] &&arr[mid]==arr[end]){
                start++;
                end--;
            }
            else if(arr[mid]>=arr[start]){
                min=Math.min(min,arr[start]);
                start=mid+1;
            }else if(arr[mid]<=arr[end]){
                min=Math.min(arr[mid],min);
                end=mid;
            }
        }
        return min;
    }
}

// 81. Search in Rotated Sorted Array II


class Solution {
    public boolean search(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if(arr[mid]==target){
                return true;
            }
              if(arr[mid]==arr[start]&& arr[mid]==arr[end]){
                start++;
                end--;
              }
              else if(arr[mid]>=arr[start]){
                  if(arr[start]<=target && target<=arr[mid]){
                    end=mid-1;
                  }else{
                    start=mid+1;
                  }
              }
              else if(arr[mid]<=arr[end]){
                if(arr[mid]<=target && target<=arr[end]){
                    start=mid+1;
                }else{
                    end=mid-1;
                }
              }
            }
        
        return false;
    }
}


// binary serach on answer


// find sqrt of a number
class Main {
    public static int sqrt(int n){
        int start=0;
        int end=n;
        int ans=1;
        while(start<=end){
            int mid=(start+(end-start))/2;
            if(mid*mid<=n){
                ans=Math.max(ans,mid);
                start=mid+1;
            }else{
            end=mid-1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(sqrt(9));
    }
}


// find nth root of a number


class Main {
    public static int sqrt(int n,int nth){
        int start=0;
        int end=n;
        int ans=1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(Math.pow(mid,nth)<=n){
                ans=Math.max(ans,mid);
                start=mid+1;
            }else{
            end=mid-1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(sqrt(16,2));
    }
}


// brute force approach

class Solution {
    public int minEatingSpeed(int[] arr, int h) {
        int max=Integer.MIN_VALUE;
        
        for(int i=0;i<arr.length;i++){
             max=Math.max(max,arr[i]);
        }
        int p=1;
        
        int output=max;
        while(p<=max){
        int sum=0;
        for(int i=0;i<arr.length;i++){
           int val=0;
            val = (arr[i] + p - 1) / p;
            sum+=val;
        }
       
        if(sum<=h){
            output=Math.min(p,output);
        }
        p++;
        }
        return output;
    }
}