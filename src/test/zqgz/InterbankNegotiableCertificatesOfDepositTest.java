package test.zqgz;

import cpgz.zqjqysp.zqgz.InterbankNegotiableCertificatesOfDeposit;

public class InterbankNegotiableCertificatesOfDepositTest {

    public static void main(String[] args) throws Exception {
        System.out.println(
                InterbankNegotiableCertificatesOfDeposit.getDownloadIBNCD("", "", "402880e5438a816001438a833adf0008", "2013-12-13", "2013-12-13", "0", "/home/zhangyibin/下载/", "2013-12-13")
        );
    }

}
