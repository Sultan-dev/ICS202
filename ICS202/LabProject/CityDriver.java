import java.util.Scanner;

public class CityDriver {
    private static Scanner scanner = new Scanner(System.in);
    protected static MSLL<String> mList = new MSLL<>();
    protected static SLL<City> cityList = new SLL<City>(mList);

    public static void main(String[] args) {

        int choice;

        do {
            choice = getMenuChoice();

            switch (choice) {
                case 1:
                    addCityToSublistAtRear();
                    break;

                case 2:
                    addCityToSublistAtPosition();
                    break;

                case 3:
                    searchForCity();
                    break;

                case 4:
                    deleteCityFromCitySublist();
                    break;

                case 5:
                    deleteCitySublist();
                    break;

                case 6:
                    makeCitySublistEmpty();
                    break;

                case 7:
                    displayCitySublist();
                    break;

                case 8:
                    addToMSSLAtHead();
                    break;

                case 9:
                    addToMSSLAtTail();
                    break;

                case 10:
                    SearchMSLLList();
                    break;

                case 11:
                    getDistance();
                    break;


            }

        } while (choice != 12);
    }

    private static void getDistance() { // choice 11
        String city1, city2;
        try {
            System.out.println("Enter name of city 1: ");
            city1 = scanner.next();

            System.out.println("Enter name of city 2: ");
            city2 = scanner.next();

            System.out.printf("The distance between %s and %s is %.2f kilometers", city1, city2, cityList.getDistance(city1, city2));

        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println();
    }

    private static void SearchMSLLList() { // choice 10
        String key;
        boolean flag;
        try {
            System.out.println("Enter the key: ");
            key = scanner.next();

            flag = mList.isInMSLList(key);

            if (flag) {
                System.out.println("The key is in the MSLL.");
            } else {
                System.out.println("The key is not in the MSLL.");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println();
    }

    private static void addToMSSLAtTail() { // choice 9
        String key;

        try {
            System.out.println("Enter the key: ");
            key = scanner.next();

            mList.addToMSLLTail(key);

            System.out.println("The key added successfully.");

        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println();
    }

    private static void addToMSSLAtHead() { // choice 8
        String key;

        try {
            System.out.println("Enter the key: ");
            key = scanner.next();

            mList.addToMSLLHead(key);

            System.out.println("The key added successfully.");

        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println();
    }

    private static void displayCitySublist() { // choice 7
        String key;

        try {
            System.out.println("Enter the key: ");
            key = scanner.next();

            mList.displayCitySublist(key);

        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println();
    }

    private static void makeCitySublistEmpty() { // choice 6
        String key;
        try {
            System.out.println("Enter the key: ");
            key = scanner.next();

            cityList.makeCitySublistEmpty(key);

            System.out.println("The city sublist deleted successfully.");
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println();
    }

    private static void deleteCitySublist() { // choice 5
        String key;

        try {
            System.out.println("Enter the key: ");
            key = scanner.next();

            mList.deleteFromMSLL(key);

            System.out.println("The list deleted successfully.");
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println();
    }

    private static void deleteCityFromCitySublist() { // choice 4
        String name;
        double latitude, longitude;
        try {

            System.out.println("Enter City name, latitude and longitude of the city that you want to delete: ");
            name = scanner.next();
            latitude = scanner.nextDouble();
            longitude = scanner.nextDouble();

            cityList.deleteCityFromSublist(new City(name, latitude, longitude));

            System.out.println("The city deleted successfully.");

        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println();
    }

    private static void searchForCity() { // choice 3
        String name;
        double latitude, longitude;
        boolean flag;
        try {
            System.out.println("Enter City name, latitude and longitude of the city: ");
            name = scanner.next();
            latitude = scanner.nextDouble();
            longitude = scanner.nextDouble();

            flag = cityList.cityIsInSubList(new City(name, latitude, longitude));

            if (flag) {
                System.out.println("The city is in the sublist.");
            } else {
                System.out.println("The city is not in the sublist.");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println();
    }

    private static void addCityToSublistAtPosition() { // choice 2
        int pos;
        String name;
        double latitude, longitude;
        try {

            System.out.println("Enter City name, latitude and longitude for city and its position : ");
            name = scanner.next();
            latitude = scanner.nextDouble();
            longitude = scanner.nextDouble();
            pos = scanner.nextInt();
            cityList.addToCitySublist(new City(name, latitude, longitude), pos);
            System.out.println("The city added successfully.");

        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println();
    }

    private static void addCityToSublistAtRear() { // choice 1
        String name;
        double latitude, longitude;
        try {

            System.out.println("Enter City name, latitude and longitude of the city: ");
            name = scanner.next();
            latitude = scanner.nextDouble();
            longitude = scanner.nextDouble();
            cityList.addCityToSublistAtRear(new City(name, latitude, longitude));

            System.out.println("The city added successfully.");

        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println();
    }

    public static int getMenuChoice() {
        int choice;

        do {
            System.out.println("Please select the operation: ");
            System.out.println("1. Add City To Sublist At Rear");
            System.out.println("2. Add City To Sublist At Position");
            System.out.println("3. Search For City");
            System.out.println("4. Delete City From City Sublist");
            System.out.println("5. Delete City Sublist");
            System.out.println("6. Make City Sublist Empty");
            System.out.println("7. Display City Sublist");
            System.out.println("8. Add To MSLL At Head");
            System.out.println("9. Add To MSLL At Tail");
            System.out.println("10. Search MSLL List");
            System.out.println("11. get Distance");
            System.out.println("12. Exit");

            choice = scanner.nextInt();
            if (choice < 1 || choice > 12)
                System.out.println("Error: Wrong operation!");
        } while (choice < 1 || choice > 12);

        return choice;
    }
}

