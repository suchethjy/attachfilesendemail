/**
 *
 */
package de.hybris.practice.core.service;

import de.hybris.platform.commerceservices.customer.CustomerAccountService;
import de.hybris.platform.core.model.user.CustomerModel;

import java.io.FileNotFoundException;


/**
 * @author Dell
 *
 */
public interface TaskCustomerAccountService extends CustomerAccountService
{


	void sendEmail(CustomerModel customerModel) throws FileNotFoundException;


}
