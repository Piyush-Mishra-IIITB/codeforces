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