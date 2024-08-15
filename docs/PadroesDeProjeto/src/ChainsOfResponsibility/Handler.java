package ChainsOfResponsibility;

public interface Handler {
    Handler setNext(Handler handler);
    String handle(Request request);
}
