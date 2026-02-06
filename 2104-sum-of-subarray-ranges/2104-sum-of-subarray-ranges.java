class Solution {

    public int[] NSEE(int arr[]){
        int[] NSEE = new int[arr.length];
        int n= arr.length;
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i])
                st.pop();
            if(st.isEmpty())
                NSEE[i]=n;
            else
                NSEE[i]=st.peek();
            st.push(i);
        }
        return NSEE;
    }

     public int[] NGEE(int arr[]){
        int[] NSEE = new int[arr.length];
        int n= arr.length;
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()] <= arr[i])
                st.pop();
            if(st.isEmpty())
                NSEE[i]=n;
            else
                NSEE[i]=st.peek();
            st.push(i);
        }
        return NSEE;
    }

    public int[] PSEE(int arr[]){
        int[] PSEE = new int[arr.length];
        int n= arr.length;
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()] > arr[i])
                st.pop();
            if(st.isEmpty())
                PSEE[i]=-1;
            else
                PSEE[i]=st.peek();
            st.push(i);
        }
        return PSEE;
    }

    public int[] PGEE(int arr[]){
        int[] PSEE = new int[arr.length];
        int n= arr.length;
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()] < arr[i])
                st.pop();
            if(st.isEmpty())
                PSEE[i]=-1;
            else
                PSEE[i]=st.peek();
            st.push(i);
        }
        return PSEE;
    }

    public long minimums(int[] arr){
        int n= arr.length;
        int ps[] = PSEE(arr);
        int ns[] = NSEE(arr);
        long sum = 0;

        for(int i = 0; i < n; i++){
            long left = i - ps[i];
            long right = ns[i] - i;
            long freq = left * right;
            long contrib = (arr[i] * freq);
            sum = (sum + contrib) ;
        }

        return sum;
    }

    public long maximums(int[] arr){
        int n= arr.length;
        int ps[] = PGEE(arr);
        int ns[] = NGEE(arr);
        long sum = 0;

        for(int i = 0; i < n; i++){
            long left = i - ps[i];
            long right = ns[i] - i;
            long freq = left * right;
            long contrib = (arr[i] * freq);
            sum = (sum + contrib) ;
        }

        return sum;
    }

    public long subArrayRanges(int[] nums) {
        long sum1 = minimums(nums);
        long sum2 = maximums(nums);
        return sum2 - sum1;
    }

}