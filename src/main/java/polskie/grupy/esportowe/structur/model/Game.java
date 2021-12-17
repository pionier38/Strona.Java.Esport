package polskie.grupy.esportowe.structur.model;

import javax.persistence.*;

@Entity(name = "tgame")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private double price;
    @Enumerated(EnumType.STRING)
    private Console console;
    private int available;
    private int rent;

    public Game(int id, String title, double price, Console console, int available, int rent) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.console = console;
        this.available = available;
        this.rent = rent;
    }

    public Game() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Console getConsole() {
        return console;
    }

    public void setConsole(Console console) {
        this.console = console;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public enum Console {
        PS3,
        PS4,
        PS5,
        XBOX360,
        XBOXONE,
        XBOXSX,
        NINTENDOSWITCH
    }

}
