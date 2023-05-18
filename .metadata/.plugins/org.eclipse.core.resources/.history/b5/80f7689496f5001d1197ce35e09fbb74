package twilio;

import org.springframework.beans.factory.annotation.Autowired;

public class SmsService {

	private final SmsSender smsSender;
	
	@Autowired
	public SmsService(SmsSender smsSender) {
		
		this.smsSender = smsSender;
	}

	public void sendSms(SmsRequest smsRequest)
	{
		smsSender.sendSms(smsRequest);
	}
}
