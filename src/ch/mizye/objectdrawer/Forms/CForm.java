package ch.mizye.objectdrawer.Forms;

import java.awt.*;


public class CForm {

    protected String Form;

    protected int X, Y;
    protected int W, H;

    protected Color RColor, IColor;

    public CForm(String form, Color rcolor, Color icolor, int x, int y, int w, int h) {
        Form = form;

        X = x;
        Y = y;
        W = w;
        H = h;

        RColor = rcolor;
        IColor = icolor;
    }

    public void draw(Graphics g) {

    }

    public String getForm() {
        return Form;
    }

    public Color getRColor() {
        return RColor;
    }

    public Color getIColor() {
        return IColor;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public int getW() {
        return W;
    }

    public int getH() {
        return H;
    }

}
