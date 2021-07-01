public class Hero extends Person {

    public Hero(String name,  int health, int gold, int dexterity, int experience, int power) {
        super.setName(name);
        super.setHealth(health);
        super.setGold(gold);
        super.setDexterity(dexterity);
        super.setExperience(experience);
        super.setPower(power);
        //this.setMonsterType(monsterType);
    }

    @Override
    public boolean attack() {
        System.out.println("Атака из класса Hero");
        //Определение силы удара
        if (this.getDexterity()*3>=(int) Math.round(Math.random()*100)) {
            System.out.println("Герой " + this.getName() + " атакует с силой " + this.getPower());
            return true;
        }
            else
            System.out.println("К сожалению, герой " + this.getName() + " промахивается...");
            return false;
        }
    }



