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

// optimized way of Koko Eating Bananas

class Solution {
    public int minEatingSpeed(int[] arr, int h) {
        int max=Integer.MIN_VALUE;
        
        for(int i=0;i<arr.length;i++){
             max=Math.max(max,arr[i]);
        }
        int start=1;
        
        int end=max;
        int op=max;
        while(start<=end){
            int mid=start+(end-start)/2;
            int sum=0;
            for(int i=0;i<arr.length;i++){
                int val=0;
                val=(arr[i]+mid-1)/mid;
               sum +=val;
               if(sum>h){
                break;
               }
            }
            
            if(sum<=h){
                op=Math.min(op,mid);
                end=mid-1;
            }else{
              
              start=mid+1;
            }
        }
        return op;
    }
}

// brute force of 1482. Minimum Number of Days to Make m Bouquets

class Solution {
    public int minDays(int[] nums, int m, int k) {
        if(k*m>nums.length){
            return -1;
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
        }
        int output=max;
        for(int i=1;i<=max;i++){
            if(helper(m,k,i,nums)){
              output=Math.min(output,i);
            }
        }
        return output;
    }
    public static boolean helper(int m,int k,int j,int arr[]){
        boolean ans[]=new boolean[arr.length];
        for(int i=0;i<arr.length;i++){
              if(arr[i]<=j){
                ans[i]=true;
              }else{
                ans[i]=false;
              }
        }
        int z=k;
        for(int i=0;i<ans.length;i++){
            if(ans[i]==true){
                z--;
            }else{
                z=k;
            }
            if(z==0){
                m--;
                z=k;
            }
        }
        if(m==0){
            return true;
        }else{
            return false;
        }
    }
}

// optimized way 1482. Minimum Number of Days to Make m Bouquets


class Solution {
    public int minDays(int[] nums, int m, int k) {
        if((long)k * m > nums.length){
            return -1;
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
        }
        int start=1;
        int end=max;
        int output=max;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(helper(m,k,mid,nums)){
                output=mid;
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        
        return output;
    }
    public static boolean helper(int m,int k,int j,int arr[]){
        
        int z=k;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=j){
                z--;
            }else{
                z=k;
            }
            if(z==0){
                m--;
                z=k;
            }
            if(m==0){
                return true;
                
            }
        }
        return m==0;
    }
}


// optimized way of 1283. Find the Smallest Divisor Given a Threshold


class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
        }
        int start=1;
        int end=max;
        int output=max;
        while(start<=end){
            int mid=start+(end-start)/2;
            int sum=0;
            for(int i=0;i<nums.length;i++){
            sum += ((nums[i] + mid - 1) / mid);
            }
            if(sum>threshold){
                start=mid+1;
            }else{
                output=Math.min(output,mid);
                end=mid-1;
            }

        }
        return output;
    } 
}


// second type of BS max of min
// aggreesive cows



import java.util.*;
public class main{
    public static int dist(int arr[],int cows){
        
        Arrays.sort(arr);
        if(arr.length<cows){
            return-1;
        }
        int max=arr[arr.length-1];
        int start=1;
        int end=max;
        int output=max;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(poss(arr,cows,mid)){
                output=mid;
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return output;
    }
    public static boolean poss(int arr[],int cows,int j){
        int var=cows-1;
        int prev=arr[0];
        
            for(int i=1;i<arr.length;i++){
                if(arr[i]-prev>=j){
                    var--;
                    prev=arr[i];
                }
            }
        return var<=0;
    }
    public static void main(String args[]){
        int arr[]={0,3,4,7,9,10};
       System.out.println( dist(arr,4));
    }
}

//Allocate Books or Book Allocation 



class Main {
    public static int p(int arr[],int st){
        int max=arr[0];
        int sum=0;
        for(int i=0;i<arr.length;i++){
            max=Math.max(max,arr[i]);
            sum+=arr[i];
        }
        for(int j=max;j<=sum;j++){
            if(poss(arr,j,st)){
                return j;
        }
        
    }
        return -1;
    }
    public static boolean poss(int arr[],int j,int st){
        int student=1;
        int maxPage=0;
        for(int i=0;i<arr.length;i++){
            if(maxPage+arr[i]<=j){
                maxPage=maxPage+arr[i];
            }else{
                student++;
                maxPage=arr[i];
            }
        }
       return student<=st;
    }
    public static void main(String[] args) {
        int arr[]={10, 20, 30, 40};
        System.out.println(p(arr,4));
    }
}


//llinkedlist

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
       if(head ==null||head.next==null){
        return head;
       }
        ListNode temp=head;
        ListNode prev=null;
        ListNode fr=head.next;
        while(temp!=null){
                temp.next=prev;
                prev=temp;
                temp=fr;
                if(fr.next==null){
                    break;
                }
                fr=fr.next;
        }
        temp.next=prev;
        return temp;
    }
}

//2. Add Two Numbers

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      ListNode t1=l1;
      ListNode t2=l2;
      ListNode temp=new ListNode(-1);
      ListNode t=temp;
      int carry=0;
      while(t1!=null && t2 !=null){
           int sum=carry+t1.val+t2.val;
           
        if(sum>=10){
            carry=sum/10;
            sum=sum%10;
        }else{
            carry=0;
        }
        ListNode h=new ListNode(sum);
        t.next=h;
        t=t.next;
        t1=t1.next;
        t2=t2.next;
      }
      
    
    while(t1!=null){
        int sum=carry+t1.val;
        if(sum>=10){
            carry=sum/10;
            sum=sum%10;
        }else{
            carry=0;
        }
        ListNode h=new ListNode(sum);
        t.next=h;
        t=t.next;
        t1=t1.next;
    }

    while(t2!=null){
        int sum=carry+t2.val;
        if(sum>=10){
            carry=sum/10;
            sum=sum%10;
        }else{
            carry=0;
        }
        ListNode h=new ListNode(sum);
        t.next=h;
        t=t.next;
        t2=t2.next;
    }
    if(carry !=0){
        ListNode h=new ListNode(carry);
        t.next=h;
    }
    return temp.next;
}}


// 328. Odd Even Linked List brute force

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode odd=head;
        ListNode even=head.next;
        ListNode ans=new ListNode(-1);
        ListNode temp=ans;
        while( odd!=null){
            temp.next=new ListNode(odd.val);
            temp=temp.next;
            if(odd.next==null){
                break;
            }
            odd=odd.next.next;
        }while(even!=null){
            temp.next=new ListNode(even.val);
            temp=temp.next;
            if(even.next==null){
                break;
            }
            even=even.next.next;
        }
        return ans.next;

    }
    
}

// optimize code 


     class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head;         
        ListNode even = head.next;     
        ListNode evenHead = even;     

        while (even != null && even.next != null) {
            odd.next = even.next;     
            odd = odd.next;

            even.next = odd.next;     
            even = even.next;
        }

        odd.next = evenHead;          
        return head;
    }
}

    
//234. Palindrome Linked List


class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
      ListNode nexthalf=reverse(slow.next);
      ListNode firstHalf=head;
      while(firstHalf!=null && nexthalf!=null){
        if(firstHalf.val!=nexthalf.val){
             return false;
        }else{
            firstHalf=firstHalf.next;
            nexthalf=nexthalf.next;
        }
      }
      return true;
}

public ListNode reverse(ListNode head){
    ListNode prev=null;
    ListNode curr=head;
    while(curr!=null){
        ListNode fr=curr.next;
        curr.next=prev;
        prev=curr;
        curr=fr;
    }
    return prev;
}

}
// intersection of 2 linked list

// brute force


public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashMap<ListNode,Integer>hm=new HashMap<>();
        ListNode h1=headA;
        while(h1!=null){
            hm.put(h1,1);
            h1=h1.next;
        }
        ListNode h2=headB;
        while(h2!=null){
            if(hm.containsKey(h2)){
                return h2;
            }else{
                h2=h2.next;
            }
        }
        return null;
}}


//141. Linked List Cycle


public class Solution {
    public boolean hasCycle(ListNode head) {

   ListNode slow=head;
   ListNode fast=head;
   while(fast!=null && fast.next!=null){
    
    slow=slow.next;
    fast=fast.next.next;
    if(slow==fast){
        return true;
    }
    
   }
   return false;

}
}
// removal of cycle

static void removeLoop(Node head) {

    Node slow = head;
    Node fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;

        if (slow == fast) {

            Node entry = head;
            while (entry != slow) {
                entry = entry.next;
                slow = slow.next;
            }
            Node temp = entry;
            while (temp.next != entry) {
                temp = temp.next;
            }
            temp.next = null;

            break; 
        }
    }
}

// 61. Rotate List

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }

        k = k % len;

        while (k-- > 0) {

            ListNode prev = null;
            ListNode curr = head;

            while (curr.next != null) {
                prev = curr;
                curr = curr.next;
            }
            prev.next = null;   
            curr.next = head;  
            head = curr;       
        }

        return head;
    }
}

//21. Merge Two Sorted Lists


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */class Solution {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode temp1=list1;
    ListNode temp2=list2;
    ListNode ans=new ListNode(-1);
    ListNode var=ans;
    int l1=length(list1);
    int l2=length(list2);
    while(l1 !=0 && l2 !=0){
        int val=Math.min(temp1.val,temp2.val);
        var.next=new ListNode(val);
        var=var.next;
        if(temp1.val>=temp2.val){
            l2--;
            temp2=temp2.next;
        }else{
            l1--;
            temp1=temp1.next;
        }
    }
    while(l1!=0){
        int val=temp1.val;
        var.next=new ListNode(val);
        var=var.next;
        temp1=temp1.next;
        l1--;
    }
    while(l2!=0){
        int val=temp2.val;
        var.next=new ListNode(val);
        var=var.next;
        temp2=temp2.next;
        l2--;
    }
    return ans.next;
    }
    public static int length(ListNode l1){
        ListNode temp=l1;
        int length=0;
        while(temp!=null){
            length++;
            temp=temp.next;
        }
        return length;
    } 
}
// recursion

// factorial
class Main {
    public static int  print(int i){
        if(i==0 || i==1){
            return i;
        }
        return i*print(i-1);
    }
    public static void main(String[] args) {
       System.out.print(print(5));
    }
}

// reversal of array using recursion


class Main {
    public static void  print(int arr[],int i,int j){
        if(i>j){
            return;
        }
        else{int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
        print(arr,i+1,j-1);
        }
    
    }
    public static void main(String[] args) {
       int arr[]={1,2,3,4,5};
       print(arr,0,4);
       for(int p=0;p<arr.length;p++){
            System.out.println(arr[p]);
        }
    }
}


// subsequence 


import java.util.*;

class Main {

    public static void helper(int arr[], int i, List<Integer> ll, List<List<Integer>> ans) {
        
        if (i == arr.length) {
            ans.add(new ArrayList<>(ll)); 
            return;
        }

        ll.add(arr[i]);
        helper(arr, i + 1, ll, ans);

        ll.remove(ll.size() - 1);
        helper(arr, i + 1, ll, ans);
    }

    public static List<List<Integer>> print(int arr[]) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(arr, 0, new ArrayList<>(), ans);
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3};
        System.out.println(print(arr));
    }
}


// combination sum-1

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>ll=new ArrayList<>();
        helper(candidates,target,0,ans,ll,0);
        return ans;
    }
    public static void helper(int arr[],int target,int sum,List<List<Integer>>ans,List<Integer>ll,int i){
        if(sum==target){
            ans.add(new ArrayList<>(ll));
            return;
        }
        if(sum>target || i==arr.length){
            return;
        }

        ll.add(arr[i]);
        helper(arr,target,sum+arr[i],ans,ll,i);
        ll.remove(ll.size()-1);
        helper(arr,target,sum,ans,ll,i+1);
}
}

// brute force of combination sum-2


class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>ll=new ArrayList<>();
        helper(candidates,target,0,ans,ll,0);
        return ans;
    }
    public static void helper(int arr[],int target,int sum,List<List<Integer>>ans,List<Integer>ll,int i){
        if(sum==target){
            if(ans.contains(ll)==false){
                ans.add(new ArrayList<>(ll));
            }
            return;
        }
        if(sum>target || i==arr.length){
            return;
        }

        ll.add(arr[i]);
        helper(arr,target,sum+arr[i],ans,ll,i+1);
        ll.remove(ll.size()-1);
        helper(arr,target,sum,ans,ll,i+1);
}
}


// optimized way of combination sum-2


class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>ll=new ArrayList<>();
        helper(candidates,target,0,ans,ll,0);
        return ans;
}
public static void helper(int arr[],int target,int sum,List<List<Integer>>ans,List<Integer>ll,int i){

if(sum==target){
    ans.add(new ArrayList<>(ll));
    return;
}
    for(int j=i;j<arr.length;j++){

        
        if(j >i && arr[j]==arr[j-1]){
              continue;
        }
        if(sum>target){
            break;
        }
        ll.add(arr[j]);
        helper(arr,target,sum+arr[j],ans,ll,j+1);
        ll.remove(ll.size()-1);
    }
}

}

// 90. Subsets II

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>(); 
        List<Integer> list = new ArrayList<>();  
        Arrays.sort(nums);   
        helper(0, nums, list, ans);
        return ans;
    }
    public static void helper(int index,int arr[],List<Integer> list,List<List<Integer>> ans){
       
           ans.add(new ArrayList<>(list));
      
        for(int i=index;i<arr.length;i++){
            if(i>index && arr[i]==arr[i-1]){
                continue;
            }
            list.add(arr[i]);
            helper(i+1,arr,list,ans);
            list.remove(list.size()-1);
        }

    }
}

// 46. Permutations

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> a=new ArrayList<>();
        boolean arr[]=new boolean[nums.length];
        Arrays.sort(nums);
        permute(0,nums,ans,a,arr);
        return ans;
        
        
    }
    public static void permute(int index,int nums[],List<List<Integer>> ans,List<Integer> a,boolean arr[]){
        if(a.size()==arr.length){
            ans.add(new ArrayList<>(a));
            return ;
        }
        for(int i=0;i<arr.length;i++){
              if(arr[i]!=true){
                a.add(nums[i]);
                arr[i]=true;
                permute(index+1,nums,ans,a,arr);
                a.remove(a.size()-1);
                arr[i]=false;
              }
        }
    }
}

//131. Palindrome Partitioning

import java.util.*;
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>>ans=new ArrayList<>();
        List<String>ll=new ArrayList<>();
    
        helper(0,ll,ans,s);
        return ans;
    }
    public static void helper(int index,List<String>ll,List<List<String>>ans,String s){
        
        if(index==s.length()){
            ans.add(new ArrayList<>(ll));
            return;
        }

        for(int i=index;i<s.length();i++){
              
               if(isPlaind(s,index,i)){
                 ll.add(s.substring(index,i+1));
                 helper(i+1,ll,ans,s);
                 ll.remove(ll.size()-1);
               }
               
        }
    }
    public static boolean isPlaind(String s,int index,int p){
      int i=index;
      int j=p;
      while(i<=j){
        if(s.charAt(i)!=s.charAt(j)){
            return false;
        }
        i++;
        j--;
      }
      return true;
    }
}


// brute force of 22 generate parentheses

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String>ans=new ArrayList<>();
        String s="";
        helper(0,n,ans,s);
        return ans;

    }
    public static void helper(int i,int n,List<String>ans,String s){
        
        if(s.length()==2*n){
           if(isValidate(s)){
              ans.add(s);
            return;
           } 
        }
        
        helper(i+1,n,ans,s+ "(");
        helper(i+1,n,ans,s+ ")");
    }
    public static boolean isValidate(String s){
        Stack<Character>ss=new Stack<>();
        
        for(int i=0;i<s.length();i++){
            char p=s.charAt(i);
            if(p=='('){
                ss.push(p);
            }else{
                if(ss.size()==0){
                    return false;
                }
                ss.pop();
            }
     
    }
    return ss.size()==0;
}}

// leetcpode 22 generate parentheses optimized way


class Solution {
    public List<String> generateParenthesis(int n) {
        List<String>ans=new ArrayList<>();
        String s="";
        helper(n,ans,s,0,0);
        return ans;

    }
    public static void helper(int n,List<String>ans,String s,int open,int close){
        
        if(s.length()==2*n)
          {
              ans.add(s);
            return;
           } 
        
        if(open<n){
             helper(n,ans,s+ "(",open+1,close);
        }
       if(close<open){
            helper(n,ans,s+ ")",open,close+1);
       }
       
    }
   
}

//.605. Can Place Flowers

 class Solution {
    public boolean canPlaceFlowers(int[] arr, int n) {
        if(arr.length==1){
            if(arr[0]==0 && n==1){
                return true;
            }
            if(arr[0]==1 && n==0){
                return true;
            }
            if(arr[0]==0 && n==0){
                return true;
            }
          return false;
        }
     int pl=0;
       for(int i=0;i<arr.length;i++){
        if(arr[i]==0){
               arr[i]=1;
               pl++;
               if(i==0){
                    if( arr[i+1]==0){
                       continue;
               }}
               if(i==arr.length-1){
                    if( arr[i-1]==0){
                       continue;
                  }
               }
               
               if(i>0 && i<arr.length-1){
                  if(arr[i-1]==0 && arr[i+1]==0){
                continue;
               }
               }
                
               arr[i]=0;
               pl--;
        }
        
    }return pl>=n;
} }

// mext greater ellement in array


class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
          Stack<Integer>ss=new Stack<>();
          int nge[]=new int[nums2.length];
          for(int i=nums2.length-1;i>=0;i--){
            int curr=nums2[i];
            while(!ss.isEmpty() && ss.peek()<=curr){
                ss.pop();
            }
            if(ss.isEmpty()){
                 nge[i]=-1;
            }else{
                nge[i]=ss.peek();
            }
            ss.push(nums2[i]);
          }
          HashMap<Integer,Integer>hm=new HashMap<>();
     for(int i=0;i<nums2.length;i++){
            hm.put(nums2[i],nge[i]);
     }
     for(int i=0;i<nums1.length;i++){
        int val=hm.get(nums1[i]);
        nums1[i]=val;
     }
     return nums1;
    }
}


// brute force of sum of subarray ranges



class Solution {
    public long subArrayRanges(int[] arr) {
       List<List<Integer>>ll=new ArrayList<>();
       
        for(int i=0;i<arr.length;i++){
            List<Integer>ans=new ArrayList<>();
            for(int j=i+1;j<arr.length;j++){
                for(int k=i;k<=j;k++){
                   ans.add(arr[k]);
                }
                ll.add(new ArrayList<>(ans));
            } 
        }
        long sum=0;
        for(int i=0;i<ll.size();i++){
            List<Integer>a=ll.get(i);
            int min=Integer.MAX_VALUE;
            int max=Integer.MIN_VALUE;
            for(int j=0;j<a.size();j++){
                 min=Math.min(min,a.get(j));
                 max=Math.max(max,a.get(j));
            }
            sum+=max-min;
        }
        return sum;

    }
}

// asteriod collision


 class Solution {
    public int[] asteroidCollision(int[] arr) {
        Stack<Integer> ss = new Stack<>();
       for(int i=0;i<arr.length;i++){
        int curr=arr[i];
        if(curr>0){
            ss.push(curr);
        }
         else{
        boolean mark=false;
         while(!ss.isEmpty() && ss.peek()>0){
            if(Math.abs(curr)==ss.peek()){
            ss.pop();
            mark=true;
            break;
        }
        else if(Math.abs(curr)>ss.peek()){
            ss.pop();
            mark=false;
        }else{
            mark=true;
            break;
        }
       
         }
          if(mark==false){
            ss.push(curr);
        }

        
       }}
       List<Integer>ans=new ArrayList<>();
       while(!ss.isEmpty()){
        ans.add(ss.pop());
       }
       Collections.reverse(ans);
       int a[]=new int[ans.size()];
       for(int i=0;i<ans.size();i++){
        a[i]=ans.get(i);
       }
       return a;
    }
}
// largest rectangle in histogram

class Solution {
    public int largestRectangleArea(int[] arr) {
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i];

            int left = -1;
            int right = arr.length;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < curr) {
                    left = j;
                    break;
                }
            }

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < curr) {
                    right = j;
                    break;
                }
            }
            int width = right - left - 1;
            max = Math.max(max, width * curr);
        }

        return max;
    }
}


// median of 2 sorted array


class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int arr[] = new int[n + m];

        int i = 0, j = 0;
        List<Integer> ans = new ArrayList<>();

        while (i < n && j < m) {
            if (nums1[i] >= nums2[j]) {
                ans.add(nums2[j]);
                j++;
            } else {
                ans.add(nums1[i]); 
                i++;
            }
        }

        while (i < n) {
            ans.add(nums1[i]);  
            i++;
        }

        while (j < m) {
            ans.add(nums2[j]);
            j++; 
        }

        
        for (int p = 0; p < ans.size(); p++) {
            arr[p] = ans.get(p);
        }
        int len = arr.length;
        if (len % 2 == 0) {
            int mid = len / 2;
            return (arr[mid] + arr[mid - 1]) / 2.0; 
        } else {
            return arr[len / 2]; 
        }
    }
}

// next permutation


class Solution {
    public void nextPermutation(int[] arr) {
        int index=-1;
        for(int i=arr.length-2;i>=0;i--){
            if(arr[i]<arr[i+1]){
                index=i;
                break;
            }
        }
        if(index==-1){
            Arrays.sort(arr);
            return;
        }
    
        for(int i=arr.length-1;i>index;i--){
            if(arr[i]>arr[index]){
            swap(arr,i,index);
            break;
            }
        }
      reverse(arr,index+1);
      

    }
    public static void swap(int arr[],int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void reverse(int arr[],int i){
        int start=i;
        int end=arr.length-1;
        while(start<=end){
            int t=arr[start];
            arr[start]=arr[end];
            arr[end]=t;
            start++;
            end--;
        }
    }
}

// inordr traversal travesal 


class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ll=new ArrayList<>();
        inorder(root,ll);
        return ll;
      
    }
    public static void inorder(TreeNode root,List<Integer>ans){
        if(root==null){
            return;
        }
        inorder(root.left,ans);
        ans.add(root.val);
        inorder(root.right,ans);
    }
   
}

// level order traversal


import java.util.*;
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        List<List<Integer>> ans=new ArrayList<>();
        Queue<TreeNode>qq=new LinkedList<>();
        qq.add(root);
        while(!qq.isEmpty()){
            List<Integer> an=new ArrayList<>();
            int length=qq.size();
            for(int i=0;i<length;i++){
            TreeNode curr=qq.poll();  
            an.add(curr.val);       
             if(curr.left!=null){
                qq.add(curr.left);
            }
            if(curr.right!=null){
                qq.add(curr.right);
            }
            }

           ans.add(new ArrayList<>(an)); 

        }
        return ans;
    }
}


// balanced binary tree
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
      int lh=height(root.left);
      int rh=height(root.right);
      if(Math.abs(lh-rh)>1){
        return false;
      }
      boolean lef=isBalanced(root.left);
      boolean righ=isBalanced(root.right);
      if(!lef || !righ){
        return false;
      }else{
        return true;
      }
    
    }
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=height(root.left);
        int right=height(root.right);
        return Math.max(left,right)+1;
    }
}
// level wise traversal of binary tree

import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data = data;
    }
}

public class Main {

    public static void levels(Node root, int l, HashMap<Integer, List<Integer>> ans){
        if(root == null){
            return;
        }

        if(ans.containsKey(l)){
            List<Integer> ll = ans.get(l);
            ll.add(root.data);
        } else {
            List<Integer> ll = new ArrayList<>();
            ll.add(root.data);
            ans.put(l, ll);
        }

        levels(root.left, l + 1, ans);
        levels(root.right, l + 1, ans);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        HashMap<Integer, List<Integer>> ans = new HashMap<>();
        levels(root, 0, ans);

        for(int i = 0; i < ans.size(); i++){
            List<Integer> ll = ans.get(i);
            for(int j = 0; j < ll.size(); j++){
                System.out.println("Level " + i + " -> " + ll.get(j));
            }
        }
    }
}


//diameter of binary tree


class Solution {
     int sum=0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        int leftH=height(root.left);
        int rightH=height(root.right);
        sum=Math.max(leftH+rightH,sum);
        diameterOfBinaryTree(root.left);
        diameterOfBinaryTree(root.right);
        return sum;
    }
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=height(root.left);
        int right=height(root.right);
        return Math.max(left,right)+1;
    }
}




// path sum in binary tree



class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        return helper(root,targetSum);
    }
    public boolean helper(TreeNode root,int target){
        if(root==null){
           return false;
        }
     if(root.left==null && root.right==null){
        if(target==root.val){
            return true;
        }else{
            return false;
        }
     }

        boolean left=helper(root.left,target-root.val);
        boolean right=helper(root.right,target-root.val);
        
        if(left || right){
            return true;
        }else{
            return false;
        }

    }
}

// path sum 2 in binary tree



class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer>ll=new ArrayList<>();
        helper(targetSum,root,ll,ans);
        return ans;
    }
    public void helper(int target,TreeNode root,List<Integer>var,List<List<Integer>>ans){
        if(root==null){
            return;
        }
        
        if(root.left==null && root.right==null){
           
            if(root.val==target){
                var.add(root.val);
                ans.add(new ArrayList<>(var));
                var.remove(var.size()-1);
                return;
            }
        }
        var.add(root.val);
        helper(target-root.val,root.left,var,ans);
        helper(target-root.val,root.right,var,ans);
        var.remove(var.size()-1);
    }
}

// 129. Sum Root to Leaf Numbers

class Solution {
    public int sumNumbers(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ll = new ArrayList<>();

        helper(ll, ans, root);

        int total = 0;

        
        for(int i = 0; i < ans.size(); i++){
            List<Integer> path = ans.get(i);
            int num = 0;

            for(int j = 0; j < path.size(); j++){
                num = num * 10 + path.get(j);
            }

            total += num;
        }

        return total;
    }

    public static void helper(List<Integer> ll, List<List<Integer>> ans, TreeNode root){
        if(root == null){
            return;
        }

        ll.add(root.val);

        if(root.left == null && root.right == null){
            ans.add(new ArrayList<>(ll));
        } else {
            helper(ll, ans, root.left);
            helper(ll, ans, root.right);
        }

        ll.remove(ll.size() - 1); 
    }
}

// invert binary tree


class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        helper(root);
        return root;
    }
    public void helper(TreeNode root){
         if(root==null){
            return;
         }
         TreeNode v=root.left;
         root.left=root.right;
         root.right=v;
         helper(root.left);
         helper(root.right);
    }
}


// binary tree path


class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        StringBuilder ss = new StringBuilder();
        helper(ans, ss, root);
        return ans;
    }

    public void helper(List<String> ans, StringBuilder ss, TreeNode root){
        if(root == null){
            return;
        }

        int len = ss.length();
        if(len != 0){
            ss.append("->");
        }
        ss.append(root.val);
        if(root.left == null && root.right == null){
            ans.add(ss.toString());
        } else {
            helper(ans, ss, root.left);
            helper(ans, ss, root.right);
        }
        ss.setLength(len);
    }
}

// 404. Sum of Left Leaves



class Solution {
    int sum=0;
    public int sumOfLeftLeaves(TreeNode root) {
        TreeNode p=new TreeNode(-1);
        helper(root,p);
        return sum;
    }
    public void helper(TreeNode root,TreeNode parent){
        if(root==null){
            return;
        }
        if(root.right==null && root.left==null){
             if(parent.left==root){
               sum+=root.val;
             }
        }
        helper(root.left,root);
        helper(root.right,root);
    }
}


// path sum 3 in binary tree



 class Solution {
    int no = 0;

    public int pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return no;
        }

        helper(root, targetSum, 0);

        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);

        return no;
    }

    public void helper(TreeNode root, int target, long sum){ 
        if(root == null){
            return;
        }

        if(sum + root.val == target){
            no++;
        }

        helper(root.left, target, sum + root.val);
        helper(root.right, target, sum + root.val);
    }
}

// 429. N-ary Tree Level Order Traversal


class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        
        Queue<Node>qq=new LinkedList<>();
        qq.add(root);
        while(!qq.isEmpty()){
            List<Integer>ll=new ArrayList<>();
            int length=qq.size();
            for(int i=0;i<length;i++){
                Node curr=qq.poll();
                ll.add(curr.val);
                if (curr.children != null) {
                List<Node>child=curr.children;
                for(int j=0;j<child.size();j++){
                    qq.add(child.get(j));
                }
            }}
            ans.add(new ArrayList<>(ll));
        }
        return ans;
    }
}