public class Runner {
    public static void main(String[] args){
        NGon square = new NGon(20,4,new Point(100,100));
        Point[] pointList = square.getPoints();
        System.out.println(pointList[0].toString());
        System.out.println(pointList[1].toString());
        System.out.println(pointList[2].toString());
        System.out.println(pointList[3].toString());
    }
}
