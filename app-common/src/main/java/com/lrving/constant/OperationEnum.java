package com.lrving.constant;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public enum OperationEnum {
    /**4位2进制：1(增)1(删)1(改)1(查)*/
    Query("查询权限"),
    Update("更新权限"),
    Remove("删除权限"),
    Save("新增权限");




    private String name;

    public enum Type{
        Admin,App;
        private Type(){}
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public static String indexOf(int index){
        int count=0;
        for (OperationEnum operation:values()){
            if (count==index)
                return operation.name();
            count++;
        }
        return "";
    }
}
