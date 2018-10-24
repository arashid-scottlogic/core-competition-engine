import cucumber.api.java8.En;

import static org.assertj.core.api.Assertions.*;

public class ApplicationStepDefinitions implements En {
    public ApplicationStepDefinitions() {
    Given("^(true|false) is (true|false)$", (String arg1, String arg2) -> {
      Boolean bool1 = Boolean.parseBoolean(arg1);
      Boolean bool2 = Boolean.parseBoolean(arg2);
      assertThat(bool1).isEqualTo(bool2);
    });
    When("^I ask if (true|false) is (true|false)$", (String arg1, String arg2) -> {
      Boolean bool1 = Boolean.parseBoolean(arg1);
      Boolean bool2 = Boolean.parseBoolean(arg2);
      assertThat(bool1).isNotEqualTo(bool2);
    });
    Then("^I should receive (true|false)", (String arg1) -> {
      Boolean bool1 = Boolean.parseBoolean(arg1);
      assertThat(bool1).isEqualTo(false);
    });
  }
}