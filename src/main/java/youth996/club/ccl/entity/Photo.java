package youth996.club.ccl.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zxj
 * @date 2019-12-03 16:31
 * @<p> 图片实体类 </p>
 */
@Data
public class Photo implements Serializable {
    /**
     * 图片ID
     */
    private int id;
    /**
     * 图片名称
     */
    private String name;
    /**
     * 图片链接地址
     */
    private String url;
    /**
     * 图片格式
     */
    private String format;
    /**
     * 图片大小
     */
    private double size;
    /**
     * 图片类型，0-4分别代表人物，风景，食物，朋友
     */
    private int type;

    public Photo(String name, String url, String format, double size) {
        this.name = name;
        this.url = url;
        this.format = format;
        this.size = size;
    }

    public Photo(int id, String name, String url, String format, double size, int type) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.format = format;
        this.size = size;
        this.type = type;
    }

    public Photo(String name, String url, String format, double size, int type) {
        this.name = name;
        this.url = url;
        this.format = format;
        this.size = size;
        this.type = type;
    }
}
