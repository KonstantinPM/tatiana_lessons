package homework6;

public class SubscriberServiceImpl implements SubscriberService {
    public Subscriber[] generateArrayOfSubscriber() {
        Subscriber[] subscribersArray = new Subscriber[10];
        subscribersArray[0] = new Subscriber(1, "Serbinenko", "Tanya", "Igorevna", "Dnipro", 80990275678L, 67654534L, 450, 20, 180, 20);
        subscribersArray[1] = new Subscriber(1, "Shementov", "Vlad", "Vadymovych", "Dnipro", 80990565698L, 67654535L, 100, 10, 100, 10);
        subscribersArray[2] = new Subscriber(1, "Sushenko", "Alina", "Sergeevna", "Dnipro", 80990245678L, 67654536L, 50, 80, 200, 40);
        subscribersArray[3] = new Subscriber(1, "Kuzyk", "Eugen", "Valentinovych", "Dnipro", 80930275600L, 67654537L, -60, 5, 20, 20);
        subscribersArray[4] = new Subscriber(1, "Hodko", "Nastya", "Eduardovna", "Nikopol", 80990275111L, 67654538L, 0, 88, 188, 30);
        subscribersArray[5] = new Subscriber(1, "Filenko", "Roman", "Igorevych", "Lviv", 80990272323L, 67654539L, -5, 65, 234, 30);
        subscribersArray[6] = new Subscriber(1, "Sidorenko", "Vadym", "Vadymovych", "Lviv", 80970975678L, 67654540L, 1000, 0, 127, 30);
        subscribersArray[7] = new Subscriber(1, "Klimenko", "Katerina", "Olegovna", "Lviv", 80990275657L, 67654541L, 0, 0, 0, 10);
        subscribersArray[8] = new Subscriber(1, "Grigorieva", "Tanya", "Romanovna", "Kyiv", 80990275698L, 67654542L, 30, 40, 400, 40);
        subscribersArray[9] = new Subscriber(1, "Antonov", "Anton", "Antonovych", "Kyiv", 80990275454L, 67654543L, 40, 0, 80, 20);
        return subscribersArray;
    }

    public void callTimeHigherThen(Subscriber[] arrayOfSubscribers, int timeBetweenStreets) {
        for (Subscriber subscriber : arrayOfSubscribers) {
            if (subscriber.getTimeBetweenSrteets() > timeBetweenStreets) {
                System.out.println(subscriber);
            }
        }
    }

    public void checkCommunicationBetweenCities(Subscriber[] arrayOfSubscribers) {
        for (Subscriber subscriber : arrayOfSubscribers) {
            if (subscriber.getTimeBetweenCities() > 0) {
                System.out.println(subscriber);
            }
        }
    }

    public int consumptionOfTraffic(Subscriber[] arrayOfSubscribers, String city) {
        int consumptionOfTraffic = 0;
        for (Subscriber subscriber : arrayOfSubscribers) {
            if (subscriber.getCity().equals(city)) {
                consumptionOfTraffic = consumptionOfTraffic + subscriber.getTraffic();
            }
        }
        return consumptionOfTraffic;
    }

    public int amountOfSubscribersNegativeBalance(Subscriber[] arrayOfSubscribers) {
        int amountOfSubscribersNegativeBalance = 0;
        for (Subscriber subscriber : arrayOfSubscribers) {
            if (subscriber.getBalance() < 0) {
                amountOfSubscribersNegativeBalance++;
            }
        }
        return amountOfSubscribersNegativeBalance;
    }

    public void searchByFirstCharacter(Subscriber[] arrayOfSubscribers, Character firstLetter) {
        for (Subscriber subscriber : arrayOfSubscribers) {
            if (subscriber.getSurname().charAt(0) == firstLetter) {
                System.out.println(subscriber.getSurname() + " " + subscriber.getName() + " " + subscriber.getPatronymic() + " " + subscriber.getNumberPhone() + " " + subscriber.getBalance());
            }
        }
    }
}
