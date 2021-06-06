

public class Entry {

    public Object dataObject;
    public String status;

    public Entry(){
        this(null, "E");
    }
    public Entry(Object dataObject, String status){
        this.dataObject= dataObject;
        this.status= status;
    }

    public Object getDataObject() {
        return dataObject;
    }

    public String getStatus() {
        return status;
    }

    public int hash(){
        return dataObject.hashCode();
    }

    public String toString(){
        return "Data: "+getDataObject()+", Status: "+getStatus();
    }

}
