public class Text implements IComponent {
    private String content;
    private int height;
    private int width;

    public Text(String content) {
        this.content = content;
    }
    @Override
    public char[][] GetUI() {
        char[][] res = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if(i == 0 && j < content.length()) {
                    res[i][j] = content.charAt(j);
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
        return content.length();
    }

    @Override
    public int CalcHeight() {
        return 1;
    }

    @Override
    public void Calculate() {
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
