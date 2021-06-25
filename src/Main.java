
import java.util.HashMap;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args){
        PyramidCSVDAO PDAO=new PyramidCSVDAO();
        LinkedList<Pyramid> pyramids=PDAO.readPyramidsFromCSV("H:\\ITI AI-PRO\\Java & UML\\WorkSpace\\Day(3)_Lab_Exercise(2)\\pyramids.csv");
        int i=1;
        for(Pyramid p:pyramids){
            System.out.println("# "+(i++)+" "+p);
        }
        LinkedList<Pyramid> sortedPyramids=PDAO.sortPyramids(pyramids);
        for (int j=0; j<sortedPyramids.size(); j++)
            System.out.println("# "+(j+1)+" "+sortedPyramids.get(j));
        HashMap<String, Integer> Info=PDAO.pyramidsInfo(pyramids);
        System.out.println(Info);
    }
}

