import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

// класс девайс база
class Device {
    private String type;
    private double price;
    private double weight;

    public Device(String type, double price, double weight) {
        this.type = type;
        this.price = price;
        this.weight = weight;
    }


    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}

// класс смартфон
class Smartphone extends Device {
    private double screenSize;
    private int cameraResolution;

    public Smartphone(String type, double price, double weight, double screenSize, int cameraResolution) {
        super(type, price, weight);
        this.screenSize = screenSize;
        this.cameraResolution = cameraResolution;
    }

    
    public double getScreenSize() {
        return screenSize;
    }

    public int getCameraResolution() {
        return cameraResolution;
    }
}

// класс ноут
class Laptop extends Device {
    private String processor;
    private int ram;

    public Laptop(String type, double price, double weight, String processor, int ram) {
        super(type, price, weight);
        this.processor = processor;
        this.ram = ram;
    }

    public String getProcessor() {
        return processor;
    }

    public int getRam() {
        return ram;
    }
}

class Tablet extends Device {
    private String operatingSystem;

    public Tablet(String type, double price, double weight, String operatingSystem) {
        super(type, price, weight);
        this.operatingSystem = operatingSystem;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // число устройств надо ввести
        System.out.print("Enter the number of devices to create (1-20): ");
        int numDevices = scanner.nextInt();

        if (numDevices < 1 || numDevices > 20) {
            System.out.println("Invalid number of devices. Please enter a number between 1 and 20.");
            return;
        }

        ArrayList<Device> devices = new ArrayList<>();

        Random random = new Random();

        for (int i = 0; i < numDevices; i++) {
            String type;
            double price = random.nextDouble() * 1000; // рандом от 0 до 1000
            double weight = random.nextDouble() * 2000; // рандом вес 0 2000

            // рандом устройство
            switch (random.nextInt(3)) {
                case 0:
                    type = "Smartphone";
                    devices.add(new Smartphone(type, price, weight, random.nextDouble() * 7, random.nextInt(48) + 12));
                    break;
                case 1:
                    type = "Laptop";
                    devices.add(new Laptop(type, price, weight, "Intel Core i7", random.nextInt(32) + 4));
                    break;
                case 2:
                    type = "Tablet";
                    devices.add(new Tablet(type, price, weight, "Android"));
                    break;
            }
        }

        // посчитать и вывести
        double totalWeight = 0;
        double totalPrice = 0;
        ArrayList<String> distinctDeviceTypes = new ArrayList<>();

        for (Device device : devices) {
            totalWeight += device.getWeight();
            totalPrice += device.getPrice();
            if (!distinctDeviceTypes.contains(device.getType())) {
                distinctDeviceTypes.add(device.getType());
            }
        }

        System.out.println("Number of distinct device types created: " + distinctDeviceTypes.size());
        System.out.println("Total price of all devices: $" + totalPrice);
        System.out.println("Total weight of all devices: " + totalWeight + " grams");

        scanner.close();
    }
}
