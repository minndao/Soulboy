public class Test {
    public static void main(String[] args) {
        StorePair<Integer> a = new StorePair<>(6, 4);
        StorePair<Integer> b = new StorePair<Integer>(2, 2);
        StorePair<Integer> c = new StorePair<Integer>(6, 3);
        
        System.out.println(a.compareTo(b));
        System.out.println(a.compareTo(c));
        System.out.println(b.compareTo(c));
        System.out.println(a.equals(b));
        System.out.println(a.equals(c));
        System.out.println(b.equals(c));
    }
}
