package HelloWord1.Enum;

import jdk.nashorn.internal.objects.annotations.Getter;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author zhenghuan
 * @date 2021/7/1
 */

public enum ColorEnum {

    BLACK(Arrays
            .asList("000000", "003333", "333300", "000033", "330000", "333333", "330033", "003300"),
            (byte) 0, "黑色"),
    PINK(Arrays.asList("ff9999", "ff6699", "ff66cc", "ff66ff","ffcccc", "ff99cc", "ff99ff","ff3399", "ff33cc", "ff0099", "ff33ff", "ff00cc"),
            (byte) 1, "粉色"),
    WHITE(Arrays.asList("ffffcc", "ffffff", "ffccff"), (byte) 2, "白色"),
    GRAY(Arrays.asList("666666", "999999", "cccccc"), (byte) 3, "灰色"),
    RED(Arrays
            .asList("cc3300", "cc0000", "cc3333", "ff3300", "cc0033", "ff0000", "ff3333", "ff0033","660000", "993300", "660033", "990000", "993333", "660066", "990033","ff6600", "993366", "ff6633", "990066", "cc3366", "ff6666", "cc0066",
                    "ff3366", "ff0066"),
            (byte) 4, "红色"),
    ORANGE(Arrays.asList("ff9900", "ff9933", "ff9966","cccc00", "cccc33", "cccc66","cc9900",
            "cc6600", "cc9933", "cc6633", "cc9966", "cc6666"), (byte) 5,
            "橙色"),
    YELLOW(Arrays.asList("ffff00", "ffff33","ffcc00", "ffcc33", "ffcc66","ffff66", "ffff99",
            "ffcc99"), (byte) 6, "黄色"),
    CYAN(Arrays
            .asList("339900", "00ffcc", "339933", "00ffff", "339966", "33cc00", "33cc33", "00cc99",
                    "33cc66", "00ccff","669900", "009999", "669933", "339999", "669966", "669999", "336600",
                    "00cccc", "336633", "33cc99", "336666", "33cccc", "6666ff","33ffcc", "33ffff"
                    , "66ffff", "99ffff", "ccffff"), (byte) 7, "青色"),
    GREEN(Arrays
            .asList("00ff00", "33ff00", "00ff33", "66ff00", "33ff33", "00ff66", "66ff33", "33ff66",
                    "00ff99", "66ff66", "33ff99", "66ff99", "66ffcc", "00cc00", "00cc33", "66cc00",
                    "00cc66", "66cc33", "66cc66, 66cc99","009900", "009933", "009966", "006600", "99cc00", "006633", "99cc33",
                    "006666",
                    "99cc66", "99cc99","99ff00", "ccff00", "99ff33", "ccff33", "99ff66", "ccff66",
                    "99ff99", "ccff99", "99ffcc", "ccffcc"), (byte) 8, "绿色"),
    BLUE(Arrays.asList("0033cc", "0033ff", "3333cc", "3333ff", "0066cc", "336699", "0066ff",
            "3366cc", "0000cc", "3366ff", "0000ff", "3300cc", "3300ff","0099cc", "0099ff", "3399cc", "3399ff", "6699cc", "6699ff", "66cccc",
            "33ccff", "99cccc", "66ccff", "666699", "99ccff", "6666cc","003366", "003399",
            "333366", "333399", "006699", "000066", "000099","330066", "330099"), (byte) 9, "蓝色"),
    PURPLE(Arrays.asList("993399", "9933cc", "cc3399", "9933ff", "cc33cc", "cc33ff", "990099","9900cc",
            "cc0099", "9900ff", "cc00cc", "cc00ff", "ff00ff","663366", "663399", "6633cc",
            "6633ff", "660099", "6600cc", "6600ff","9999cc", "9999ff", "cc99cc", "cc99ff", "996699", "9966cc",
            "cc6699", "ccccff", "9966ff", "cc66cc", "cc66ff"), (byte) 10, "紫色"),
    BROWN(Arrays.asList("996600", "996633", "996666","666600", "663300", "666633", "663333","999900", "999933", "999966", "cccc99", "cc9999"),
            (byte) 11, "棕色");

    private final List<String> hexValueList;
    private final byte code;
    private final String color;

    public static byte getCodeByHexValue(final String hexValue){
        for (final ColorEnum value : ColorEnum.values()) {
            if(value.getHexValueList().contains(hexValue)){
                return value.getCode();
            }
        }
        throw new RuntimeException("hexValue can not find colourTag");
    }

    ColorEnum(final List<String> hexValueList, final byte code, final String color) {
        this.hexValueList = hexValueList;
        this.code = code;
        this.color = color;
    }

    public List<String> getHexValueList() {
        return hexValueList;
    }

    public byte getCode() {
        return code;
    }

    public String getColor() {
        return color;
    }
}