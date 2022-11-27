package homework6;

public interface SubscriberService {
    public Subscriber[] generateArrayOfSubscriber();

    public void callTimeHigherThen(Subscriber[] arrayOfSubscribers, int timeBetweenStreets);

    public void checkCommunicationBetweenCities(Subscriber[] arrayOfSubscribers);

    public int consumptionOfTraffic(Subscriber[] arrayOfSubscribers, String city);

    public int amountOfSubscribersNegativeBalance(Subscriber[] arrayOfSubscribers);

    public void searchByFirstCharacter(Subscriber[] arrayOfSubscribers, Character firstLetter);
}
