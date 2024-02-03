package com.bobocode.patterns;

import java.math.BigDecimal;

/**
 * ONLINE TRAINING 5 | TASK 2
 * 👉 Prep a Proxy Pattern demo
 * <p>
 * Think about the following questions in terms of the Proxy design pattern
 * - What is the problem? (PROBLEM) Performance logging
 * - What is the solution to that problem? (SOLUTION) Use proxy to log time before and after execution of the service method
 * - What is the outcome of that solution? (OUTCOME)
 * Prepare a demo (a code snippet) that shows the Proxy pattern
 * Post screenshots of your code in the Thread 👇
 */
public class ProxyDemo {

    public static void main(String[] args) {
        ComputationService computationServiceProxy = getComputationService();
        computationServiceProxy.compute(111);
    }

    private static ComputationService getComputationService() {
        return new ComputationServiceProxy();
    }

    interface ComputationService {
        BigDecimal compute(Integer object);
    }

    static class ComputationServiceImpl implements ComputationService {
        @Override
        public BigDecimal compute(Integer value) {
            return BigDecimal.valueOf(value).multiply(BigDecimal.TEN);
        }
    }

    static class ComputationServiceProxy extends ComputationServiceImpl {

        @Override
        public BigDecimal compute(Integer value) {
            System.out.println("Start time: " + System.currentTimeMillis());
            var result = super.compute(value);
            System.out.println("End time: " + System.currentTimeMillis());
            return result;
        }
    }


}
