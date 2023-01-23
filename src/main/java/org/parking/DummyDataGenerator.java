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
        final int ZONES_PER_ROW = (int) Math.round(Math.sqrt(numberOfZones));
        List<Zone> zones = new ArrayList<>(numberOfZones);

        int id = 0;
        int size = 11;
        int half = size / 2;

        for (int row = 0; row < size; row++) {
            int cols = size - java.lang.Math.abs(row - half);

            for (int col = 0; col < cols; col++) {
                int posX = row < half ? col - row : col - half;
                int posY = row - half;
                Zone zone = new Zone(id, city, posX, posY, rand.nextDouble(), rand.nextDouble());
                zones.add(zone);
                id++;
            }
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
                        /*((zone.getCordX() - 1) * 10) + */rand.nextInt(15+15)-15,
                        /*((zone.getCordY() - 1) * 10)+*/rand.nextInt(10+10)-10,
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
