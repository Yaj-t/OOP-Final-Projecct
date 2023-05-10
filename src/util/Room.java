
package util;

/**
 *
 * The Room class represents a room with its attributes such as ID, room number,
 * price, and description.
 */
public class Room {
    private int id; // The unique identifier of the room.
    private String roomNumber; // The room number.
    private double price; // The price of the room per night.
    private String description; // A brief description of the room.
    
    /**
    
    Constructs a Room object with default values.
    */
    public Room(){
    }
    
    /**
    
    Constructs a Room object with the specified values.
    @param roomNumber The room number.
    @param price The price of the room per night.
    @param description A brief description of the room.
    */
    public Room(String roomNumber, double price, String description) {
    this.roomNumber = roomNumber;
    this.price = price;
    this.description = description;
    }
    /**
    
    Constructs a Room object with the specified values.
    @param id The unique identifier of the room.
    @param roomNumber The room number.
    @param price The price of the room per night.
    @param description A brief description of the room.
    */
    public Room(int id, String roomNumber, double price, String description) {
    this.id = id;
    this.roomNumber = roomNumber;
    this.price = price;
    this.description = description;
    }
    /**
    
    Returns the unique identifier of the room.
    @return The unique identifier of the room.
    */
    public int getId() {
    return this.id;
    }
    /**
    
    Sets the unique identifier of the room.
    @param id The unique identifier of the room.
    */
    public void setId(int id) {
    this.id = id;
    }
    /**
    
    Returns the room number.
    @return The room number.
    */
    public String getRoomNumber() {
    return roomNumber;
    }
    /**
    
    Sets the room number.
    @param roomNumber The room number.
    */
    public void setRoomNumber(String roomNumber) {
    this.roomNumber = roomNumber;
    }
    /**
    
    Returns the price of the room per night.
    @return The price of the room per night.
    */
    public double getPrice() {
    return price;
    }
    /**
    
    Sets the price of the room per night.
    @param price The price of the room per night.
    */
    public void setPrice(double price) {
    this.price = price;
    }
    /**
    
    Returns a brief description of the room.
    @return A brief description of the room.
    */
    public String getDescription() {
    return description;
    }
    /**
    
    Sets a brief description of the room.
    @param description A brief description of the room.
    */
    public void setDescription(String description) {
    this.description = description;
    }
    }