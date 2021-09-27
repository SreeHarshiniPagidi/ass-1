//PAIR PROGRAMING//
//stimulater1 holds the program files//
//imported java.util library//
//the program creates classes like Main,sim and created stimulater.iml//
//THIS PROGRAM IS DONE BY HARSHINI//
//finished on 26th sep 2021 and submitted on  26th sep 2021//
// The program stimulates the grid of our choice greater than 2*2 and calculates the time required for the two persons to meet each other lost in the grid
// credits: javapoint.com --> used to know more info regarding HashMap()



import java.util.*;
class Sim {

    public Sim() {}

    //method to simulate walk
    int simulate(int A, int B) {

        HashMap<String,String> ways=new HashMap<>();
        ways.put("-10","North");
        ways.put("01","East");
        ways.put("0-1","West");
        ways.put("10","South");
        ways.put("-11","NorthEast");
        ways.put("-1-1","NorthWest");
        ways.put("11","SouthEast");
        ways.put("1-1","SOuthWest");

        Random rand=new Random();

        //setting positions of pat and chris
        int px=0,py=0;
        int cx=A-1,cy=B-1;
        int timestep=0;
        Integer px_new,py_new,cx_new,cy_new;

        //loop for 1 million steps
        while(timestep<1000000) {
            ++timestep;

            //move pat and chris towards any of the valid 8 directions
            while (true) {
                px_new = rand.nextInt(3) - 1;
                py_new = rand.nextInt(3) - 1;
                if (px_new!=0 || py_new!=0) break;
            }
            while (true){
                cx_new=rand.nextInt(3)-1;
                cy_new=rand.nextInt(3)-1;
                if (cx_new!=0 || cy_new!=0) break;

            }


            //printing directions
            System.out.println("Pat chose : "+ways.get(px_new.toString().concat(py_new.toString())));
            System.out.println("chris chose : "+ways.get(cx_new.toString().concat(cy_new.toString())));


            //if any movement takes any of them out of the boundary, bring them back
            if((px+px_new>=0 && px+px_new<B) && (py+py_new>=0 && py+py_new<A)) {
                px+=px_new;
                py+=py_new;
            }
            if((cx+cx_new>=0 && cx+cx_new<B) && (cy+cy_new>=0 && cy+cy_new<A)) {

            }
            else if(py<0) py=0;

            if(cx>=A) cx=A-1;
            else if(cx<0) cx=0;
            if(cy>=B) cy=B-1;
            else if(cy<0) cy=0;

            //printing pat and chris positions
            System.out.println("pat is at ("+px+","+py+")");
            System.out.println("chris is at ("+cx+","+cy+")");
            System.out.println();
            Scanner in=new Scanner(System.in);
            in.nextLine();


            //if they are in the same position, return time taken
            if(px==cx && py==cy) return timestep;
        }

        //if positionnot reached on 1 million
        return timestep;
    }
}
public class Main
{
    public static void main(String[] args) {

        Scanner in=new Scanner(System.in);
        int A,B;

        //take input A B
        while(true) {
            System.out.println("Pat will start in the upper left corner of the grid, and Chris will\n" +
                    "start in the lower right corner of the grid. The grid is surrounded on all four sides by the impossible barrier.\n"+"enter the dimentions of the grid");
            System.out.println("Enter A such that 2<=A<=50: ");
            A=in.nextInt();
            System.out.println("Enter B such that 2<=B<=50: ");
            B=in.nextInt();

            if((A>=2 && A<=50) && (B>=2 && B<=50)) break;
            else System.out.println("Invalid length");
        }

        //creating simulation object and starting simulation
        Sim ob1=new Sim();
        int res=ob1.simulate(A,B);
        if(res<=1000000) System.out.println("Time required to meet: "+res);
        else System.out.println("1000000 exceeded");
    }
}