
import java.util.Stack;
interface NavigationManager {
    void visit(String url);
    String back();
    String forward();
    String getCurrentPage();
}

public class Tab_Navigation implements NavigationManager {
    private String currentPage;
    private Stack<String> backStack;
    private Stack<String> forwardStack;

    public Tab_Navigation() {
        backStack = new Stack<>();
        forwardStack = new Stack<>();
        currentPage = "Home"; // default
    }

    @Override
    public void  visit(String url){
        if (currentPage != null) {
            backStack.push(currentPage); // Save current before switching
        }
        currentPage = url;
        forwardStack.clear();
    }
    @Override
    public String back(){
        if (!backStack.isEmpty()) {
            forwardStack.push(currentPage);
            currentPage = backStack.pop();
        }
        return currentPage;
    }
    @Override
    public  String forward(){
        if (!forwardStack.isEmpty()) {
            backStack.push(currentPage);
            currentPage = forwardStack.pop();
        }
        return currentPage;

    }

    @Override
    public String getCurrentPage() {
        return currentPage;
    }
}

