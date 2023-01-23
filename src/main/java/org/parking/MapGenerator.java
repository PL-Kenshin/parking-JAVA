package org.parking;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.*;

public class MapGenerator extends JPanel {
    private static final long serialVersionUID = 1L;
    private final int WIDTH = 800;
    private final int HEIGHT = 600;
    private static JFrame f = new JFrame();

    private Font font = new Font("Arial", Font.BOLD, 12);
    FontMetrics metrics;

    private static List<ParkingLot> parkings;
    private static List<ParkingLot> allParkings;
    private static List<Zone> zones;
    private static List<test> best;

    private static Integer userX;
    private static Integer userY;

    public static void closeWindow(){
        f.dispose();
    };

    public MapGenerator() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Point origin = new Point(WIDTH / 2, HEIGHT / 2);

        g2d.setStroke(new BasicStroke(4.0f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER));
        g2d.setFont(font);
        metrics = g.getFontMetrics();
        int hexS = 11; int hexR = 25;

        //drawCircle(g2d, origin, hexS*hexR, true, true, 0x4488FF, 0);
        drawHexGridLoop(g2d, origin, hexS, hexR, 1);
        drawLegend(g2d, origin, (int) ( HEIGHT*0.15), (int) (WIDTH*0.3),false,true,0xAAAAAA,0);
    }

    private void drawHexGridLoop(Graphics g, Point origin, int size, int radius, int padding) {
        double ang30 = Math.toRadians(30);
        double xOff = Math.cos(ang30) * (radius + padding);
        double yOff = Math.sin(ang30) * (radius + padding);
        int half = size / 2;

        for (int row = 0; row < size; row++) {
            int cols = size - java.lang.Math.abs(row - half);

            for (int col = 0; col < cols; col++) {
                int xLbl = row < half ? col - row : col - half;
                int yLbl = row - half;
                int x = (int) (origin.x + xOff * (col * 2 + 1 - cols));
                int y = (int) (origin.y + yOff * (row - half) * 3);

                drawHex(g, xLbl, yLbl, x, y, radius);
            }
        }
    }

    private void drawHex(Graphics g, int posX, int posY, int x, int y, int r) {
        Graphics2D g2d = (Graphics2D) g;

        Hexagon hex = new Hexagon(x, y, r);


        if(posX == userX && posY == userY){
            hex.draw(g2d, x, y, 0, 0xFF0000, true);
            //hex.draw(g2d, x, y, 4, 0xFFDD88, false);
        }
        else{
            hex.draw(g2d, x, y, 0, 0xBBBBBB, true);
            //hex.draw(g2d, x, y, 4, 0xFFDD88, false);
        }

        g.setColor(new Color(0x505050));
        for(int i =0; i<allParkings.toArray().length;i++){
            if(zones.get(allParkings.get(i).getZoneId()).getCordX() == posX && zones.get(allParkings.get(i).getZoneId()).getCordY() == posY){
                g.fillOval(x+allParkings.get(i).getCordX(),y+allParkings.get(i).getCordY(),5,5);
            }
        }


        g.setColor(new Color(0x00FF00));
        for(int i = 0; i<parkings.toArray().length;i++){
            if(zones.get(parkings.get(i).getZoneId()).getCordX() == posX && zones.get(parkings.get(i).getZoneId()).getCordY() == posY){
                for(int j = 0; j < best.size(); j++){
                    if(best.get(j).getId() == parkings.get(i).getParkingLotId()){
                        g.setColor(new Color(0x00FFFF));
                    }
                }
                g.fillOval(x+parkings.get(i).getCordX(),y+parkings.get(i).getCordY(),5,5);
            }
        }

        Integer currZone = null;
        for(int i = 0; i <zones.toArray().length; i++){
            if(zones.get(i).getCordX() == posX && zones.get(i).getCordY() == posY){
                currZone = zones.get(i).getZoneId();
            }
        }

        Font fontSm = new Font("Arial", Font.BOLD, 10);
        g.setFont(fontSm);
        g.setColor(new Color(0xFFFFFF));
        String text = String.format("%s: %s", coord(posX),coord(posY));
        int w = metrics.stringWidth(text);
        int h = metrics.getHeight();
        g.drawString(text, x-w/2, y+h+6);

        g.setFont(font);
        g.setColor(new Color(0x000000));
        String text2 = String.format("%s", currZone);
        w = metrics.stringWidth(text2);
        g.drawString(text2, x-w/2, y+h-24);
    }

    private String coord(int value) {
        return (value > 0 ? "+" : "") + Integer.toString(value);
    }

    public void drawCircle(Graphics2D g, Point origin, int radius,
                           boolean centered, boolean filled, int colorValue, int lineThickness) {
        // Store before changing.
        Stroke tmpS = g.getStroke();
        Color tmpC = g.getColor();

        g.setColor(new Color(colorValue));
        g.setStroke(new BasicStroke(lineThickness, BasicStroke.CAP_ROUND,
                BasicStroke.JOIN_ROUND));

        int diameter = radius * 2;
        int x2 = centered ? origin.x - radius : origin.x;
        int y2 = centered ? origin.y - radius : origin.y;

        if (filled)
            g.fillOval(x2, y2, diameter, diameter);
        else
            g.drawOval(x2, y2, diameter, diameter);

        // Set values to previous when done.
        g.setColor(tmpC);
        g.setStroke(tmpS);
    }

    public static void main(List<ParkingLot> pk,List<ParkingLot>apk,List<test> items, List<Zone> zn, Integer x, Integer y) {
        parkings = pk;
        allParkings = apk;
        zones = zn;
        userX = x;
        userY = y;
        best = items.stream().sorted(Comparator.comparingLong(test::getScore).reversed()).limit(3).collect(Collectors.toList());;

        MapGenerator p = new MapGenerator();

        f.setContentPane(p);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public void drawLegend(Graphics2D g, Point origin, int height, int width,
                           boolean centered, boolean filled, int colorValue, int lineThickness) {
        // Store before changing.
        Stroke tmpS = g.getStroke();
        Color tmpC = g.getColor();

        g.setColor(new Color(colorValue));
        g.setStroke(new BasicStroke(lineThickness, BasicStroke.CAP_ROUND,
                BasicStroke.JOIN_ROUND));

        int x2 = centered ? origin.x : WIDTH-width;
        int y2 = centered ? origin.y : origin.y - HEIGHT/2;

        if (filled)
            g.fillRect(x2,y2,width,height);
        else
            g.drawRect(x2,y2,width,height);

        g.setColor(new Color(0xFF0000));
        g.fillRect(x2+10,y2+14,10,10);
        g.setColor(new Color(0x00FFFF));
        g.fillRect(x2+10,y2+26,10,10);
        g.setColor(new Color(0x00FF00));
        g.fillRect(x2+10,y2+38,10,10);
        g.setColor(new Color(0x505050));
        g.fillRect(x2+10,y2+50,10,10);

        g.setColor(new Color(0xFFFFFF));
        g.drawString("Legenda",x2+10,y2+12);

        g.drawString("- Twoja pozycja",x2+22,y2+24);
        g.drawString("- Lokalizacje TOP3 parkingów",x2+22,y2+36);
        g.drawString("- Lokalizacje zalecanych parkingów",x2+22,y2+48);
        g.drawString("- Lokalizacje parkingów",x2+22,y2+60);
        g.drawString("niespełniających kryteriow", x2+28,y2+72);

        // Set values to previous when done.
        g.setColor(tmpC);
        g.setStroke(tmpS);
    }
}