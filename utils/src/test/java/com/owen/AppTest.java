package com.owen;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest
    extends TestCase
{

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {

        /*TokenThread tokenThread= new TokenThread();
        tokenThread.run();*/
      /*  String Access_tokenTime = WeChatUtil.getaccess_token().getAccess_token();
        WeChatUtil.getJSApiTicket(Access_tokenTime);
        String nonce_str = UUID.randomUUID().toString();;
        String timestamp = Long.toString(System.currentTimeMillis() / 1000);
        String string1;
        String signature = "";
        string1 = "jsapi_ticket=" + JsapiTicketUtil.getJSApiTicket() +
                "&noncestr=" + nonce_str +
                "&timestamp=" + timestamp +
                "&url=" + url;
        System.out.println(string1);
        try {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(string1.getBytes("UTF-8"));
            signature = byteToHex(crypt.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(Validation.checkSignature(signature,timestamp,nonce_str));*/
       /*WeChatUtil weChatUtil = new WeChatUtil();
       weChatUtil.getaccess_token();*/
       //WeChatUtil.getJSApiTicket(WeChatUtil.getaccess_token().getAccess_token());
        assertTrue( true );
    }


}
