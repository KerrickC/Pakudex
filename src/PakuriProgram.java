import java.util.Scanner;
import java.util.Arrays;

public class PakuriProgram {


    public static void main(String[] args) {
        //new scanner
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to Pakudex: Tracker Extraordinaire!");

        int capacity = 0;

        boolean valid = false;

        //while the input is not valid, do this
        while(!valid){
            System.out.println("Enter max capacity of the Pakudex: ");

            String capString = scan.next();
            try{ //convert input to int, if errors, it is invalid, continue loop
                capacity = Integer.parseInt(capString);
                if(capacity < 1){
                    System.out.println("Please enter a valid size.");
                    valid = false;
                }else{
                    valid = true;
                }
            }catch(Exception e){
                System.out.println("Please enter a valid size.");
                valid = false;
            }
        }

        System.out.println("The Pakudex can hold " + capacity + " species of Pakuri.");

        //create new pakudex with size capacity
        Pakudex pakudex = new Pakudex(capacity);

        boolean finish = false;

        //while user is not finished, do this code
        while(!finish) {

            int choice = 0;

            boolean validChoice = false;

            //while there is a valid input and the user is not finished, do this code
            while(!validChoice && !finish){
                    System.out.println("Pakudex Main Menu \n----------------- \n1. List Pakuri\n2. Show Pakuri\n3. Add Pakuri\n4. Evolve Pakuri\n5. Sort Pakuri\n6. Exit");

                    System.out.println("What would you like to do?");

                String choiceString = scan.next();
                try{ //while this code is not error here, the 21245636re is a valid input
                    choice = Integer.parseInt(choiceString);

                    switch (choice) {
                        case 1: //list pakuri
                            Pakuri[] arr = pakudex.getSpeciesArray();

                            //if no pakuri have yet been added
                            if(arr == null){
                                System.out.println("No Pakuri in Pakudex yet!");
                                System.out.println();
                                break;
                            }

                            //if first pakuri index is empty
                            if(arr[0] == null){
                                System.out.println("No Pakuri in Pakudex yet!");
                                System.out.println();
                                break;
                            }
                            //if not, return pakuri in pakudex
                            System.out.println("Pakuri In Pakudex:");
                            for (int i = 0; i < arr.length; i++) {
                                if(arr[i]!= null){
                                    System.out.println(i+1 + ". " + arr[i].getSpecies());
                                }
                            }
                            System.out.println();
                            break;

                        case 2: //show pakuri
                            System.out.println("Enter the name of the species to display: ");
                            String displayName = scan.next();

                            Pakuri[] showPakArr = pakudex.getSpeciesArray();

                            //if no pakuri have yet been added
                            if(showPakArr == null){
                                System.out.println("Error: No such Pakuri!");
                                break;
                            }

                            //if first index is empty
                            if(showPakArr[0] == null){
                                System.out.println("Error: No such Pakuri!");
                                break;
                            }

                            //else, use getStat() that returns an int[] to print out the stats
                            for (int i = 0; i < showPakArr.length; i++) {
                                if (showPakArr[i].getSpecies().equals(displayName)) {
                                    int[] statsArr = pakudex.getStats(displayName);
                                    System.out.println("Species: " + displayName);
                                    System.out.println("Attack: " + statsArr[0]);
                                    System.out.println("Defense: " + statsArr[1]);
                                    System.out.println("Speed: " + statsArr[2]);
                                    System.out.println();
                                    break;
                                }
                            }

                            break;

                        case 3: //add pakuri
                            Pakuri[] addPakArr = pakudex.getSpeciesArray();

                            //if there is a pkauri in the first pakudex spot and the cap of the pakudex is 1
                            if(addPakArr != null && addPakArr[0] != null && addPakArr.length == 1){
                                System.out.println("Error: Pakudex is full!");

                            }else if(addPakArr != null && addPakArr[addPakArr.length-1] != null){ //if there is a pakuri in the last spot
                                System.out.println("Error: Pakudex is full!");
                            }else{ //if there is a empty availble spot in the pakude
                                System.out.println("Enter the name of the species to add: ");
                                String pName = scan.next();
                                //add the pakuri
                                pakudex.addPakuri(pName);
                        }
                            System.out.println();
                            break;

                        case 4: //evolve pakuri
                            System.out.println("Enter the name of the species to evolve: ");
                            String evolvePakName = scan.next();
                            //if there is an error, then the pakuri does not exist
                            try{
                                Pakuri[] pakArr = pakudex.getSpeciesArray();
                                int index = 0;
                                for(Pakuri p: pakArr){
                                    index ++;
                                    if(p.getSpecies().equals(evolvePakName)){
                                        pakudex.evolveSpecies(evolvePakName);
                                        System.out.println( evolvePakName + " has evolved!");
                                        break;
                                        //if index is equal to the last spot of the array and that spot is not empty
                                    }else if(index == pakArr.length - 1){
                                        System.out.println("Error: No such Pakuri!");
                                        break;
                                    }
                                }

                                validChoice = true;
                            }catch (Exception e){
                                System.out.println("Error: No such Pakuri!");
                            }


                            break;
                        case 5: //sort pakuri
                            //use a linear sort and compareTo() to sort the species alphabetically
                            Pakuri[] unsortedPakArr = pakudex.getSpeciesArray();

                            for(int i = 0; i < unsortedPakArr.length; i ++) {
                                for (int j = i + 1; j < unsortedPakArr.length -1 ; j++) {
                                    if(unsortedPakArr[j] != null){
                                        int compare = unsortedPakArr[i].getSpecies().compareTo(unsortedPakArr[j].getSpecies());
                                        if (compare > 0) { //index i is greater than index j
                                            Pakuri temp = unsortedPakArr[j];
                                            unsortedPakArr[j] = unsortedPakArr[i];
                                            unsortedPakArr[i] = temp;
                                        }
                                    }

                                }

                            }

                            System.out.println("Pakuri have been sorted!");
                            System.out.println();

                            break;
                        case 6: //exit the while loop
                            System.out.println("Thanks for using Pakudex! Bye!");
                            finish = true;
                            break;
                        default: //default selection
                            System.out.println("Unrecognized menu selection!");
                            System.out.println();
                            break;
                    }

                }catch(Exception e){
                    System.out.println("Unrecognized menu selection!");
                    validChoice = false;
                }
            }


        }

    }

}
