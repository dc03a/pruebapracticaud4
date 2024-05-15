package org.iesvdm.booking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.mockito.Spy;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class BookingDAOTest {

    private BookingDAO bookingDAO;
    private Map<String, BookingRequest> bookings;

    @BeforeEach
    public void setup() {
        bookings = new HashMap<>();
        bookingDAO = new BookingDAO(bookings);
    }


    /**
     * Crea 2 peticiones de reserva (BookingRequest)
     * agrégalas a las reservas (bookings) con la que
     * construyes el objeto BookingDAO bajo testeo.
     * Comprueba que cuando invocas bookingDAO.getAllBookingRequest
     * obtienes las 2 peticiones.
     */
    @Test
    void getAllBookingRequestsTest() {
        BookingRequest request1 = Mockito.spy(new BookingRequest("user2", LocalDate.of(2023, 8, 10), LocalDate.of(2024, 8, 10), 4, true));
        BookingRequest request2 = Mockito.spy(new BookingRequest("user1", LocalDate.of(2022, 8, 10), LocalDate.of(2024, 8, 10), 3, true));
        BookingDAO bookingDAOSpy = Mockito.spy(bookingDAO);
        bookings.put(request1.getUserId(), request1);
        bookings.put(request2.getUserId(), request2);
        bookingDAOSpy.getAllBookingRequests();
        Mockito.verify(bookingDAOSpy, Mockito.times(1)).getAllBookingRequests();
    }

    /**
     * Crea 2 peticiones de reserva (BookingRequest)
     * agrégalas a las reservas mediante bookingDAO.save.
     * Comprueba que cuando invocas bookingDAO.getAllUUIDs
     * obtienes las UUIDs de las 2 peticiones guardadas.
     */
    @Test
    void getAllUUIDsTest() {
        BookingRequest request1 = Mockito.spy(new BookingRequest("user2", LocalDate.of(2023, 8, 10), LocalDate.of(2024, 8, 10), 4, true));
        BookingRequest request2 = Mockito.spy(new BookingRequest("user1", LocalDate.of(2022, 8, 10), LocalDate.of(2024, 8, 10), 3, true));
        BookingDAO bookingDAOSpy = Mockito.spy(bookingDAO);

        bookingDAOSpy.save(request1);
        bookingDAOSpy.save(request2);
        bookingDAOSpy.getAllUUIDs();

        ArgumentCaptor acString = ArgumentCaptor.forClass(String.class);

        Mockito.verify(bookingDAOSpy, Mockito.times(1)).getAllUUIDs();
    }


    /**
     * Crea 2 peticiones de reserva (BookingRequest)
     * agrégalas a las reservas mediante bookingDAO.save.
     * Comprueba que cuando invocas bookingDAO.get con el UUID
     * obtienes las respectivas 2 peticiones guardadas.
     */
    @Test
    void getTest() {

    }

    /**
     * Crea 2 peticiones de reserva (BookingRequest)
     * agrégalas a las reservas mediante bookingDAO.save.
     * A continuación, borra la primera y comprueba
     * que se mantiene 1 reserva, la segunda guardada.
     */
    @Test
    void deleteTest() {

    }

    /**
     * Guarda 2 veces la misma petición de reserva (BookingRequest)
     * y demuestra que en la colección de bookings están repetidas
     * pero con UUID diferente
     *
     */
    @Test
    void saveTwiceSameBookingRequestTest() {

    }

}
