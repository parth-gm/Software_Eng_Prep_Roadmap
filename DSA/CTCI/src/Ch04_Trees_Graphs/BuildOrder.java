package Ch04_Trees_Graphs;

import java.util.*;

public class BuildOrder {



    static void buildOrderByDFS(Graph_Adjacency_List gal, HashMap<String, Project> hm, Project  p,List<String> order){

        p.state=State.Visited;
        for(Project adjproject:gal.getConnectedProjects(p)){
            if(adjproject.state==State.Unvisited){

                buildOrderByDFS(gal,hm,adjproject,order);
            }

        }
        order.add(p.projectName);
        //System.out.println(p.projectName);

    }

    static  void topologicalSortDFS(Graph_Adjacency_List gal, HashMap<String,Project> hm){

        List<String> orderbyDfs=new LinkedList<>();

        for(Project prj:hm.values()){
            prj.state=State.Unvisited;
        }

        for(String project:hm.keySet()){
            if(hm.get(project).state==State.Unvisited){
                buildOrderByDFS(gal,hm,hm.get(project),orderbyDfs);
            }
        }
        Collections.reverse(orderbyDfs);
        System.out.println(orderbyDfs);
    }


    static List<String> findBuildOrder(Graph_Adjacency_List gal,HashMap<String,Project> hm){

        List<String> listOrder=new LinkedList<>();
        Queue<String> q=new LinkedList<>();
        for(Project p:hm.values()){
            //System.out.println(p.projectName);
            if(p.indegree==0){
                q.add(p.projectName);
            }
        }
        //System.out.println(q);
        while(q.size()>0){
            String node=q.remove();
            listOrder.add(node);
            Project phead= hm.get(node);

            for(Project pconn:gal.getConnectedProjects(phead))
            {
                pconn.indegree--;
                if(pconn.indegree==0)
                    q.add(pconn.projectName);

            }
        }
        return listOrder;
    }

    public static void main(String[] args) {
        int n=7;
        Scanner sc=new Scanner(System.in);
        Graph_Adjacency_List gal=new Graph_Adjacency_List(6);
        HashMap<String,Project> hm=new HashMap<String, Project>();

        for(int i=0;i<n;i++){
            String name=sc.next();
            hm.put(name,gal.addProject(name));
        }

        System.out.println("Enter Dependency Nos: ");
        int noDeps=sc.nextInt();

        for(int j=0;j<noDeps;j++){
            String a=sc.next();
            String b=sc.next();
            if(hm.containsKey(a) && hm.containsKey(b))
                gal.addDependency(hm.get(a),hm.get(b));
            else
                System.out.println("Not Added Dependency Error in Nodes names");
        }

        Iterator it = hm.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            System.out.print(pair.getKey() + " : ");

            for(Project p:gal.getConnectedProjects((Project) pair.getValue())){
                System.out.print(p.projectName+"-->");
            }
            System.out.print("END");
            System.out.println();
            System.out.println("Indegree: "+((Project) pair.getValue()).indegree );

            //it.remove(); // avoids a ConcurrentModificationException
        }


        List<String> order=findBuildOrder(gal,hm);
        System.out.println(order);

        System.out.println("------------BY DFS---------------");

        topologicalSortDFS(gal,hm);

    }


}
