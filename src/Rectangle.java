public class Rectangle implements IComponent {
    private FrameType frameType = new FrameType('┌','─', '┐', '│', '└', '┘');
    private IComponent child;

    private int height;
    private int width;
    public Rectangle(IComponent child) {
        this.child = child;
    }

    @Override
    public char[][] GetUI() {
        char[][] childUI = child.GetUI();
        char[][] res = UIHelper.CreateVoidFrame(width, height, frameType);
        for (int i = 1; i < height - 1; i++) {
            for (int j = 2; j < width - 1; j++) {
                if(i - 1 < child.GetHeight() && j  - 2 < child.GetWidth()) {
                    res[i][j] = childUI[i - 1][j - 2];
                }
                else {
                    res[i][j] = ' ';
                }
            }
        }
        return res;
    }

    @Override
    public int CalcWidth() {
        return child.GetWidth() + 4;
    }

    @Override
    public int CalcHeight() {
        return child.GetHeight() + 2;
    }

    @Override
    public void Calculate() {
        child.Calculate();
        height = CalcHeight();
        width = CalcWidth();
    }

    @Override
    public int GetHeight() {
        return height;
    }

    @Override
    public int GetWidth() {
        return width;
    }

    @Override
    public void SetHeight(int value) {
        height = value;
    }

    @Override
    public void SetWidth(int value) {
        width = value;
    }
}
