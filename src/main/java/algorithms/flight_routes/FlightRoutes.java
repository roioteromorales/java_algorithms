package algorithms.flight_routes;

import data_structures.hashmaps.HashMap;
import data_structures.lists.SingleLinkedList;
import java.io.BufferedReader;
import java.io.FileReader;

public class FlightRoutes {
    private static HashMap<Airport> airports = new HashMap<>(); // stores airport data (Nodes)

    public static void main(String[] args) {

        // load airports into hashtable
        loadAirports();

        // load route csv
        loadRoutes();

        System.out.println();

        // test algorithm
        shortestPath("CNX","HKG");
        shortestPath("KLO", "SGN");
        shortestPath("KCH", "TPE");
        shortestPath("LGK", "KBR");
    }

    private static void shortestPath(String start, String dest) {
        SingleLinkedList<String> keys = airports.keys();
        SingleLinkedList<Airport> vertices = new SingleLinkedList<>();
        SingleLinkedList<Airport> path = new SingleLinkedList<>();

        // build list of vertices to visit
        for (int i = 0; i < keys.size(); i++) {
            airports.find(keys.get(i)).distanceToSource = Integer.MAX_VALUE;
            vertices.add(airports.find(keys.get(i)));
        }

        // set defaults
        airports.find(start).distanceToSource = 0;

        // continue until all vertices are visited
        while(vertices.size() > 0) {

            // find smallest node
            Airport currentNode = vertices.get(0);
            int currentIndex = 0;

            for (int i = 0; i < vertices.size(); i++) {
                Airport temp = vertices.get(i);

                if (temp.distanceToSource < currentNode.distanceToSource) {
                    currentNode = temp;
                    currentIndex = i;
                }
            }

            // check all edges of current node
            for (int j = 0; j < currentNode.routes.size(); j++) {
                Airport neighborNode = currentNode.routes.get(j).destination;

                int neighborDistance = currentNode.routes.get(j).distance;
                int tempDistance = currentNode.distanceToSource + neighborDistance;

                // update distance if shorter
                if (tempDistance < neighborNode.distanceToSource) {
                    neighborNode.distanceToSource = tempDistance;
                    neighborNode.previous = currentNode;
                }
            }

            // remove current node from list
            vertices.remove(currentIndex);
        }

        // create path
        Airport iterator = airports.find(dest);
        while (iterator != airports.find(start)) {
            // move backwards
            path.insert(iterator,0);
            iterator = iterator.previous;
        }
        path.insert(iterator,0); // insert start

        // print results
        for (int i = 0; i < path.size(); i++) {
            Airport p = path.get(i);
            System.out.print(p.code + " " + p.distanceToSource);
            if (i < path.size() - 1) {
                System.out.print(" -> ");
            }
        }
        System.out.println("\n");
    }

    private static void loadAirports() {
        // read csv
        try (BufferedReader fin = new BufferedReader(new FileReader("src/algorithms/flight_routes/airports.csv"))) {

            String line;

            do {
                // get current line
                line = fin.readLine();
                if (line != null) {

                    // parse
                    line = line.replaceAll("\"","");
                    String[] data = line.split(",");
                    Airport temp = new Airport(data[0],data[1],data[2],data[3],data[4],data[5]);

                    // add to hashmap
                    airports.add(temp.code,temp);
                }

            } while (line != null);

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    private static void loadRoutes() {
        // read csv
        try (BufferedReader fin = new BufferedReader(new FileReader("src/algorithms/flight_routes/routes.csv"))) {

            String line;

            do {
                // get current line
                line = fin.readLine();
                if (line != null) {

                    // parse
                    line = line.replaceAll("\"","");
                    String[] data = line.split(",");

                    // add routes to airports
                    Route temp = new Route(airports.find(data[0]),airports.find(data[1]));
                    temp.start.routes.add(temp);

                    System.out.println("Route: " + temp.start.code + " -> " + temp.destination.code + " " + temp.distance + "km");
                }

            } while (line != null);

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    private static class Route {
        Airport start;
        Airport destination;
        int distance; // kilometers

        Route(Airport start, Airport destination) {
            this.start = start;
            this.destination = destination;
            distance = calculateDistance();
        }

        // calculates distance between two lat/lng positions using the Haversine Formula
        private int calculateDistance() {
            final int earthRadius = 6371;
            double dLat = Math.toRadians(destination.lat - start.lat);
            double dLng = Math.toRadians(destination.lng - start.lng);
            double sLat = Math.toRadians(start.lat);
            double eLat = Math.toRadians(destination.lat);

            double a = Math.pow(Math.sin(dLat / 2), 2) +
                    Math.cos(sLat) * Math.cos(eLat) *
                            Math.pow(Math.sin(dLng / 2), 2);

            double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

            return (int)Math.round(c * earthRadius);
        }
    }

    private static class Airport {
        String name;
        String city;
        String country;
        String code;
        double lat;
        double lng;

        SingleLinkedList<Route> routes = new SingleLinkedList<>();

        int distanceToSource = Integer.MAX_VALUE;
        Airport previous;

        Airport(String name, String city, String country, String code, String lat, String lng) {
            this.name = name;
            this.city = city;
            this.country = country;
            this.code = code;
            this.lat = Double.parseDouble(lat);
            this.lng = Double.parseDouble(lng);
        }
    }
}


