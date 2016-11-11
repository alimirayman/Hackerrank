import java.io.*;
import java.util.*;

public class BFS {
    public static int nodes;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0){
            nodes = sc.nextInt();
            node[] ns = new node[nodes];
            for(int i = 0; i < nodes; i++) ns[i] = new node();
            int edge = sc.nextInt();
            while(edge-- > 0){
                int n1 = sc.nextInt() - 1;
                int n2 = sc.nextInt() - 1;
                if(ns[n1].notHave(ns[n2])) ns[n1].addChild(ns[n2]);
                if(ns[n2].notHave(ns[n1])) ns[n2].addChild(ns[n1]);
                
            }
                
            int dist = 0;
            int src = sc.nextInt() - 1;
            Queue<node> queue = new LinkedList<>();
            ns[src].distance = 0;
            queue.add(ns[src]);
            calcD(dist, queue);

            for(int i = 0; i < nodes; i++) {
                if(i != src)
                    System.out.print(ns[i].distance + " ");
            }
            System.out.println();
        }

    }
    public static void calcD(int dist, Queue<node> q){
        if(q.isEmpty()) return;
        Queue<node> queue = new LinkedList<>();
        while(!q.isEmpty()){
            node ns = q.remove();
            queue.addAll(ns.getChildren());
            dist = ns.distance + 6;
            while(!queue.isEmpty()){
                node n = queue.remove();
                if(!n.visited()){
                    if(n.distance > dist || n.distance == -1) n.distance = dist;
                    q.add(n);
                }
                
            }
            ns.visit();
        }
    }
}
class node{
    int distance = -1;
    private boolean v = false;
    private node parent = null;
    private ArrayList<node> list = new ArrayList<>();
    public ArrayList<node> getChildren(){return list;} 
    public void addChild(node n){list.add(n);} 
    public boolean isEmpty(){ return (list.size() <= 0);}
    public boolean notHave(node n){ 
        if(isEmpty()) return true;
        if(list.contains(n)) return false;
        return true;
    }
    public void remove(){ list.clear();}
    public void visit(){ v = true;}
    public void goingHome(){ v = false;}
    public boolean visited(){return v;}
}
