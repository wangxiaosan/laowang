package com.rm.test.jmeter;

import com.baofoo.rm.request.RequestOrder;
import com.baofoo.rm.response.SingleLimitResDto;
import com.baofoo.rm.ws.dubbo.core.IRmRequestService;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by BF100405 on 2017/1/18.
 */
public class JTestSingleLimitFacade extends AbstractJavaSamplerClient {
    private ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    private IRmRequestService iRmRequestService = (IRmRequestService) context.getBean(IRmRequestService.class);

    private RequestOrder requestOrder;
    private SingleLimitResDto singleLimitResDto;

    public void setupTest(JavaSamplerContext arg0) {

    }

    public void teardownTest(JavaSamplerContext arg0) {

    }

    public Arguments getDefaultParameters() {
        Arguments arguments = new Arguments();
        return arguments;
    }

    @Override
    public SampleResult runTest(JavaSamplerContext javaSamplerContext) {
        SampleResult sampleResult = new SampleResult();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String[] arr = new String[]{"PC1019181716", "PC1019181716", "MB10190000", "MB1025250"};
        RequestOrder order = new RequestOrder(); //ÇëÇó¶©µ¥
        order.setMonitor_point(2L);
        order.setProduct_id(149L);
        order.setMember_id(100000749L); //»áÔ±ID

        order.setTrans_no("oyDD"+System.nanoTime());  //ÉÌ»§¶©µ¥ºÅ
        order.setMobile("13386166789"); // ÊÖ»úºÅ
        order.setCard_no("6228480031572810914"); //ÒøÐÐ¿¨ºÅ
        order.setDevice_id("MB1025253");// Éè±¸ID
        order.setIp("116.115.207.156"); //IPµØÖ·
        order.setId_card("412728199308027213"); // Éí·ÝÖ¤
        //¼ÇÂ¼µ÷ÓÃÆðÊ¼Ê±¼äµã
        sampleResult.sampleStart();
        singleLimitResDto = iRmRequestService.getSingleLimit(order);
        sampleResult.setSuccessful(true);
        sampleResult.setResponseMessage(ToStringBuilder.reflectionToString(singleLimitResDto, ToStringStyle.SIMPLE_STYLE));
        sampleResult.sampleEnd();
        return sampleResult;
    }
}
