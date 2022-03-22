package design_pattern.creational.builder;

public class Builder {

    /**
     * 객체 생성과정을 더 자유롭게, 커스텀할 수 있다.
     * @param args
     */


    public static void main(String[] args) {

        Text text = new Text.Builder()
                .setTitle("hello")
                .setContent("내용")
                .setItems("항목1", "항목2")
                .build();

        System.out.println(text);

    }

}


class Text {

    private String text;

//    public Text(String text) { 생성자를 사용하지 않고
//        this.text = text;
//    }

    @Override
    public String toString() {
        return "Text{" +
                "text='" + text + '\'' +
                '}';
    }


    public static class Builder {
        private String title;
        private String content;
        private String[] items;

        public Builder setTitle(String title){
            this.title = title;
            return this;
        }

        public Builder setContent(String content){
            this.content = content;
            return this;
        }

        public Builder setItems(String... items) {
            this.items = items;
            return this;
        }
        
        public Text build(){
            Text text = new Text();

            StringBuilder sb = new StringBuilder();
            sb.append("title: ").append(title).append("\n");
            sb.append("content: ").append(content).append("\n");
            sb.append("items: ").append("\n");

            for (String item : items) {
                sb.append(" - ").append(item).append("\n");
            }

            text.text = sb.toString();

            return text;
        }
        
    }

}