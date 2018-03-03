package pl.sda.poznan.builder;

import java.time.LocalDate;

public class PlayGround {
    public static void main(String[] args) {

       // Reservation reservation = new Reservation();
       // reservation.setCity( "Poznan" );
        //reservation.setHeadcount( 199 );

        Reservation.ReservationBuilder rb = Reservation.builder()
                //fluent appi- tworzy się łańcuch wywołań
                .city( "Poznan" )
                .headcount( 100 )
                .price( 99 );

        // odczyt z pliku
        rb.date( LocalDate.parse( "2018-03-03" ) );

        // zakoncz proces budowania- zwróc gotowy objekt
        Reservation build = rb.build();
        System.out.println(build);

// inny scenariusz- znam wszystkie wartości od razu

        Reservation wroclaw = Reservation.builder()
                .date( LocalDate.parse( "2018-09-09" ) )
                .headcount( 100 )
                .price( 20 )
                .city( "Wroclaw" )
                .build();
    }

}
