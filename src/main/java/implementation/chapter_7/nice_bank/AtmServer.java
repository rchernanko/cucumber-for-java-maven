package implementation.chapter_7.nice_bank;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class AtmServer {

    private final Server server;

    public AtmServer(int port) {
        server = new Server(port);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);

        context.addServlet(new ServletHolder(new AtmServlet()), "/*");
    }

    public void start() throws Exception {
        server.start();
        System.out.println("Listening on " + server.getURI());
    }

    public void stop() throws Exception {
        server.stop();
    }

    /*
    This main method is no longer required once I start to use @Before cucumber hooks - these call the start() method
    above
     */
    public static void main(String[] args) throws Exception {
        new AtmServer(9988).start();
    }
}
