public class Draggable extends ClickUIElement {
  private float x, y;
  private static float r = 10;

  public float get_x() {
    return x;
  }

  public float get_y() {
    return y;
  }

  public Draggable(float x, float y) {
    super();
    this.x = x;
    this.y = y;
  }

  boolean hovers(float x, float y) {
    return parent.dist(x, y, this.x, this.y) < r;
  }

  void drag(float x, float y) {
    this.x = x;
    this.y = y;
  }

  void draw_element() {
    parent.noFill();
    parent.strokeWeight(3);
    parent.stroke(255, 0, 0);
    parent.ellipse(x, y, r*2, r*2);
  }
}