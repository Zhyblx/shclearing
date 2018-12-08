package cpgz.zqjqysp.zqgz;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 类：InterbankNegotiableCertificatesOfDeposit
 * 中文名：同业存单
 * 外文名：Interbank negotiable certificates of deposit
 * 简  写：IBNCD
 */

public class InterbankNegotiableCertificatesOfDeposit {

    private static final String REQUESTURL = "http://www.shclearing.com/shchapp/web/valuationclient/downloadvaluation";

    /*
     *  参数说明：
     *  bondNames：默认为空
     *  bondCodes：默认为空
     *  bondTypes：默认为402880e5438a816001438a833adf0008
     *  startTime：开始时间
     *  endTime：结束时间
     *  exportFlag：默认为0
     *  storageLocation：存储位置
     *  fileName：文件命名称
     *
     */

    public static String getDownloadIBNCD(String bondNames, String bondCodes, String bondTypes, String startTime, String endTime, String exportFlag, String storageLocation, String fileName) {

        String status = "";
        String[] URLParameter = {"bondNames=", "&bondCodes=", "&bondTypes=", "&startTime=", "&endTime=", "&exportFlag="};


        try {
            URL url = new URL(REQUESTURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            //设置链接超时,时间为2分钟;
            conn.setConnectTimeout(120000);
            //设置读取超时，时间为2分钟
            conn.setReadTimeout(120000);
            //防止屏蔽程序抓取而返回403错误
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.77 Safari/537.36");
            //设置Cookie
            conn.setRequestProperty("Cookie", "HDSESSIONID=" + "8e061d90-3a11-400e-90b6-56b34df21858; Hm_lvt_d885bd65f967ea9372fc7200bc83fa81=1544189383,1544191063,1544246516; Hm_lpvt_d885bd65f967ea9372fc7200bc83fa81=1544246516");
            //设置下载的文件名称
            conn.setRequestProperty("Content-Disposition", "attachment;fileName=" + fileName + ".zip");
            //设置访问参数
            conn.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
            conn.setRequestProperty("Accept-Encoding", "gzip, deflate");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Host", "www.shclearing.com");
            conn.setRequestProperty("Origin", "http://www.shclearing.com");
            conn.setRequestProperty("Referer", "http://www.shclearing.com/cpgz/zqjqysp/zqgz/");

            //提交请求模式
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            //建立输入流，向指向的URL传入参数
            //System.out.println(URLParameter[0]+bondNames+URLParameter[1]+bondCodes+URLParameter[2]+bondTypes+URLParameter[3]+startTime+URLParameter[4]+endTime+URLParameter[5]+exportFlag);
            DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
            dos.writeBytes(URLParameter[0] + bondNames + URLParameter[1] + bondCodes + URLParameter[2] + bondTypes + URLParameter[3] + startTime + URLParameter[4] + endTime + URLParameter[5] + exportFlag);
            dos.flush();
            dos.close();

            //得到输入流
            InputStream inputStream = conn.getInputStream();
            //获取自己数组
            byte[] getData = readInputStream(inputStream);

            //文件保存位置
            File saveDir = new File(storageLocation);
            if (!saveDir.exists()) {
                saveDir.mkdir();
            }
            File file = new File(saveDir + File.separator + fileName + ".zip");
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(getData);
            if (fos != null) {
                fos.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }

            status = startTime + "~" + endTime + ":下载成功;";

        } catch (Exception e) {
            status = startTime + "~" + endTime + ":下载失败;";
            System.err.println(status);
            //e.printStackTrace();

        }
        return status;
    }

    /**
     * 从输入流中获取字节数组
     *
     * @param inputStream
     * @return
     * @throws IOException
     */
    private static byte[] readInputStream(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while (( len = inputStream.read(buffer) ) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        return bos.toByteArray();
    }

}
