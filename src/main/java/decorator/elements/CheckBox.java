package decorator.elements;

import org.openqa.selenium.WebElement;

public class CheckBox extends PageElement {

  public CheckBox(WebElement webElement) {
    super(webElement);
  }

  public void setChecked(boolean value) {
    if (value != isChecked()) {
      webElement.click();
    }
  }

  public boolean isChecked() {
    return webElement.isSelected();
  }

}
