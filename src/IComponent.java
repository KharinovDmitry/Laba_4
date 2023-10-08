public interface IComponent {
    public char[][] GetUI();
    public int CalcWidth();
    public int CalcHeight();
    public void Calculate();

    public int GetHeight();
    public int GetWidth();
    public void SetHeight(int value);
    public void SetWidth(int value);

}
