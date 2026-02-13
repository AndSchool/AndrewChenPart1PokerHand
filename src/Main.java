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


        int[] handValues = {0,0,0,0,0,0,0};
        int[] bidValues = new int[79];
        int[][] allHands = new int[79][7];
        //can make code to adapt to data size
        //compare one list to the others, for however many lists are less than the selected, that's its rank
        int counter=0;
        for (String line : lines) {
            int bar = line.indexOf("|");
            String numbers = line.substring(0, bar);
            String[] list = numbers.split(",");

            int[] cardValues = {0,0,0,0,0,0,0,0,0,0,0,0,0};
            int[] tempValue={0,0,0,0,0,0,0};


            for (int i = 0; i < list.length; i++) {


                if(list[i].contains("Ace")){
                    cardValues[0]=cardValues[0]+1;
                    tempValue[i]=14;
                }
                if(list[i].contains("King")){
                    cardValues[1]=cardValues[1]+1;
                    tempValue[i]=13;
                }
                if(list[i].contains("Queen")){
                    cardValues[2]=cardValues[2]+1;
                    tempValue[i]=12;
                }
                if(list[i].contains("Jack")){
                    cardValues[3]=cardValues[3]+1;
                    tempValue[i]=11;
                }
                if(list[i].contains("10")){
                    cardValues[4]=cardValues[4]+1;
                    tempValue[i]=10;
                }
                if(list[i].contains("9")){
                    cardValues[5]=cardValues[5]+1;
                    tempValue[i]=9;
                }
                if(list[i].contains("8")){
                    cardValues[6]=cardValues[6]+1;
                    tempValue[i]=8;
                }
                if(list[i].contains("7")){
                    cardValues[7]=cardValues[7]+1;
                    tempValue[i]=7;
                }
                if(list[i].contains("6")){
                    cardValues[8]=cardValues[8]+1;
                    tempValue[i]=6;
                }
                if(list[i].contains("5")){
                    cardValues[9]=cardValues[9]+1;
                    tempValue[i]=5;
                }
                if(list[i].contains("4")){
                    cardValues[10]=cardValues[10]+1;
                    tempValue[i]=4;
                }
                if(list[i].contains("3")){
                    cardValues[11]=cardValues[11]+1;
                    tempValue[i]=3;
                }
                if(list[i].contains("2")){
                    cardValues[12]=cardValues[12]+1;
                    tempValue[i]=2;
                }
            }
            tempValue[5]=Integer.parseInt(line.substring(bar+1));




            int temp=0;
            //0=high,1=pair,2=two pair, 3= 3kind, 4=full, 5=four, 6=five
            for (int i = 0; i < cardValues.length; i++) {
                if (cardValues[i]==5){
                    temp=6;
                    tempValue[6]=6;
                }
                if (cardValues[i]==4){
                    if(temp<5){
                        temp=5;
                        tempValue[6]=5;
                    }
                }
                if (cardValues[i]==3){
                    for (int x = 0; x < cardValues.length; x++) {
                        if (cardValues[x]==2){
                            if(temp<4){
                                temp=4;
                                tempValue[6]=4;
                            }
                        }
                        else{
                            if(temp<3){
                                temp=3;
                                tempValue[6]=3;
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
                                tempValue[6]=3;
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
                            tempValue[6]=2;
                        }
                    }
                    if(pairs==1){
                        if(temp<1){
                            temp=1;
                            tempValue[6]=1;
                        }
                    }
                }
            }




            if (temp==6){
                handValues[0]++;
            }
            if (temp==5){
                handValues[1]++;
            }
            if (temp==4){
                handValues[2]++;
            }
            if (temp==3){
                handValues[3]++;
            }
            if (temp==2){
                handValues[4]++;
            }
            if (temp==1){
                handValues[5]++;
            }
            if (temp==0){
                handValues[6]++;
            }
            System.out.println(Arrays.toString(tempValue));
            allHands[counter]=tempValue;
            counter++;
        }




        System.out.println((handValues[0])+" five of a kind");
        System.out.println((handValues[1])+" four of a kind");
        System.out.println((handValues[2])+" full house");
        System.out.println((handValues[3])+" three of a kind");
        System.out.println((handValues[4])+" two pairs");
        System.out.println((handValues[5])+" one pair");
        System.out.println((handValues[6])+" high hand");




        for (int x = 0; x < allHands.length; x++) {
            int temp2=0;
            for (int i = 0; i < allHands.length; i++) {


                if(x!=i){


                    if(allHands[x][6]>allHands[i][6]){
                        temp2++;
                    }
                    else
                    if(allHands[x][6]==allHands[i][6]){
                        if(allHands[x][0]>allHands[i][0]){
                            temp2++;
                        }
                        else if(allHands[x][0]==allHands[i][0]){
                            if(allHands[x][1]>allHands[i][1]){
                                temp2++;
                            }
                            else if(allHands[x][1]==allHands[i][1]){
                                if(allHands[x][2]>allHands[i][2]){
                                    temp2++;
                                }
                                else if(allHands[x][2]==allHands[i][2]){
                                    if(allHands[x][3]>allHands[i][3]){
                                        temp2++;
                                    }
                                    else if(allHands[x][3]==allHands[i][3]){
                                        if(allHands[x][4]>allHands[i][4]){
                                            temp2++;
                                        }


                                    }
                                }
                            }
                        }
                    }
                }
            }
            bidValues[temp2]=allHands[x][5];
        }
        int finalTotal=0;
        for (int x = 0; x < bidValues.length; x++) {
            finalTotal+=(bidValues[x]*(x+1));
        }

        System.out.println("total bid value: "+finalTotal);



        for (int x = 0; x < allHands.length; x++) {
            int jackCount=0;
            for (int i = 0; i < allHands[x].length; i++) {
                if (allHands[x][i]==11){
                    allHands[x][i]=1;
                    jackCount++;
                }
            }
            if (jackCount==1){
                if(allHands[x][6]==5){
                    allHands[x][6]=6;
                }
                else if (allHands[x][6]==3){
                    allHands[x][6]=5;
                }
                else if (allHands[x][6]==2){
                    allHands[x][6]=4;
                }
                else if (allHands[x][6]==1){
                    allHands[x][6]=3;
                }
                else if (allHands[x][6]==0){
                    allHands[x][6]=1;
                }
            }
            if (jackCount==2){
                if(allHands[x][6]==4){
                    allHands[x][6]=6;
                }
                else if (allHands[x][6]==2){
                    allHands[x][6]=5;
                }
                else if (allHands[x][6]==1){
                    allHands[x][6]=3;
                }
            }
            if (jackCount==3){
                if(allHands[x][6]==4){
                    allHands[x][6]=6;
                }
                else{
                    allHands[x][6]=5;
                }
            }
            if (jackCount==4){
                allHands[x][6]=6;
            }
        }

        for (int x = 0; x < allHands.length; x++) {
            int temp2=0;
            for (int i = 0; i < allHands.length; i++) {


                if(x!=i){


                    if(allHands[x][6]>allHands[i][6]){
                        temp2++;
                    }
                    else
                    if(allHands[x][6]==allHands[i][6]){
                        if(allHands[x][0]>allHands[i][0]){
                            temp2++;
                        }
                        else if(allHands[x][0]==allHands[i][0]){
                            if(allHands[x][1]>allHands[i][1]){
                                temp2++;
                            }
                            else if(allHands[x][1]==allHands[i][1]){
                                if(allHands[x][2]>allHands[i][2]){
                                    temp2++;
                                }
                                else if(allHands[x][2]==allHands[i][2]){
                                    if(allHands[x][3]>allHands[i][3]){
                                        temp2++;
                                    }
                                    else if(allHands[x][3]==allHands[i][3]){
                                        if(allHands[x][4]>allHands[i][4]){
                                            temp2++;
                                        }


                                    }
                                }
                            }
                        }
                    }
                }
            }
            bidValues[temp2]=allHands[x][5];
        }
        int finalJackTotal=0;
        for (int x = 0; x < bidValues.length; x++) {
            finalJackTotal+=(bidValues[x]*(x+1));
        }

        System.out.println("total wild jack bid value: "+finalJackTotal);
    }










}



