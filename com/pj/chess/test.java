package com.pj.chess;


import java.io.IOException;

public class test
{
    public static void main(String[] args)
    {
        ApiTool api = new ApiTool();
        String requestBoard;
        requestBoard = "rnbakabnr/9/1c5c1/p1p1p1p1p/9/9/P1P1P1P1P/1CN4C1/9/R1BAKABNR b";
        String run = null;
        try {
            run = api.run("http://www.chessdb.cn/chessdb.php?action=query&board=" + requestBoard);
            System.out.println(run);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
