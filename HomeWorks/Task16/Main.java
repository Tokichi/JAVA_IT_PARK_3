package com.company;

import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception{
        TextViewer viewer = new TextViewer();
        viewer.setText("3.jr.D832.4uf'g94E5'83h?jGsf!s!h");
        viewer.addTask(new LettersTask());
        viewer.addTask(new DigitsTask());
        viewer.addTask(new PmTask());
        viewer.process();
    }
}
