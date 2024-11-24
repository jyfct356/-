package vip.xiaozhao.intern.baseUtil.intf.constant;


public enum MajorFirst {
    ZHE(1, "哲学"),
    JINGJI(2, "经济学"),
    FA(3, "法学"),
    JIAOYU(4, "教育学"),
    WEN(5, "文学"),
    LISHI(6, "历史学"),
    LI(7, "理学"),
    GONG(8, "工学"),
    NONG(9, "农学"),
    YI(10, "医学"),
    GUANLI(11, "管理学"),
    JUNSHI(12, "军事学"),
    YISHU(13, "艺术学"),
    JIAOCHA(14, "交叉学科");

    private final Integer ID;
    private final String NAME;

    MajorFirst(Integer id, String name) {
        this.ID = id;
        this.NAME = name;
    }
}
