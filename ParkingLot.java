import java.util.*;

class ParkingLot {
  int slots;
  int[] allottedSlots; // keep track of occupied slots
  Hashtable<String, Integer> carAllotted; // check allotted slot for car
  Hashtable<Integer, Integer> ageCount; // keep count of age

  public ParkingLot(int slots) {
    this.slots = slots;
    allottedSlots = new int[slots];
    carAllotted = new Hashtable <>();
    ageCount = = new Hashtable <>();
  }

}