package com.stanford.week5;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    private int value;
    private boolean explored;
    private Vertex leader = null;
    private int finishingTime= -1;
    private List<Edge> edges;
    private List<Edge> revEdges;
    private List<Edge> inUse = null;


    public Vertex(int value) {
        this.value = value;
        explored = false;
        edges = new ArrayList<>();
        revEdges = new ArrayList<>();
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

    public boolean isExplored() { return explored; }

    public void setExplored(boolean explored) {
        this.explored = explored;
    }

    public int getFinishingTime() {
        return finishingTime;
    }

    public void setFinishingTime(int finishingTime) {
        this.finishingTime = finishingTime;
    }

    public Vertex getLeader() {
        return leader;
    }

    public void setLeader(Vertex leader) {
        this.leader = leader;
    }

    public void addReverseEdge(Edge edge) {
        revEdges.add(edge);
    }

    public List<Edge> getRevEdges() {
        return revEdges;
    }
}
