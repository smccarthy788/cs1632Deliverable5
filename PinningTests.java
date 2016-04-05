import org.junit.*;

import static org.junit.Assert.*;

public class PinningTests {

    @Test
    public void noNeighborsTest(){
        /*
            - - - - -
            - - - - -
            - - o - -
            - - - - -
            - - - - -

            should return 0
        */
        MainPanel mp = new MainPanel(5);

        assertEquals(0, mp.getNumNeighbors(2,2));
    }

    @Test
    public void fullNeighborsTest(){
        /*
            - - - - -
            - x x x -
            - x o x -
            - x x x -
            - - - - -

            should return 8
        */
        MainPanel mp = new MainPanel(5);
        Cell cells[][] = new Cell[5][5];

        for(int i = 0; i < 5; i ++){
            for(int j = 0; j <5; j++){
                cells[i][j] = new Cell();
            }
        }

        cells[1][1] = new Cell(true);
        cells[1][2] = new Cell(true);
        cells[1][3] = new Cell(true);
        cells[2][1] = new Cell(true);
        cells[2][3] = new Cell(true);
        cells[3][1] = new Cell(true);
        cells[3][2] = new Cell(true);
        cells[3][3] = new Cell(true);

        mp.setCells(cells);

        assertEquals(8,mp.getNumNeighbors(2,2));
    }

    @Test
    public void randomNeighborsTest(){
        /*
            - - - - -
            - - - - -
            - - x - x
            - - x o -
            - - - - x

            should return 4
         */
        MainPanel mp = new MainPanel(5);
        Cell cells[][] = new Cell[5][5];

        for(int i = 0; i < 5; i ++){
            for(int j = 0; j <5; j++){
                cells[i][j] = new Cell();
            }
        }

        cells[2][2] = new Cell(true);
        cells[2][4] = new Cell(true);
        cells[3][2] = new Cell(true);
        cells[4][4] = new Cell(true);

        mp.setCells(cells);

        assertEquals(4, mp.getNumNeighbors(3,3));
    }

    @Test
    public void runContinuous(){
        MainPanel mp = new MainPanel(5);

        boolean isRunning = false;

        mp.runContinuous();
        int i = 0;
        while(i < 1000){
            isRunning = mp._running;
        }
        assertTrue(isRunning);
    }


}
