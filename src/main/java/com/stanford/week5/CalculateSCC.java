package com.stanford.week5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class CalculateSCC {

    private static Vertex leader;
    private static int verticesProcessed;
    private static boolean isSecondPass = false;
    private static Map<Integer, Integer> leaderAndNode = new HashMap<>();

    public static void main(String[] args) throws IOException {
        String fileName = "src/com/week5/numbers.txt";
        BufferedReader br
                = new BufferedReader(new FileReader(fileName));
        String st;
        Graph graph = new Graph();
        int first;
        int second;
        String[] items;
        while ((st = br.readLine()) != null) {
            items = st.split(" ");
            first = Integer.parseInt(items[0]);
            second = Integer.parseInt(items[1]);
            buildGraph(graph, first, second);
        }

        List<Integer> sccList = getSccList(graph);

        System.out.println(sccList);

    }

    private static List<Integer> getSccList(Graph graph) {

        List<Vertex> vertices = graph.getVertexList();

        // first pass. After this, the finishing times on the vertices should be populated
        for (int index = vertices.size() - 1; index >= 0; index--) {
            Vertex sourceVertex = vertices.get(index);
            if (!sourceVertex.isExplored()) {
                DFS(graph, sourceVertex);
            }
        }

        // second pass. sort the vertices based on finishing times and reset exploration value
        vertices.sort((Vertex one, Vertex two) -> Integer.compare(one.getFinishingTime(), two.getFinishingTime()));
        vertices.forEach(vertex -> vertex.setExplored(false));
        isSecondPass = true;
        for (int index = vertices.size() - 1; index >= 0; index--) {
            Vertex sourceVertex = vertices.get(index);
            if (!sourceVertex.isExplored()) {
                leader = sourceVertex;
                DFS(graph, sourceVertex);
            }
        }

        List<Integer> sccList = leaderAndNode.values().stream().sorted(Comparator.reverseOrder())
                .limit(5)
                .collect(Collectors.toList());

        return sccList;

    }

    private static void DFS(Graph graph, Vertex vertex) {
        vertex.setExplored(true);
        List<Edge> edgeList = null;

        if (!isSecondPass) {
            edgeList = vertex.getRevEdges();
        } else {
            edgeList = vertex.getEdges();
            vertex.setLeader(leader);
            leaderAndNode.put(leader.getValue(), leaderAndNode.get(leader.getValue()) == null ?
                    1 : leaderAndNode.get(leader.getValue()) + 1);
        }

        for (Edge edge : edgeList) {
            if (!edge.getEndingVertex().isExplored())
                DFS(graph, edge.getEndingVertex());
        }

        if (!isSecondPass) {
            verticesProcessed++;
            vertex.setFinishingTime(verticesProcessed);
        }
    }

    private static void buildGraph(Graph graph, int first, int second) {
        Vertex vertex1 = graph.addOrGetVertex(first);
        Vertex vertex2 = graph.addOrGetVertex(second);

        graph.addEdge(vertex1, vertex2);
    }
}
