package homeWork1;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WorkWithLocatorsTest {

  final static Logger logger = Logger.getLogger(WorkWithLocatorsTest.class);

  private WebDriver driver;
  JavascriptExecutor js;
  Actions actions;
  private String baseUrlEpam = "https://www.epam.com/";
  private String trainingUrlEpam = "https://www.training.by/";
  private String positionsAnalystUrlEpam = "https://www.epam.com/careers/job-listings?country=Ukraine&city=Lviv";
  private String pastEventsUrlEpam = "https://www.epam.com/about/who-we-are/events";
  private String userName = "vitaliy.babiak@gmail.com";
  private String userPassword = "Pswepam_";
  private String userNameIncorrect = "smb@gmail.com";
  private String userPasswordIncorrect = "1234567890";
  private String searchItem1 = "Java";
  private String searchItem2 = "DATA";
  private String searchItem3 = "Pascal";
  private String searchLocation1 = "Kyiv";
  private String searchLocation2 = "Los Angeles";

  @Before
  public void setUp() {
    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    js = (JavascriptExecutor) driver;
    actions = new Actions(driver);
  }

  @Test
  public void testVerifyTrainingsLocations() {
    driver.get(trainingUrlEpam);

    WebElement signInButton = driver.findElement(By.xpath("//p[@class=\"header-auth__signin\"]"));
    signInButton.click();
    logger.debug("Click sign in button");

    WebElement inputEmail = driver.findElement(By.id("signInEmail"));
    inputEmail.sendKeys(userName);
    logger.debug("Input user name");

    WebElement inputPassword = driver.findElement(By.id("signInPassword"));
    inputPassword.sendKeys(userPassword);
    logger.debug("Input user password");

    WebElement submitElement = driver.findElement(By.xpath("//input[@class=\"popup-reg-sign-in-form__sign-in\"]"));
    submitElement.click();
    logger.debug("Click on submit button");

    WebElement trainingListButton = driver.findElement(By.xpath("//div[@class=\"container\"]/nav/ul/li/a[@class=\"topNavItem training click hover\"]"));
    if (trainingListButton.isEnabled() && !trainingListButton.isSelected()) {
      trainingListButton.click();
      logger.debug("Click training list button");
    }

    WebElement filterItemLocationsArrow = driver.findElement(By.xpath("//div[@class=\"filter__item filter__item-locations\"]/div/div[@class=\"filter-field__arrow-icon\"]"));
    js.executeScript("arguments[0].scrollIntoView();", filterItemLocationsArrow);
    filterItemLocationsArrow.click();
    logger.debug("Filter item locations arrow was clicked");

    WebElement inputFieldLocations = driver.findElement(By.xpath("//div[@class=\"drop-down drop-down-locations drop-down-visibility\"]/input"));
    inputFieldLocations.sendKeys(searchLocation1);
    logger.debug("Perform search for " + searchLocation1 + " search location");

    List<WebElement> listOfLocations = driver.findElements(By.xpath("//div[@class=\"drop-down drop-down-locations drop-down-visibility\"]/ul[@class=\"drop-down__input-search__list\"]/li"));
    Assert.assertEquals(2, listOfLocations.size());
    logger.debug("Count elements with " + searchLocation1 + " are " + listOfLocations.size());

    inputFieldLocations.clear();
    inputFieldLocations.sendKeys(searchLocation2);
    logger.debug("Perform search for " + searchLocation2 + " search location");

    listOfLocations = driver.findElements(By.xpath("//div[@class=\"drop-down drop-down-locations drop-down-visibility\"]/ul[@class=\"drop-down__input-search__list\"]/li"));
    Assert.assertEquals(2, listOfLocations.size());
    logger.debug("Count elements with " + searchLocation2 + " are " + listOfLocations.size());

  }

  @Test
  public void verifyNewsPage() {

    driver.get(trainingUrlEpam);

    WebElement signInButton = driver.findElement(By.xpath("//p[@class=\"header-auth__signin\"]"));
    signInButton.click();
    logger.debug("Click sign in button");

    WebElement inputEmail = driver.findElement(By.id("signInEmail"));
    inputEmail.sendKeys(userName);
    logger.debug("Input user name");

    WebElement inputPassword = driver.findElement(By.id("signInPassword"));
    inputPassword.sendKeys(userPassword);
    logger.debug("Input user password");

    WebElement submitElement = driver.findElement(By.xpath("//input[@class=\"popup-reg-sign-in-form__sign-in\"]"));
    submitElement.click();
    logger.debug("Click on submit button");

    WebElement newsElement = driver.findElement(By.xpath("//div[@class=\"tab-nav\"]/div/div/span[text()=\"News\"]/.."));
    actions.moveToElement(newsElement).click().perform();
    logger.debug("Click on News button");
    logger.debug(newsElement.getAttribute("class"));
    Assert.assertTrue(newsElement.getAttribute("class").contains("active"));

    WebElement successStoriesElement = driver.findElement(By.xpath("//div[@class=\"tab-nav\"]/div/div/span[text()=\"Success Stories\"]/.."));
    actions.moveToElement(successStoriesElement).click().perform();
    logger.debug("Click on Success Stories button");
    logger.debug(successStoriesElement.getAttribute("class"));
    Assert.assertTrue(successStoriesElement.getAttribute("class").contains("active"));

    WebElement materialsElement = driver.findElement(By.xpath("//div[@class=\"tab-nav\"]/div/div/span[text()=\"Materials\"]/.."));
    actions.moveToElement(materialsElement).click().perform();
    logger.debug("Click on Materials button");
    logger.debug(materialsElement.getAttribute("class"));
    Assert.assertTrue(materialsElement.getAttribute("class").contains("active"));

    WebElement videosElement = driver.findElement(By.xpath("//div[@class=\"tab-nav\"]/div/div/span[text()=\"Videos\"]/.."));
    actions.moveToElement(videosElement).click().perform();
    logger.debug("Click on Videos button");
    logger.debug(videosElement.getAttribute("class"));
    Assert.assertTrue(videosElement.getAttribute("class").contains("active"));

  }

  @Test
  public void testVerifyTrainings() {
    driver.get(trainingUrlEpam);

    WebElement signInButton = driver.findElement(By.xpath("//p[@class=\"header-auth__signin\"]"));
    signInButton.click();
    logger.debug("Click sign in button");

    WebElement inputEmail = driver.findElement(By.id("signInEmail"));
    inputEmail.sendKeys(userName);
    logger.debug("Input user name");

    WebElement inputPassword = driver.findElement(By.id("signInPassword"));
    inputPassword.sendKeys(userPassword);
    logger.debug("Input user password");

    WebElement submitElement = driver.findElement(By.xpath("//input[@class=\"popup-reg-sign-in-form__sign-in\"]"));
    submitElement.click();
    logger.debug("Click on submit button");

    WebElement trainingListButton = driver.findElement(By.xpath("//div[@class=\"container\"]/nav/ul/li/a[@class=\"topNavItem training click hover\"]"));
    if (trainingListButton.isEnabled() && !trainingListButton.isSelected()) {
      trainingListButton.click();
      logger.debug("Click training list button");
    }

    WebElement filterItemSkillsArrow = driver.findElement(By.xpath("//div[@class=\"filter__item filter__item-skills\"]/div/div[@class=\"filter-field__arrow-icon\"]"));
    js.executeScript("arguments[0].scrollIntoView();", filterItemSkillsArrow);
    filterItemSkillsArrow.click();
    logger.debug("Filter item skills arrow was clicked");

    WebElement inputFieldSkills = driver.findElement(By.xpath("//div[@class=\"drop-down drop-down-skills drop-down-visibility\"]/input"));
    inputFieldSkills.sendKeys(searchItem1);
    logger.debug("Perform search for " + searchItem1 + " search term");

    List<WebElement> listOfSkills = driver.findElements(By.xpath("//div[@class=\"drop-down drop-down-skills drop-down-visibility\"]/ul[@class=\"drop-down__input-search__list\"]/li"));
    Assert.assertEquals(2, listOfSkills.size());
    logger.debug("Count elements with " + searchItem1 + " are " + listOfSkills.size());

    inputFieldSkills.clear();
    inputFieldSkills.sendKeys(searchItem2);
    logger.debug("Perform search for " + searchItem2 + " search term");

    listOfSkills = driver.findElements(By.xpath("//div[@class=\"drop-down drop-down-skills drop-down-visibility\"]/ul[@class=\"drop-down__input-search__list\"]/li"));
    Assert.assertEquals(2, listOfSkills.size());
    logger.debug("Count elements with " + searchItem2 + " are " + listOfSkills.size());

    inputFieldSkills.clear();
    inputFieldSkills.sendKeys(searchItem3);
    logger.debug("Perform search for " + searchItem3 + " search term");

    listOfSkills = driver.findElements(By.xpath("//div[@class=\"drop-down drop-down-skills drop-down-visibility\"]/ul[@class=\"drop-down__input-search__list\"]/li"));
    Assert.assertEquals(0, listOfSkills.size());
    logger.debug("Count elements with " + searchItem3 + " are " + listOfSkills.size());

  }

  @Test
  public void testVerifyLoginWithIncorrectCredentials() {
    driver.get(trainingUrlEpam);

    WebElement signInButton = driver.findElement(By.xpath("//p[@class=\"header-auth__signin\"]"));
    signInButton.click();
    logger.debug("Click sign in button");

    WebElement inputEmail = driver.findElement(By.id("signInEmail"));
    inputEmail.sendKeys(userNameIncorrect);
    logger.debug("Input user name");

    WebElement inputPassword = driver.findElement(By.id("signInPassword"));
    inputPassword.sendKeys(userPasswordIncorrect);
    logger.debug("Input user password");

    WebElement submitElement = driver.findElement(By.xpath("//input[@class=\"popup-reg-sign-in-form__sign-in\"]"));
    submitElement.click();
    logger.debug("Click on submit button");

    WebElement errorMessage = driver.findElement(By.xpath("//div[@class=\"popup__error-message ng-binding\"]"));
    logger.debug("errorMessage isEnabled " + errorMessage.isEnabled());

    /*WebElement userInfoName = driver.findElement(By.xpath("//div[@class=\"user-info__name\"]"));
    logger.debug("userInfoName isEnabled " + userInfoName.isEnabled());*/

    Assert.assertTrue(errorMessage.isEnabled());
    driver.close();
  }

  @Test
  public void testVerifyLogin() {
    driver.get(trainingUrlEpam);

    WebElement signInButton = driver.findElement(By.xpath("//p[@class=\"header-auth__signin\"]"));
    signInButton.click();
    logger.debug("Click sign in button");

    WebElement inputEmail = driver.findElement(By.id("signInEmail"));
    inputEmail.sendKeys(userName);
    logger.debug("Input user name");

    WebElement inputPassword = driver.findElement(By.id("signInPassword"));
    inputPassword.sendKeys(userPassword);
    logger.debug("Input user password");

    WebElement submitElement = driver.findElement(By.xpath("//input[@class=\"popup-reg-sign-in-form__sign-in\"]"));
    submitElement.click();
    logger.debug("Click on submit button");

    WebElement userInfoName = driver.findElement(By.xpath("//div[@class=\"user-info__name\"]"));
    logger.debug("userInfoName isEnabled " + userInfoName.isEnabled());

    Assert.assertTrue(userInfoName.isEnabled());
    driver.close();
  }

  @Test
  public void findElementsMainMenu() {
    driver.get(baseUrlEpam);

    List<WebElement> sectionList = driver.findElements(By.xpath("//ul[@class=\"hamburger-menu__list\"]/li/a"));
    logger.debug("Count of section " + sectionList.size());
    Assert.assertEquals(6, sectionList.size());
    driver.close();
  }

  @Test
  public void findCalendars() {

    driver.get(trainingUrlEpam);

    WebElement arrowElement = driver.findElement(By.xpath("//div[@class=\"filter-field__arrow-icon\" and @ng-click=\"openLocationsDropDown()\"]"));
    arrowElement.click();
    logger.debug("Found and click arrow button");

    WebElement chekBoxLocations = driver.findElement(By.xpath("//div[@class=\"drop-down drop-down-locations drop-down-visibility\"]/ul[@class=\"drop-down__input-search__list\"]/li/label[text()[contains(.,'Belarus')]]/span"));
    if (!chekBoxLocations.isSelected()) {
      chekBoxLocations.click();
    }
    logger.debug("Selected country check box");

    List<WebElement> trainingsList = driver.findElements(By.xpath("//div[@class=\"training-list__container training-list__desktop\"]/div/div/div[contains(text(), \"Minsk\")]/../div[@class=\"training-item__duration\"]/div[@class=\"duration-calendar ng-binding\"]"));
    logger.debug("Count actual trainings " + trainingsList.size());

    Assert.assertEquals(9, trainingsList.size());
    driver.close();
  }

  @Test
  public void testFindPositionsAnalyst() {
    driver.get(positionsAnalystUrlEpam);

    List<WebElement> positionElements = driver.findElements(By.xpath("//ul[@class=\"search-result__list\"]/li/div/h5/a[contains(text(), 'Analyst')]"));
    logger.debug("Count of positions " + positionElements.size());

    Assert.assertEquals(5, positionElements.size());
    driver.close();
  }

  @Test
  public void testFindLernMoreButtons() {
    driver.get(pastEventsUrlEpam);

    WebElement pastEventsElement = driver.findElement(By.xpath("//div[@class=\"tabs__title\"]/a[text()[contains(.,'Past Events')]]/.."));
    if (pastEventsElement.isEnabled() && !pastEventsElement.isSelected()) {
      pastEventsElement.click();
      logger.debug("Button Past events was clicked");
    }

    List<WebElement> buttonElements = driver.findElements(By.xpath("//ul[@class=\"events-viewer__list\"]/li/time[contains(text(), 'MAY')]/../div[@class=\"events-viewer__button-wrapper\"]/a/span[text()='Learn more']"));
    logger.debug("Count of past events is " + buttonElements.size());

    Assert.assertEquals(2, buttonElements.size());
    driver.close();
  }

  @After
  public void afterTest() {
    driver = null;
  }

}
