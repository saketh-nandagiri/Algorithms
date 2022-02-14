package com.stanford.week4;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    private int value;

    public Vertex() {

    }

    public List<Edge> getEdges() {
        return edges;
    }

    private ArrayList<Edge> edges = new ArrayList<>();

    public Vertex(int value) {
        this.value = value;
    }

    public void addEdge(Edge edge) {
        edges.add(edge);
    }

    public int getValue() {
        return value;
    }

    public void removeEdge(Edge edge) {
        edges.remove(edge);
    }
}
