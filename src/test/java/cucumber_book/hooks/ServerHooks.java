package cucumber_book.hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber_book.support.chapter_7.nice_bank.KnowsTheDomain;
import implementation.chapter_7.nice_bank.AtmServer;

public class ServerHooks {

    public static final int PORT = 8887;

    private AtmServer server;
    private KnowsTheDomain helper;

    public ServerHooks(KnowsTheDomain helper) {
        this.helper = helper;
    }

    @Before
    public void startServer() throws Exception {
        server = new AtmServer(PORT, helper.getCashSlot(), helper.getMyAccount());
        server.start();
    }

    @After
    public void stopServer() throws Exception {
        server.stop();
    }
}
