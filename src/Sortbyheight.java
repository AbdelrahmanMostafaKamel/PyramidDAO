import java.util.*;
public class Sortbyheight implements Comparator<Pyramid>{
    public int compare(Pyramid a, Pyramid b)
    {
        return Double.compare(a.getHeight(),b.getHeight());
    }
}

