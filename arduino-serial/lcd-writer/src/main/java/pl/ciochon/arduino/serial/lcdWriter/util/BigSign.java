package pl.ciochon.arduino.serial.lcdWriter.util;

/**
 * Created by Konrad Ciochoń on 2017-02-12.
 */
public enum BigSign {
    //cust_c = 0
    //cust_lines_bottom_top = 1
    //cust_bottom_right_corner = 2
    //cust_top_line = 3
    //cust_bottom_line = 4


    SPACE(new byte[][]{{' '}, {' '}}),
    O_LETTER(new byte[][]{ //2
            {(byte) 255, (byte) 255},
            {(byte) 255, (byte) 255}
    }),
    V_LETTER(new byte[][]{ //3
            {(byte) 255, ' ', (byte) 255},
            {' ', (byte) 255, ' '}
    }),
    L_LETTER(new byte[][]{ //2
            {(byte) 255, ' '},
            {(byte) 255, (byte) 255}
    }),
    I_LETTER(new byte[][]{ //2
            {(byte) 255,},
            {(byte) 255,}
    }),
    D_LETTER(new byte[][]{ //2
            {(byte) 255, (byte) 255},
            {(byte) 255, (byte) 255}
    }),
    E_LETTER(new byte[][]{ //2
            {(byte) 255, (byte) 0},
            {(byte) 255, (byte) 0}
    }),
    S_LETTER(new byte[][]{ //2
            {(byte) 0, (byte) 1},
            {(byte) 95, (byte) 2}
    }),
    Y_LETTER(new byte[][]{ //3
            {(byte) 255, ' ', (byte) 255},
            {' ', (byte) 255, ' '}
    }),
    P_LETTER(new byte[][]{ //2
            {(byte) 255, (byte) 255},
            {(byte) 255, ' '}
    }),
    W_LETTER(new byte[][]{ //5
            {(byte) 255, ' ', (byte) 255, ' ', (byte) 255},
            {' ', (byte) 255, ' ', (byte) 255, ' '}
    }),
    M_LETTER(new byte[][]{ //5
            {' ', (byte) 255, ' ', (byte) 255, ' '},
            {(byte) 255, ' ', (byte) 255, ' ', (byte) 255}

    }),
    C_LETTER(new byte[][]{ //5
            {(byte) 255, (byte) 3},
            {(byte) 255, (byte) 4}

    });

    private byte[][] value;

    BigSign(byte[][] value) {
        this.value = value;
    }

    public byte[][] getValue() {
        return value;
    }
}
