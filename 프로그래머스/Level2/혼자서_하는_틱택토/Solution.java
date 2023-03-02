class Solution {
    public int solution(String[] board) {
        int O = 0;
        int OWin = 0;
        int X = 0;
        int XWin = 0;

        String[][] b = new String[3][3];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {

                String n = String.valueOf(board[i].charAt(j));
                if (n.equals("O")) {
                    O++;
                }

                if (n.equals("X")) {
                    X++;
                }

                b[i][j] = String.valueOf(board[i].charAt(j));
            }
        }

        //가로
        if (!b[0][0].equals(".") && (b[0][0].equals(b[0][1]) && b[0][0].equals(b[0][2]))) {
            if (b[0][0].equals("O"))
                OWin++;
            else
                XWin++;
        }

        if (!b[1][0].equals(".") && (b[1][0].equals(b[1][1]) && b[1][0].equals(b[1][2]))) {
            if (b[1][0].equals("O"))
                OWin++;
            else
                XWin++;
        }

        if (!b[2][0].equals(".") && (b[2][0].equals(b[2][1]) && b[2][0].equals(b[2][2]))) {
            if (b[2][0].equals("O"))
                OWin++;
            else
                XWin++;
        }

        //세로
        if (!b[0][0].equals(".") && (b[0][0].equals(b[1][0]) && b[0][0].equals(b[2][0]))) {
            if (b[0][0].equals("O"))
                OWin++;
            else
                XWin++;
        }

        if (!b[0][1].equals(".") && (b[0][1].equals(b[1][1]) && b[0][1].equals(b[2][1]))) {
            if (b[0][1].equals("O"))
                OWin++;
            else
                XWin++;
        }

        if (!b[0][2].equals(".") && (b[0][2].equals(b[1][2]) && b[0][2].equals(b[2][2]))) {
            if (b[0][2].equals("O"))
                OWin++;
            else
                XWin++;
        }

        //대각선
        if (!b[0][0].equals(".") && (b[0][0].equals(b[1][1]) && b[0][0].equals(b[2][2]))) {
            if (b[0][0].equals("O"))
                OWin++;
            else
                XWin++;
        }

        if (!b[0][2].equals(".") && (b[0][2].equals(b[1][1]) && b[0][2].equals(b[2][0]))) {
            if (b[0][2].equals("O"))
                OWin++;
            else
                XWin++;
        }

        //승리 조건 계산하기
        if ((OWin >= 1 && XWin == 0) || (OWin == 0 && XWin >= 1) || (OWin == 0 && XWin == 0)) {
            
            //무승부
            if ((OWin == 0 && XWin == 0) && (O == X || O - X == 1)) {
                return 1;
            } 
            //X승
            else if ((OWin == 0 && XWin >= 1) && (O == X)) {
                return 1;
            } 
            //O승
            else if ((OWin >= 1 && XWin == 0) && (O - X == 1)) {
                return 1;
            } else
                return 0;
            
        } else {
            return 0;
        }
    }
}