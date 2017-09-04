import java.util.ArrayList;
import processing.core.PApplet;

public abstract class ClickUIElement {
  static PApplet parent;
  private static boolean any_pressed = false;
  private static ClickUIElement clicked_element;
  private static ArrayList<ClickUIElement> elements = new ArrayList<ClickUIElement>();

  public static void init(PApplet app) {
    parent = app;
  }

  public ClickUIElement() {
    if (parent == null) {
      throw new Error("you haven't called init()");
    }
    elements.add(this);
  }

  abstract void draw_element();
  public static void draw() {
    parent.pushMatrix();
    parent.resetMatrix();
    for (ClickUIElement e : elements) {
      e.draw_element();
    }
    parent.popMatrix();
  }

  abstract void drag(float x, float y);
  abstract boolean hovers(float x, float y);
  public static void update() {
    if (parent.mousePressed) {
      float x = parent.mouseX;
      float y = parent.mouseY;

      if (any_pressed) {
        clicked_element.drag(x, y);
      } else {
        for (ClickUIElement e : elements) {
          if (e.hovers(x, y)) {
            clicked_element = e;
            any_pressed = true;
            break;
          }
        }
      }
    } else {
      any_pressed = false;
    }
  }
}