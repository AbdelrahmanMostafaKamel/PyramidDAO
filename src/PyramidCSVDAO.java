
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

import java.util.HashMap;
import java.util.*;
public class PyramidCSVDAO {
    public PyramidCSVDAO(){}
    public LinkedList<Pyramid> readPyramidsFromCSV(String fileName){
        LinkedList<Pyramid> Pyramids=new LinkedList<>();
        try{
            FileReader r=new FileReader(fileName);
            BufferedReader br=new BufferedReader(r);
            String line=br.readLine();//First line header,skip it

            do{
               line=br.readLine();
               if(line!=null) {
                   String[] parts = line.split(",");
                   Pyramid obj = createPyramid(parts);
                   Pyramids.add(obj);
               }
            }while(line != null);
            br.close();
            r.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return Pyramids;
    }
    public Pyramid createPyramid(String[] metadata){
        String pharaoh=metadata[0];
        String modernName=metadata[2];
        String site=metadata[4];
         double height;
        if (metadata[7].isEmpty()) {
            height=0;
        } else {
            height=Double.parseDouble(metadata[7]);
        }
        Pyramid obj=new Pyramid(pharaoh,modernName,site,height);
        return obj;
    }
    public LinkedList<Pyramid> sortPyramids(LinkedList<Pyramid> pyramids){
        pyramids.sort(new Sortbyheight());
        return pyramids;
    }
    public HashMap<String,Integer> pyramidsInfo(LinkedList<Pyramid> pyramids){
        HashMap<String, Integer> pyramidsInfo = new HashMap<>();
        for (Pyramid p:pyramids) {
            Integer count = pyramidsInfo.containsKey(p.getSite()) ? pyramidsInfo.get(p.getSite()) : 0;
            pyramidsInfo.put(p.getSite(), count + 1);
        }
        return pyramidsInfo;
    }
}
