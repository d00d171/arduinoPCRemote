package pl.ciochon.arduino.serial.lcdWriter.util;

/**
 * Created by Konrad Ciochoń on 2017-02-12.
 */
public class LcdSerialWriterUtil {

    public static String prefix(String line, String prefix, int count){
        for(int i = 0; i<count; i++){
            line = prefix + line;
        }
        return line;
    }

    public static String suffix(String line, String suffix, int count) {
        for (int i = 0; i < count; i++) {
            line = line + suffix;
        }
        return line;
    }

    public static String suffixLine(String line, String suffix) {
        return suffix(line, suffix, 16 - line.length());
    }

    public static String prefixLine(String line, String prefix){
        return prefix(line, prefix, 16 - line.length());
    }

}
