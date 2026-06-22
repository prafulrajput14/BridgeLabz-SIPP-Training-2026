class MyHashSet {
    private boolean[] set;

    public MyHashSet() {
        set = new boolean[1000001];
    }

    public void add(int key) {
        set[key] = true;
    }

    public void remove(int key) {
        set[key] = false;
    }

    public boolean contains(int key) {
        return set[key];
    }

    public static void main(String[] args) {
        MyHashSet hs = new MyHashSet();
        hs.add(1);
        hs.add(2);
        System.out.println(hs.contains(1));
        System.out.println(hs.contains(3));
        hs.add(2);
        System.out.println(hs.contains(2));
        hs.remove(2);
        System.out.println(hs.contains(2));
    }
}
