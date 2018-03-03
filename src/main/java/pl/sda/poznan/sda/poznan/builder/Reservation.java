package pl.sda.poznan.builder;

import java.time.LocalDate;

public class Reservation {

    private LocalDate date;
    private int headcount;
    private String city;
    private double price;

    private Reservation() {
        // prywatny konstruktor, gdy nie chcemy, zeby dany objekt mógł być zmieniany
        // wewnątrz klasy można skozystać z tego konstruktora

    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getHeadcount() {
        return headcount;
    }

    public void setHeadcount(int headcount) {
        this.headcount = headcount;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    // metoda do wystawienia buildera na zewnątrz
    public static ReservationBuilder builder (){
        return new ReservationBuilder();
    }

    public static class ReservationBuilder {
        // tworzenie klasy wewnętrznej, musi mieć te same pola, co klasa wyżej

        private LocalDate date;
        private int headcount;
        private String city;
        private double price;

        public ReservationBuilder date(LocalDate val) {
            this.date = val;
            return this;
        }

        public ReservationBuilder headcount(int val) {
            this.headcount = val;
            return this;

        }

        public ReservationBuilder city(String val) {
            this.city = val;
            return this;
        }

        public ReservationBuilder price(double price) {
            this.price = price;
            return this;
        }

        //metoda, która zwraca nam objekt
        public Reservation build() {
            Reservation reservation = new Reservation();
            reservation.setHeadcount( this.headcount );
            reservation.setCity( this.city );
            reservation.setDate( this.date );
            reservation.setPrice( this.price );
            return reservation;
        }

    }
}
