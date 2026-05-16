public class Main {
    public static void main(String[] args) {
        MyGeneric<String> strObj = new MyGeneric<>("Ethan");
        MyGeneric<Integer> intObj = new MyGeneric<>(67);

        strObj.setType("Hector");
        intObj.setType(1);

        System.out.println(strObj.getType());
        System.out.println(intObj.getType());
    }
}