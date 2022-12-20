package NovakJ_SemestralProject;
import java.util.Scanner;

public class SemestralniPraceUloha7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean possible;
        int outsidePoints, insidePoints, onEgePoints, numOfPoints;
        char again;
        double ax, ay, bx, by, cx, cy, px, py;
        double areaABP, areaACP, areaBCP, areaABC;
        final double precision = 0.000001;

        //logic 
        do{
            outsidePoints= 0; insidePoints = 0; onEgePoints = 0;
            do {
                System.out.println("Zadej vrcholy trojuhelnika (x y):");
                ax = sc.nextDouble();
                ay = sc.nextDouble();
                bx = sc.nextDouble();
                by = sc.nextDouble();
                cx = sc.nextDouble();
                cy = sc.nextDouble();
                possible = isPossible(ax, ay, bx, by, cx, cy);
                if (possible) {
                    break;
                } else {
                    System.out.println("Z techto vrcholu nejde sestrojit trojuhelnik");
                }
            } while (!possible);
            
            System.out.println("Zadej pocet testovanych bodu");
            do {
                numOfPoints = sc.nextInt();
                if (numOfPoints<0){
                    System.out.println("Pocet testovanych bodu musi byt 1 nebo vice. Zadej znovu:");
                }
            } while (numOfPoints<0);
            
            System.out.println("Zadej souradnice bodu");
            areaABC = areaOfTriangle(ax, ay, bx, by, cx, cy);
            for (int i = 0; i < numOfPoints; i++) {
                px = sc.nextDouble();
                py = sc.nextDouble();
                areaBCP = areaOfTriangle(bx, by, cx, cy, px, py);
                areaABP = areaOfTriangle(ax, ay, bx, by, px, py);
                areaACP = areaOfTriangle(ax, ay, cx, cy, px, py);
                if (Math.abs(0-areaABP) <precision || Math.abs(0-areaACP) <precision || Math.abs(0-areaBCP) <precision) {
                    onEgePoints++;
                } else if ( precision > Math.abs(1-((areaABP+areaACP+areaBCP)/areaABC))) {
                    insidePoints++;
                } else {
                    outsidePoints++;
                }
            }

            //output
            System.out.println("Uvnitr trojuhelnika lezi " + insidePoints + " bodu");
            System.out.println("Na hrane trojuhelnika lezi " + onEgePoints + " bodu");
            System.out.println("Vne trojuhelnika lezi " + outsidePoints + " bodu");
            System.out.println("");
            System.out.println("Pokracovat ve zpracovani (a/n):");
            again = sc.next().toLowerCase().charAt(0); 
        }while(again == 'a');
    }

    /**
     * checks if a triangle can be created from given points
     * @param ax
     * @param ay
     * @param bx
     * @param by
     * @param cx
     * @param cy
     * @return
     */
    private static boolean isPossible(double ax, double ay, double bx, double by, double cx, double cy) {
        double side1 = Math.sqrt(Math.pow(ax - bx, 2) + Math.pow(ay - by, 2));
        double side2 = Math.sqrt(Math.pow(cx - bx, 2) + Math.pow(cy - by, 2));
        double side3 = Math.sqrt(Math.pow(ax - cx, 2) + Math.pow(ay - cy, 2));
        if ((side1 + side2 > side3) && (side2 + side3 > side1) && (side1 + side3 > side2)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * calculates area of triangle
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @param x3
     * @param y3
     * @return
     */
    private static double areaOfTriangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        double area = Math.abs((x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2);
        return area;
    }
}
