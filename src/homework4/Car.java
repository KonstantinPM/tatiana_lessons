package homework4;

public class Car {
    @Override
    public String toString() {
        return "Car{" +
                "volumeTank=" + volumeTank +
                ", restOfTank=" + restOfTank +
                ", fuelConsumption=" + fuelConsumption +
                '}';
    }

    private int volumeTank;
    private int restOfTank;
    private double fuelConsumption;

    public int getVolumeTank() {
        return volumeTank;
    }

    public void setVolumeTank(int volumeTank) {
        this.volumeTank = volumeTank;
    }

    public int getRestOfTank() {
        return restOfTank;
    }

    public void setRestOfTank(int restOfTank) {
        this.restOfTank = restOfTank;
    }

    public double getFuelConsamption() {
        return fuelConsumption;
    }

    public void setFuelConsamption(int fuelConsamption) {
        this.fuelConsumption = fuelConsamption;
    }

    public int fullTank(int restOfTank, int volumeTank) {
        int c = 0;
        if (restOfTank < volumeTank) {
            c = volumeTank - restOfTank;
            this.restOfTank = volumeTank;
        }
        return c;
    }

    public int restOfTankAfterN(int restOfTank, double fuelConsumption, int n) {
        int c = (int) (restOfTank - ((fuelConsumption * n) / 100));
        this.restOfTank = c;
        return c;
    }

    public int refueling(int restOfTank, double fuelConsumption, int n) {
        int c = (int) (((n * fuelConsumption) / 100) - restOfTank);
        return c;
    }
}
