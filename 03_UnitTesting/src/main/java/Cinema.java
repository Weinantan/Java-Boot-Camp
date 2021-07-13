public class Cinema {
    public boolean canBuyTicket(Movie movie, Customer customer){
        if (customer.getAge() > movie.getAgeRestriction()){
            return true;
        }else{
            return false;
        }
    }

    public Ticket orderTicket(Movie movie, Customer customer, int seat) throws Exception {
        if (!canBuyTicket(movie,customer)){
            throw new Exception();
        }
         return new Ticket(movie.getTitle(), 42);

    }



}
