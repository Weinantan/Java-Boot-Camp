package bootcamp.data;

public class Processor {
    private double [] arr  ;

    public Processor(double[] arr) {
        this.arr = arr;
    }

    public Summary process (){
        if (arr.length == 0){
            return new Summary(Double.NaN,Double.NaN,0,0,Double.NaN);
        }else {
        return new Summary(calculateMin(arr),calculateMax(arr),calculateSum(arr),calculateCount(arr),calculateAverage(arr));
    }
    }


    public double calculateMin(double[] arr){
       if (arr == null){
           return Double.NaN;
       }
        double min = arr[0];
        for (int i = 0; i < arr.length ; i ++){
            if (min > arr[i]){
                min = arr[i];
            }
        }
        return min;
    }

    public double calculateMax(double[] arr){
        if (arr == null){
            return Double.NaN;
        }
        double max = 0;
        for (int i = 0; i < arr.length ; i ++){
            if (max < arr[i]){
                max = arr[i];
            }
        }
        return max;
    }

    public double calculateSum(double [] arr){
        if (arr == null){
            return 0;
        }
        double sum = 0;
        for (int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        return sum;
    }

    public double calculateCount(double [] arr){
        if (arr == null){
            return 0;
        }
        double count = 0;
        for (int i = 0; i < arr.length; i++){
            count++;
        }
        return count;
    }

    public double calculateAverage(double [] arr){
        if (arr == null){
            return Double.NaN;
        }
        return  calculateSum(arr) / calculateCount(arr);

    }


    public double getValue(int num){
       if (num >= arr.length || num < 0){
           return Double.NaN;
       }
       return arr[num-1];
    }


}
