import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Battle_Ships {
    static int ctr_user=5,ctr_comp=5;
    public static void main(String[] args) {

        System.out.println("\n\u0488\u0488\u0488 Welcome to a game of Battle Ships \u0488\u0488\u0488");

        String[][] map=new String[10][10];
        init(map);
        print(map);


        System.out.println("Lets start playing!! \nDeploy 5 ships: Location of your ships will be marked as: \u0394");
        UserEntry(map);
        print(map);

        System.out.println("\nNow, it's computer's turn to deploy ships :--");
        CompDeploy(map);
        print1(map);

        loop:
        while(true)
        {
            System.out.println("\nNow, it's your turn to attack!!");
            UserAttack(map);
            print(map);

            System.out.println("\nNow, it's computer's turn to attack!!");
            CompAttack(map);
            print(map);
            System.out.println("Your ships : "+ctr_user+" || Computer's ships : "+ctr_comp);
            if (ctr_comp==0)
            {
                System.out.println("You WIN!!!!!");
                break loop;
            }
            else if (ctr_user==0)
            {
                System.out.println("GAME OVER !!! You LOST !!!");
                break loop;
            }
        }


    }

    public static void UserAttack(String[][] map)
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter X coordinate : ");
        int x=sc.nextInt();
        System.out.print("Enter Y coordinate : ");
        int y=sc.nextInt();
        if (x>9||y>9||x<0||y<0)
        {
            System.out.println("Please enter a valid value");
            UserAttack(map);
        }
        if (map[y][x].equals("C"))
        {
            System.out.println("Boom! You sunk the ship!");
            map[y][x]="\u00a4";
            ctr_comp--;
        }
        else if (map[y][x].equals("\u0394"))
        {
            System.out.println("Oh no, you sunk your own ship :(");
            map[y][x]="\u0222";
            ctr_user--;
        }
        else
        {
            System.out.println("Sorry, you missed");
            map[y][x]="-";
        }

    }

    public static void CompAttack(String[][] map)
    {
        Random r= new Random();
        int y=r.nextInt(10);
        int x=r.nextInt(10);
        if (map[y][x].equals("C"))
        {
            System.out.println("The Computer sunk one of its own ships");
            map[y][x]="\u00a4";
            ctr_comp--;
        }
        else if (map[y][x].equals("\u0394"))
        {
            System.out.println("The Computer sunk one of your ships!");
            map[y][x]="\u0222";
            ctr_user--;
        }
        else
        {
            System.out.println("Computer missed");
            map[y][x]="-";
        }
    }

    public static void CompDeploy(String[][] map)
    {
        Random r= new Random();
        for (int i=1;i<=5;i++)
        {
            int y=r.nextInt(10);
            int x=r.nextInt(10);
            if (map[y][x].equals(" "))
            {
                map[y][x]="C";
                System.out.println("Deploying ship "+i);
            }
            else
                i--;
        }


    }

    //To initialize " " values initially
    public static void init(String[][] map)
    {
        System.out.println("Right now the sea is empty!!\n");
        for (int i=0;i<map.length;i++)
        {
            for (int j=0;j<map[i].length;j++)
            {
                map[i][j]=" ";
            }
        }
    }

    //Takes input of ship's location from user
    public static void UserEntry(String[][] map)
    {
        int x,y;
        Scanner sc=new Scanner(System.in);
        for (int i=1; i<=5;i++)
        {
            System.out.print("Enter X coordinate of ship "+i+" : ");
            x=sc.nextInt();
            System.out.print("Enter Y coordinate of ship "+i+" : ");
            y=sc.nextInt();
            if (x>9||y>9||x<0||y<0)
            {
                System.out.println("Please enter a valid value");
                i--;
            }
            else
            {
                if (map[y][x].equals("\u0394"))
                {
                    System.out.println("Ship already deployed at this spot, please enter again!!");
                    i--;
                }
                else
                    map[y][x]="\u0394";
            }

        }
    }

    //To print map
    public static void print(String[][] map)
    {
        System.out.println("Sea looks like :-- ");
        System.out.println("  0123456789");
        for (int i=0;i<map.length;i++)
        {
            System.out.print(""+i+"|");
            for (int j=0;j<map[i].length;j++)
            {
                if (map[i][j].equals("C"))
                {
                    System.out.print(" ");
                }
                else
                    System.out.print(map[i][j]);
            }
            System.out.print("|"+i+"\n");
        }
        System.out.println("  0123456789");
    }

    //Another method to print map
    public static void print1(String[][] map)
    {
        System.out.println("   0, 1, 2, 3, 4, 5, 6, 7, 8, 9");
        for (int i=0;i<map.length;i++)
        {
            System.out.println(i+" "+Arrays.toString(map[i])+" "+i);
        }
        System.out.println("   0, 1, 2, 3, 4, 5, 6, 7, 8, 9");
    }
}
