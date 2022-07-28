class CarDriver {
  private String registrationNumber;
  private int driverAge;

  public CarDriver() {
    registrationNumber = "";
    driverAge = 0;
  }

  public CarDriver(String registrationNumber, int driverAge) {
    this.registrationNumber = registrationNumber;
    this.driverAge = driverAge;
  }

  public String getRegistrationNumber() {
    return this.registrationNumber;
  }

  public int getDriverAge() {
    return this.driverAge;
  }
}