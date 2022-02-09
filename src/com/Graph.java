import java.util.ArrayList;

public class Graph {
    ArrayList<Vertex> vertices;


    public Graph(){
        vertices = new ArrayList<Vertex>();
    }
    public void addVertex(Vertex v){
        vertices.add(v);
    }
    public void addEdge(Vertex from,Vertex to, Integer weight){
        if(!(vertices.contains(from) && vertices.contains(to)) ) {
            System.out.println("Vertex not found");
            return;
        }
        Edge edgeFrTo = new Edge(from, to, weight);
        Edge edgeToFr = new Edge(to, from, weight);
    }



    public  void PrintGraph(){
        Vertex v;
        for (Vertex vertex : vertices) {
            v = vertex;
            System.out.println("From Vertex: " + v.getName());
            for (int j = 0; j < v.getOutEdges().size(); j++) {
                Edge currentEdge = v.getOutEdges().get(j);
                System.out.println("To " + currentEdge.getTo().getName() + " weight: " + currentEdge.getWeight());
            }
            System.out.println(" ");
        }
    }

    public void MSTPrims(){
        MinHeap<Vertex> Q = new MinHeap<Vertex>();

        for (int vertex = 0; vertex < vertices.size(); vertex++) {
            //all vertex dist are set to Max_value (infinity)
            vertices.get(vertex).setDistance(Integer.MAX_VALUE);
            //since we don't start out with a predecessor before we iterate we set them all to null
            vertices.get(vertex).setPrevious(null);
            Q.insert(vertices.get(vertex)); //creates a queue for all vertices in the graph

        }

        if (vertices.size() > 0) {
            int root = 0;

            vertices.get(root).setDistance(0);
            int position = Q.getPosition(vertices.get(root));
            Q.decreaseKey(position);
            int MST = 0;


            while (!Q.isEmpty()) {
                //U contains the list of vertices that have been visited
                Vertex u = Q.extractMin();

                for (int vIndex = 0; vIndex < u.getOutEdges().size(); vIndex++) { //O(2E), because while a V to a V one path
                    //V-U is the list of vertices that haven't been visited
                    Edge v = u.getOutEdges().get(vIndex);

                    if (v.getWeight() < v.getTo().dist) {
                        v.getTo().setDistance(v.getWeight()); //sets the v's weight/dist as the weight of the parent which is v
                        v.getTo().setPrevious(u); //set the u nodes vertex to be v - thereby v is removed from queue
                        int pos = Q.getPosition(v.getTo());
                        Q.decreaseKey(pos);
                    }
                }

                MST += u.dist;

                if (u.prev != null) {
                    //Printing out the edges in the MST
                    System.out.println("Distance from " + u.prev.getName() + " to " + u.getName() + " is " +
                            u.getDistance() + " km.");
                }
            }

            System.out.println("Minimum Spanning Tree Totals:");
            //Printing the total distance of MST
            System.out.println("MST distance is: " + MST + " Km");
            //Printing the total price of the spanning tree
            System.out.println("MST price is: " + MST * 100000 + " DKK");

        }else{
            System.out.println("ERROR: no elements in arraylist this.vertices");
        }
    }
}

class Vertex implements Comparable<Vertex>{
    String name;
    ArrayList<Edge> OutEdges;
    Integer dist = Integer.MAX_VALUE;
    Vertex prev = null;
    public Vertex(String id){
        name=id;
        OutEdges=new ArrayList<Edge>();
    }
    public void addOutEdge(Edge e) {
        OutEdges.add(e);
    }

    @Override
    public int compareTo(Vertex o) {
        if (this.dist<o.dist)
            return -1;
        if (this.dist>o.dist)
            return 1;
        return 0;
    }

    // Getter and setter Methods
    public String getName() {
        return name;
    }

    public ArrayList<Edge> getOutEdges() {
        return OutEdges;
    }

    public Integer getDistance() {
        return dist;
    }

    public void setDistance(Integer dist) {
        this.dist = dist;
    }

    public void setPrevious(Vertex prev) {
        this.prev = prev;
    }
}

class Edge{
    Integer weight;
    Vertex from;
    Vertex to;
    public Edge(Vertex from, Vertex to, Integer cost){
        this.from=from;
        this.to=to;
        this.weight=cost;
        this.from.addOutEdge(this);
    }

    public Vertex getTo() {
        return to;
    }

    public Integer getWeight() {
        return weight;
    }
}
