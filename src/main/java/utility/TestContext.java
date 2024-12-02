package utility;

public class TestContext {



        public  BrowserBase browserBase = new BrowserBase();
        public  PageObjectManager pageObjectManager;


        public TestContext() {
            BrowserBase browserBase = new BrowserBase();
            pageObjectManager = new PageObjectManager(browserBase.browserInvocation());
        }
}
