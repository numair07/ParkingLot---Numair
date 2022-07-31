import java.io.*;
import java.util.*;

class Main {
  private FileReader fileReader;
  private FileWriter fileWriter;
  public BufferedReader bufferedReader;
  public BufferedWriter bufferedWriter;
  public Scanner scanner;

  public Main() throws IOException {
    fileReader = new FileReader("input.txt");
    fileWriter = new FileWriter("output.txt");
    bufferedReader = new BufferedReader(fileReader);
    bufferedWriter = new BufferedWriter(fileWriter);
    scanner = new Scanner(System.in);
  }

  public static void main(String[] args) throws IOException {
    Main main = new Main();

    // list to store read lines from input.txt
    List<String> inputContent = new LinkedList<>();

    // read contents of input.txt
    String lineReader = "";
    while ((lineReader = main.bufferedReader.readLine()) != null) {
      inputContent.add(lineReader);
    }
    
    ParkingLot parkingLot = null;
    int parking_lot_created = 0;
    String outputString = ""; //string to be written to output
    
    for (String str : inputContent) {
      if(str.contains("Create_parking_lot") && parking_lot_created == 0) {
        //check if parking lot is already created or not, also check if the command to create parking lot has been executed or not.
        parking_lot_created = 1;
        String splitString[] = str.split(" "); //split string based on regex
        parkingLot = new ParkingLot(Integer.parseInt(splitString[1]));
        outputString = "Created parking of " + splitString[1] + " slots";
        main.bufferedWriter.write(outputString + "\n");
        System.out.println(outputString);
      }
      else if (parking_lot_created == 1) {
        if(str.contains("Park")) { // if the command is to park vehicle
          String splitString[] = str.split(" ");
          String vehicleNumber = splitString[1];
          String driverAge = splitString[3];
          int availableSlot = parkingLot.getNearestSlot();
          parkingLot.completeParkingOperation(Integer.parseInt(driverAge), vehicleNumber, availableSlot); //add car to data
          
          outputString = "Car with vehicle registration number \"" + vehicleNumber +  "\" has been parked at slot number " + Integer.toString(availableSlot);
          main.bufferedWriter.write(outputString + "\n");
          System.out.println(outputString);
        }
        else if(str.contains("Slot_numbers_for_driver_of_age")) {
          String splitString[] = str.split(" ");
          String driverAge = splitString[1];
          String slots = parkingLot.getSlotsCountByAge(Integer.parseInt(driverAge));
          main.bufferedWriter.write(slots + "\n");
          System.out.println(slots);
        }
        else if(str.contains("Slot_number_for_car_with_number")) {
          String splitString[] = str.split(" ");
          String vehicleNumber = splitString[1];
          int slotNo = parkingLot.getSlotNumberByVehicleNumber(vehicleNumber);
          main.bufferedWriter.write(Integer.toString(slotNo) + "\n");
          System.out.println(Integer.toString(slotNo));
        }
        else if(str.contains("Vehicle_registration_number_for_driver_of_age")) {
          String splitString[] = str.split(" ");
          String driverAge = splitString[1];
          String RegistrationNumbers = parkingLot.getVehiclesByAge(Integer.parseInt(driverAge));
          if(RegistrationNumbers.length() > 0)
            main.bufferedWriter.write(RegistrationNumbers + "\n");
          System.out.println(RegistrationNumbers);
        }
        else if(str.contains("Leave")) {
          String splitString[] = str.split(" ");
          String slot = splitString[1];
          CarDriver carDriver = parkingLot.getAllDetailsBySlotAndRemove(Integer.parseInt(slot));
          if(carDriver != null) {
            outputString = "Slot number " + slot +  " vacated, the car with vehicle registration number \"" + carDriver.getRegistrationNumber() +  "\" left the space, the driver of the car was of age " + Integer.toString(carDriver.getDriverAge());
          }
          else {
            outputString = "Slot already vacant";
          }
          main.bufferedWriter.write(outputString + "\n");
          System.out.println(outputString);
        }
      }
    }
    main.bufferedWriter.close();
  }
}