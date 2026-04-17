import java.util.*;

public class Game {

    Scanner sc = new Scanner(System.in);

    // Postup metody: jméno → vytvoření postavy → staty → itemy → menu
    public void start() {
        System.out.println("Program začal.");
        // 🎓 ZÁKLAD 6: načtení jména
        System.out.println("Zadej jméno:");
        String name = sc.nextLine();

        // TODO načti jméno (patří do 🎓 ZÁKLAD 6)

        /* 🎓 ZÁKLAD 3: úprava jména
          - odstraň mezery na začátku a konci (trim())
         - nastav první písmeno jako velké */

        name = name.trim();

        char fl = name.charAt(0);

        String FL =  fl + "";

        FL = FL.toUpperCase();

        StringBuilder s =  new StringBuilder(name);

        s.replace(0,1,FL);

        name = s.toString();

        // TODO uprav name (patří do 🎓 ZÁKLAD 6)


        // 🎓 ZÁKLAD 8: vytvoř hráče (vytvoř novou instanci Character se jménem hráče)
        Character player = new Character(name);


        // 🎓 ZÁKLAD 9: vygeneruj staty hráče (generateStats())

        player.generateStats();

        /* 🎓 ZÁKLAD 10: načti 3 itemy
         hint: zkus použít for cyklus */

        for (int i = 0; i < 3; i++){
            player.addItem("The sword of Tuah");
        }

        int choice = 5;
        System.out.println();

        // 🎓 ZÁKLAD 11: menu
        do {
            System.out.println("-------------------------------------------------------------------");
            System.out.println("1 - vypiš postavu");
            System.out.println("2 - souboj");

            /* ⭐ BONUS 3: přidávání a odebrání itemů uživatelem pomocí menu - zde jen odkomentuj, více níže
            System.out.println("3 - přidej item");
            System.out.println("4 - odeber item"); */

            System.out.println("5 - konec");
            System.out.println("-------------------------------------------------------------------");

            choice = sc.nextInt();
            sc.nextLine();

            // TODO načti volbu (patří do 🎓 ZÁKLAD 11)


            if (choice == 1) {

                player.printInfo();

                // TODO vypiš postavu (patří do 🎓 ZÁKLAD 11)
            }

            if (choice == 2) {
                System.out.println("Zadej název nepřítele:");
                name = sc.nextLine();

                name = name.trim();

                fl = name.charAt(0);

                FL =  fl + "";

                FL = FL.toUpperCase();

                s =  new StringBuilder(name);

                s.replace(0,1,FL);

                name = s.toString();

                Character opponent = new Character(name);

                opponent.generateStats();
                for (int i = 0; i < 3; i++){
                    opponent.addItem("The mace of Rah");
                }

                // TODO vytvoř nepřítele (Character) (patří do 🎓 ZÁKLAD 11)

                opponent.printInfo();

                fight(player, opponent);

                // TODO zavolej fight() (patří do 🎓 ZÁKLAD 11)
            }

            // ⭐ BONUS 3:
            if (choice == 3) {
                // TODO načti item a přidej ho (patří do ⭐ BONUS 3)
            }

            if (choice == 4) {
                // TODO načti index a odeber item (patří do ⭐ BONUS 3)
            }

            System.out.println();
        } while (choice != 5);

        System.out.println("Program skončil.");
    }

    /**
     * 🎓 ZÁKLAD 12: metoda fight
     *
     * Metoda simuluje souboj mezi dvěma postavami.
     * Postavy se střídají v útocích, dokud mají oba více než 0 HP.
     *
     * Průběh:
     * - nejdříve útočí postava {@code a} na {@code b}
     * - pokud {@code b} přežije, útočí zpět na {@code a}
     *
     * ⭐ BONUS 4:
     * - kritický zásah (20% šance na vyšší poškození)
     *
     * ⭐ BONUS 5:
     * - pokud má postava item "lektvar", může se vyléčit
     *
     * Na konci metoda vypíše vítěze.
     *
     * @param a první postava (začíná)
     * @param b druhá postava
     */
    public void fight(Character a, Character b) {

        System.out.println("Souboj začíná!\n");

        /* hint: zkus použít while cyklus
         - cyklus běží dokud mají oba HP > 0
         - a útočí na b  ( patří do 🎓 ZÁKLAD 12)*/

        // ⭐ BONUS 4: kritický zásah =  s pravděpodobností 20 % způsobí 3x vyšší poškození

        boolean combat = true;

        while (combat){
            int damageDealt = 0;

            if (a.getHp() > 0 &&  b.getHp() > 0) {
                damageDealt = a.getAttack();
                b.lowerHp(damageDealt);

                System.out.println(a.getName() + " zaůtočil na " + b.getName() + " a ubral " + damageDealt + " HP, " + b.getName() + " nyní má " + b.getHp() + " HP");

                if (b.getHp() > 0){
                    damageDealt = b.getAttack();
                    a.lowerHp(damageDealt);

                    System.out.println(b.getName() + " zaůtočil na " + a.getName() + " a ubral " + damageDealt + " HP, " + a.getName() + " nyní má " + a.getHp() + " HP");
                }
            }
            else {
                if (a.getHp() <= 0) {
                    System.out.println("\n" + a.getName() + " vyhrál");
                }
                else {
                    System.out.println("\n" + b.getName() + " vyhrál");
                }
                combat = false;
            }
        }

        // TODO kontrola jestli b žije (patří do 🎓 ZÁKLAD 12)

        // ⭐ BONUS 5: pokud má hráč "lektvar", může se vyléčit (čili v poli item, položku s nazvem "lektvar")

        // TODO b útočí na a (patří do 🎓 ZÁKLAD 12)

        // TODO výpis vítěze (patří do 🎓 ZÁKLAD 12)
    }
}