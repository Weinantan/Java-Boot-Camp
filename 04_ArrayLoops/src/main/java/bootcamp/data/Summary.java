package bootcamp.data;

import java.util.Objects;

public class Summary {
    private final double min;
    private final double max;
    private final double sum;
    private final double count;
    private final double average;

    public Summary(double min, double max, double sum, double count, double average) {
        this.min = min;
        this.max = max;
        this.sum = sum;
        this.count = count;
        this.average = average;
    }


    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }

    public double getSum() {
        return sum;
    }

    public double getCount() {
        return count;
    }

    public double getAverage() {
        return average;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Summary summary = (Summary) o;
        return Double.compare(summary.min, min) == 0 && Double.compare(summary.max, max) == 0 && Double.compare(summary.sum, sum) == 0 && Double.compare(summary.count, count) == 0 && Double.compare(summary.average, average) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(min, max, sum, count, average);
    }


//    @Override
//    Laura's Solution
//    public boolean equals (Object obj){
//        if (this == obj) return true;
//        if (obj.getClass() == Summary.class) {
//            Summary s = (Summary) obj;
//            if (this.min == s.min && this.max == s.max && this.sum == s.sum && this.count == s.count && this.average == s.average) return true;}
//
//        return false;
//    }

//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if ((obj == null) || (obj.getClass() != this.getClass())) {
//            return false;
//        }
//            Summary summary = (Summary) obj;
//            return (this.min == summary.min || (Double.isNaN(this.min)) && Double.isNaN(summary.min))
//                && (this.max == summary.max || (Double.isNaN(this.max)) && Double.isNaN(summary.max))
//                && (this.sum == summary.sum || (Double.isNaN(this.sum)) && Double.isNaN(summary.sum))
//                && (this.count == summary.count || (Double.isNaN(this.count)) && Double.isNaN(summary.count))
//                && (this.average == summary.average || (Double.isNaN(this.average)) && Double.isNaN(summary.average));
//    }


}



