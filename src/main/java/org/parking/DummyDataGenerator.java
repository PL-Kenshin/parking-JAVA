package org.parking;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DummyDataGenerator {
    Random rand;

    public DummyDataGenerator(int seed) {
        rand = new Random(seed);
    }

    public List<Zone> generateZones(int numberOfZones, String city) {
        Random rand = new Random();
        final int ZONES_PER_ROW = (int) Math.round(Math.sqrt(numberOfZones));
        List<Zone> zones = new ArrayList<>(numberOfZones);
        for (int i = 0; i < numberOfZones; i++) {
            Zone zone = new Zone(i, city, (i % ZONES_PER_ROW) + 1, (i / ZONES_PER_ROW) + 1, rand.nextDouble(), rand.nextDouble());
            zones.add(zone);
        }
        return zones;
    }

    public List<ParkingLot> generateParkingLots(List<Zone> zones) {
        List<ParkingLot> parkingLots = new ArrayList<>();

        for (Zone zone : zones) {
            int loftsInZone = rand.nextInt(5) + 1;
            for (int i = 0; i < loftsInZone; i++) {
                ParkingLot parking = new ParkingLot(
                        parkingLots.size(),
                        zone.getZoneId(),
                        ((zone.getCordX() - 1) * 10) + rand.nextInt(10),
                        ((zone.getCordY() - 1) * 10)+rand.nextInt(10),
                        rand.nextBoolean(),
                        rand.nextBoolean(),
                        rand.nextBoolean(),
                        rand.nextInt(30));

                parkingLots.add(parking);
            }
        }
        return parkingLots;
    }
}
