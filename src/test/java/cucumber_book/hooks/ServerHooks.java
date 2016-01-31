package cucumber_book.hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import implementation.chapter_7.nice_bank.AtmServer;

public class ServerHooks {

    public static final int PORT = 8887;

    private AtmServer server;

    @Before("@server")
    public void startServer() throws Exception {
        server = new AtmServer(PORT);
        server.start();
    }

    @After("@server")
    public void stopServer() throws Exception {
        server.stop();
    }
}
