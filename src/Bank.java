import OFF.*;

import java.util.Scanner;


class Customer {
    private int enteringTime;
    private int serviceNeededTime;
    private int id;

    public Customer() {
    }

    public int getEnteringTime() {
        return enteringTime;
    }

    public void setEnteringTime(int enteringTime) {
        this.enteringTime = enteringTime;
    }

    public int getServiceNeededTime() {
        return serviceNeededTime;
    }

    public void setServiceNeededTime(int serviceNeededTime) {
        this.serviceNeededTime = serviceNeededTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer(int id,int enteringTime, int serviceNeededTime) {
        this.id=id;
        this.enteringTime = enteringTime;
        this.serviceNeededTime = serviceNeededTime;
    }

}

public class Bank {


    public static void main(String[] args) {
        int cus_num, et, st;
        int t1 = 0, t2 = 0;


        Scanner scanner = new Scanner(System.in);
        cus_num = scanner.nextInt();

        int timeRunning = 0;
        int customer_index = 0;
        int served_customers = 0;
        int total_customers = cus_num;

        //ALQ <Customer> Q1 = new ALQ <Customer>();
        //ALQ <Customer> Q2 = new ALQ <Customer>();
        LLQ<Customer> Q1 = new LLQ<>();
        LLQ<Customer> Q2 = new LLQ<>();
        Customer[] customers = new Customer[cus_num + 1];

        for (int i = 0; i < cus_num; i++) {
            et = scanner.nextInt();
            st = scanner.nextInt();
            customers[i] = new Customer(i,et, st);

        }


        boolean b1Active = false;                       // check if the booth is serving any customer
        boolean b2Active = false;                       // false means not serving , true means serving a customer


        while (true) {


            if (served_customers >= total_customers)
                break;

            // when running time is exactly at that time of entering of that customer,enqueue him

            if( customer_index < total_customers && timeRunning == customers[customer_index].getEnteringTime()) {
                if(Q1.length() > Q2.length())
                {
                    Q2.enqueue(customers[customer_index++]);
                }
                else{
                    Q1.enqueue(customers[customer_index++]);
                }
            }


            //if it is 5 min running and the front customer needs 7 min to finish that means he is still receiving service and booth 1
            //is active

            if(timeRunning < t1){
                b1Active = true;
            }else if(timeRunning == t1 && Q1.length()>0){
                b1Active = false;
                Q1.dequeue();
                served_customers++; //service completed!!!
            }

            if(timeRunning < t2){
                b2Active = true;
            }else if(timeRunning == t2 && Q2.length() > 0){
                b2Active = false;
                Q2.dequeue();
                served_customers++;
            }


            // If a queue switching and a new customer taking position in a queue
            //appear to happen simultaneously, prioritize the new customer
            // Prioritize dequeue over queue switching
            //that's why switching condition is written after enqueue of new customer
            // take a look to switch queue and switch if possible
            if(Q1.length()-1 > Q2.length()){
                Customer customer = Q1.leaveQueue();
                Q2.enqueue(customer);
            }
            else if(Q2.length()-1 > Q1.length()){
                Customer customer = Q2.leaveQueue();
                Q1.enqueue(customer);
            }


            // calculation of service time
            if(!b1Active && Q1.length()>0){
                b1Active = true;
                Customer customer = Q1.frontValue();
                t1 = ( t1 > timeRunning )?t1: timeRunning ;//first customer enters at runningTime 2,but that time t1 was 0,but booth was open..so it will be added
                t1 += customer.getServiceNeededTime();
            }


            if(!b2Active && Q2.length()>0){
                b2Active = true;
                Customer customer = Q2.frontValue();
                t2 = ( t2>timeRunning )? t2 : timeRunning;
                t2 += customer.getServiceNeededTime();
            }

            timeRunning++;


        }


//        Q1.enqueue(customers[0]);
//        t1=t1+customers[0].getServiceNeededTime();
//        Q2.enqueue(customers[1]);
//        t2=t2+customers[1].getServiceNeededTime();




//        for (int i = 0; i < cus_num; i++) {
//
//
//            if (customers[i].getEnteringTime() >= t1) {
//                Q1.enqueue(customers[i]);
//                t1 = t1 + customers[i].getServiceNeededTime();
//                customers[i].setQueueNum(1);
//            } else if (customers[i].getEnteringTime() >= t2) {
//                Q2.enqueue(customers[i]);
//                t2 = t2 + customers[i].getServiceNeededTime();
//                customers[i].setQueueNum(2);
//            } else {
//                while (Q1.length() != 0 && Q2.length() != 0) {
//
//                    if (Q1.length() == 0) {
//                        Q1.enqueue(customers[i]);
//                        t1 = t1 + customers[i].getServiceNeededTime();
//                        customers[i].setQueueNum(1);
//
//                    } else if (Q2.length() == 0) {
//                        Q2.enqueue(customers[i]);
//                        t2 = t2 + customers[i].getServiceNeededTime();
//                        customers[i].setQueueNum(2);
//                    }
//
//
//                    if (Q1.length() < Q2.length()) {
//                        Q1.enqueue(customers[i]);
//                        t1 = t1 + customers[i].getServiceNeededTime();
//                    } else if (Q2.length() < Q1.length()) {
//                        Q2.enqueue(customers[i]);
//                        t2 = t2 + customers[i].getServiceNeededTime();
//                    }
//
//
//                }
//
//            }
//
//        }

        System.out.println("Booth 1 finishes service at t="+ t1+"\n" + "Booth 2 finishes service at t=" + t2);


    }

}
