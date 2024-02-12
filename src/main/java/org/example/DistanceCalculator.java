package org.example;

import java.util.Scanner;

public class DistanceCalculator {

    private static final double EARTH_RADIUS = 6371.01; // Радиус Земли в километрах

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Запрашиваем у пользователя координаты первой точки
        System.out.println("Введите широту первой точки в градусах:");
        double latitude1 = Math.toRadians(scanner.nextDouble()); // Преобразование в радианы

        System.out.println("Введите долготу первой точки в градусах:");
        double longitude1 = Math.toRadians(scanner.nextDouble()); // Преобразование в радианы

        // Запрашиваем у пользователя координаты второй точки
        System.out.println("Введите широту второй точки в градусах:");
        double latitude2 = Math.toRadians(scanner.nextDouble()); // Преобразование в радианы

        System.out.println("Введите долготу второй точки в градусах:");
        double longitude2 = Math.toRadians(scanner.nextDouble()); // Преобразование в радианы

        double distance = calculateDistance(latitude1, longitude1, latitude2, longitude2);

        System.out.printf("Расстояние между точками: %.2f км\n", distance);
    }

    // Формула гаверсинуса
    public static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        double latDistance = lat2 - lat1;
        double lonDistance = lon2 - lon1;
        double a = Math.pow(Math.sin(latDistance / 2), 2) +
                Math.cos(lat1) * Math.cos(lat2) *
                        Math.pow(Math.sin(lonDistance / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return EARTH_RADIUS * c;
    }
}
