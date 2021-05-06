package BihavioralsPatterns.TemplateMethod;

public class TemplateMethodPatternsMain {
    public static void main(String[] args) {
        WebSiteTemplate welcomePage = new WelcomePage();
        WebSiteTemplate newsPage = new NewsPage();

        welcomePage.showPage();

        System.out.println("\n==========================\n");

        newsPage.showPage();
    }
}
