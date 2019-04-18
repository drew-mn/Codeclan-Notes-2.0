# Airline!

Your task is to model a system for the world renowned online travel booking agent __TravelJava__. You should use the tools you have learnt this week _where appropriate and useful_. Remember to **TDD**!

TravelJava doesn't really exist (sadly) - don't stress about how a "real" example of this would work differently. This is just an exercise to practice some different concepts.

**Assumptions**:
* Each passenger bag weighs the same
* Planes reserve half of their total weight for passenger bags
* The weight of bag per person is a set value based on the plane weight and capacity
* Passengers exist for a single flight only

## MVP
Create a `Passenger` class which has:
* a name
* a number of bags

Create a `Plane` class which has:
* an enum PlaneType (e.g. *BOEING747*) which stores capacity and total weight

Create a `Flight` class which has:
* an empty list of booked `Passenger`'s
* a `Plane`
* flight number (i.e. "FR756")
* destination (i.e. GLA, EDI)
* departure airport (i.e. GLA, EDI)
* departure time (use a String)

The `Flight` class should have methods to:
* return the number of available seats
* book a passenger (if there are remaining seats)

### Extensions
Create a `FlightManager` class which has methods to:
* calculate how much weight in baggage is booked by passengers for a flight
* calculate how much overall weight reserved for baggage remains for a flight
* calculate how much baggage weight should be reserved for each passenger for a flight

### More Extensions
* Refactor the Flight's departure time to use the Date class (*HINT*: Look into **Type Migration** in IntelliJ to refactor faster)
* Add a `flight` property to the `Passenger` class which is assigned when a `Passenger` is booked on a flight
* Add a property 'seat number' to the `Passenger` class as an integer. Set it to a `Random` number which is assigned when a `Passenger` is booked on a flight
* Make sure the flight doesn't double book the same seat number to more than one passenger
