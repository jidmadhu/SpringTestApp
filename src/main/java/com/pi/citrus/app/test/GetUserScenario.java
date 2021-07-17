package com.pi.citrus.app.test;

import com.consol.citrus.simulator.scenario.AbstractSimulatorScenario;
import com.consol.citrus.simulator.scenario.Scenario;
import com.consol.citrus.simulator.scenario.ScenarioDesigner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Jidhu Madhu on 17/07/2021.
 */
@Scenario("GET_USER")
@RequestMapping(value = "/services/rest/v1/user/{username}", method = RequestMethod.GET)
public class GetUserScenario extends AbstractSimulatorScenario {

    @Override
    public void run(ScenarioDesigner scenario) {
        scenario
                .http()
                .receive()
                .get();

        scenario
                .http()
                .send()
                .response(HttpStatus.OK)
                .payload(new ClassPathResource("template/random-user.json"));
    }
}
