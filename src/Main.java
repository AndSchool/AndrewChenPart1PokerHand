import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        String fileData = "";
        try {
            File f = new File("src/data");
            Scanner s = new Scanner(f);


            while (s.hasNextLine()) {
                String line = s.nextLine();
                fileData += line + "\n";
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }


        String[] lines = fileData.split("\n");




        //this works only for this specific example, but I can make code to count each line of data
        int[] handValues = {0,0,0,0,0,0,0};

        for (String line : lines) {
            int bar = line.indexOf("|");
            String numbers = line.substring(0, bar);
            String[] list = numbers.split(",");


            int[] values = new int[list.length];
            int[] cardValues = {0,0,0,0,0,0,0,0,0,0,0,0,0};

            for (int i = 0; i < list.length; i++) {


                if(list[i].contains("Ace")){
                    cardValues[0]=cardValues[0]+1;
                }
                if(list[i].contains("King")){
                    cardValues[1]=cardValues[1]+1;
                }
                if(list[i].contains("Queen")){
                    cardValues[2]=cardValues[2]+1;
                }
                if(list[i].contains("Jack")){
                    cardValues[3]=cardValues[3]+1;
                }
                if(list[i].contains("10")){
                    cardValues[4]=cardValues[4]+1;
                }
                if(list[i].contains("9")){
                    cardValues[5]=cardValues[5]+1;
                }
                if(list[i].contains("8")){
                    cardValues[6]=cardValues[6]+1;
                }
                if(list[i].contains("7")){
                    cardValues[7]=cardValues[7]+1;
                }
                if(list[i].contains("6")){
                    cardValues[8]=cardValues[8]+1;
                }
                if(list[i].contains("5")){
                    cardValues[9]=cardValues[9]+1;
                }
                if(list[i].contains("4")){
                    cardValues[10]=cardValues[10]+1;
                }
                if(list[i].contains("3")){
                    cardValues[11]=cardValues[11]+1;
                }
                if(list[i].contains("2")){
                    cardValues[12]=cardValues[12]+1;
                }
            }
int temp=0;
            //0=high,1=pair,2=two pair, 3= 3kind, 4=full, 5=four, 6=five
            for (int i = 0; i < cardValues.length; i++) {
            if (cardValues[i]==5){
temp=6;
            }
                if (cardValues[i]==4){
if(temp<5){
    temp=5;
}
                }
                if (cardValues[i]==3){
                    for (int x = 0; x < cardValues.length; x++) {
                        if (cardValues[x]==2){
                            if(temp<4){
                                temp=4;
                            }
                        }
                        else{
                            if(temp<3){
                                temp=3;
                            }
                        }
                    }
                }
                if (cardValues[i]==2){
                    int pairs=0;
                    for (int x = 0; x < cardValues.length; x++) {
                        if (cardValues[x]==3){
                            if(temp<3){
                                temp=3;
                            }
                        }
                        else{
                            if (cardValues[x]==2){
pairs++;
                            }

                        }
                    }
                    if(pairs==2){
                        if(temp<2){
                            temp=2;
                        }
                    }
                    if(pairs==1){
                        if(temp<1){
                            temp=1;
                        }
                    }
                }
            }

if (temp==6){
    System.out.print("5 in a row ");
    handValues[0]++;
}
            if (temp==5){
                System.out.print("4 in a row ");
                handValues[1]++;
            }
            if (temp==4){
                System.out.print("full house ");
                handValues[2]++;
            }
            if (temp==3){
                System.out.print("3 in a row ");
                handValues[3]++;
            }
            if (temp==2){
                System.out.print("2 pairs ");
                handValues[4]++;
            }
            if (temp==1){
                System.out.print("1 pair ");
                handValues[5]++;
            }
            if (temp==0){
                System.out.print("nothing hand ");
                handValues[6]++;
            }


            System.out.print(Arrays.toString(cardValues));

            System.out.println(Arrays.toString(list));

        }

        System.out.println((handValues[0])+" five of a kind");
        System.out.println((handValues[1])+" four of a kind");
        System.out.println((handValues[2])+" full house");
        System.out.println((handValues[3])+" three of a kind");
        System.out.println((handValues[4])+" two pairs");
        System.out.println((handValues[5])+" one pair");
        System.out.println((handValues[6])+" high hand");

    }


}

