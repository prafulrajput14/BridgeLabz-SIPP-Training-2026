import java.util.*;

class UndergroundSystem {
    private Map<Integer, CheckIn> checkIns;
    private Map<String, TravelTime> travelTimes;

    private static class CheckIn {
        String station;
        int time;
        CheckIn(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    private static class TravelTime {
        long total;
        int count;
        void addTime(int diff) {
            total += diff;
            count++;
        }
        double getAverage() {
            return (double) total / count;
        }
    }

    public UndergroundSystem() {
        checkIns = new HashMap<>();
        travelTimes = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new CheckIn(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckIn ci = checkIns.remove(id);
        String route = ci.station + "-" + stationName;
        travelTimes.putIfAbsent(route, new TravelTime());
        travelTimes.get(route).addTime(t - ci.time);
    }

    public double getAverageTime(String startStation, String endStation) {
        return travelTimes.get(startStation + "-" + endStation).getAverage();
    }

    public static void main(String[] args) {
        UndergroundSystem us = new UndergroundSystem();
        us.checkIn(45, "Leyton", 3);
        us.checkIn(32, "Paradise", 8);
        us.checkOut(45, "Waterloo", 15);
        us.checkOut(32, "Cambridge", 22);
        System.out.println(us.getAverageTime("Leyton", "Waterloo"));
        System.out.println(us.getAverageTime("Paradise", "Cambridge"));
        us.checkIn(27, "Leyton", 10);
        us.checkOut(27, "Waterloo", 20);
        System.out.println(us.getAverageTime("Leyton", "Waterloo"));
    }
}
