

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // write your code here
    }

    public static class DrawPolygons extends Component {



        class Polygon{
            private String name;
            private Point point;

            public  Polygon(String name,Point point){
                if(name==null || point == null){
                    return;
                }
                this.name= name;
                this.point= point;
            }
            public String getName() {

                return this.name;
            }
            public Point getPoint() {
                return this.point;
            }
        }
        private ArrayList<Polygon> polygons = new ArrayList<Polygon>();

        public DrawPolygons(){
            int i =0;
            //Lägg till möjligheten att klicka ut nya polygoner•Hur bör denna förändring implementeras?
            polygons.add(new Polygon("triangle", new Point(100,150)));
            polygons.add(new Polygon("square", new Point(150,200)));
            for(i=0;i<=40;i++){
                polygons.add(new Polygon("rectangle", new Point(150+i,200+i)));
                polygons.add(new Polygon("triangle", new Point(100+i,150+i)));

            }
        }//constructor

        @Override
        public void paint(Graphics g) {
            for (int i = 0; i < polygons.size(); i++) {
                String currentPolygon = polygons.get(i).getName();
                Point currentCenter = polygons.get(i).getPoint();
                if (currentPolygon.equals("square"))
                    g.drawRect(currentCenter.x -10, currentCenter.y -10, 20, 20);
                else if (currentPolygon.equals("triangle")) {
                    g.drawLine(currentCenter.x, currentCenter.y-10, currentCenter.x-10, currentCenter.y+10);
                    g.drawLine(currentCenter.x-10, currentCenter.y+10,
                            currentCenter.x+10, currentCenter.y+10);
                    g.drawLine(currentCenter.x+10, currentCenter.y+10, currentCenter.x, currentCenter.y-10);
                } else if (currentPolygon.equals("rectangle"))
                    g.drawRect(currentCenter.x -20, currentCenter.y -10, 40, 20);
            }
        }//paint

        public static void main(String[] args) {
            JFrame frame = new JFrame();
            DrawPolygons geometry = new DrawPolygons();

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setBounds(30,30,300,300);
            frame.getContentPane().add(geometry);
            frame.setVisible(true);

        }//main

    }//com.company.Main.DrawPolygons
}
