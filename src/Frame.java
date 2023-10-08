public class Frame implements IComponent {
    private FrameType frameType = new FrameType('╔','═', '╗', '║', '╚', '╝');
    private String title;
    private IComponent child;

    private int width;
    private int height;

    public Frame(String title, IComponent child) {
        this.child = child;
        this.title = " " + title + " ";
    }

    @Override
    public char[][] GetUI() {
        char[][] childUI = child.GetUI();
        char[][] res = UIHelper.CreateVoidFrame(width, height, frameType);
        SetTitle(res);
        for (int i = 1; i < height - 1; i++) {
            for (int j = 2; j < width - 1; j++) {
                if(i - 1 < child.GetHeight() && j - 2< child.GetWidth()) {
                    res[i][j] = childUI[i - 1][j - 2];
                }
                else {
                    res[i][j] = ' ';
                }
            }
        }
        return res;
    }

    private void SetTitle(char[][] res) {
        for (int i = 0; i < title.length(); i++) {
            res[0][i + 2] = title.charAt(i);
        }
    }

    @Override
    public int CalcWidth() {
        if(child.GetWidth() < title.length() + 1)
            return title.length() + 4;
        
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
