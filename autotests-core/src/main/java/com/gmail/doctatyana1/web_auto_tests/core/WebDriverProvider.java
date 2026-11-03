package com.gmail.doctatyana1.web_auto_tests.core;

import java.time.Duration;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

/**
 * Instantiates a web driver instance.
 */
@Slf4j
public final class WebDriverProvider {

  private static final int IMPLICITLY_WAIT_SECS = 20;

  private static final OsType OS = OsType.from(System.getProperty("os.name"));

  private final RemoteWebDriver remoteWebDriver;

  public RemoteWebDriver getRemoteWebDriver() {
    return remoteWebDriver;
  }

  public WebDriverProvider(Browser browser) {
    log.info("Instantiating a WebDriver for OS {} and browser {}", OS, browser);
    this.remoteWebDriver = startRemoteWebDriver(browser);
    remoteWebDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_SECS));
  }

  public void quit() {
    remoteWebDriver.quit();
  }

  private static RemoteWebDriver startRemoteWebDriver(Browser browser) {
    switch (browser) {
      case CHROME:
        return startChrome();
      case EDGE:
        return startEdge();
      case IE:
        return startInternetExplore();
      case FIREFOX:
        return startFirefox();
      case SAFARI:
        return startSafari();
      default:
        throw new UnsupportedOperationException("Unsupported browser " + browser);
    }
  }

  private static RemoteWebDriver startChrome() {
    return new ChromeDriver();
  }

  private static RemoteWebDriver startEdge() {
    return new EdgeDriver();
  }

  private static RemoteWebDriver startInternetExplore() {
    return new InternetExplorerDriver();
  }

  private static RemoteWebDriver startFirefox() {
    return new FirefoxDriver();
  }

  private static RemoteWebDriver startSafari() {
    return new SafariDriver();
  }
}
