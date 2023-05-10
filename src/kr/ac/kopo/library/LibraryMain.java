package kr.ac.kopo.library;

import kr.ac.kopo.library.ui.MainMenuUI;

public class LibraryMain {
    public static void main(String[] args) {

        try {
            new MainMenuUI().execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
