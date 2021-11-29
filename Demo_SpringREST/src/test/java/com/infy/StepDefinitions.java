package com.infy;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.extern.log4j.Log4j2;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import com.infy.entity.Customer;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class StepDefinitions {

    @LocalServerPort
    private int port;
    private RestTemplate restTemplate = new RestTemplate();
    private String postUrl = "http://localhost";
    private String value = "/infybank";

    private Integer custId = 0;

    @Given("user can create a new customer")
    public void user_can_create_a_new_customer() {
        String url = postUrl + ":" + port + value + "/customers";
        List<Customer> allCust = restTemplate.getForObject(url, List.class);
        log.info(allCust);
        assertTrue(!allCust.isEmpty());
    }

    @Given("^user sends attributes customer id (.*), email id (.*), name (.*) and date of birth (.*)$")
    public void user_sends_attr(Integer customerId, String emailId, String name, LocalDate dateOfBirth) {
        String url = postUrl + ":" + port + value + "/customers";
        Customer newCust = new Customer();
        newCust.setCustomerId(customerId);
        newCust.setEmailId(emailId);
        newCust.setName(name);
        newCust.setDateOfBirth(dateOfBirth);
        Customer cust = restTemplate.postForObject(url, newCust, Customer.class);
        custId = cust.getCustomerId();
        log.info(cust);
        assertNotNull(cust);
    }

    @Then("user should be able to see the newly created customer")
    public void user_should_see_the_newly_created_customer() {
        String url = postUrl + ":" + port + value + "/customers/" + custId;
        Customer myCust = restTemplate.getForObject(url, Customer.class);
        log.info(myCust);
        assertNotNull(myCust);
    }
}
