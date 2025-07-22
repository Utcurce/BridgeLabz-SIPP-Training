//public class MobileNavitorManager extends Tab_Navigation{
//    @Override
//    public void visit(String url) {
//        System.out.println("Mobile transition animation");
//        super.visit(url);
//    }
//}
  public class Main{
    public static void main(String[] args) {
        NavigationManager browser = new Tab_Navigation();

        browser.visit("https://google.com");
        browser.visit("https://github.com");
        browser.visit("https://openai.com");

        System.out.println("Current: " + browser.getCurrentPage()); // openai

        browser.back();
        System.out.println("After back: " + browser.getCurrentPage()); // github

        browser.back();
        System.out.println("After another back: " + browser.getCurrentPage()); // google

        browser.forward();
        System.out.println("After forward: " + browser.getCurrentPage()); // github
    }
}
