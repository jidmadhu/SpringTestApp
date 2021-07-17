package com.pi.citrus.app.test;

import com.consol.citrus.simulator.scenario.AbstractSimulatorScenario;
import com.consol.citrus.simulator.scenario.Scenario;
import com.consol.citrus.simulator.scenario.ScenarioDesigner;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Jidhu Madhu on 17/07/2021.
 */
@Scenario("USER_LOGIN")
@RequestMapping(value = "/services/rest/v1/user/login", method = RequestMethod.GET)
public class UserLoginScenario extends AbstractSimulatorScenario {

    @Override
    public void run(ScenarioDesigner scenario) {
        scenario
                .http()
                .receive()
                .get()
                .queryParam("@assertThat(allOf(containsString(username=),containsString(password=))@");

        scenario
                .http()
                .send()
                .response(HttpStatus.OK)
                .contentType("text/plain")
                .header("X-Rate-Limit", "10")
                .header("X-Expires-After", "citrus:currentDate(YYYY-MM-DD'T'hh:mm:ss, +1h)")
                .payload("citrus:randomString(40)");
    }
}
