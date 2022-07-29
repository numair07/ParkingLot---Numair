import java.util.*;

class ParkingLot {
  private int slots;
  private String[] allottedSlots; // keep track of occupied slots
  private Hashtable<String, CarDriver> carAllotted; // check allotted slot for car
  private List<CarDriver> listOfCars; //list of all cars
  
  public ParkingLot(int slots) {
    this.slots = slots;
    allottedSlots = new String[slots];
    carAllotted = new Hashtable<>();
    listOfCars = new LinkedList<>();
  }

  public int getNearestSlot() {
    // get nearest available slot
    for (int i = 0; i < slots; i++) {
      if (allottedSlots[i] == null || allottedSlots[i].equals("")) {
        return i + 1;
      }
    }
    return 0;
  }

  public void completeParkingOperation(int age, String carNumber, int slotAllotted) {
    allottedSlots[slotAllotted - 1] = carNumber;
    CarDriver carDriver = new CarDriver(carNumber, age, slotAllotted);
    carAllotted.put(carNumber, carDriver);
    listOfCars.add(carDriver);
  }

  public String getSlotsCountByAge(int age) {
    String slots = "";
    int first = 0;
    for(CarDriver c : listOfCars) {
      if(first == 0) {
        slots += Integer.toString(c.getAllottedSlot());
        first = 1;
      }else {
        slots += ", " + Integer.toString(c.getAllottedSlot());
      }
    }
    return slots;
  }

  public String getVehiclesByAge(int age) {
    String slots = "";
    int first = 0;
    for(CarDriver c : listOfCars) {
      if(c.getDriverAge() == age) {
        if(first == 0) {
          slots += c.getRegistrationNumber();
          first = 1;
        }else {
          slots += ", " + c.getRegistrationNumber();
        }
      }
    }
    return slots;
  }

  public int getSlotNumberByVehicleNumber(String vehicleNumber) {
    return carAllotted.get(vehicleNumber).getAllottedSlot();
  }

  public CarDriver getAllDetailsBySlotAndRemove(int slot) {
    if(allottedSlots[slot - 1] == null || allottedSlots[slot - 1].equals("")) {
      return null;
    }
    CarDriver carDriver = carAllotted.get(allottedSlots[slot - 1]);
    allottedSlots[slot - 1] = "";
    carAllotted.remove(carDriver.getRegistrationNumber());
    for(CarDriver c : listOfCars) {
      if(c.getRegistrationNumber().equals(carDriver.getRegistrationNumber())) {
        listOfCars.remove(c);
        break;
      }
    }
    return carDriver;
  }
}