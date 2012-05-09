package lib;

import java.awt.AWTException;
import java.awt.Robot;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.InputEvent;

/**
  *
  * @author fernandorodriguez
  */
public class TheRobot{


   public static final Point MousePosition() {

     PointerInfo a = MouseInfo.getPointerInfo();
     Point b  = a.getLocation();
     int x = (int)b.getX();
     int y = (int)b.getY();

     return new Point(x,y);

   }


   public static final void Drag_Drop(int initX, int initY, int  
finalX, int finalY) throws AWTException {

     Robot robot = new Robot();

     
     robot.mouseMove(initX, initY);
     robot.mousePress(InputEvent.BUTTON1_MASK);

     robot.mouseMove(finalX,finalY);
     robot.mouseRelease(InputEvent.BUTTON1_MASK);
   }



   public static final void Press(int button) throws AWTException {

     Robot robot = new Robot();

     switch (button) {
       case 1:  robot.mousePress(InputEvent.BUTTON1_MASK); break;
       case 2:  robot.mousePress(InputEvent.BUTTON2_MASK); break;
       case 3:  robot.mousePress(InputEvent.BUTTON3_MASK); break;
     }
   }


   public static final void Release(int button) throws AWTException {

     Robot robot = new Robot();

     switch (button) {
       case 1:  robot.mouseRelease(InputEvent.BUTTON1_MASK); break;
       case 2:  robot.mouseRelease(InputEvent.BUTTON2_MASK); break;
       case 3:  robot.mouseRelease(InputEvent.BUTTON3_MASK); break;
     }
   }


   public static final void Move(int X, int Y) throws AWTException {

     Robot robot = new Robot();

     robot.mouseMove(X, Y);
   }


}
