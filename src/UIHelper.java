public class UIHelper {
    public static char[][] CreateVoidFrame(int width, int height, FrameType frameType) {
        char[][] res = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                res[i][j] = getNeedSymFromIndex(i, j, width, height, frameType);
            }
        }
        return res;
    }

    private static char getNeedSymFromIndex(int i, int j, int width, int height, FrameType frameType) {
        if(i == 0 && j == 0)
            return frameType.UpperLeftCorner;
        if(i == 0 && j == width - 1)
            return frameType.UpperRightCorner;
        if(i == height - 1 && j == 0)
            return frameType.LowerLeftCorner;
        if(i == height - 1 && j == width - 1)
            return frameType.LowerRightCorner;
        if(j == width - 1 || j == 0)
            return frameType.VerticalLine;
        if(i == height - 1 || i == 0)
            return frameType.HorizontalLine;
        return ' ';
    }
}
