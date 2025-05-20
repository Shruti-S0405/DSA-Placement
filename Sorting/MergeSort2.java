import java.util.Arrays;

public class MergeSort2 {
    public static void main(String args[]){
        int[] arr = {5,4,3,2,1};
        mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    static void mergeSort(int[] arr, int low, int high){
        if(low>=high) return;
        int mid = (low+high) / 2;
        mergeSort(arr, low, mid);//left
        mergeSort(arr, mid+1, high);//right
        merge(arr, low, mid, high);//merge them 
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high-low+1];

        int left=low;
        int right=mid+1;
        int k=0;

        while(left<=mid && right<=high){
            if(arr[left]<=arr[right]){
                temp[k]=arr[left];
                left++;
            }
            else{
                temp[k]=arr[right];
                right++;
            }
            k++;
        }
        //if right is empty
        while(left<=mid){
            temp[k]=arr[left];
            left++;
            k++;
        }
        //if left is empty
        while(right<=high){
            temp[k]=arr[right];
            right++;
            k++;
        }
        //copy to original array
        for(int i = 0; i< temp.length; i++){
            arr[low+i] = temp[i];
        }
    }    
}
