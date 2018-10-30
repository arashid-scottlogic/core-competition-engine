package steps;

import cucumber.api.java8.En;
import static org.assertj.core.api.Assertions.*;

public class ApplicationSteps implements En {
    public ApplicationSteps() {
        Given("^(true|false) is (true|false)$", (String arg1, String arg2) ->
        {
            Boolean bool1 = Boolean.parseBoolean(arg1);
            Boolean bool2 = Boolean.parseBoolean(arg2);
            assertThat(bool1).isEqualTo(bool2);
        });

        Then("^I should not receive (true|false)$", (String arg1) ->
        {
            Boolean bool1 = Boolean.parseBoolean(arg1);
            assertThat(bool1).isEqualTo(false);
        });
    }
}
