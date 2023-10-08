public class Main {
    public static void main(String[] args) {

        Frame frame = new Frame("Login",
                new HorizontalLayout(
                        new VerticalLayout(
                                new Rectangle(new Text("User")),
                                new Rectangle(new Text("Password")),
                                new HorizontalLayout(
                                        new Rectangle(new Text("Ok")),
                                        new Rectangle(new Text("Cancel"))
                                )
                        ),
                        new Frame("Help",
                                new VerticalLayout(
                                        new Text("Please enter login"),
                                        new Text("  and password"),
                                        new Text("Then press Ok button")
                                )
                        )
                )
        );

        frame.Calculate();
        char[][] res = frame.GetUI();

        for (int i = 0; i < frame.GetHeight(); i++) {
            for (int j = 0; j < frame.GetWidth(); j++) {
                System.out.print(res[i][j]);
            }
            System.out.println();
        }
    }

}