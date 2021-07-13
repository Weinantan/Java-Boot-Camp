package bootcamp.data;

public class Location {
    private final int x ;
    private final int y ;


    public Location() {
        this.x = Integer.MIN_VALUE;
        this.y = Integer.MIN_VALUE;
    }

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj){
//            return true;
//        }
//        if (obj == null || obj.getClass() != this.getClass()){
//            return false;
//        }
//        Location location = (Location) obj;
//        return this.getX() == location.getX() && this.getY() == location.getY();
//    }


}
