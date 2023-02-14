package OFF;

import java.util.Scanner;

public class Main {

    private static <E> void print(ALQ my)

    {



        System.out.print("< ");

        E j;
        //AL<E> temp = my;
        int tempSize=my.length();
        E[]temp = (E[]) new Object[tempSize];
        for (int i = 0; i < tempSize; i++) {
            j= (E) my.dequeue();
            temp[i]=j;



        }

        for (int i = 0; i < tempSize; i++) {
            System.out.print(temp[i]);
            System.out.print(" ");


        }

        for (int i = 0; i < tempSize; i++) {
            my.enqueue(temp[i]);



        }


        System.out.print(">");
        System.out.println();


    }


//    private static <E> void print(LLQ<E> my)
//
//    {
//        System.out.print("< ");
//
//        E j;
//
//        int tempSize=my.length();
//        E[]temp = (E[]) new Object[tempSize+1];
//        for (int i = 0; i < tempSize; i++) {
//            j=my.dequeue();
//            temp[i]=j;
//
//
//
//        }
//
//        for (int i =0; i <tempSize; i++) {
//            System.out.print(temp[i]);
//            System.out.print(" ");
//
//
//        }
//
//        for (int i =0; i <tempSize; i++) {
//            my.enqueue(temp[i]);
//
//
//
//        }
//
//
//        System.out.print(">");
//        System.out.println();
//
//
//
//
//    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int k,x;
        k = scanner.nextInt();
        x = scanner.nextInt();

        int prnt;



        ALQ<Integer> list = new ALQ<Integer>(x);
        //LLQ<Integer> list = new LLQ<>();
        for (int i = 0;i<k;i++){
            int v = scanner.nextInt();
            list.enqueue(v);
        }

        print(list);


        int q,p;
        q = scanner.nextInt();
        p = scanner.nextInt();
        while(q!=0){
            switch (q){
                case 1:
                {    list.clear();

                    print(list);




                    break;
                }
                case 2:
                {   list.enqueue(p);

                    print(list);



                    break;
                }
                case 3:
                {   prnt=list.dequeue();

                    print(list);


                    System.out.println(prnt);
                    break;
                }
                case 4:
                {   prnt=list.length();

                    print(list);


                    System.out.println(prnt);
                    break;
                }
                case 5:
                {  prnt=list.frontValue();

                    print(list);


                    System.out.println(prnt);
                    break;
                }
                case 6:
                {   prnt=list.rearValue();




                    System.out.println(prnt);
                    print(list);

                    break;
                }


                case 7:

                {

                    prnt= list.leaveQueue();


                    print(list);


                    System.out.println(prnt);
                    break;
                }



            }
            q = scanner.nextInt();
            p = scanner.nextInt();
        }




    }





}
