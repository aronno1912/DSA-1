package pac;

public class AL<E> implements StackADT<E> {
    private static final int DEFAULTSIZE = 15;
    int maxsize;
    int size;

    E[] listArray;

    int top;
    private int direction;
    private int first;



    public  AL(int size)

    {  maxsize = size;
        this.size=0;
        direction=1;
        first=0;
        listArray = (E[]) new Object[maxsize];
    }
    public AL()
    {
        this(DEFAULTSIZE);
    }

    public  AL(E[]listArray,int direction)

    {
//        //DEFAULTSIZE=defSize;
//        maxsize=my.maxsize;
//        top=maxsize;
//        listArray=(E[])new Object[maxsize];

        this.listArray=listArray;
        this.direction=direction;
        this.maxsize=listArray.length;
        this.size=0;
        if(direction==1)
        {
            first=0;
            top=0;
        }
        else
        {
            first=maxsize-1;
            top=maxsize-1;
        }
    }


    @Override
    public int clear() {
        top=0;
        size=0;
        return -1;
    }

//    public void increaseArraySize()
//    {
//        E[]temp=listArray;
//        sizeFactor=2*sizeFactor;
//        listArray=(E[])new Object[maxsize*sizeFactor];
//        for (int i = 0; i < size; i++) {
//            listArray[i] = temp[i];
//        }
//    }


    @Override
    public void push(E item) {
//        //assert top != maxsize : "Stack is full and can't push a new element into it";
//        if(top==maxsize && listArray[top-1]!=null)
//        {  increaseArraySize();
//        listArray[top++] = item;}
//        if(top==maxsize && listArray[top-1]==null)
//
//        {
//            listArray[maxsize--] = item;
//        }
//        else
//            push(item,direction);
//
//        return -1;

        if(maxsize<=size)
        {
            maxsize=maxsize*2;
            E[] array2=listArray;
            listArray=(E[])new Object[maxsize];
            int  l=maxsize-size-1;

            if(direction==-1)
            {
                top=maxsize-1;
                for(int i=maxsize-1;i>l;i--)
                {
                    listArray[i]=array2[first];
                    first--;
                    top--;
                }
                first=maxsize-1;
                listArray[top]=item;
                top--;
            }
            else
            {
                top=0;
                for(int i=0;i<size;i++)
                {
                    listArray[i]=array2[first];
                    first++;
                    top++;
                }
                first=0;
                listArray[top]=item;
                top++;
            }

        }
        else
        {
            if(direction==-1)
            {
                listArray[top]=item;
                top--;

            }
            else
            {
                listArray[top]=item;
                top++;
            }

        }
        size++;



    }
//    public int push(E item,int direction) {
//
//        if(direction==-1)
//        {listArray[maxsize--] = item;}
//        if (direction==1)
//        {  if(top==maxsize)
//          increaseArraySize();
//            {listArray[top++] = item;}
//        }
//
//        return -1;
//    }

    @Override
    public E pop() {
//        assert top != 0 : "Stack is empty and can't pop out any element";
//        return listArray[--top];

        if(size!=0) {

            if (direction == -1) {
                E item = listArray[++top];
                size--;
                return item;
            } else {
                E item = listArray[--top];
                size--;
                return item;
            }
        }
        return null;

    }

    @Override
    public int length() {
        return size;
    }



    @Override
    public E topValue() {
        if(size!=0) {
            if (direction == -1) {
                E item = listArray[++top]; //to get one step back and to return..coz it is not pop
                top--;
                return item;
            } else {
                E item = listArray[--top];
                top++;
                return item;
            }
        }
        return null;
    }

    @Override
    public void setDirection(int direction) {
//        if(top!=0){ System.out.println("is not applicable for a non empty stack ");
//        return -1;}
//        else
//        {
//            if(direction==-1)
//            {
//                top=maxsize;
//
//            }
//            return 1;
//        }

        if(size==0) {
            this.direction =direction;
            if(this.direction==-1)
            {
                first=maxsize-1;
                top=maxsize-1;
            }
            else
            {
                first=0;
                top=0;
            }
        }
        else
            System.out.println("not applicable");


    }

    @Override
    public void insert(E item, int offset) {

        int temp=top;
        if(top-offset>=0)
        {

            top =top-offset;
            for(int i=top-offset+1;i<=temp;i++)
            {
                listArray[i+1]=listArray[i];
            }
            push(item);




        }
        top=temp+1;


    }

    @Override
    public E remove(int offset) {

        E item = null;

        int temp=top;
        if(top-offset>=0)
        {

            top =top-offset;
            item=pop();
            for(int i=top-offset+1;i<=temp;i++)
            {
                listArray[i]=listArray[i-1];
            }





        }
        top=temp-1;



        return item;
    }
}

