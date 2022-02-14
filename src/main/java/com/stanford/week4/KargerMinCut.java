package com.stanford.week4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class KargerMinCut {

    public static void main(String[] args) throws IOException {
        String fileName = "src/com/week4/testnumbers3.txt";
        int count = 0;
        int minCut = 200;
        while (count < 400) {
            BufferedReader br
                    = new BufferedReader(new FileReader(fileName));
            String st;
            ArrayList<Integer> convertedRankList = null;
            Graph graph = new Graph();
            while ((st = br.readLine()) != null) {
                convertedRankList = (ArrayList<Integer>) Stream.of(st.split(" "))
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
                buildGraph(graph, convertedRankList);
            }

            minCut = Math.min(runKargerMinCut(graph), minCut);
            count++;
            br.close();
        }

        System.out.println("Min cut is: " + minCut);
    }

    private static int runKargerMinCut(Graph graph) {
        while (graph.getVertexList().size() > 2) {
            Random random = new Random();
            int randEgdeIndex = random.nextInt(graph.getEdgeList().size());
            Collections.shuffle(graph.getEdgeList());
            Edge baseEdge = graph.getEdgeList().get(randEgdeIndex);

            Vertex v1 = baseEdge.getStartingVertex();
            Vertex v2 = baseEdge.getEndingVertex();

            // merge v2 edges into v1
            for (Edge edge : v2.getEdges()) {
                if ((edge.getStartingVertex().equals(v1) && edge.getEndingVertex().equals(v2)
                        || (edge.getStartingVertex().equals(v2) && edge.getEndingVertex().equals(v1)))) {
                    graph.getEdgeList().remove(edge);
                    v1.getEdges().remove(edge);
                } else if (edge.getEndingVertex().equals(v2)) {
                    edge.setEndingVertex(v1);
                    v1.addEdge(edge);
                } else if (edge.getStartingVertex().equals(v2)) {
                    v1.addEdge(edge);
                    edge.setStartingVertex(v1);
                }
            }
            graph.getVertexList().remove(v2);
        }

        return graph.getVertexList().get(0).getEdges().size();

    }

    private static void buildGraph(Graph graph, ArrayList<Integer> convertedRankList) {
        Vertex vertex1 = graph.addVertex(convertedRankList.get(0));

        for (int currentIndex = 1; currentIndex < convertedRankList.size(); currentIndex++) {
            Vertex vertex2 = graph.addVertex(convertedRankList.get(currentIndex));
            graph.addEdge(vertex1, vertex2);
        }
    }
}
