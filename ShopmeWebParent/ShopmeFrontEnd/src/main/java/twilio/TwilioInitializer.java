package twilio;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.twilio.Twilio;

@Configuration
public class TwilioInitializer {
	
	private final static Logger LOGGER= org.slf4j.LoggerFactory.getLogger(TwilioInitializer.class);
	private final TwilioConfiguration twilioConfiguration;

	@Autowired
	public TwilioInitializer(TwilioConfiguration twilioConfiguration) {
		
		this.twilioConfiguration = twilioConfiguration;
	    Twilio.init(
	    		twilioConfiguration.getAccountSid(),
	    		twilioConfiguration.getAuthToken()
	    );
	    LOGGER.info("Twilio initialised ... with account sid {}",twilioConfiguration.getAccountSid());
	          
	
	}
	
	
	

}
