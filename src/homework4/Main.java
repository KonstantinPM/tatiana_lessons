package homework4;

public class Main {
    public static void main(String[] args) {
        final int WAY = 476;
        double priceOfFuel = Double.parseDouble(args[0]);
        Car car1 = new Car();
        car1.setVolumeTank(40);
        car1.setFuelConsamption(8);
        car1.setRestOfTank(25);
        double distance = car1.getRestOfTank();
        System.out.println(car1);
        System.out.println();
        System.out.println("Растояние Одесаа-Киев составляет: " + WAY);
        System.out.println("Для всего расстояния нужно дозалить: " + car1.refueling(car1.getRestOfTank(), car1.getFuelConsamption(), WAY) + " литров");
        System.out.println();
        System.out.println("Вы проехали расстояние Одеса-Кривое Озеро (179 км)");
        System.out.println("Остаток литров в баке: " + car1.restOfTankAfterN(car1.getRestOfTank(), car1.getFuelConsamption(), 179));
        System.out.println();
        System.out.println("Вы дозаправили автомобиль до полного бака, залив:");
        System.out.println(car1.fullTank(car1.getRestOfTank(), car1.getVolumeTank()) + " литров");
        System.out.println();
        System.out.println("Вы проехали расстояние Кривое Озеро-Жашков (153 км)");
        System.out.println("Остаток литров в баке: " + car1.restOfTankAfterN(car1.getRestOfTank(), car1.getFuelConsamption(), 153));
        System.out.println();
        System.out.println("Вы дозаправили автомобиль до полного бака, залив:");
        System.out.println(car1.fullTank(car1.getRestOfTank(), car1.getVolumeTank()) + " литров");
        System.out.println("Вы доехали до Киева (148)");
        System.out.println("Остаток литров в баке: " + car1.restOfTankAfterN(car1.getRestOfTank(), car1.getFuelConsamption(), 148));
        System.out.println();
        double price = ((WAY * car1.getFuelConsamption()) / 100) * priceOfFuel;
        System.out.println("Стоимость поездки: " + price);
    }
}
