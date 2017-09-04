import processing.core.PVector;

public class Rotatable extends ClickUIElement {
  private PVector loc, head;
  private float th;
  private static float r = 15;
  private static float l = 100;

  public float get_rotation() {
    return (head.heading() + parent.TWO_PI - th) % parent.TWO_PI;
  }
  
  public void set_pos(float x, float y) {
    loc.x = x;
    loc.y = y;
  }

  public Rotatable(float x, float y, float th) {
    super();
    loc = new PVector(x, y);
    head = PVector.fromAngle(th).mult(l);
    this.th = th % parent.TWO_PI;
  }
  
  public Rotatable(float x, float y) {
    this(x, y, 0);
  }

  boolean hovers(float x, float y) {
    return new PVector(x, y).sub(PVector.add(loc, head)).mag() < r;
  }

  void drag(float x, float y) {
    head = new PVector(x, y).sub(loc).normalize().mult(l);
  }

  void draw_element() {
    parent.noFill();
    parent.stroke(0, 0, 255);
    parent.strokeWeight(3);
    parent.ellipse(loc.x + head.x, loc.y + head.y, r*2, r*2);
    parent.line(loc.x, loc.y, loc.x + head.x, loc.y + head.y);
  }
}