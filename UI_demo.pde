Draggable position;
Extendable wide, hi;
Rotatable rot;

void setup() {
  size(800, 800);
  ClickUIElement.init(this);
  position = new Draggable(width / 2, height / 2);
  wide = new Extendable(width / 2, height / 2, 0, 100, 200);
  hi = new Extendable(width / 2, height / 2, HALF_PI, 100, 200);
  rot = new Rotatable(width / 2, height / 2, PI);
}

void draw() {
  ClickUIElement.update();

  background(0);

  float x = position.get_x();
  float y = position.get_y();
  wide.set_pos(x, y);
  hi.set_pos(x, y);
  rot.set_pos(x, y);
  float r = rot.get_rotation();
  wide.set_rotation(r);
  hi.set_rotation(r);
  float w = wide.get_value();
  float h = hi.get_value();

  translate(x, y);
  rotate(r);
  fill(255);
  stroke(255);
  rect(0, 0, w, h);

  ClickUIElement.draw();
}