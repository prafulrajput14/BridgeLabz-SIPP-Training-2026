import java.util.*;

class MovieRentalSystem {
    private Map<Integer, Map<Integer, Integer>> inventory;
    private TreeSet<int[]> rented;
    private Map<Integer, TreeSet<int[]>> moviePrices;

    public MovieRentalSystem(int n, int[][] entries) {
        inventory = new HashMap<>();
        rented = new TreeSet<>((a, b) -> {
            if (a[2] != b[2]) return Integer.compare(a[2], b[2]);
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });
        moviePrices = new HashMap<>();

        for (int[] e : entries) {
            int movie = e[0], shop = e[1], price = e[2];
            inventory.computeIfAbsent(movie, k -> new HashMap<>()).put(shop, price);
            moviePrices.computeIfAbsent(movie, k -> new TreeSet<>((a, b) -> {
                if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
                return Integer.compare(a[0], b[0]);
            })).add(new int[]{shop, price});
        }
    }

    public List<Integer> search(int movie) {
        TreeSet<int[]> set = moviePrices.get(movie);
        List<Integer> result = new ArrayList<>();
        if (set == null) return result;
        int count = 0;
        for (int[] entry : set) {
            if (count >= 5) break;
            result.add(entry[0]);
            count++;
        }
        return result;
    }

    public void rent(int movie, int shop) {
        int price = inventory.get(movie).get(shop);
        inventory.get(movie).remove(shop);
        moviePrices.get(movie).remove(new int[]{shop, price});
        rented.add(new int[]{movie, shop, price});
    }

    public void drop(int movie, int shop) {
        int price = -1;
        for (int[] r : rented) {
            if (r[0] == movie && r[1] == shop) {
                price = r[2];
                rented.remove(r);
                break;
            }
        }
        inventory.get(movie).put(shop, price);
        moviePrices.get(movie).add(new int[]{shop, price});
    }

    public List<List<Integer>> report() {
        List<List<Integer>> result = new ArrayList<>();
        int count = 0;
        for (int[] r : rented) {
            if (count >= 5) break;
            result.add(Arrays.asList(r[0], r[1]));
            count++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] entries = {{1, 1, 5}, {2, 2, 4}, {1, 3, 3}};
        MovieRentalSystem mrs = new MovieRentalSystem(3, entries);
        System.out.println(mrs.search(1));
        mrs.rent(1, 1);
        System.out.println(mrs.search(1));
        System.out.println(mrs.report());
        mrs.drop(1, 1);
        System.out.println(mrs.search(1));
    }
}
