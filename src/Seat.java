public class Seat extends AssociationManager{

    private Theater theater;
    private String row;
    private int number;

    private Seat(Theater theater, String row, int number){
        this.theater = theater;
        this.row = row.toUpperCase();
        this.number = number;
    }

    @Override
    public String toString(){
        return row + number;
    }

    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Seat)) return false;
        Seat s = (Seat) obj;
        return s.theater.equals(theater) && s.row.equals(row) && s.number == number;
    }

    public static Seat createSeat(Theater theater, String row, int number) throws Exception{
        if(theater == null){
            throw new Exception("Theater doesn't exist");
        }
        Seat s = new Seat(theater, row, number);
        theater.addAssociation("Teatr", "Miejsce", s);
        return s;
    }
}
