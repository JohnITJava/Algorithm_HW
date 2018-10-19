package Lesson5;

public class HanoiTowers {
    private int ringSize;
    private int[] fStick;
    private int[] secStick;
    private int[] thirdStick;
    private int ringCount;
    private int last;

    public HanoiTowers(int... ringSizes) {
        fStick = ringSizes;
        ringCount = ringSizes.length;
    }

    public int getLast(int[] stick){
        for (int i = stick.length - 1; i >= 0; i--) {
            if (stick[i] != 0) {
                last = stick[i];
                stick[i] = 0;
                return last;
            }
        }
        return 0;
    }

    public int checkLast(int[] stick){
        for (int i = stick.length - 1; i >= 0; i--) {
            if (stick[i] != 0) {
                last = stick[i];
                return last;
            }
        }
        return 0;
    }

    public void moveTower(){
        while ()
    }
}
