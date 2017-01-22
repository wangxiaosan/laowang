package com.rm.test.jmeter;

import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;

/**
 * Created by BF100405 on 2017/1/16.
 */
public class Test {
    public static void main(String[] args) {
        JTestCheckBlacklistFcade jTestCheckBlacklistFcade = new JTestCheckBlacklistFcade();
        JavaSamplerContext arg = new JavaSamplerContext(jTestCheckBlacklistFcade.getDefaultParameters());
        jTestCheckBlacklistFcade.runTest(arg);
        jTestCheckBlacklistFcade.teardownTest(arg);
    }
}
