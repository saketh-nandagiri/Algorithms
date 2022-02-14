package com.week4;


import java.util.LinkedList;
import java.util.List;

public class Graph {

    private List<Vertex> vertexList;
    private List<Edge> edgeList;

    public List<Vertex> getVertexList() {
        return vertexList;
    }

    public List<Edge> getEdgeList() {
        return edgeList;
    }

    public Graph() {
        vertexList = new LinkedList<>();
        edgeList = new LinkedList<>();
    }

    // add vertex
    public Vertex addVertex(int value) {

        for (Vertex v : vertexList) {
            if (v.getValue() == value)
                return v;
        }

        Vertex v = new Vertex(value);
        vertexList.add(v);
        return v;
    }

    // add edge
    public void addEdge(Vertex one, Vertex two) {

        // check if an edge for these vertices has already been processed
        for (Edge edge : getEdgeList()) {
            if ((edge.getStartingVertex().equals(one) && edge.getEndingVertex().equals(two))
            || (edge.getStartingVertex().equals(two) && edge.getEndingVertex().equals(one)))
                return;
        }

        Edge edge = new Edge(one, two);
        edgeList.add(edge);
        one.addEdge(edge);
        two.addEdge(edge);
    }


}
