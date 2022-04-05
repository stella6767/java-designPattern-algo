package javacore.basic;

public class Ch14 {

    /**
     * Shellow Copy vs Deep copy
     * @param args
     */


    public static void main(String[] args) {
        TargetObject orginTarget = new TargetObject();
        TargetObject copyTarget = orginTarget;
        TargetObject copyTarget2 = TargetObject.newInstance(orginTarget);


        orginTarget.name = "원본";

        /**
         * 깊은 복사를 구현하는 방법은
         * - 복사 팩터리를 구현
         * - 직접 객체 생성하여 복사
         * - clone() 재정의
         * clone 은 final 인스턴스 또는 배열이 아닌 경우 사용권장 X
         *
         */




        System.out.println(orginTarget);
        System.out.println(copyTarget);
        System.out.println(copyTarget2);

    }


}



class TargetObject {
    String name;
    long money;
    //복사 팩토리
    public static TargetObject newInstance(TargetObject object){
        TargetObject copyObject = new TargetObject();
        copyObject.name = object.name;
        copyObject.money = object.money;
        
        return copyObject;
    }

    @Override
    public String toString() {
        return "TargetObject{" +
                "name='" + name + '\'' +
                ", money=" + money +
                '}';
    }

//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        return super.clone();
//    }
}