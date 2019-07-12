package com.tbuk.psd2.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tbuk.psd2.model.common.BankAccount;
import com.tbuk.psd2.model.request.PaymentInitiationRequest;

import java.io.IOException;

public class Samples1 {

    public static void main(String[] args) throws Exception {
   //     PaymentInitiationRequest p=getP();
//        BankAccount c=DummyRequests.credtor2_1();
          ObjectMapper mapper = new ObjectMapper();
//        String paymentRequestAsString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(c);
//        System.out.println(paymentRequestAsString);
//         PaymentInitiationRequest r1= DummyRequests.domesticPayment1_1();
//        PaymentInitiationRequest r2= DummyRequests.domesticPayment1_2();
//          PaymentInitiationRequest r3= DummyRequests.betweenAccountsPayment();
          PaymentInitiationRequest r4= DummyRequests.internationalPayment1_1();
          PaymentInitiationRequest r5= DummyRequests.internationalPayment1_2();
          PaymentInitiationRequest r6= DummyRequests.internationalPayment1_3();
//
//          printPayRequest(r1);
//        System.in.read(); // read a char
//        printPayRequest(r2);
//        System.in.read(); // read a char
 //         printPayRequest(r3);
//        System.in.read(); // read a char
          printPayRequest(r4);
//        System.in.read(); // read a char
          printPayRequest(r5);
//        System.in.read(); // read a char
         printPayRequest(r6);



    }

    private static PaymentInitiationRequest getP() throws  Exception{
        String str="{\n" +
                "    \"grpHdr\": {\n" +
                "        \"referenceId\": \"tppRefId001\",\n" +
                "        \"creDtTm\": {\n" +
                "            \"year\": 2019,\n" +
                "            \"month\": 7,\n" +
                "            \"day\": 12,\n" +
                "            \"hour\": 18,\n" +
                "            \"minute\": 23,\n" +
                "            \"second\": 44\n" +
                "        }\n" +
                "    },\n" +
                "    \"debtor\": {\n" +
                "        \"accountId\": \"08351341\",\n" +
                "        \"statementAvailable\": false\n" +
                "    },\n" +
                "    \"creditor\": {\n" +
                "        \"statementAvailable\": false\n" +
                "    },\n" +
                "    \"instructedAmount\": {\n" +
                "        \"amount\": 6.35\n" +
                "    },\n" +
                "    \"remittanceInfo\": {\n" +
                "        \"unstructuredData\": \"School payment, etc.\"\n" +
                "    }\n" +
                "}";
        ObjectMapper mapper = new ObjectMapper();
        PaymentInitiationRequest p = mapper.readValue(str, PaymentInitiationRequest.class);
        return p;
    }
     private static void printPayRequest(PaymentInitiationRequest request) throws IOException{
         		 ObjectMapper mapper = new ObjectMapper();
   		         String paymentRequestAsString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(request);
   		         System.out.println(paymentRequestAsString);
     }
}
