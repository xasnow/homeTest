package file;

import sun.nio.cs.ext.GBK;

import java.io.*;

public class FileUpdate {

    private static String reqSuffix = "ReqPack.rcd";
    private static String rspSuffix = "RspPack.rcd";
    private static String addFlag = "<Category name=\"BODY\">";
    private static String reqBodyAddContent = "          <Field FieldDefaultValue=\"&quot;&quot;\" FieldName=\"#APP_HEAD\" FieldSubtle=\"false\" FieldType=\"Bytes\" Verify=\"false\">\n" +
            "                <Parameter Name=\"路径\" Value=\"\"/>\n" +
            "                <Parameter Name=\"字段类型\" Value=\"字符\"/>\n" +
            "                <Parameter Name=\"数据拼包类型\" Value=\"必送\"/>\n" +
            "                <Message ClassName=\"JsonAnalyzer\" FieldDescription=\"\" Type=\"JSON报文\">\n" +
            "                    <Parameter Name=\"是否自定义变量名\" Value=\"否\"/>\n" +
            "                    <Parameter Name=\"字符编码\" Value=\"UTF-8\"/>\n" +
            "                    <Import ImportFileName=\"&quot;input/message/A_APPHEAD_ReqPack.rcd&quot;\" ImportName=\"&quot;&quot;\"/>\n" +
            "                </Message>\n" +
            "            </Field>";
    private static String rspBodyAddContent = "      <Field FieldDefaultValue=\"&quot;&quot;\" FieldName=\"#APP_HEAD\" FieldType=\"Bytes\">\n" +
            "        <Parameter Name=\"路径\" Value=\"\"/>\n" +
            "        <Parameter Name=\"字段类型\" Value=\"字符\"/>\n" +
            "        <Parameter Name=\"数据拼包类型\" Value=\"必送\"/>\n" +
            "        <PackExpr/>\n" +
            "        <Message ClassName=\"JsonAnalyzer\" Type=\"JSON报文\">\n" +
            "          <Parameter Name=\"是否自定义变量名\" Value=\"否\"/>\n" +
            "          <Parameter Name=\"字符编码\" Value=\"UTF-8\"/>\n" +
            "          <Import ImportFileName=\"&quot;input/message/A_APPHEAD_RspPack.rcd&quot;\" ImportName=\"&quot;&quot;\"/>\n" +
            "        </Message>\n" +
            "      </Field>";


    public static void main(String[] args) throws IOException {
//        String fileName = "E:\\temp\\75rcd调试\\A0110001_A26_ReqPack.rcd";
        String path = "E:\\temp\\75rcd调试";
        // 根据目录遍历文件，获取文件绝对路径
        getRcdFileAndUpdate(path);
    }

    private static void getRcdFileAndUpdate(String path) throws IOException {
        File file = new File(path);

        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files == null) {
                return;
            }
            for (File f : files) {
                if (f.getName().endsWith(reqSuffix) || f.getName().endsWith(rspSuffix)) {
                    updateRcdFile(f.getAbsolutePath());
                }
            }
        }
    }

    public static void updateRcdFile(String fileName) throws IOException {
        if (fileName == null || "".equals(fileName)) {
            return;
        }
        BufferedReader reader = null;
        String tempFilePath = "";
        // 获取临时文件名
        if (fileName.endsWith(reqSuffix)) {
            tempFilePath = fileName.replaceAll(reqSuffix, "ReqPack_Temp.rcd");
        } else if (fileName.endsWith(rspSuffix)) {
            tempFilePath = fileName.replaceAll(rspSuffix, "RspPack_Temp.rcd");
        } else {
            // 没有对应的文件，生成rcd文件异常，后续就不需要了
            return;
        }
        // 根据新的文件名创建临时文件
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(tempFilePath), "GBK"));
        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "GBK");
            reader = new BufferedReader(inputStreamReader);

            String tempString;
            boolean isAdded = false;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                out.write(tempString);
                out.newLine();
                if (!isAdded && tempString.trim().equalsIgnoreCase(addFlag)) {
                    if (fileName.endsWith(reqSuffix)) {
                        out.write(reqBodyAddContent);
                        out.newLine();
                        isAdded = true;
                    } else if (fileName.endsWith(rspSuffix)) {
                        out.write(rspBodyAddContent);
                        out.newLine();
                        isAdded = true;
                    }
                }
            }
            reader.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e1) {
                }
            }
        }
        // 新的临时文件已创建完成，删除旧文件，更新临时文件的文件名
        File file1 = new File(tempFilePath);
        new File(fileName).delete();
        boolean b = file1.renameTo(new File(fileName));
    }
}
