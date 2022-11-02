package homework6;

public class Run {
    public static void main(String[] args) {
        SubscriberServiceImpl subscriberServiceImpl = new SubscriberServiceImpl();
        Subscriber[] subscribers = subscriberServiceImpl.generateArrayOfSubscriber();
        System.out.println("List of subscribers, who's time of calling in the city higher then 50 minutes:");
        subscriberServiceImpl.callTimeHigherThen(subscribers, 50);
        System.out.println();
        System.out.println("List of subscribers, who calling to another city:");
        subscriberServiceImpl.checkCommunicationBetweenCities(subscribers);
        System.out.println();
        System.out.println("Sum of traffic for subscribers from Dnipro:");
        System.out.println(subscriberServiceImpl.consumptionOfTraffic(subscribers, "Dnipro"));
        System.out.println();
        System.out.println("Amount of subscribers with negative balance:");
        System.out.println(subscriberServiceImpl.amountOfSubscribersNegativeBalance(subscribers));
        String firstLetter = args[0];
        char firstLetterChar = firstLetter.charAt(0);
        System.out.println("Information data of subscribers, who's surname starts from " + firstLetterChar + ":");
        subscriberServiceImpl.searchByFirstCharacter(subscribers, firstLetterChar);
    }
}
