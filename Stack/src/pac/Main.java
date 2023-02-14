
package pac;

import java.util.Scanner;

public class Main {


    private static <E> void print(AL<E> my)

    {
        //String s = "<";

//        if (my.size == 0) {
//            s += ">";
//            System.out.println(s);
//        }


        System.out.print("< ");

        E j;
        //AL<E> temp = my;
        int tempSize=my.length();
        E[]temp = (E[]) new Object[tempSize];
        for (int i = 0; i < tempSize; i++) {
            j=my.pop();
            temp[i]=j;



        }

        for (int i = tempSize-1; i >=0; i--) {
            System.out.print(temp[i]);
            System.out.print(" ");


        }

        for (int i = tempSize-1; i >=0; i--) {
            my.push(temp[i]);



        }


        System.out.print(">");
        System.out.println();


    }


    private static <E> void print(LL<E> my)

    {
        System.out.print("< ");

        E j;
        //AL<E> temp = my;
        int tempSize=my.length();
        E[]temp = (E[]) new Object[tempSize];
        for (int i = 0; i < tempSize; i++) {
            j=my.pop();
            temp[i]=j;



        }

        for (int i = tempSize-1; i >=0; i--) {
            System.out.print(temp[i]);
            System.out.print(" ");


        }

        for (int i = tempSize-1; i >=0; i--) {
            my.push(temp[i]);



        }


        System.out.print(">");
        System.out.println();




    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int k;
        k = scanner.nextInt();
        //dir= scanner.nextInt();
        int prnt;
        Integer[]arr=new Integer[k];


        AL<Integer> list = new AL<Integer>(arr,1);
        //LL<Integer> list = new LL<>();
        for (int i = 0;i<k;i++){
            int v = scanner.nextInt();
            list.push(v);
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


                    //System.out.println(prnt);

                    break;
                }
                case 2:
                {   list.push(p);

                    print(list);
                    //System.out.println(list);


                    break;
                }
                case 3:
                {   prnt=list.pop();

                    print(list);
                    //System.out.println(list);

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
                {  prnt=list.topValue();

                    print(list);


                    System.out.println(prnt);
                    break;
                }
                case 6:
                {   list.setDirection(p);


                    print(list);


                    //System.out.println(prnt);
                    break;
                }


                case 7:

                {   int offset=scanner.nextInt();

                    list.insert(p,offset);


                    print(list);


                    //System.out.println(prnt);
                    break;
                }

                case 8:

                {   int offset=scanner.nextInt();

                    prnt=list.remove(offset);


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
