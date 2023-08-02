public class Rectangle {
    int length;
    int breadth;

    public Rectangle(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    public void setData(int length,int breadth){
        this.length = length;
        this.breadth = breadth;
    }

    public int[] getData(){
        int[] result = new int[2];
        result[0] = length;
        result[1] = breadth;
        return result;
    }
    public void DisplayData(){
        System.out.println(" The length is: "+length+"\n The breadth is: "+breadth);
    }

    public int Area(){
        return length*breadth;
    }

    public static int Area(int length, int breadth){
        return length*breadth;
    }


}
