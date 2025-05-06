package com.pluralsight;

public class Reservation {
        private String roomType;
        private double price;
        private int numberOfNights;
        private boolean isWeekend;

        // Constructor
        public Reservation(String roomType, int numberOfNights, boolean isWeekend) {
            setRoomType(roomType);  // will set roomtype with price
            this.numberOfNights = numberOfNights;
            this.isWeekend = isWeekend;
        }

        // Getters and Setters
        public String getRoomType() {
            return roomType;
        }

        public void setRoomType(String roomType) {
            this.roomType = roomType.toLowerCase();
            if (roomType.equalsIgnoreCase("king")) {
                this.price = 139.00;
            } else if (roomType.equalsIgnoreCase("double")) {
                this.price = 124.00;
            }else {
                this.price=0;
            }
        }

        public double getPrice() {
            return price;
        }

        public int getNumberOfNights() {
            return numberOfNights;
        }

        public void setNumberOfNights(int numberOfNights) {
            this.numberOfNights = numberOfNights;
        }

        public boolean isWeekend() {
            return isWeekend;
        }

        public void setIsWeekend(boolean isWeekend) {
            this.isWeekend = isWeekend;
            // Recalculate price if weekend flag changes
            setRoomType(this.roomType);  // Re-apply price logic
        }

        public double getReservationTotal() {
           double total= this.getPrice() * this.getNumberOfNights();

            // Apply weekend increase
            if (this.isWeekend()) {
               total=total*(total*0.1);
            }
            return total;
        }
    }
