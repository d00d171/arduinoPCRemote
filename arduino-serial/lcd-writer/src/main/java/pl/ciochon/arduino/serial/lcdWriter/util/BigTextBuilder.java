package pl.ciochon.arduino.serial.lcdWriter.util;

/**
 * Created by Konrad Ciochoń on 2017-02-12.
 */
public class BigTextBuilder {

    private int pos1 = 0;
    private int pos2 = 0;
    private byte[][] text = new byte[2][16];

    public BigTextBuilder add(BigSign sign){
        byte[][] signValue = sign.getValue();
        byte[] sign1 = signValue[0];
        byte[] sign2 = signValue[1];

        System.arraycopy(sign1, 0, text[0], pos1, sign1.length);
        System.arraycopy(sign2, 0, text[1], pos2, sign2.length);

        pos1 += sign1.length;
        pos2 += sign2.length;

        return this;
    }

    public BigTextBuilder addS(BigSign sign){
        return add(sign).add(BigSign.SPACE);
    }

    public byte[] build(){
        byte[] result = new byte[32];
        System.arraycopy(text[0], 0, result, 0, text[0].length);
        fillWithEmpty(result, pos1, 16);
        System.arraycopy(text[1], 0, result, 16, text[1].length);
        fillWithEmpty(result, 16 + pos2, 32);
        return result;
    }

    public void fillWithEmpty(byte[] array, int start, int end) {
        for(int i = start; i<end; i++){
            array[i] = ' ';
        }
    }

}
