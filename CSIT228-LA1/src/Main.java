public class Main {
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();
        try {
            list.add(1);
            list.add(2);
            list.add(4);
            list.print("Jay", 4.13);
            list.print(4.13, "Jay");
        } catch (ArrayFullException e) {

        }
    }
}
