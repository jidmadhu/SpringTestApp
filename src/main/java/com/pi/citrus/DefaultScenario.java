package com.pi.citrus;

import com.consol.citrus.http.message.HttpMessage;
import com.consol.citrus.simulator.scenario.AbstractSimulatorScenario;
import com.consol.citrus.simulator.scenario.Scenario;
import com.consol.citrus.simulator.scenario.ScenarioDesigner;
import org.springframework.http.HttpStatus;

/**
 * @author Jidhu Madhu on 17/07/2021.
 */
@Scenario("DEFAULT_SCENARIO")
public class DefaultScenario extends AbstractSimulatorScenario {

    @Override
    public void run(ScenarioDesigner designer) {
        designer.send()
                .message(new HttpMessage("No scenario found for this request")
                        .status(HttpStatus.NOT_FOUND));
    }
}
