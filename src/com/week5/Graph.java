package com.week5;

import java.util.*;

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
    public void addEdge(Vertex one, Vertex two) {

        // check if an edge for these vertices has already been processed
        if (one.getValue() == two.getValue())
            return;

        Edge edge = new Edge(one, two);
        edgeList.add(edge);
        one.addEdge(edge);

        edge = new Edge(two, one);
        two.addReverseEdge(edge);
    }

    public List<Vertex> getVertexList() {
        return vertexList;
    }

    public List<Edge> getEdgeList() {
        return edgeList;
    }


}
