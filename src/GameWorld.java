import java.util.Scanner;

public class GameWorld {
    Scanner scanner = new Scanner(System.in);
    public Hero hero;
    private static int level, i, j;
    static String heroName;
    public void printmenu(int level) {
        switch (level) {
            case 0:
                System.out.println("Добро пожаловать в город!");
                System.out.println("1: В магазин");
                System.out.println("2: В темный лес на битву");
                System.out.println("3: Выход из программы");
                break;
            case 1:
                System.out.println("Добро пожаловать в магазин!");
                System.out.println("1: Обменять золото на здоровье");
                System.out.println("2: Вернуться в город");
                break;
            case 2:
                System.out.println("Вы сейчас в темном лесу и только что победили монстра!");
                System.out.println("1: Продолжить битву с монстрами");
                System.out.println("2: Вернуться в город");

        }
    }
    public void runmenu(int level) {
        switch (level) {
            case 0:
                i = scanner.nextInt();
                switch (i) {
                    case 1:
                        printmenu(1);
                        level = 1;
                        runmenu(1);
                        break;
                    case 2:
                        System.out.println("Вы выбрали поход в темный лес на битву!");
                        System.out.println("Да начнется битва!!!");
                        Battle battle = new Battle();
                        battle.start();
                        battle.run(hero);
                        printmenu(2);
                        //level = 0;
                        runmenu(2);
                        break;
                    case 3:
                        System.out.println("Вы выбрали выход из программы, до новых встреч!");
                        System.exit(0);
                    default:
                        System.out.println("Неверно выбран пункт меню");
                        break;
                    }
            case 1:
                i = scanner.nextInt();
                switch (i) {
                    case 1:
                        System.out.println("У героя " + hero.getName()+ " в наличии " + hero.getGold() + " единиц золота и " + hero.getHealth() + " единиц здоровья. Сколько единиц золота Вы хотели бы обменять на здороье?");
                        j = scanner.nextInt();
                        hero.setHealth(hero.getHealth() + j);
                        hero.setGold(hero.getGold() - j);
                        System.out.println("Теперь у героя " + hero.getName() + " " + hero.getHealth() + " единиц здоровья, а единиц золота - " + hero.getGold());
                        printmenu(1);
                        runmenu(1);
                        break;
                    case 2:
                        printmenu(0);
                        runmenu(0);
                        level = 0;
                        break;
                }
            case 2:
                i = scanner.nextInt();
                switch (i) {
                    case 1:
                        System.out.println("Вы выбрали поход в темный лес на битву!");
                        System.out.println("Да начнется битва!!!");
                        Battle battle = new Battle();
                        battle.start();
                        battle.run(hero);
                        printmenu(2);
                        //level = 0;
                        runmenu(2);
                        break;
                    case 2:
                        printmenu(0);
                        runmenu(0);
                        level = 0;
                        break;
                }

        }

    }
    public void go() {
        System.out.println("Добро пожаловать в игру! Для начала введите имя героя:");
        heroName = scanner.nextLine();
        hero = new Hero(heroName, 100, 5, 30, 20, 20);
        printmenu(0);
        level = 0;
        runmenu(level);

    }
}
