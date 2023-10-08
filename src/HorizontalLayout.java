import java.util.List;

public class HorizontalLayout implements IComponent  {
    private IComponent[] children;
    public int height;
    public int width;
    public HorizontalLayout(IComponent... children) {
        this.children = children;
    }
    @Override
    public char[][] GetUI() {
        char[][] res = new char[height][width];
        int sumWidth = 0;
        for (int c = 0; c < children.length; c++) {
            IComponent child = children[c];
            char[][] childUI = child.GetUI();


            for (int i = 0; i < child.GetHeight(); i++) {
                res[i][sumWidth] = ' ';
                for (int j = 0; j < child.GetWidth(); j++) {
                    res[i][sumWidth + j + c] = childUI[i][j];
                }
            }

            sumWidth += child.GetWidth();
        }
        return res;
    }

    @Override
    public int CalcWidth() {
        int res = children.length - 1;
        for (IComponent child: children) {
            res += child.GetWidth();
        }
        return res;
    }

    @Override
    public int CalcHeight() {
        int res = 0;
        for (IComponent child: children) {
            res = Math.max(res, child.GetHeight());
        }
        for (IComponent child: children) {
            child.SetHeight(res);
        }
        return res;
    }

    @Override
    public void Calculate() {
        for (IComponent child: children) {
            child.Calculate();
        }
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
