package Models;

import javafx.scene.image.Image;

public class Phone {
    private String make;
    private String model, os;
    private double screenSize, memory, frontCameraRes, rearCameraRes, price;
    private Image image;

    public Phone(String make, String model, String os, double screenSize) {
        setMake(make);
        setModel(model);
        setOs(os);
        setScreenSize(screenSize);
    }

    public Phone(String make, String model, String os, double screenSize, double memory, double frontCameraRes, double rearCameraRes, double price, Image image) {
        this(make, model, os, screenSize);
        setMemory(memory);
        setFrontCameraRes(frontCameraRes);
        setRearCameraRes(rearCameraRes);
        setPrice(price);
        setImage(image);
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public double getMemory() {
        return memory;
    }

    public void setMemory(double memory) {
        this.memory = memory;
    }

    public double getFrontCameraRes() {
        return frontCameraRes;
    }

    public void setFrontCameraRes(double frontCameraRes) {
        this.frontCameraRes = frontCameraRes;
    }

    public double getRearCameraRes() {
        return rearCameraRes;
    }

    public void setRearCameraRes(double rearCameraRes) {
        this.rearCameraRes = rearCameraRes;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
