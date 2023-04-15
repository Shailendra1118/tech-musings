import java.util.Stack;

public class PartsUtility {

    public static void main(String[] args) {
        PartsUtility util = new PartsUtility();

        Part[] parts = new Part[7];
        util.populateComponents(parts);
        System.out.println("parts: "+parts.length);
        int result = util.getComponents("car", "nut", parts);
        System.out.println("Result: "+result);
    }



    public void populateComponents(Part[] parts){
        parts[0]=new Part("car","door",4);
        parts[1]=new Part("door","hinge",2);
        parts[2]=new Part("hinge","nut",2);
        parts[3]=new Part("car","wheel",4);
        parts[4]=new Part("wheel","nut",4); //car
        parts[5]=new Part("car","seat",4);
        parts[6]=new Part("seat","cover",1);
    }

    public int getComponents(String parent, String child, Part[] parts) {
        // Write your code here
        //car, nut ==16
        //populateComponents();
        //String partName = "";
        Stack<Part> stack = new Stack<>();
        //part part = findPart(parent);
        //stack.push()
        Part part = findPart(parent, parts);
        stack.push(part);
        while(part != null && !part.partName.equals(child)) {
            part = findPart(part.childName, parts);
            stack.push(part);
            //partName = part.childName;
        }

        int count = 1;
        System.out.println("Stack size :"+stack.size());
        while(!stack.isEmpty()) {
            Part curPart = stack.pop();
            count = count * curPart.quantity;
        }
        return count;

    }

    private Part findPart(String parent, Part[] parts) {
        //  = "";
        //System.out.println(parts.length);
        Part part = null;
        for(int i=0; i<parts.length; i++) {
            if(parts[i].partName.equals(parent)) {
                return parts[i];
            }
        }
        return part;
    }
    /*
     * Complete the 'getComponents' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING parent
     *  2. STRING child
     */
    public class Part{
        String partName;
        String childName;
        int quantity;

        public Part(String partName,String childName,int quantity){
            this.partName=partName;
            this.childName=childName;
            this.quantity=quantity;
        }
    }
}
