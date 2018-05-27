public class Main {

    public static void main(String[] args) {
        Theater narodowy = new Theater(new Address("Warszawska", 12, "02-495", "Warsaw", "Poland"));
        Theater nieNarodowy = new Theater(new Address("Marszałkowska", 11, "02-666", "Warsaw", "Poland"));


        try {
            Seat s1 = Seat.createSeat(narodowy, "A", 1);
            Seat s2 = Seat.createSeat(narodowy, "A", 2);
            Seat s3 = Seat.createSeat(nieNarodowy, "A", 1);

            narodowy.addPart("Teatr", "Miejsce", s1);
            narodowy.addPart("Teatr", "Miejsce", s1);
            nieNarodowy.addPart("Teatr", "Miejsce", s1);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
