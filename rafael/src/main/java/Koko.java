import java.util.Arrays;

public class Koko {
    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        Arrays.stream(piles).max().getAsInt();
        int total = 0;
        int hours = 4;
        for(int i=0; i<piles.length; i++) {
            //total += piles[i]/hours;
            //total += piles[i]%hours == 0 ? 0 : 1;
            int div = piles[i]/hours;
            System.out.println("Without double: " + div);
            double ddiv = (double)piles[i]/hours;
            System.out.println("With double: " + ddiv);
            System.out.println("With Ceiling: " + Math.ceil(ddiv));
            total += Math.ceil((double)piles[i]/hours);
            System.out.println("total now: "+total);
            //System.out.println("Ceil: "+Math.ceil((double)piles[i]/hours));
        }
        System.out.println("Res: "+total);
        System.out.println(Math.ceil(1.1));
    }
}
