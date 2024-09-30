package aki.枚举.接口和组合;

import lombok.val;

import java.util.ArrayList;
import java.util.List;

public interface DicEnumInterface {

    /* 枚举码 */
    Object getCode();

    /* 枚举说明 */
    String getDesc();

    default DicEnumVO getResourceDicStrVo() {
        DicEnumVO resourceDicVo = new DicEnumVO();
        resourceDicVo.setValue(getCode());
        resourceDicVo.setName(getDesc());
        return resourceDicVo;
    }

    /**
     * 获取枚举
     *
     * @param enumClass 枚举类的Class对象
     * @return 返回枚举指定字段值的列表
     */
    static <E extends DicEnumInterface> List<DicEnumVO> getDicVo(Class<E> enumClass) {
        List<DicEnumVO> list = new ArrayList<>();
        for (E enumConstant : enumClass.getEnumConstants()) {
            DicEnumVO resourceDicStrVo = enumConstant.getResourceDicStrVo();
            if (resourceDicStrVo != null)
                list.add(resourceDicStrVo);
        }
        return list;
    }
}
