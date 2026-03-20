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