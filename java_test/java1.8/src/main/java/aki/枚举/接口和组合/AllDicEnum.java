package aki.枚举.接口和组合;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public enum AllDicEnum {

    animal("animal","动物",AnimalEnum.class)
    ;
    /* 字典类型 */
    private final String type;
    private final String desc;
    private final Class dicEnumInterface;

    AllDicEnum(String type, String desc, Class<?> dicEnumInterface) {
        this.type = type;
        this.desc = desc;
        this.dicEnumInterface = dicEnumInterface;
    }

    public static List<DicEnumVO> findByType(String type) {
        List<DicEnumVO> list = new ArrayList<>();
        for (AllDicEnum allDicEnum : values()) {
            if (allDicEnum.getType().equals(type)) {
                list = DicEnumInterface.getDicVo(allDicEnum.getDicEnumInterface());
            } else if (type.equals("all")) {
                list.addAll(DicEnumInterface.getDicVo(allDicEnum.getDicEnumInterface()));
            }
        }
        return list;
    }
}
