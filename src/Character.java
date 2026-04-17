import java.util.ArrayList;
import java.util.Random;

public class Character {

    /* 🎓 ZÁKLAD 1: vytvoř atributy
     name (String)
     hp (int)
     attack (int)
     inventory (ArrayList<String>) */

    private String name;
    private int hp;
    private int attack;
    private ArrayList<String> inventory;


    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void lowerHp(int hp) {
        this.hp -= hp;
    }

    public int getAttack() {
        return attack;
    }

    public ArrayList<String> getInventory() {
        return inventory;
    }

    // 🎓 ZÁKLAD 2: konstruktor
    // nastav jméno a vytvoř prázdný inventář
    public Character(String name) {
        this.name = name;
        inventory = new ArrayList<>();
    }

    /*
     * 🎓 ZÁKLAD 4:vygeneruje náhodné základní statistiky postavy.
     * hp v rozsahu: 50–100
     * attack v rozsahu: 5–20
     * hint: zkus použít Random
     */
    public void generateStats() {
        Random rand = new Random();
        hp = rand.nextInt(50, 100);
        attack =  rand.nextInt(5, 20);
    }

    // 🎓 ZÁKLAD 2: přidání itemu do inventory
    public void addItem(String item) {
        inventory.add(item);
    }

    // ⭐ BONUS 2: odebrání itemu
    public void removeItem(int index) {
        // hint: pozor na to, aby to nespadlo pokud nebude existovat


    }

    // 🎓 ZÁKLAD 2: výpis postavy - jmeno, hp, attack (bez itemů))
    public void printInfo() {

        System.out.println("Name: " + name);
        System.out.println("HP: " + hp);
        System.out.println("Attack: " + attack);
        // ⭐ BONUS 1:
        // vypiš o inventář a to očíslovaně (1. item)
    }
}