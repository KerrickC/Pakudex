public class Pakudex {

    //define Pakudex variable
    private int cap;
    private int size;
    private static Pakuri speciesArray[];

    //default class
    public Pakudex() {
        cap = 20;
        speciesArray = new Pakuri[cap];
    }

    //Pakudex class with capacity
    public Pakudex(int capacity) {
        cap = capacity;
        speciesArray = new Pakuri[cap];
    }

    //for loop returns size of species array
    public int getSize(){
        int size = 0;
        for(int i = 0; i < speciesArray.length; i ++){
            if(speciesArray[i] != null){
                size ++;
            }
        }
        return size;
    }

    //return capacity val
    public int getCapacity(){
        return cap;
    }

    //returns species array of non null vals
    public Pakuri[] getSpeciesArray(){
        if(speciesArray[0] != null){
            return speciesArray;
        }else{
            return null;
        }
    }

    //returns species stats using basic for loop
    public int[] getStats(String species){

        for(int i = 0; i < speciesArray.length; i ++){
            if(speciesArray[i].getSpecies().equals(species)){
                int[] stats = new int[3];
                stats[0] = speciesArray[i].getAttack();
                stats[1] = speciesArray[i].getDefense();
                stats[2] = speciesArray[i].getSpeed();
                return stats;
            }
        }
        return null;
    }

    public void sortPakuri(){

    }

    public boolean addPakuri(String species){
        for(int i = 0; i < speciesArray.length; i ++){
            if(i == speciesArray.length - 1 && speciesArray[i] != null){
                System.out.println("Error: Pakudex is full!");
                return false;
            }

            Pakuri p = new Pakuri(species);
            //System.out.println(p.getSpecies());
            if(speciesArray[i] == null){
                speciesArray[i] = p;
                System.out.println("Pakuri species " + speciesArray[i].getSpecies() + " successfully added!");
                return true;
            }else if(speciesArray[i].getSpecies().equals(p.getSpecies())){
                System.out.println("Error: Pakudex already contains this species!");
                return false;
            }

        }
        return false;
    }

    public boolean evolveSpecies(String species){
        for(int i = 0; i < speciesArray.length; i ++){
            if(speciesArray[i].getSpecies().equals(species)){
                speciesArray[i].evolve();
                return true;
            }
        }
        return false;
    }


    public Pakuri getPakuri(String species){
        for(Pakuri p: speciesArray){
            if(p.getSpecies().equals(species)){
                return p;
            }
        }
        return null;
    }

    public void setSpeciesArray(Pakuri[] sortedPakArr){
        speciesArray = sortedPakArr;
    }

}
