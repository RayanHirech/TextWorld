public class Item {

    private String name;
    private String description;
//    private boolean isFree;

    public Item(String name, String description/*, boolean isFree*/) {
        this.name = name;
        this.description = description;
//        this.isFree = isFree;
    }

    public String getName() {
        return this.name;
    }
    public String getDescription() {
        return this.description;
    }
//    public boolean isFree() {
//        return isFree;
//    }

    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
//    public void setFree(boolean isFree) {
//        this.isFree = isFree;
//    }

}
