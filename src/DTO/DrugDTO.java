package DTO;

public class DrugDTO {
    private String  drugcode;
    private String drugname;
    private int formcode;
    private String formname;
    private String path;

    public String getDrugcode() {
        return drugcode;
    }

    public void setDrugcode(String drugcode) {
        this.drugcode = drugcode;
    }

    public String getDrugname() {
        return drugname;
    }

    public void setDrugname(String drugname) {
        this.drugname = drugname;
    }

    public int getFormcode() {
        return formcode;
    }

    public void setFormcode(int formcode) {
        this.formcode = formcode;
    }

    public String getFormname() {
        return formname;
    }

    public void setFormname(String formname) {
        this.formname = formname;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public DrugDTO() { }

}
