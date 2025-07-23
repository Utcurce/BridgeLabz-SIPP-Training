import java.util.LinkedList;
import java.util.Queue;

public class LibrarySystem {
    private Queue<Request<? extends Book>> requestQueue;

    public LibrarySystem() {
        requestQueue = new LinkedList<>();
    }

    public void addRequest(Request<? extends Book> request) {
        requestQueue.offer(request);
        System.out.println("✅ Added: " + request);
    }

    public void processRequests() {
        System.out.println("\n📚 Processing Requests...");
        while (!requestQueue.isEmpty()) {
            Request<? extends Book> req = requestQueue.poll();
            System.out.println("🔄 Processing: " + req);
        }
        System.out.println("✅ All requests processed.");
    }

    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();

        EBook ebook = new EBook("Java Basics", "James Gosling", "PDF");
        HardCopyBook hardCopy = new HardCopyBook("Data Structures", "Robert Lafore", "978-DSA-001");

        Request<EBook> req1 = new Request<>("UserA", ebook);
        Request<HardCopyBook> req2 = new Request<>("UserB", hardCopy);

        library.addRequest(req1);
        library.addRequest(req2);

        library.processRequests();
    }
}