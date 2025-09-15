package com.APIAutomation._07_Payload_Management.Class.ByUsingTools.ResponsePayload;

import com.APIAutomation._07_Payload_Management.Class.ByUsingTools.RequestPayload.Booking;

public class BookingResponse {
    private Integer bookingId;
    private Booking booking;

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}
