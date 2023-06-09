
public class gameMove {
        private int clickedRow;
        private int clickedCol;
        private boolean clickedLeftClick;

        public gameMove(int row, int col,boolean click) {
            this.clickedRow = row;
            this.clickedCol = col;
            this.clickedLeftClick = click;
        }

    public static void replayGame() throws InterruptedException {

        new Thread(() -> {
            for (int i = 0; i < GUI.gridRows; i++) {
                for (int j = 0; j < GUI.gridCols; j++) {
                    GUI.currentMap.get(i + (j * 10)).getBtn().setEnabled(true);
                    GUI.currentMap.get(i + (j * 10)).getBtn().setText("");
                    GUI.currentMap.get(i + (j * 10)).setFlagged(false);
                    GUI.currentMap.get(i + (j * 10)).setRevealed(false);
                }
            }
            gameConditions.minesLeft = gameConditions.startingMines;
            GUI.lblMineCount.setText(String.valueOf(gameConditions.startingMines));

                for (gameMove move : buttonAction.moveList) {
                        int col = move.getClickedCol();
                        int row = move.getClickedRow();
                        boolean click = move.isClickedLeftClick();
                    try {
                        Thread.sleep(1000);
                        buttonAction.clickAction(row, col, click, GUI.currentMap.get(GUI.posOfCell(row,col)).getBtn());

                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
        }).start();
        }

    public int getClickedRow() {
        return clickedRow;
    }

    public int getClickedCol() {
        return clickedCol;
    }

    public boolean isClickedLeftClick() {
        return clickedLeftClick;
    }
}