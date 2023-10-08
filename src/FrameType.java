public class FrameType {
    public char UpperLeftCorner;
    public char HorizontalLine;
    public char UpperRightCorner;
    public char VerticalLine;
    public char LowerLeftCorner;
    public char LowerRightCorner;

    public FrameType(char upperLeftCorner,
                     char horizontalLine,
                     char upperRightCorner,
                     char verticalLine,
                     char lowerLeftCorner,
                     char lowerRightCorner) {
        UpperLeftCorner = upperLeftCorner;
        HorizontalLine = horizontalLine;
        UpperRightCorner = upperRightCorner;
        VerticalLine = verticalLine;
        LowerLeftCorner = lowerLeftCorner;
        LowerRightCorner = lowerRightCorner;
    }
}
