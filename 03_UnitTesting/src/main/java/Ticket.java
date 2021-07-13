public class Ticket {
    private final String title;
    private final int seat;

    public Ticket(String title, int seat) {
        this.title = title;
        this.seat = seat;
    }

    public String getTitle() {
        return title;
    }

    public int getSeat() {
        return seat;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null || (obj.getClass() != this.getClass())){
            return false;
        }

        Ticket tickets = (Ticket) obj;
        return (this.title.equals(tickets.getTitle())  && this.seat == tickets.getSeat());
    }
}
