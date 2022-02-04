/**
 *
 */
package de.hybris.practice.facades.process.email.context;
import de.hybris.platform.acceleratorservices.model.cms2.pages.EmailPageModel;
import de.hybris.platform.acceleratorservices.process.email.context.AbstractEmailContext;
import de.hybris.platform.basecommerce.model.site.BaseSiteModel;
import de.hybris.platform.core.model.c2l.LanguageModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.practice.core.model.process.NewAttachmentEmailTaskProcessModel;


public class NewAttachmentEmailContext extends AbstractEmailContext<NewAttachmentEmailTaskProcessModel>
{
	private String newemail;

	@Override
	public void init(final NewAttachmentEmailTaskProcessModel processModel, final EmailPageModel emailPageModel)
	{
		super.init(processModel, emailPageModel);
		if (processModel instanceof NewAttachmentEmailTaskProcessModel)
		{
			setNewemail(processModel.getNewemail());
		}
	}

	/**
	 * @return the newemail
	 */
	protected String getNewemail()
	{
		return newemail;
	}

	/**
	 * @param newemail
	 *           the newemail to set
	 */
	protected void setNewemail(final String newemail)
	{
		this.newemail = newemail;
	}

	@Override
	protected BaseSiteModel getSite(final NewAttachmentEmailTaskProcessModel businessProcessModel)
	{
		return businessProcessModel.getSite();
	}

	@Override
	protected CustomerModel getCustomer(final NewAttachmentEmailTaskProcessModel businessProcessModel)
	{

		return businessProcessModel.getCustomer();
	}

	@Override
	protected LanguageModel getEmailLanguage(final NewAttachmentEmailTaskProcessModel businessProcessModel)
	{
		return null;

	}


}
