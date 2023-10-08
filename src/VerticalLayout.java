public class VerticalLayout implements IComponent {
    private int height;
    private int width;
    private IComponent[] children;

    public VerticalLayout(IComponent... children) {
        this.children = children;
    }

    @Override
    public char[][] GetUI() {
        char[][] res = new char[height][width];
        int sumHeight = 0;
        for (int c = 0; c < children.length; c++) {
            IComponent child = children[c];
            char[][] childUI = child.GetUI();

            for (int i = 0; i < child.GetHeight(); i++) {
                for (int j = 0; j < child.GetWidth(); j++) {
                    res[i + sumHeight][j] = childUI[i][j];
                }
            }

            sumHeight += child.GetHeight();
        }
        return res;
    }

    @Override
    public int CalcWidth() {
        int res = 0;
        for (IComponent child: children) {
            res = Math.max(res, child.GetWidth());
        }
        for (IComponent child: children) {
            child.SetWidth(res);
        }
        return res;
    }

    @Override
    public int CalcHeight() {
        int res = 0;
        for (IComponent child: children) {
            res += child.GetHeight();
        }
        return res;
    }

    @Override
    public void Calculate() {
        for (IComponent child: children) {
            child.Calculate();
        }
        width = CalcWidth();
        height = CalcHeight();
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
