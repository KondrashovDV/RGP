
public class Battle extends Thread {
    static String monsterName;
    static int monsterDexterity;
    public Monster monster;
    //public Hero hero;
    public static void chooseMonster() {
        int i = (int) Math.round(Math.random()*100);
        System.out.println("Выпало случайное значение " + i);
        if (i<=32) {
            monsterName = "Goblin";
            int j = (int) Math.round(Math.random()*50);
            if (j<20)
                monsterDexterity = 20;
                        else
                            monsterDexterity = j;
        }
        if (i >=33&&i<=65) {
            monsterName = "Skeleton";
            int j = (int) Math.round(Math.random()*40);
            if (j<15)
                monsterDexterity = 15;
            else
                monsterDexterity = j;
        }
        if (i >=66) {
            monsterName = "Dragon";
            int j = (int) Math.round(Math.random()*100);
            if (j<40)
                monsterDexterity = 40;
            else
                monsterDexterity = j;
        }
        /*else
            monsterName = "Skeleton";*/
        System.out.println("В сражение с героем вступает " + monsterName);
    }

    public void run(Hero hero) {
        // Создаем монстра
        chooseMonster();
        if (monsterName.equals("Goblin"))
            monster = new Monster(monsterName,50,30,monsterDexterity,10,40);
        if (monsterName.equals("Skeleton"))
            monster = new Monster(monsterName,30,20,monsterDexterity,5,30);
        if (monsterName.equals("Dragon"))
            monster = new Monster(monsterName,90,80,monsterDexterity,15,50);

        // Битва с монстром идет либо до победы монстра, либо до победы героя. Если герой погибает - выход из программы
        while (true) {
            System.out.println("Герой наносит удар!");
            if (hero.attack()) {
             monster.setHealth(monster.getHealth() - hero.getPower());
            }
            if (monster.getHealth()<=0) {
                System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("Битва окончена! Монстр " + monster.getName() + " повержен!!!");
                System.out.println("Герой " + hero.getName() + " получает золото монстра " + monster.getName() + " в размере " + monster.getGold() + " единиц золота.");
                hero.setGold(hero.getGold() + monster.getGold());
                System.out.println("Теперь у героя " + hero.getName() + " " + hero.getGold() + " единиц золота!!!");
                System.out.println("Остаток единиц здоровья героя - " + hero.getHealth());
                hero.setExperience(hero.getExperience() + monster.getExperience());
                System.out.println("Теперь у героя прибавилось опыта на " + monster.getExperience() + " единиц и опыт составляет " + hero.getExperience() + " единиц.");
                hero.setPower(hero.getPower() + hero.getExperience());
                System.out.println("Сила удара героя теперь составляет " + hero.getPower());
                if (hero.getHealth()<=20) {
                    System.out.println("У героя мало едениц здоровья - " + hero.getHealth()+ "! Рекомендуем посетить магазин для пополнения единиц здоровья! Мертвым деньги не нужны! :)");
                }
                System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------");
                break;
            }
            try {
                sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Монстр наносит удар!");
            if (monster.attack()) {
                hero.setHealth(hero.getHealth() - monster.getPower());
                System.out.println("Монстр " + monster.getName()+ " нанес ущерб герою " + hero.getName()+ " в размере " + monster.getPower() + " единиц. Остаток здоровья героя - " + hero.getHealth() + " единиц.");
            }

            if (hero.getHealth()<=0) {
                System.out.println("Герой " + hero.getName() + " пал в бою!!!");
                System.out.println("RIP, " + hero.getName()!!! + "Нам будет тебя не хватать!");
                System.out.println("Программа прекращена!");
                System.exit(0);

            }
            try {
                sleep(1500);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
        //
        //hero.attack();

    }
}
