### 清算项目
----

##### 项目说明：
下载2013-12-13日以后的"同业存单"数据。<br>

操作步骤：<br>
1.数据文件目录“产品估值”-“债券市场数据”-“债券估值”。<br>
2.债券品种“同业存单”。<br>
3.选择下载日期。<br>

----

##### 项目API：

一、下载“同业存单”数据<br>
接口：cpgz.zqjqysp.zqgz.InterbankNegotiableCertificatesOfDeposit<br>
方法：getDownloadIBNCD()<br>
类型：String<br>
定义：static<br>
描述：下载同业存单数据<br>
参数：
<table>
<tr>
    <td>名称</td>
    <td>类型</td>
    <td>必填</td>
    <td>描述</td>
</tr>

<tr>
    <td>bondNames</td>
    <td>String</td>
    <td>否</td>
    <td>债券名称</td>
</tr>

<tr>
    <td>bondCodes</td>
    <td>String</td>
    <td>否</td>
    <td>债券代码</td>
</tr>

<tr>
    <td>bondTypes</td>
    <td>String</td>
    <td>是</td>
    <td>债券类型</td>
</tr>

<tr>
    <td>startTime</td>
    <td>String</td>
    <td>是</td>
    <td>开始时间</td>
</tr>

<tr>
    <td>endTime</td>
    <td>String</td>
    <td>是</td>
    <td>结束时间</td>
</tr>

<tr>
    <td>exportFlag</td>
    <td>String</td>
    <td>是</td>
    <td>出口号</td>
</tr>

<tr>
    <td>storageLocation</td>
    <td>String</td>
    <td>是</td>
    <td>存储位置</td>
</tr>

<tr>
    <td>fileName</td>
    <td>String</td>
    <td>是</td>
    <td>文件命名称</td>
</tr>

</table>

参数示例：<br>
*  bondNames：默认为空
*  bondCodes：默认为空
*  bondTypes：默认为402880e5438a816001438a833adf0008
*  startTime：开始时间
*  endTime：结束时间
*  exportFlag：默认为0
*  storageLocation：存储位置
*  fileName：文件命名称


返回结果：<br>

    2013-12-13~2013-12-13:下载成功;
    或
    2013-12-13~2013-12-13:下载失败;


二、日志打印工具<br>
接口：loggingtool.LogFile<br>
方法：getLogFile()<br>
类型：void<br>
定义：static<br>
描述：打印错误日志<br>
参数：
<table>

<tr>
    <td>名称</td>
    <td>类型</td>
    <td>必填</td>
    <td>描述</td>
</tr>

<tr>
    <td>msg</td>
    <td>String</td>
    <td>是</td>
    <td>错误日志</td>
</tr>

</table>

返回结果： 2013-12-13~2013-12-13:下载失败;

##### 获取"同业存单"数据示例代码：

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



