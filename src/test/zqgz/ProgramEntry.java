package test.zqgz;

import cpgz.zqjqysp.zqgz.InterbankNegotiableCertificatesOfDeposit;

/**
 * 取数示例
 */

public class ProgramEntry {

    public static void main(String[] args) throws Exception {
        //开始时间
        String[] listStartTime = {"2018-12-01", "2018-12-02", "2018-12-03", "2018-12-04", "2018-12-05", "2018-12-06", "2018-12-07", "2018-12-08"};
        //结束时间
        String[] listEndTime = {"2018-12-01", "2018-12-02", "2018-12-03", "2018-12-04", "2018-12-05", "2018-12-06", "2018-12-07", "2018-12-08"};

        /*
         *说明：
         * 当开始时间和结束时间相同的情况下,说明该下载的数据是一天的数据.
         */

        for (int i = 0; i < listStartTime.length; i++) {
            System.out.println(
                    InterbankNegotiableCertificatesOfDeposit.getDownloadIBNCD("", "", "402880e5438a816001438a833adf0008", listStartTime[i], listEndTime[i], "0", "/home/zhangyibin/下载/", listStartTime[i] + "~" + listEndTime[i])
            );
            Thread.sleep(8000);

        }
    }
}
