package com.atguigu.bean;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.OAuthTokenCredential;
import com.paypal.base.rest.PayPalRESTException;

@Configuration
public class PaypalConfig {
	
	//@Value("${paypal.client.clientId}")
	private String clientId="AQyXf-N2nNr8QwJsFt7IudPRL-CMGYEXCCzgqOHIA037JLhSFOEchb2kGa_z_BqzKY4CmUPFiGqG_uNj";
    //private String clientId="AQyXf-N2nNr8QwJsFt7IudPRL-CMGYEXCCzgqOHIA037JLhSFOEchb2kGa_z_BqzKY4CmUPFiGqG_uNj";
    //真实private String clientId="AZTtkPd6LowZG2KewtB3TAHIu3WeqcM6VCgp2xB4ShixmnAgOxskEgwdWEM9Qv0fc3Ln2DLVy6xPLPFN";
    
    //@Value("${paypal.client.secret}")
    private String clientSecret="EO5N6EtaEiIQXF18UWWZJGGeB8VL4qMxC-jR4tvHoXJD0RBdZGzcCguUBuRgWNBR8Lk-ge8XRK379NCl";
    //private String clientSecret="EO5N6EtaEiIQXF18UWWZJGGeB8VL4qMxC-jR4tvHoXJD0RBdZGzcCguUBuRgWNBR8Lk-ge8XRK379NCl";
    //真实private String clientSecret="EANTizGHYqb_0rWbPKlDD-otKQwi0k7RN6xvDiWtZNZY1gSyO71VrCpzvy6xTzGPVC5VxB6U66wjndYM";
    
    //@Value("${paypal.mode}")
    private String mode="sandbox";
    //真实private String mode="sandbox";
    //真实private String mode="live";

    @Bean
    public Map<String, String> paypalSdkConfig(){
        Map<String, String> sdkConfig = new HashMap<>();
        sdkConfig.put("mode", mode);
        return sdkConfig;
    }

    @Bean
    public OAuthTokenCredential authTokenCredential(){
        return new OAuthTokenCredential(clientId, clientSecret, paypalSdkConfig());
    }

    @Bean
    public APIContext apiContext() throws PayPalRESTException{
        APIContext apiContext = new APIContext(authTokenCredential().getAccessToken());
        apiContext.setConfigurationMap(paypalSdkConfig());
        return apiContext;
    }
}
