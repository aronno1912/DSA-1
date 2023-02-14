

import pac.*;

import java.util.Scanner;


class Dish{
    private int person;
    private int time;
    private int course;
    public Dish(int person,int time,int course)
    {
        this.course=course;
        this.person=person;
        this.time=time;
    }

    public Dish() {

    }

    public void setPerson(int person) {
        this.person = person;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public int getPerson() {
        return person;
    }

    public int getTime() {
        return time;
    }

    public int getCourse() {
        return course;
    }
}


public class newDishWasher {



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int invitees=scanner.nextInt();
        int course=scanner.nextInt();
//        LL<Dish> dirtySt = new LL<>();
        //LL<Dish> cleanSt = new LL<>();
        AL<Dish> dirtySt = new AL<>();
        AL<Dish> cleanSt = new AL<>();

        Dish[]dish = new Dish[invitees*course+1];
        Integer[] timeArray=new Integer[course];    // which dish takes which time to wash 2 4 1
        Integer[]friends=new Integer[invitees];
        Integer[] time_counting=new Integer[invitees*course];

        /**
         * one array two stack
         *
         *
         *
         */

//        AL<Dish> dirtySt = new AL<>(dish,1);
//        AL<Dish> cleanSt = new AL<>(dish,-1);


        for(int i=1;i<=course;i++)
        {
            int t=scanner.nextInt();
            timeArray[i-1]=t;

        }
        int k,t,s;
        k = scanner.nextInt();
        t = scanner.nextInt();
        s = scanner.nextInt();
        int sz=0;
        // int freetime = -1,endtime=0;

        while(k!=0)
        {

            dish[sz]=new Dish(k,t,s);        // create new dish( friend index , when pushed, which dish)

            //dirtySt.push(dish[sz]);
            //toDoClean(dish[i]);
            sz++;
            k = scanner.nextInt();
            t = scanner.nextInt();
            s = scanner.nextInt();
        }
        //System.out.println(sz);// show the size of dish array
        int count=0;
        int  washingTime=-1; //washing time
        for(int j=0;j<sz;j++) //sz means total plates
        {
//            if(j==sz-1)
//            {
//
//
//                endtime=endtime+timeArray[dirtySt.topValue().getCourse()-1];
//
//                System.out.println(endtime);
//
//                cleanSt.push(dirtySt.pop());
//                break;
//
//
//            }
//            else {
//                if (dish[j + 1].getTime() - dish[j].getTime() > 0) {
//                    freetime = dish[j + 1].getTime() - dish[j].getTime();
//
//                } else
//                    freetime = 0;
//                endtime += dish[j].getTime() - freetime + timeArray[dirtySt.topValue().getCourse()-1];
//                System.out.println(endtime);
//                cleanSt.push(dirtySt.pop());
//
//            }


            if(dish[j].getTime()<=washingTime)
            {
                dirtySt.push(dish[j]);
            }
            else
            {

                if(dirtySt.length()==0)
                {
                    dirtySt.push(dish[j]);
                }
                else
                {
                    while(dirtySt.length()!=0)
                    {

                        if(dirtySt.topValue().getTime()>washingTime)
                        {
                            washingTime=dirtySt.topValue().getTime()-1; //we have a free time
                        }

                        if(timeArray[dirtySt.topValue().getCourse()-1]+washingTime>=dish[j].getTime())
                        {   washingTime=washingTime+timeArray[dirtySt.topValue().getCourse()-1];  //no free time

                            time_counting[count]=washingTime; //output time array
                            count++;
                            cleanSt.push(dirtySt.pop());

                            break;
                        }

                        else
                        {

                            washingTime=washingTime+timeArray[dirtySt.topValue().getCourse()-1]; //no free time er total

                            time_counting[count]=washingTime;
                            count++;
                            // System.out.println("the top of dirtyStack is "+dirtySt.topValue());
                            cleanSt.push(dirtySt.pop());
                        }


                    }
                    dirtySt.push(dish[j]);


                }




            }




        }


//        System.out.println("total time is "+endtime);
//        int allMeal=0;
//        int personTakenAllMeal=dish[0].getPerson();
//        int gotOne=0;
//        LL<Integer> full_meal_complete=new LL<>();
//
//        for(int j=1;j<sz;j++)
//        {
//            if(dish[j].getPerson()==personTakenAllMeal)
//            {
//                allMeal++;
//            }
//            if(allMeal==course) {System.out.println(personTakenAllMeal);
//                full_meal_complete.push(personTakenAllMeal);
//                allMeal=0;
//
//                gotOne++;
//                System.out.println("all meal taken by "+personTakenAllMeal);
//            }
//            else
//            {
//                if(j!=sz-1)
//                { personTakenAllMeal=dish[j+1].getPerson();
//                    allMeal=0;}
//            }
//        }
//
//        if(full_meal_complete.length()==invitees)
//            System.out.println("Y");
//        else System.out.println("N");

        while (dirtySt.length()!=0)   //when all push are done but still there is some plates on dirtystack
        {    if(dirtySt.topValue().getTime()>washingTime)
        {
            washingTime=dirtySt.topValue().getTime()-1;
        }
            washingTime=washingTime+timeArray[dirtySt.topValue().getCourse()-1];
            time_counting[count]=washingTime;
            count++;
            cleanSt.push(dirtySt.pop());
        }

        System.out.println(washingTime);
        for(int j=0;j<count;j++)
        {
            System.out.print(time_counting[j]);
            if(j!=count-1)
            {
                System.out.print(",");
            }
        }

        System.out.println();
        int num=0;
        int[] fullMealTaken=new int[sz];
        while (cleanSt.length()!=0)
        {
            if(cleanSt.topValue().getCourse()==course) //someone cannot eat course 3 unless he eats course 2
            {
                fullMealTaken[num]=cleanSt.pop().getPerson();
                num++;

            }
            else
            {
                cleanSt.pop();
            }
        }

        if(num==invitees)
        {
            System.out.println("Y");
        }

        else
        {
            System.out.println("N");
        }

        for (int j=0;j<num;j++)
        {
            System.out.print(fullMealTaken[j]);
            if(j!=num-1)
            {
                System.out.print(",");
            }
        }
        System.out.println();


    }
}
