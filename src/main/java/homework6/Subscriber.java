package homework6;

public class Subscriber {
    public int identificator;
    public String surname;
    public String name;
    public String patronymic;
    public String city;
    public long numberPhone;
    public long numberOfAgreement;
    public int balance;
    public int timeBetweenCities;
    public int timeBetweenSrteets;
    public int traffic;

    public int getIdentificator() {
        return identificator;
    }

    public void setIdentificator(int identificator) {
        this.identificator = identificator;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(long numberPhone) {
        this.numberPhone = numberPhone;
    }

    public long getNumberOfAgreement() {
        return numberOfAgreement;
    }

    public void setNumberOfAgreement(long numberOfAgreement) {
        this.numberOfAgreement = numberOfAgreement;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getTimeBetweenCities() {
        return timeBetweenCities;
    }

    public void setTimeBetweenCities(int timeBetweenCities) {
        this.timeBetweenCities = timeBetweenCities;
    }

    public int getTimeBetweenSrteets() {
        return timeBetweenSrteets;
    }

    public void setTimeBetweenSrteets(int timeBetweenSrteets) {
        this.timeBetweenSrteets = timeBetweenSrteets;
    }

    public int getTraffic() {
        return traffic;
    }

    public void setTraffic(int traffic) {
        this.traffic = traffic;
    }

    public Subscriber(int identificator, String surname, String name, String patronymic, String city, long numberPhone, long numberOfAgreement, int balance, int timeBetweenCities, int timeBetweenSrteets, int traffic) {
        this.identificator = identificator;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.city = city;
        this.numberPhone = numberPhone;
        this.numberOfAgreement = numberOfAgreement;
        this.balance = balance;
        this.timeBetweenCities = timeBetweenCities;
        this.timeBetweenSrteets = timeBetweenSrteets;
        this.traffic = traffic;
    }

    public Subscriber(int identificator, long numberOfAgreement, int balance) {
        this.identificator = identificator;
        this.numberOfAgreement = numberOfAgreement;
        this.balance = balance;
    }

    public Subscriber() {

    }

    @Override
    public String toString() {
        return "Subscriber{" +
                "identificator=" + identificator +
                ", family='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", city='" + city + '\'' +
                ", numberPhone=" + numberPhone +
                ", numberOfAgreement=" + numberOfAgreement +
                ", balance=" + balance +
                ", timeBetweenCities=" + timeBetweenCities +
                ", timeBetweenSrteets=" + timeBetweenSrteets +
                ", traffic=" + traffic +
                '}';
    }


}
