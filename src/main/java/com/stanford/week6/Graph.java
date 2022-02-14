package com.stanford.week6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    List<Vertex> vertexList;
    List<Edge> edgeList;
    Map<Integer, Vertex> vertexMap;

    public Graph() {
        vertexList = new ArrayList<>();
        edgeList = new ArrayList<>();
        vertexMap = new HashMap<>();
    }

    public Vertex addOrGetVertex(int value) {
        Vertex v = vertexMap.get(value);
        if (v != null)
            return v;

        v = new Vertex(value);
        vertexList.add(v);
        vertexMap.put(value, v);
        return v;
    }

    // add edge
    public void addEdge(Vertex one, Vertex two, int edgeLength) {
        // check if an edge for these vertices has already been processed
        for (Edge edge : getEdgeList()) {
            if ((edge.getStartingVertex().equals(one) && edge.getEndingVertex().equals(two))
                    || (edge.getStartingVertex().equals(two) && edge.getEndingVertex().equals(one)))
                return;
        }
        Edge edge = new Edge(one, two, edgeLength);
        edgeList.add(edge);
        one.addEdge(edge);
        two.addEdge(new Edge(two, one, edgeLength));
    }

    public List<Vertex> getVertexList() {
        return vertexList;
    }

    public List<Edge> getEdgeList() {
        return edgeList;
    }

    public void buildGraph(String filePath) throws IOException {
        BufferedReader br
                = new BufferedReader(new FileReader(filePath));
        String st;
        String[] items;
        while ((st = br.readLine()) != null) {
            items = st.split(" ");
            Vertex source = addOrGetVertex(Integer.parseInt(items[0]));
            String[] edgeDetails;
            Vertex target;
            int edgeLength;
            for (int i = 1; i < items.length; i ++) {
                 edgeDetails = items[i].split(",");
                 target = addOrGetVertex(Integer.parseInt(edgeDetails[0]));
                 edgeLength = Integer.parseInt(edgeDetails[1]);

                 this.addEdge(source, target, edgeLength);
            }
        }
    }

    public Vertex getVertex(int value) {
        return vertexMap.get(value);
    }
}
