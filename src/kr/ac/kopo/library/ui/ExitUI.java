package kr.ac.kopo.library.ui;

import kr.ac.kopo.util.Line;

public class ExitUI extends BaseUI {

    @Override
    public void execute() throws Exception {

        Line.line('_');
        System.out.println("\n\t\t\t\t\t\t\t\t\t\t   JH도서관은 폐점했습니다.\n");
        Line.line('_');
        System.exit(0);

    }

}
