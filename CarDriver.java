class CarDriver {
  private String registrationNumber;
  private int driverAge;
  private int allottedSlot;

  public CarDriver() {
    registrationNumber = "";
    driverAge = 0;
    allottedSlot = 0;
  }

  public CarDriver(String registrationNumber, int driverAge, int allottedSlot) {
    this.registrationNumber = registrationNumber;
    this.driverAge = driverAge;
    this.allottedSlot = allottedSlot;
  }

  public String getRegistrationNumber() {
    return this.registrationNumber;
  }

  public int getDriverAge() {
    return this.driverAge;
  }

  public int getAllottedSlot() {
    return this.allottedSlot;
  }
}