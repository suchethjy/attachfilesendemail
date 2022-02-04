/**
 *
 */
package de.hybris.practice.core.event;

import de.hybris.platform.acceleratorservices.model.email.EmailAttachmentModel;
import de.hybris.platform.basecommerce.model.site.BaseSiteModel;
import de.hybris.platform.commerceservices.event.AbstractCommerceUserEvent;

import java.util.List;


/**
 * @author Dell
 *
 */
public class NewAttachmentEmailEvent extends AbstractCommerceUserEvent<BaseSiteModel>
{
	private List<EmailAttachmentModel> emailAttachments;

	/**
	 * @return the emailAttachments
	 */
	public List<EmailAttachmentModel> getEmailAttachments()
	{
		return emailAttachments;
	}



	/**
	 * @param emailAttachments
	 *           the emailAttachments to set
	 */
	public void setEmailAttachments(final List<EmailAttachmentModel> emailAttachments)
	{
		this.emailAttachments = emailAttachments;
	}

	private String newemail;

	/**
	 * @param newemail
	 */
	public NewAttachmentEmailEvent(final String newemail)
	{
		super();
		this.newemail = newemail;
	}



	public NewAttachmentEmailEvent()
	{
		super();
	}

	/**
	 * @return the newemail
	 */
	public String getNewemail()
	{
		return newemail;
	}

	/**
	 * @param newemail
	 *           the newemail to set
	 */
	public void setNewemail(final String newemail)
	{
		this.newemail = newemail;
	}

}

