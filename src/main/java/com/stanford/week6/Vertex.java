package com.stanford.week6;

import java.util.ArrayList;
import java.util.List;

public class Vertex implements Comparable<Vertex> {
    private int value;
    private List<Edge> edges;
    private int calculatedDistance;

    public Vertex(int value) {
        this.value = value;
        edges = new ArrayList<>();
        calculatedDistance = value;
    }

    public void addEdge(Edge edge) {
        edges.add(edge);
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public int getValue() {
        return value;
    }

    public int getCalculatedDistance() {
        return calculatedDistance;
    }

    public void setCalculatedDistance(int calculatedDistance) {
        this.calculatedDistance = calculatedDistance;
    }

    @Override
    public int compareTo(Vertex o) {
        if (this.getCalculatedDistance() > o.getCalculatedDistance())
            return 1;
        return -1;
    }
}
