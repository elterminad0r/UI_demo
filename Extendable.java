import processing.core.PVector;

public class Extendable extends ClickUIElement {
  private PVector len, loc;
  private float min, max, th;
  private static float r = 15;
  private static float range = 200;

  public float get_value() {
    return parent.map(len.mag(), 0, range, min, max);
  }
  
  public void set_pos(float x, float y) {
    loc.x = x;
    loc.y = y;
  }
  
  public void set_rotation(float th) {
    float m = len.mag();
    len = PVector.fromAngle(th + this.th).mult(m);
  }

  public Extendable(float x, float y, float th, float min, float max) {
    super();
    loc = new PVector(x, y);
    len = PVector.fromAngle(th).mult(range / 2);
    this.min = min;
    this.max = max;
    this.th = th;
  }
  
  public Extendable(float x, float y) {
    this(x, y, 0, 0, 50);
  }

  boolean hovers(float x, float y) {
    return new PVector(x, y).sub(PVector.add(loc, len)).mag() < r;
  }

  void drag(float x, float y) {
    float l = PVector.dot(new PVector(x, y).sub(loc), len.normalize());
    l = parent.constrain(l, 1, range);
    len.setMag(l);
  }

  void draw_element() {
    parent.noFill();
    parent.stroke(0, 255, 0);
    parent.strokeWeight(3);
    parent.ellipse(loc.x + len.x, loc.y + len.y, r*2, r*2);
    parent.line(loc.x, loc.y, loc.x + len.x, loc.y + len.y);
  }
}