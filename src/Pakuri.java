public class Pakuri {
    private String speciesName;
    private int attack, defense, speed;

    //Pakuri class
    public Pakuri(String species) {
        speciesName = species;
        attack = (species.length() * 7) + 9;
        defense = (species.length() * 5) + 17;
        speed = (species.length() * 6) + 13;
    }

    //returns species name string
    public String getSpecies(){
        return speciesName;
    }

    //returns attack int
    public int getAttack(){
        return attack;
    }

    //return defense int
    public int getDefense(){
        return defense;
    }

    //returns speed int
    public int getSpeed(){
        return speed;
    }

    //sets attack int
    public void setAttack(int newAttack){
        attack = newAttack;
    }

    //evolves species
    public void evolve(){
        speed *= 3;
        defense *= 4;
        attack *= 2;
    }


}
