package javaExamples;

public class CallByValueExample {
    int data = 50;

    public static void main(String args[]) {
        CallByValueExample op = new CallByValueExample();

        System.out.println("before change " + op.data);
        op.change(500);
        System.out.println("after change " + op.data);
        System.out.println("before change " + op.data);
        op.increment(op);
        System.out.println("after change " + op.data);


    }

    void change(int data) {
        data = data + 100;//changes will be in the local variable only
    }

    void increment(CallByValueExample op) {
        op.data = op.data + 100;

    }
}
