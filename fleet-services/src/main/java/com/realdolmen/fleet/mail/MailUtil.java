package com.realdolmen.fleet.mail;


import com.realdolmen.fleet.Employee;
import com.realdolmen.fleet.PhysicalCar;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.MediaType;
import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

@Component
public class MailUtil {
    private static final String BUNDLE_NAME = "emails";
    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

    public ClientResponse sendMessage(String subject, String text, String fromName, String ... tos) {
        Client client = Client.create();
        client.addFilter(new HTTPBasicAuthFilter("api",
                "key-a9917a7f2ee759ef8191a3c986cdb962"));
        WebResource webResource =
                client.resource("https://api.mailgun.net/v3/sandbox0f49013ff6694398876ccfa56380833a.mailgun.org" +
                        "/messages");
        MultivaluedMapImpl formData = new MultivaluedMapImpl();
        formData.add("from", fromName + " <mailgun@sandbox0f49013ff6694398876ccfa56380833a.mailgun.org>");
        formData.add("to", "bar@example.com");
        for(String to : tos)
            formData.add("to", to);

        formData.add("subject", subject);
        formData.add("text", text);
        return webResource.type(MediaType.APPLICATION_FORM_URLENCODED).
                post(ClientResponse.class, formData);
    }

    public boolean sendRenewalMessage(PhysicalCar car) {
        if(car == null)
            return false;

        Employee employee = car.getEmployee();
        if(employee == null)
            return false;

        String employeeName = employee.getFirstName() + " " + employee.getLastName();
        String carName = car.getCarModel().getBrand() + " " + car.getCarModel().getModel();
        ClientResponse clientResponse = sendMessage(getString("fleet.renewal-email.subject"),
                getString("fleet.renewal-email.text", employeeName, carName),
                getString("fleet.renewal-email.from"), car.getEmployee().getEmail());

        return clientResponse.getStatus() == 200;
    }

    public String getString(String key) {
        try {
            return RESOURCE_BUNDLE.getString(key);
        } catch (MissingResourceException e) {
            return '!' + key + '!';
        }
    }

    public String getString(String key, Object... params  ) {
        try {
            return MessageFormat.format(RESOURCE_BUNDLE.getString(key), params);
        } catch (MissingResourceException e) {
            return '!' + key + '!';
        }
    }
}
