package com.lexue.study.example;

/**
 * 桥接模式eg
 */
public class BridgeEg {

    interface DrawApi {
        void drawCircle(int radius, int x, int y);
    }

    static class RedCircle implements DrawApi {

        @Override
        public void drawCircle(int radius, int x, int y) {
            System.out.println("Drawing Circle[ color: red, radius: "
                    + radius + ", x: " + x + ", " + y + "]");
        }
    }

    static class GreenCircle implements DrawApi {
        @Override
        public void drawCircle(int radius, int x, int y) {
            System.out.println("Drawing Circle[ color: green, radius: "
                    + radius + ", x: " + x + ", " + y + "]");
        }
    }

    abstract static class Shape {

        protected final DrawApi drawApi;

        protected Shape(DrawApi drawApi) {
            this.drawApi = drawApi;
        }


        abstract void draw();
    }

    static class Circle extends Shape {

        private final int x;
        private final int y;
        private final int radius;

        public Circle(int x, int y, int radius, DrawApi drawApi) {
            super(drawApi);
            this.x = x;
            this.y = y;
            this.radius = radius;
        }

        @Override
        void draw() {
            drawApi.drawCircle(radius, x, y);
        }
    }

    public static void main(String[] args) {
        Shape circle1 = new Circle(1, 2, 3, new GreenCircle());
        circle1.draw();
        Shape circle2 = new Circle(1, 2, 3, new RedCircle());
        circle2.draw();
    }

}
